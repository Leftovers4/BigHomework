package blservice.userblservice;

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
        return null;
    }

    @Override
    public ArrayList<UserVO> showListByType(UserType userType) {
        return null;
    }

    @Override
    public UserVO getInfo(String username) {
        return null;
    }

    @Override
    public ResultMessage setInfo(UserVO userVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<UserVO> showList() {
        return null;
    }

    @Override
    public MemberType getMemberType(String username) {
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
}
