package blservice_stub;

import blservice.userblservice.UserBLService;
import util.MemberType;
import util.ResultMessage;
import util.UserType;
import vo.user.CreditVO;
import vo.user.MemberVO;
import vo.user.UserVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class UserBLService_Stub implements UserBLService {
    @Override
    public ResultMessage login(UserVO userVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage logout() {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage add(UserVO userVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage del(String username) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public UserVO find(String username) {
        return new UserVO("zhangsan", "123456", "张三", true, "110", null, null);
    }

    @Override
    public ArrayList<UserVO> showListByType(UserType userType) {
        ArrayList<UserVO> list = new ArrayList<UserVO>();
        list.add(new UserVO("zhangsan", "123456", "张三", true, "110", null, null));
        return list;
    }

    @Override
    public UserVO getInfo(String username) {
        return new UserVO("zhangsan", "123456", "张三", true, "110", null, null);
    }

    @Override
    public ResultMessage setInfo(UserVO userVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<UserVO> showList() {
        ArrayList<UserVO> list = new ArrayList<UserVO>();
        list.add(new UserVO("zhangsan", "123456", "张三", true, "110", null, null));
        return list;
    }

    @Override
    public MemberType getMemberType(String username) {
        return MemberType.NORMAL_MEMBER;
    }

    @Override
    public ResultMessage register(MemberVO memberVO) {
        return null;
    }

    @Override
    public ResultMessage delete(String username) {
        return null;
    }

    @Override
    public MemberVO showInfo(String username) {
        return null;
    }

    @Override
    public ResultMessage addCredit(String username, double amount) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deductCredit(String username, double amount) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public CreditVO showCreditRecord(String username) {
        return null;
    }
}
