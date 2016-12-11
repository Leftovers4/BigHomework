package bl.userbl.impl;

import bl.userbl.UserBLService;
import org.junit.Before;
import org.junit.Test;
import util.ResultMessage;
import vo.user.CreditRecordVO;
import vo.user.MemberVO;
import vo.user.UserVO;

import java.time.LocalDate;
import java.util.List;

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
        ResultMessage resultMessage = tested.registerUser("Hikii", "8520");
    }

    @Test
    public void login() throws Exception {
        ResultMessage resultMessage = tested.login("lisii", "852");
    }

    @Test
    public void logout() throws Exception {

    }

    @Test
    public void getCreditRecordsByUsername() throws Exception {
        List<CreditRecordVO> creditRecordVOList = tested.getCreditRecordsByUsername("lisii");
    }

    @Test
    public void viewBasicUserInfo() throws Exception {
        UserVO userVO = tested.viewBasicUserInfo("lisii");
    }

    @Test
    public void updateBasicUserInfo() throws Exception {
        UserVO userVO = new UserVO();

        userVO.username = "lisii"; //提供唯一标识
        userVO.name = "张张";
        userVO.gender = true;
        userVO.memberVO.birthday = LocalDate.now();
        userVO.phone = "123456789";

        ResultMessage resultMessage = tested.updateBasicUserInfo(userVO);
    }

    @Test
    public void registerNormalMember() throws Exception {
        UserVO userVO = new UserVO();

        userVO.username = "lisii"; //提供唯一标识
        userVO.name = "张";
        userVO.gender = true;
        userVO.memberVO.birthday = LocalDate.now();
        userVO.phone = "123456789";

        ResultMessage resultMessage = tested.registerNormalMember(userVO);
    }

    @Test
    public void registerEnterpriseMember() throws Exception {
        UserVO userVO = new UserVO();

        userVO.username = "lisiii"; //提供唯一标识
        userVO.name = "张";
        userVO.gender = true;
        userVO.phone = "123456789";
        userVO.memberVO.birthday = LocalDate.now();
        userVO.memberVO.enterprise = "华为";

        ResultMessage resultMessage = tested.registerEnterpriseMember(userVO);
    }

    @Test
    public void topup() throws Exception {
        ResultMessage resultMessage = tested.topup("Hikii", 50);
    }

    @Test
    public void deleteUser() throws Exception {
        ResultMessage resultMessage = tested.deleteUser("lisi");
    }

    @Test
    public void getAllUsers() throws Exception {
        List<UserVO> userVOList = tested.getAllUsers();
    }

}