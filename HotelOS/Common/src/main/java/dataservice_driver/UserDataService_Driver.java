package dataservice_driver;

import dataservice.userdataservice.UserDataService;
import org.junit.Before;
import org.junit.Test;
import po.user.UserPO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class UserDataService_Driver {
    UserDataService tested;

    @Before
    public void setUp() throws Exception {

    }

//    @Test
//    public void findByUsername() throws Exception {
//        UserPO res = tested.findByUsername("张三");
//        printUserPO(res);
//    }


    @Test
    public void insert() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

//    @Test
//    public void getList() throws Exception {
//        ArrayList<UserPO> res = tested.findAll();
//        for (int i = 0; i < res.size(); i++) {
//            printUserPO(res.get(i));
//        }
//    }

    @Test
    public void addCredit() throws Exception {

    }

    @Test
    public void deductCredit() throws Exception {

    }

    private void printUserPO(UserPO userPO){
        System.out.println(userPO.getUsername());
        System.out.println(userPO.getPassword());
        System.out.println(userPO.getMemberPO());
        System.out.println(userPO.getName());
        System.out.println(userPO.isGender());
        System.out.println(userPO.getPhone());
//        System.out.println(userPO.getCreditRecordPOs().get(0));
    }
}