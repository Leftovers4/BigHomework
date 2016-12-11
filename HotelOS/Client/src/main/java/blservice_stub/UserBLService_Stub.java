package blservice_stub;

import bl.userbl.UserBLService;
import util.CreditChangedCause;
import util.ResultMessage;
import vo.user.CreditRecordVO;
import vo.user.UserVO;
import vo.user.UserVOCreater;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/10/16.
 */
public class UserBLService_Stub implements UserBLService {

    UserVOCreater userVOCreater;

    public UserBLService_Stub(){
        userVOCreater = new UserVOCreater();
    }

    @Override
    public ResultMessage registerUser(String username, String password) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage login(String username, String password) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage logout(String username) {
        return ResultMessage.Success;
    }

    public UserVO getBasicUserInfo(String username) {
        return new UserVO();
    }

    @Override
    public ResultMessage updateBasicUserInfo(UserVO userVO) {
        return ResultMessage.Success;
    }

    @Override
    public List<CreditRecordVO> getCreditRecordsByUsername(String username) {
        ArrayList<CreditRecordVO> list = new ArrayList<>();
        CreditRecordVO creditRecordVO = new CreditRecordVO();
        creditRecordVO.changedTime = LocalDateTime.parse("2016-01-01T11:11:11");
        creditRecordVO.orderID = "52200020161111000";
        creditRecordVO.creditChangedCause = CreditChangedCause.Recharge;
        creditRecordVO.changedCredit = 0.10;
        creditRecordVO.currentCredit = 1.00;
        list.add(creditRecordVO);
        list.add(creditRecordVO);
        list.add(creditRecordVO);
        list.add(creditRecordVO);
        return list;
    }

    @Override
    public UserVO viewBasicUserInfo(String username) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, RemoteException {
        return null;
    }

    @Override
    public ResultMessage registerNormalMember(UserVO userVO) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage registerEnterpriseMember(UserVO userVO) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage topup(String username, double amount) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage deleteUser(String username) throws RemoteException {
        return null;
    }

    @Override
    public List<UserVO> getAllUsers() {
        return null;
    }

    public ResultMessage topup(CreditRecordVO creditRecordVO) {
        return ResultMessage.Success;
    }

}
