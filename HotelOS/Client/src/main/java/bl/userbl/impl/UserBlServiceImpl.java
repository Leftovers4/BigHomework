package bl.userbl.impl;

import bl.userbl.UserBLService;
import dataservice.userdataservice.UserDataService;
import po.user.CreditRecordPO;
import po.user.UserPO;
import rmi.RemoteHelper;
import util.CreditChangedCause;
import util.IDProducer;
import util.MemberType;
import util.ResultMessage;
import vo.user.CreditRecordVO;
import vo.user.UserVO;
import vo.user.UserVOCreater;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class UserBlServiceImpl implements UserBLService {

    private UserDataService userDAO;

    private UserVOCreater userVOCreater;

    public UserBlServiceImpl() throws RemoteException {
        userDAO = RemoteHelper.getInstance().getUserDAO();
        userVOCreater = new UserVOCreater();
    }

    @Override
    public ResultMessage registerUser(String username, String password) throws RemoteException {
        //先判断是否有相同用户名的客户
        if (!(new UserList(userDAO.findAll()).isValidUsername(username)))
            return ResultMessage.DataExisted;

        //若没有相同用户名的客户，则添加该客户
        UserPO userPO = new UserPO();

        userPO.setUsername(username);
        userPO.setPassword(password);

        return userDAO.insert(userPO);
    }

    @Override
    public ResultMessage login(String username, String password) throws RemoteException {
        UserPO userPO = userDAO.findByUsername(username);

        //客户不存在的情况
        if (userPO == null)
            return ResultMessage.UsernameNotExisted;

        //客户存在但密码错误的情况
        if (!(new User(userPO).passwordCorrect(password)))
            return ResultMessage.PasswordWrong;

        return ResultMessage.Success;
    }

    @Override
    public ResultMessage logout(String username) {
        return null;
    }

    @Override
    public List<CreditRecordVO> getCreditRecordsByUsername(String username) throws RemoteException {
        return userVOCreater.createAllOrdinaryCreditRecordVO(userDAO.findCreditRecordsByUsername(username));
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public UserVO viewBasicUserInfo(String username) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, RemoteException {
        UserPO userPO = userDAO.findByUsername(username);

        //客户不存在的情况
        if (userPO == null)
            return null;

        return userVOCreater.createFullUserVO(userPO, userDAO.findCreditRecordsByUsername(username));
    }

    @Override
    public ResultMessage updateBasicUserInfo(UserVO userVO) throws RemoteException {
        UserPO userPO = userDAO.findByUsername(userVO.username);

        userPO.setUsername(userVO.username);
        userPO.setName(userVO.name);
        userPO.setGender(userVO.gender);
        userPO.getMemberPO().setBirthday(userVO.memberVO.birthday);
        userPO.setPhone(userVO.phone);

        return userDAO.update(userPO);
    }

    @Override
    public ResultMessage registerNormalMember(UserVO userVO) throws RemoteException {
        UserPO userPO = userDAO.findByUsername(userVO.username);

        userPO.getMemberPO().setMemberType(MemberType.NormalMember);
        userPO.setName(userVO.name);
        userPO.setGender(userVO.gender);
        userPO.getMemberPO().setBirthday(userVO.memberVO.birthday);
        userPO.setPhone(userVO.phone);

        return userDAO.update(userPO);
    }

    @Override
    public ResultMessage registerEnterpriseMember(UserVO userVO) throws RemoteException {
        UserPO userPO = userDAO.findByUsername(userVO.username);

        userPO.getMemberPO().setMemberType(MemberType.EnterpriseMember);
        userPO.setName(userVO.name);
        userPO.setGender(userVO.gender);
        userPO.getMemberPO().setBirthday(userVO.memberVO.birthday);
        userPO.setPhone(userVO.phone);
        userPO.getMemberPO().setEnterprise(userVO.memberVO.enterprise);

        return userDAO.update(userPO);
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public ResultMessage topup(String username, double amount) throws RemoteException {
        //客户不存在的情况
        if (userDAO.findByUsername(username) == null)
            return ResultMessage.UsernameNotExisted;

        CreditRecordPO creditRecordPO = new CreditRecordPO();

        creditRecordPO.setrecordID(IDProducer.produceGeneralID());
        creditRecordPO.setChangedTime(LocalDateTime.now());
        creditRecordPO.setUsername(username);
        creditRecordPO.setCreditChangedCause(CreditChangedCause.Recharge);
        creditRecordPO.setOrderID("");
        creditRecordPO.setChangedCredit(amount * 100);
        creditRecordPO.setCurrentCredit(new CreditRecordList(userDAO.findCreditRecordsByUsername(username)).getCurrentCredit() + creditRecordPO.getChangedCredit());

        return userDAO.insertCreditRecord(creditRecordPO);
    }

}
