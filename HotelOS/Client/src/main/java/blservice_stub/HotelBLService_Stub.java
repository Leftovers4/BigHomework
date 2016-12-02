package blservice_stub;

import bl.hotelbl.HotelBLService;
import util.ResultMessage;
import util.RoomType;
import vo.hotel.HotelVO;
import vo.hotel.LogicVOHelper;
import vo.hotel.RoomVO;
import vo.order.ReviewVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/10/16.
 */
public class HotelBLService_Stub implements HotelBLService {

    List<RoomVO> list;
    LogicVOHelper logicVOHelper;

    public HotelBLService_Stub(){
         list = new ArrayList<>();
         logicVOHelper = new LogicVOHelper();
    }

    @Override
    public ResultMessage addHotel(HotelVO hotelVO) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage deleteHotel(long hotelID) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage updateBasicHotelInfo(HotelVO hotelVO) {
        return ResultMessage.Success;
    }

    @Override
    public HotelVO findHotelByID(long hotelID) {
        return logicVOHelper.create(1,"如家", "工作人员", 4, 4.3, "南京", "新街口地区", "好", "Wifi");
    }

    @Override
    public List<HotelVO> findHotelsByConditions(HotelVO hotelVO) {
        ArrayList<HotelVO> list = new ArrayList<HotelVO>();
        list.add(logicVOHelper.create(1, "如家", "工作人员", 4, 4.3, "南京", "新街口地区", "好", "Wifi"));
        return list;
    }

    @Override
    public List<HotelVO> findHotelsByUsername(String username) {
        return null;
    }

    @Override
    public void sortHotels(List<HotelVO> hotelVOs, String key, int mode) {

    }

    @Override
    public ResultMessage addRoom(RoomVO roomVO) {
        list.add(roomVO);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage deleteRoom(long roomID) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage updateRoomInfo(RoomVO roomVO) {
        return ResultMessage.Success;
    }

    @Override
    public List<RoomVO> findRoomsByHotelID(long hotelID) {

        list.add(logicVOHelper.create(hotelID,RoomType.Single,10,100));
        list.add(logicVOHelper.create(hotelID,RoomType.Single,20,200));
        list.add(logicVOHelper.create(hotelID,RoomType.Couple,10,300));
        list.add(logicVOHelper.create(hotelID,RoomType.Couple,20,400));
        list.add(logicVOHelper.create(hotelID,RoomType.Couple,30,500));
        return list;
    }

    @Override
    public HotelVO viewBasicHotelInfo(long hotelID) {
        return logicVOHelper.create(1,"如家", "工作人员", 4, 4.3, "南京", "新街口地区", "好", "Wifi");
    }

    @Override
    public List<ReviewVO> viewHotelReviews(long hotelID) {
        return null;
    }

    @Override
    public ResultMessage updateBasicHotelInfo(long hotelID, String address, String tradingArea, String description, String service) {
        return null;
    }
}
