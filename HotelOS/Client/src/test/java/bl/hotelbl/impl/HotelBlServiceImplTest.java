package bl.hotelbl.impl;

import bl.hotelbl.HotelBLService;
import org.junit.Before;
import org.junit.Test;
import util.IDProducer;
import util.ResultMessage;
import util.RoomType;
import vo.hotel.HotelConditionsVO;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        hotelVO.star = 2;
        hotelVO.address = "nanjing";
        hotelVO.tradingArea = "xinjiekou";

        long ID = tested.addHotel(hotelVO);
    }

    @Test
    public void deleteHotel() throws Exception {
        ResultMessage resultMessage = tested.deleteHotel(751796);
    }

    @Test
    public void viewBasicHotelInfo() throws Exception {
        HotelVO hotelVO = tested.viewBasicHotelInfo(522000);
    }

    @Test
    public void updateBasicHotelInfo() throws Exception {
        HotelVO hotelVO = new HotelVO();

        hotelVO.hotelID = 522000; //提供唯一标识
        hotelVO.address = "上海";
        hotelVO.tradingArea = "外滩";
        hotelVO.description = "hahhahhahahahahahaha";
        hotelVO.service = "wifi, free parking";

        ResultMessage resultMessage = tested.updateBasicHotelInfo(hotelVO);
    }

    @Test
    public void addRoom() throws Exception {
        RoomVO roomVO = new RoomVO();

        roomVO.hotelID = 362355;
        roomVO.roomType = RoomType.BusinessSuite;
        roomVO.total = 20;
        roomVO.price = 150;

        ResultMessage resultMessage = tested.addRoom(roomVO);
    }

    @Test
    public void deleteRoom() throws Exception {
        ResultMessage resultMessage = tested.deleteRoom(862176);
    }

    @Test
    public void updateRoomInfo() throws Exception {
        RoomVO roomVO = new RoomVO();

        roomVO.roomID = 236992; //提供唯一标识
        roomVO.total = 15;
        roomVO.price = 150;

        ResultMessage resultMessage = tested.updateRoomInfo(roomVO);
    }

    @Test
    public void viewFullRoomInfo() throws Exception {
        RoomVO roomVO = tested.viewFullRoomInfo(236992, LocalDateTime.now(), LocalDateTime.now().plusDays(2));
    }

    @Test
    public void viewAllHotelRooms() throws Exception {
        List<RoomVO> roomVOList = tested.viewAllHotelRooms(362355);
    }

    @Test
    public void offlineCheckIn() throws Exception {
        ResultMessage resultMessage = tested.offlineCheckIn(236992, 1);
    }

    @Test
    public void offlineCheckOut() throws Exception {
        tested.offlineCheckOut(530680, 2);
    }

    @Test
    public void viewOfflineCheckInRoomAmount() throws Exception {
        int amount = tested.viewOfflineCheckInRoomAmount(145328);
    }

    @Test
    public void setHotelImage() throws Exception {

    }

    @Test
    public void sortHotels() throws Exception {
        List<HotelVO> hotelVOList1 = tested.viewFullHotelList();
        HotelVOList hotelVOList2 = new HotelVOList(hotelVOList1);
        hotelVOList2.sort("star", 0);
    }

    @Test
    public void searchHotelsByConditions() throws Exception {
        List<HotelVO> hotelVOList = tested.searchHotelsByConditions("Hiki", new HotelConditionsVO());
    }

    @Test
    public void viewOrderedHotelList() throws Exception {
        List<HotelVO> hotelVOList = tested.viewOrderedHotelList("Hikii");
    }

    @Test
    public void viewFullHotelList() throws Exception {
        List<HotelVO> hotelVOList = tested.viewFullHotelList();
    }

    @Test
    public void viewDetailedHotelInfo() throws Exception {
        HotelVO hotelVO = tested.viewDetailedHotelInfo(522000, "Hiki");
    }

}