package blservice.memberblservice_driver;

import blservice.memberblservice.MemberBLService;
import org.junit.Before;
import org.junit.Test;
import util.MemberType;
import util.ResultMessage;
import vo.member.MemberVO;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/10/16.
 */
public class MemberBLService_Driver {
    MemberBLService tested;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void register() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.register(new MemberVO("张三", MemberType.NORMAL_MEMBER, 1, null, null)));
    }

    @Test
    public void delete() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.delete("张三"));
    }

    @Test
    public void showInfo() throws Exception {
        MemberVO res = tested.showInfo("张三");
        printMemberVO(res);
    }

    private void printMemberVO(MemberVO memberVO){
        System.out.println(memberVO.memberType);
        System.out.println(memberVO.username);
        System.out.println(memberVO.level);
        System.out.println(memberVO.birthday);
        System.out.println(memberVO.enterprise);
    }
}