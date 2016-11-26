package blservice_stub;

import blservice.userblservice.UserBLService;
import util.MemberType;
import util.ResultMessage;
import vo.user.CreditRecordVO;
import vo.user.CreditVO;
import vo.user.MemberVO;
import vo.user.UserVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/10/16.
 */
public class UserBLService_Stub implements UserBLService {
    @Override
    public ResultMessage login(String username, String password) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage logout(String username) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public UserVO getBasicUserInfo(String username) {
        return new UserVO("zhangsan", "张三", true, LocalDate.now(), "13112345678", 1000, 2, "华为");
    }

    @Override
    public ResultMessage updateBasicUserInfo(UserVO userVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public List<CreditRecordVO> getCreditRecordsByUsername(String username) {
        return null;
    }

    @Override
    public ResultMessage registerNormalMember(UserVO userVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage registerEnterpriseMember(UserVO userVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage topup(CreditRecordVO creditRecordVO) {
        return ResultMessage.SUCCESS;
    }

}
