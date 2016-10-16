package blservice.hotelblservice;

import vo.hotel.HotelVO;

import java.util.ArrayLis

/**
 * Created by Hiki on 2016/10/15.
 */
public interface HotelBLService {

    // 根据酒店ID查找用户
    public HotelVO (long hotelID);

    // 根据条件显示酒店列表
    public ArrayList<HotelVO> showList(HotelVO hotelVO);

    // 添加酒店
    public ResultMessage add(HotelVO hotelVO);

    // 删除酒店
    public ResultMessage del(long hotelID);

    // 修改酒店信息
    public ResultMessage modify(HotelVO);


}
