package bl.hotelbl.impl;

import bl.hotelbl.HotelBLService;
import org.junit.Before;
import org.junit.Test;
import util.IDProducer;
import util.RoomType;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;

import java.util.List;

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

        hotelVO.hotelName = "demo";
        hotelVO.star = 4;

        tested.addHotel(hotelVO);
    }

    @Test
    public void deleteHotel() throws Exception {
        tested.deleteHotel(751796);
    }

    @Test
    public void viewBasicHotelInfo() throws Exception {
        HotelVO hotelVO = tested.viewBasicHotelInfo(145328);
    }

    @Test
    public void updateBasicHotelInfo() throws Exception {
        HotelVO hotelVO = new HotelVO();

        hotelVO.hotelID = 145328;
        hotelVO.address = "上海";
        hotelVO.tradingArea = "外滩";
        hotelVO.description = "hahhahhahahahahahaha";
        hotelVO.service = "wifi, free parking";

        tested.updateBasicHotelInfo(hotelVO);
    }

    @Test
    public void addRoom() throws Exception {
        RoomVO roomVO = new RoomVO();

        roomVO.hotelID = 145328;
        roomVO.roomType = RoomType.Single;
        roomVO.total = 20;
        roomVO.price = 100;

        tested.addRoom(roomVO);
    }

    @Test
    public void deleteRoom() throws Exception {
        tested.deleteRoom(344681);
    }

    @Test
    public void updateRoomInfo() throws Exception {
        RoomVO roomVO = new RoomVO();

        roomVO.roomID = 530680;
        roomVO.total = 15;
        roomVO.price = 150;

        tested.updateRoomInfo(roomVO);
    }

    @Test
    public void viewAllHotelRooms() throws Exception {
        List<RoomVO> roomVOList = tested.viewAllHotelRooms(145328);
        int i = 0;
    }

    @Test
    public void offlineCheckIn() throws Exception {
        tested.offlineCheckIn(568847, 1);
    }

    @Test
    public void offlineCheckOut() throws Exception {
        tested.offlineCheckOut(530680, 2);
    }

    @Test
    public void viewOfflineCheckInRoomAmount() throws Exception {
        int amount = tested.viewOfflineCheckInRoomAmount(145328);
        System.out.print(amount);
    }

    @Test
    public void sortHotels() throws Exception {

    }

    @Test
    public void searchHotelsByConditions() throws Exception {

    }

    @Test
    public void viewOrderedHotelList() throws Exception {
        List<HotelVO> hotelVOList = tested.viewOrderedHotelList("Hiki");
        int i = 0;
    }

}