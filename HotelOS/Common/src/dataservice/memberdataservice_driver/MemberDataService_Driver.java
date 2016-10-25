package dataservice.memberdataservice_driver;

import dataservice.memberdataservice.MemberDataService;
import org.junit.Before;
import org.junit.Test;
import po.member.MemberPO;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/10/16.
 */
public class MemberDataService_Driver {
    MemberDataService tested;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void find() throws Exception {
        MemberPO res = tested.find("张三");
        printMemberPO(res);
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    private void printMemberPO(MemberPO memberPO){
        System.out.println(memberPO.getMemberType());
        System.out.println(memberPO.getUsername());
        System.out.println(memberPO.getLevel());
        System.out.println(memberPO.getBirthday());
        System.out.println(memberPO.getEnterprise());
    }
}