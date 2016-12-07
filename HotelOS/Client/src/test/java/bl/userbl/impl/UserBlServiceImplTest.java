package bl.userbl.impl;

import bl.userbl.UserBLService;
import org.junit.Before;
import org.junit.Test;
import util.ResultMessage;
import vo.user.UserVO;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/12/7.
 */
public class UserBlServiceImplTest {
    UserBLService tested;

    @Before
    public void setUp() throws Exception {
        tested = new UserBlServiceImpl();
    }

    @Test
    public void registerUser() throws Exception {
        tested.registerUser("lisi", "8520");
    }

    @Test
    public void login() throws Exception {
        ResultMessage resultMessage = tested.login("List", "8520");
    }

    @Test
    public void logout() throws Exception {

    }

    @Test
    public void getCreditRecordsByUsername() throws Exception {

    }

    @Test
    public void viewBasicUserInfo() throws Exception {

    }

    @Test
    public void updateBasicUserInfo() throws Exception {

    }

    @Test
    public void registerNormalMember() throws Exception {

    }

    @Test
    public void registerEnterpriseMember() throws Exception {

    }

    @Test
    public void topup() throws Exception {

    }

}