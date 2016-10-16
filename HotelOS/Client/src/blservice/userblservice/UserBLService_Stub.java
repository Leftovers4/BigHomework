package blservice.userblservice;

import util.MemberType;
import util.ResultMessage;
import util.UserType;

/**
 * Created by kevin on 2016/10/16.
 */
public class UserBLService_Stub implements UserBLService {
    @Override
    public ResultMessage login(UserVO userVO) {
        return null;
    }

    @Override
    public ResultMessage logout() {
        return null;
    }

    @Override
    public ResultMessage add(UserVO userVO) {
        return null;
    }

    @Override
    public ResultMessage del(UserVO userVO) {
        return null;
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
        return null;
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
        return null;
    }

    @Override
    public ResultMessage deductCredit(String username, double amount) {
        return null;
    }
}
