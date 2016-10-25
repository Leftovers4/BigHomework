package blservice.userblservice_stub;

import blservice.userblservice.UserBLService;
import util.MemberType;
import util.ResultMessage;
import util.UserType;
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
    public ResultMessage del(UserVO userVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public UserVO find(String username) {
        return new UserVO("张三", "123456");
    }

    @Override
    public ArrayList<UserVO> showListByType(UserType userType) {
        ArrayList<UserVO> list = new ArrayList<>();
        list.add(new UserVO("张三", "123456"));
        return list;
    }

    @Override
    public UserVO getInfo(String username) {
        return new UserVO("张三", "123456");
    }

    @Override
    public ResultMessage setInfo(UserVO userVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<UserVO> showList() {
        ArrayList<UserVO> list = new ArrayList<>();
        list.add(new UserVO("张三", "123456"));
        return list;
    }

    @Override
    public MemberType getMemberType(String username) {
        return MemberType.NORMAL_MEMBER;
    }

    @Override
    public ResultMessage addCredit(String username, double amount) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deductCredit(String username, double amount) {
        return ResultMessage.SUCCESS;
    }
}
