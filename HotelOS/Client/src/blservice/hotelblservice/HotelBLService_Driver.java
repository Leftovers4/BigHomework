package blservice.hotelblservice;

import org.junit.Before;
import org.junit.Test;
import util.ResultMessage;
import vo.hotel.HotelVO;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/10/16.
 */
public class HotelBLService_Driver {
    HotelBLService tested;

    @Before
    public void setUp(HotelBLService hotelBLService) throws Exception {
        tested = hotelBLService;
    }

    @Test
    public void find() throws Exception {

    }

    @Test
    public void showList() throws Exception {

    }

    @Test
    public void add() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.add(new HotelVO()));
    }

    @Test
    public void del() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.del(123456));
    }

    @Test
    public void modify() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.modify(new HotelVO()));
    }

}