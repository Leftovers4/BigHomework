package dataservice_driver;

import dataservice.hoteldataservice.HotelDataService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import po.hotel.HotelPO;
import util.Address;
import util.TradingArea;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kevin on 2016/10/16.
 */
public class HotelDataService_Driver {
    HotelDataService tested;

    @Before
    public void setUp() throws Exception {

    }

//    @Test
//    public void findByHotelID() throws Exception {
//        HotelPO res = tested.findByHotelID(123456);
//        printHotelPO(res);
//    }

//    @Test
//    @Ignore
//    public void findByHotelPO() throws Exception {
//        ArrayList<HotelPO> res = tested.findByHotelPO(new HotelPO("如家", Address.NANJING, TradingArea.XIANLIN_CENTER, "好", "Wifi", null));
//        for (int i = 0; i < res.size(); i++) {
//            printHotelPO(res.get(i));
//        }
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

    @Test
    public void getRating() throws Exception {
//        assertEquals(0, tested.getRating());
    }

    private void printHotelPO(HotelPO hotelPO){
        System.out.println(hotelPO.getHotelID());
        System.out.println(hotelPO.getHotelName());
        System.out.println(hotelPO.getAddress());
        System.out.println(hotelPO.getTradingArea());
        System.out.println(hotelPO.getRooms().get(0).getRoomType());
        System.out.println(hotelPO.getDescription());
        System.out.println(hotelPO.getReviews().get(0).getReview());
    }
}