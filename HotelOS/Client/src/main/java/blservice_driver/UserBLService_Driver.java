package blservice_driver;

import blservice.userblservice.UserBLService;
import org.junit.Before;
import org.junit.Test;
import util.ResultMessage;
import vo.user.UserVO;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kevin on 2016/10/16.
 */
public class UserBLService_Driver {
    UserBLService tested;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void login() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.login("zhangsan", "123456"));
    }

    @Test
    public void logout() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.logout("zhangsan"));
    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void del() throws Exception {

    }

    @Test
    public void find() throws Exception {

    }


    @Test
    public void getInfo() throws Exception {
    }

    @Test
    public void setInfo() throws Exception {

    }

    @Test
    public void showList() throws Exception {

    }

    @Test
    public void getMemberType() throws Exception {

    }

    @Test
    public void addCredit() throws Exception {

    }

    @Test
    public void deductCredit() throws Exception {

    }

    private void printUserVO(UserVO userVO){
        System.out.println(userVO.username);
        System.out.println(userVO.password);
    }
}