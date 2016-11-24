package bl.hotelbl;

import dataservice.hoteldataservice.HotelDataService;
import rmi.RemoteHelper;
import vo.hotel.RoomVO;

import java.rmi.Remote;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/6.
 */
public class Hotel implements RoomInfoService{

    private HotelDataService hotelDao = RemoteHelper.getInstance().getHotelDAO();

    @Override
    public ArrayList<RoomVO> getRooms() {
        return null;
    }

    @Override
    public ArrayList<RoomVO> setRooms() {
        return null;
    }


}
