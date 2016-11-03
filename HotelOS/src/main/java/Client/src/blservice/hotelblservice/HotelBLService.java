package blservice.hotelblservice;
import util.*;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;

import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/15.
 */
public interface HotelBLService {

    // 根据酒店ID查找用户
    public HotelVO find(long hotelID);

    // 根据条件显示酒店列表
    public ArrayList<HotelVO> showList(HotelVO hotelVO);

    // 添加酒店
    public ResultMessage add(HotelVO hotelVO);

    // 删除酒店
    public ResultMessage del(long hotelID);

    // 修改酒店信息
    public ResultMessage modify(HotelVO hotelVO);

    // 获得房间类型及数量
    public ArrayList<RoomVO> getRooms();

    // 改变房间类型及数量
    public ArrayList<RoomVO> setRooms();


}
