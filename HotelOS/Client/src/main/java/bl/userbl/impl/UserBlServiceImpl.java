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

    public UserBlServiceImpl(){
        userDAO = RemoteHelper.getInstance().getUserDAO();
        userVOCreater = new UserVOCreater();
    }

    @Override
    public ResultMessage login(String username, String password) {
        return null;
    }

    @Override
    public ResultMessage logout(String username) {
        return null;
    }

    @Override
    public List<CreditRecordVO> getCreditRecordsByUsername(String username) {
        return null;
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public UserVO viewBasicUserInfo(String username) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, RemoteException {
        UserPO userPO = userDAO.findByUsername(username);
        List<CreditRecordPO> creditRecordPOList = userDAO.findCreditRecordsByUsername(username);
        return userVOCreater.createFullUserVO(userPO, creditRecordPOList);
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
