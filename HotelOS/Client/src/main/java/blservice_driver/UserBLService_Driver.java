package blservice_driver;

import blservice.userblservice.UserBLService;
import org.junit.Before;
import org.junit.Test;
import util.ResultMessage;
import util.UserType;
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
        assertEquals(ResultMessage.SUCCESS, tested.login(new UserVO("zhangsan", "123456", "张三", true, "110", null, null)));
    }

    @Test
    public void logout() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.logout());
    }

    @Test
    public void add() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.add(new UserVO("zhangsan", "123456", "张三", true, "110", null, null)));
    }

    @Test
    public void del() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.del(new UserVO("zhangsan", "123456", "张三", true, "110", null, null)));
    }

    @Test
    public void find() throws Exception {
        UserVO res = tested.find("张三");
        printUserVO(res);
    }

    @Test
    public void showListByType() throws Exception {
        ArrayList<UserVO> res = tested.showListByType(UserType.CLIENT);
        for (int i = 0; i < res.size(); i++) {
            printUserVO(res.get(i));
        }
    }

    @Test
    public void getInfo() throws Exception {
        UserVO res = tested.getInfo("张三");
        printUserVO(res);
    }

    @Test
    public void setInfo() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.setInfo(new UserVO("zhangsan", "123456", "张三", true, "110", null, null)));
    }

    @Test
    public void showList() throws Exception {
        ArrayList<UserVO> res = tested.showList();
        for (int i = 0; i < res.size(); i++) {
            printUserVO(res.get(i));
        }
    }

    @Test
    public void getMemberType() throws Exception {
        System.out.println(tested.getMemberType("张三"));
    }

    @Test
    public void addCredit() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.addCredit("张三", 100));
    }

    @Test
    public void deductCredit() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.deductCredit("张三", 100));
    }

    private void printUserVO(UserVO userVO){
        System.out.println(userVO.username);
        System.out.println(userVO.password);
    }
}