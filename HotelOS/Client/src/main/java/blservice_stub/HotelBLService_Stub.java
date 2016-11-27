package blservice_stub;

import blservice.hotelblservice.HotelBLService;
import po.hotel.HotelPO;
import util.Address;
import util.ResultMessage;
import util.RoomType;
import util.TradingArea;
import vo.hotel.HotelVO;
import vo.hotel.LogicVOHelper;
import vo.hotel.RoomVO;

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
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteHotel(long hotelID) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage updateBasicHotelInfo(HotelVO hotelVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public HotelVO getBasicHotelInfo(long hotelID) {
        return logicVOHelper.create(1,"如家", "工作人员", 4, 4.3, "南京", "新街口地区", "好", "Wifi");
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
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage deleteRoom(long roomID) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage updateRoomInfo(RoomVO roomVO) {
        return ResultMessage.SUCCESS;
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
}
