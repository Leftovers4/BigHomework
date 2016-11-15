package blservice_driver;

import blservice.hotelblservice.HotelBLService;
import blservice_stub.HotelBLService_Stub;
import org.junit.Before;
import org.junit.Test;
import util.Address;
import util.ResultMessage;
import util.TradingArea;
import vo.hotel.HotelVO;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kevin on 2016/10/16.
 */
public class HotelBLService_Driver {
    HotelBLService tested;

    @Before
    public void setUp() throws Exception {
        tested = new HotelBLService_Stub();
    }

    @Test
    public void find() throws Exception {
        HotelVO res = tested.find(123456);
        printHotelVO(res);
    }

    @Test
    public void showList() throws Exception {
        ArrayList<HotelVO> res = tested.showList(new HotelVO("如家", Address.NANJING, TradingArea.XIANLIN_CENTER, "好", "Wifi", null));
        for (int i = 0; i < res.size(); i++) {
            printHotelVO(res.get(i));
        }
    }

    @Test
    public void add() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.add(new HotelVO("如家", Address.NANJING, TradingArea.XIANLIN_CENTER, "好", "Wifi", null)));
    }

    @Test
    public void del() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.del(123456));
    }

    @Test
    public void modify() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.modify(new HotelVO("如家", Address.NANJING, TradingArea.XIANLIN_CENTER, "好", "Wifi", null)));
    }

    @Test
    public void getRating() throws Exception {
        assertEquals(0, tested.getRating());
    }

    private void printHotelVO(HotelVO hotelVO){
        System.out.println(hotelVO.HotelID);
        System.out.println(hotelVO.hotelName);
        System.out.println(hotelVO.address);
        System.out.println(hotelVO.tradingArea);
        System.out.println(hotelVO.rooms.get(0).roomType);
        System.out.println(hotelVO.description);
        System.out.println(hotelVO.reviews.get(0).review);
    }
}