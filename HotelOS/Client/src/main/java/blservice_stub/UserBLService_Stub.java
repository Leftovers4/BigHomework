package blservice_stub;

import bl.userbl.UserBLService;
import util.ResultMessage;
import vo.user.CreditRecordVO;
import vo.user.UserVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by kevin on 2016/10/16.
 */
public class UserBLService_Stub implements UserBLService {
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
        return null;
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

    public ResultMessage topup(CreditRecordVO creditRecordVO) {
        return ResultMessage.Success;
    }

}
