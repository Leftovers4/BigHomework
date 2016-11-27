package bl.userbl.impl;

import bl.userbl.UserBLService;
import util.ResultMessage;
import vo.user.CreditRecordVO;
import vo.user.UserVO;

import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class UserBlServiceImpl implements UserBLService {

    @Override
    public ResultMessage login(String username, String password) {
        return null;
    }

    @Override
    public ResultMessage logout(String username) {
        return null;
    }

    @Override
    public UserVO getBasicUserInfo(String username) {
        return null;
    }

    @Override
    public ResultMessage updateBasicUserInfo(UserVO userVO) {
        return null;
    }

    @Override
    public List<CreditRecordVO> getCreditRecordsByUsername(String username) {
        return null;
    }

    @Override
    public ResultMessage registerNormalMember(UserVO userVO) {
        return null;
    }

    @Override
    public ResultMessage registerEnterpriseMember(UserVO userVO) {
        return null;
    }

    @Override
    public ResultMessage topup(CreditRecordVO creditRecordVO) {
        return null;
    }

}
