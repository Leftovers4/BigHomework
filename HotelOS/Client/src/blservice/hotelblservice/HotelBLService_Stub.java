package blservice.hotelblservice;

import util.ResultMessage;
import vo.hotel.HotelVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class HotelBLService_Stub implements HotelBLService {
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
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage del(long hotelID) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modify(HotelVO hotelVO) {
        return ResultMessage.SUCCESS;
    }
}
