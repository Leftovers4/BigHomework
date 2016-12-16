package bl.userbl.impl;

import bl.userbl.UserBLService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.userdataservice.UserDataService;
import po.order.OrderPO;
import po.user.CreditRecordPO;
import po.user.UserPO;
import presentation.hotelworkerui.hotelworkerscene.UserReviewPane;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class UserBlServiceImpl implements UserBLService {

    private UserDataService userDAO;

    private OrderDataService orderDAO;

    private UserVOCreater userVOCreater;

    public UserBlServiceImpl() throws RemoteException {
        userDAO = RemoteHelper.getInstance().getUserDAO();
        orderDAO = RemoteHelper.getInstance().getOrderDAO();
        userVOCreater = new UserVOCreater();
    }

    @Override
    public ResultMessage registerUser(String username, String password) throws RemoteException {
        //用户名冲突的情况
        if (!(new UserList(userDAO.findAll()).isValidUsername(username)))
            return ResultMessage.DataExisted;

        //用户名不冲突的情况
        UserPO userPO = new UserPO();

        userPO.setUsername(username);
        userPO.setPassword(password);
        userPO.getMemberPO().setMemberType(MemberType.None);

        return userDAO.insert(userPO);
    }

    @Override
    public ResultMessage login(String username, String password) throws RemoteException {
        UserPO userPO = userDAO.findByUsername(username);

        //客户不存在的情况
        if (userPO == null)
            return ResultMessage.UsernameNotExisted;

        //客户存在且密码错误的情况
        if (!(new User(userPO).passwordCorrect(password)))
            return ResultMessage.PasswordWrong;

        //客户存在且密码正确的情况
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

        //客户存在的情况
        return userVOCreater.createFullUserVO(userPO, userDAO.findCreditRecordsByUsername(username));
    }

    @Override
    public ResultMessage updateBasicUserInfo(UserVO userVO) throws RemoteException {
        UserPO userPO = userDAO.findByUsername(userVO.username);

        //客户不存在的情况
        if (userPO == null)
            return ResultMessage.UsernameNotExisted;

        //客户存在的情况
        userPO.setName(userVO.name);
        userPO.setGender(userVO.gender);
        userPO.getMemberPO().setBirthday(userVO.memberVO.birthday);
        userPO.setPhone(userVO.phone);

        return userDAO.update(userPO);
    }

    @Override
    public ResultMessage updateUserImage(String username, byte[] image) throws RemoteException {
        UserPO userPO = userDAO.findByUsername(username);

        //客户不存在的情况
        if (userPO == null)
            return ResultMessage.UsernameNotExisted;

        //客户存在的情况
        return userDAO.setImage(username, image);
    }

    @Override
    public ResultMessage registerNormalMember(UserVO userVO) throws RemoteException {
        UserPO userPO = userDAO.findByUsername(userVO.username);

        //客户不存在的情况
        if (userPO == null)
            return ResultMessage.UsernameNotExisted;

        //客户存在且信用值不足的情况
        if (!new CreditRecordList(userDAO.findCreditRecordsByUsername(userVO.username)).canRegisterMember())
            return ResultMessage.CreditNotEnough;

        //客户存在且信用值充足且已经注册了普通会员的情况
        MemberType memberType = userPO.getMemberPO().getMemberType();
        if (memberType.equals(MemberType.NormalMember) || memberType.equals(MemberType.Both))
            return ResultMessage.DataExisted;

        //客户存在且信用值充足且未注册普通会员的情况
        userPO.getMemberPO().setMemberType(memberType.equals(MemberType.EnterpriseMember) ? MemberType.Both : MemberType.NormalMember);
        userPO.setName(userVO.name);
        userPO.setGender(userVO.gender);
        userPO.getMemberPO().setBirthday(userVO.memberVO.birthday);
        userPO.setPhone(userVO.phone);

        return userDAO.update(userPO);
    }

    @Override
    public ResultMessage registerEnterpriseMember(UserVO userVO) throws RemoteException {
        UserPO userPO = userDAO.findByUsername(userVO.username);

        //客户不存在的情况
        if (userPO == null)
            return ResultMessage.UsernameNotExisted;

        //客户存在且信用值不足的情况
        if (!new CreditRecordList(userDAO.findCreditRecordsByUsername(userVO.username)).canRegisterMember())
            return ResultMessage.CreditNotEnough;

        //客户存在且信用值充足且已经注册了企业会员的情况
        MemberType memberType = userPO.getMemberPO().getMemberType();
        if (memberType.equals(MemberType.EnterpriseMember) || memberType.equals(MemberType.Both))
            return ResultMessage.DataExisted;

        //客户存在且信用值充足且未注册企业会员的情况
        userPO.getMemberPO().setMemberType(memberType.equals(MemberType.NormalMember) ? MemberType.Both : MemberType.EnterpriseMember);
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

        //客户存在的情况
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

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public ResultMessage deleteUser(String username) throws RemoteException {
        return userDAO.delete(username);
    }

    @Override
    public List<UserVO> getAllUsers() throws RemoteException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<UserVO> res = new ArrayList<>();
        List<UserPO> userPOList = userDAO.findAll();

        for (int i = 0; i < userPOList.size(); i++) {
            List<CreditRecordPO> creditRecordPOList = userDAO.findCreditRecordsByUsername(userPOList.get(i).getUsername());
            res.add(userVOCreater.createFullUserVO(userPOList.get(i), creditRecordPOList));
        }

        return res;
    }

}
