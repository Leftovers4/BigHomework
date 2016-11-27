package bl.hotelbl.impl;

import vo.hotel.RoomVO;

import java.util.ArrayList;

/**
 * Created by:Hitiger
 * Date: 2016/11/13   Time: 17:44
 * Description:
 */
public interface RoomInfoService {

    // 获得房间类型及数量
    public ArrayList<RoomVO> getRooms();

    // 改变房间类型及数量
    public ArrayList<RoomVO> setRooms();

}
