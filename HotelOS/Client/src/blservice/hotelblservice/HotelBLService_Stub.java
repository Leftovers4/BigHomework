package blservice.hotelblservice;

import util.Address;
import util.ResultMessage;
import util.TradingArea;
import vo.hotel.HotelVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class HotelBLService_Stub implements HotelBLService {
    @Override
    public HotelVO find(long hotelID) {
        return new HotelVO("如家", Address.NANJING, TradingArea.XIANLIN_CENTER, "好", "Wifi", null);
    }

    @Override
    public ArrayList<HotelVO> showList(HotelVO hotelVO) {
        ArrayList<HotelVO> list = new ArrayList<>();
        list.add(new HotelVO("如家", Address.NANJING, TradingArea.XIANLIN_CENTER, "好", "Wifi", null));
        return list;
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
