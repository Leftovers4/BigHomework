package dataservice.userdataservice_driver;

import dataservice.userdataservice.UserDataService;
import org.junit.Before;
import org.junit.Test;
import po.user.ClientPO;
import util.UserType;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class UserDataService_Driver {
    UserDataService tested;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByUsername() throws Exception {
        ClientPO res = tested.findByUsername("张三");
        printUserPO(res);
    }

    @Test
    public void findByType() throws Exception {
        ArrayList<ClientPO> res = tested.findByType(UserType.WEB_ADMINISTRATOR);
        for (int i = 0; i < res.size(); i++) {
            printUserPO(res.get(i));
        }
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

    @Test
    public void getList() throws Exception {
        ArrayList<ClientPO> res = tested.getList();
        for (int i = 0; i < res.size(); i++) {
            printUserPO(res.get(i));
        }
    }

    @Test
    public void addCredit() throws Exception {

    }

    @Test
    public void deductCredit() throws Exception {

    }

    private void printUserPO(ClientPO clientPO){
        System.out.println(clientPO.getUsername());
        System.out.println(clientPO.getPassword());
        System.out.println(clientPO.getMemberType());
        System.out.println(clientPO.getName());
        System.out.println(clientPO.isGender());
        System.out.println(clientPO.getPhone());
        System.out.println(clientPO.getCreditPO().getCredit());
    }
}