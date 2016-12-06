package bl.hotelbl.impl;

import bl.hotelbl.HotelBLService;
import org.junit.Before;
import org.junit.Test;
import util.IDProducer;
import vo.hotel.HotelVO;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/12/5.
 */
public class HotelBlServiceImplTest {
    HotelBLService tested;

    @Before
    public void setUp() throws Exception {
        tested = new HotelBlServiceImpl();
    }

    @Test
    public void addHotel() throws Exception {
        HotelVO hotelVO = new HotelVO();

        hotelVO.hotelName = "哈哈";
        hotelVO.star = 4;

        tested.addHotel(hotelVO);
    }

    @Test
    public void deleteHotel() throws Exception {

    }

    @Test
    public void findHotelByID() throws Exception {

    }

    @Test
    public void viewBasicHotelInfo() throws Exception {

    }

    @Test
    public void updateBasicHotelInfo() throws Exception {

    }

    @Test
    public void addRoom() throws Exception {

    }

    @Test
    public void deleteRoom() throws Exception {

    }

    @Test
    public void updateRoomInfo() throws Exception {

    }

    @Test
    public void viewAllHotelRooms() throws Exception {

    }

    @Test
    public void offlineCheckIn() throws Exception {

    }

    @Test
    public void offlineCheckOut() throws Exception {

    }

    @Test
    public void viewOfflineCheckInRoomAmount() throws Exception {

    }

    @Test
    public void sortHotels() throws Exception {

    }

    @Test
    public void searchHotelsByConditions() throws Exception {

    }

    @Test
    public void viewOrderedHotelList() throws Exception {

    }

}