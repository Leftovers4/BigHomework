package bl.hotelbl;

import blservice.hotelblservice.HotelBLService;
import util.ResultMessage;
import util.RoomType;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class HotelBlServiceImpl implements HotelBLService{

    HotelList hotelList;

    public HotelBlServiceImpl(){
        hotelList = new HotelList();
    }

    @Override
    public ResultMessage addHotel(HotelVO hotelVO) {
        return null;
    }

    @Override
    public ResultMessage deleteHotel(long hotelID) {
        return null;
    }

    @Override
    public ResultMessage updateHotelInfo(HotelVO hotelVO) {
        return null;
    }

    @Override
    public HotelVO findHotelByID(long hotelID) {
        return null;
    }

    @Override
    public List<HotelVO> findHotelsByConditions(HotelVO hotelVO) {
        return null;
    }

    @Override
    public List<HotelVO> findHotelsByUsername(String username) {
        return null;
    }

    @Override
    public void sortHotels(List<HotelVO> hotelVOs, String key, int mode) {
        hotelList.sort(hotelVOs, key, mode);
    }

    @Override
    public ResultMessage addRoom(RoomVO roomVO) {
        return null;
    }

    @Override
    public ResultMessage deleteRoom(RoomType roomType) {
        return null;
    }

    @Override
    public ResultMessage updateRoomInfo(RoomVO roomVO) {
        return null;
    }

    @Override
    public List<RoomVO> findRoomsByHotelID(long hotelID) {
        return null;
    }

}
