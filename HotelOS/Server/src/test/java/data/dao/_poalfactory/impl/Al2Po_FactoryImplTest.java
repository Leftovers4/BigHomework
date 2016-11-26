package data.dao._poalfactory.impl;

import org.junit.Before;
import org.junit.Test;
import po.user.UserPO;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 11/26/2016.
 */
public class Al2Po_FactoryImplTest {

    Al2Po_FactoryImpl tested;

    @Before
    public void setUp(){
        tested = new Al2Po_FactoryImpl();
    }

    @Test
    public void toUserPO() throws Exception {
        ArrayList<Object> userInfo = new ArrayList<>();
        userInfo.add("Hiki");
        userInfo.add("123");
        userInfo.add("鲁鲁修");
        userInfo.add(true);
        userInfo.add("110");
        userInfo.add("None");
        userInfo.add(1);
        userInfo.add("2007-07-07");
        userInfo.add("BAT");

        ArrayList<Object> crInfo = new ArrayList<>();
        crInfo.add((long)123123);
        crInfo.add("Hiki");
        crInfo.add(11.11);
        crInfo.add(11.11);
        crInfo.add("2010-10-10 11:11:11");
        crInfo.add("Recharge");
        crInfo.add("56465151651651");

        ArrayList<Iterator<Object>> crInfos = new ArrayList<>();
        crInfos.add(crInfo.iterator());

        UserPO userPO = tested.toUserPO(userInfo.iterator(), crInfos.iterator());

        System.out.println(userPO.getUsername() + " " + userPO.getPassword() + " " + userPO.getName() + " " + userPO.getPhone());
        System.out.println(userPO.getMemberPO().getMemberType().toString());
        System.out.println(userPO.getCreditRecordPOs().get(0).getChangedTime());

    }

    @Test
    public void toPersonnelPO() throws Exception {

    }

    @Test
    public void toHotelPO() throws Exception {

    }

    @Test
    public void toRoomPO() throws Exception {

    }

    @Test
    public void toOrderPO() throws Exception {

    }

    @Test
    public void toPromotionPO() throws Exception {

    }

    @Test
    public void toCreditRecordPO() throws Exception {

    }

    @Test
    public void toPromotionTraAreaPO() throws Exception {

    }

    @Test
    public void toPromotionMRPO() throws Exception {

    }

    @Test
    public void toPromotionEntPO() throws Exception {

    }

}