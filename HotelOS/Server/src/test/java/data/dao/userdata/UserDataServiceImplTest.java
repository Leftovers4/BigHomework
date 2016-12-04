package data.dao.userdata;

import org.junit.Before;
import org.junit.Test;
import po.user.CreditRecordPO;
import po.user.UserPO;
import util.CommonMethod;
import util.POProducer;
import util.ResultMessage;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/4/2016.
 */
public class UserDataServiceImplTest {

    UserDataServiceImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new UserDataServiceImpl();
    }

    @Test
    public void insert() throws Exception {
        ResultMessage resultMessage = tested.insert(POProducer.getUserPO());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void delete() throws Exception {
        ResultMessage resultMessage = tested.delete(POProducer.getUserPO().getUsername());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void update() throws Exception {
        ResultMessage resultMessage = tested.update(POProducer.getUserPO());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void findAll() throws Exception {
        ArrayList<UserPO> userPOs = tested.findAll();
        for (UserPO each : userPOs) {
            CommonMethod.printClass(each);
        }

    }

    @Test
    public void findByUsername() throws Exception {
        UserPO userPO = tested.findByUsername(POProducer.getUserPO().getUsername());
        if (userPO != null){
            CommonMethod.printClass(userPO);
        }
    }

    @Test
    public void insertCreditRecord() throws Exception {
        ResultMessage resultMessage = tested.insertCreditRecord(POProducer.getCreditRecordPO());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void findCreditRecordsByUsername() throws Exception {
        ArrayList<CreditRecordPO> creditRecordPOs = tested.findCreditRecordsByUsername(POProducer.getCreditRecordPO().getUsername());
        for (CreditRecordPO each : creditRecordPOs) {
            CommonMethod.printClass(each);
        }

    }

}