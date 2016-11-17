package bl.hotelbl;

import blservice.hotelblservice.HotelBLService;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/6.
 */
public class HotelController implements HotelBLService{
    @Override
    public HotelVO find(long hotelID) {
        return null;
    }

    @Override
    public ArrayList<HotelVO> showList(HotelVO hotelVO) {
        return null;
    }

    @Override
    public ResultMessage add(HotelVO hotelVO) {
        return null;
    }

    @Override
    public ResultMessage del(long hotelID) {
        return null;
    }

    @Override
    public ResultMessage modify(HotelVO hotelVO) {
        return null;
    }

    @Override
    public ArrayList<RoomVO> getRooms() {
        return null;
    }

    @Override
    public ArrayList<RoomVO> setRooms() {
        return null;
    }

    @Override
    public double getRating() {
        return 0;
    }

}
