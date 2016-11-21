package data.datahelper.hoteldatahelper;

import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/20/2016.
 */
public interface HotelDataHelper {

    // 格式："hotel_id", "hotel_name", "star", "address", "trading_area", "description", "service"

    /**
     * 根据酒店ID从hotel表中查找酒店信息
     * @param hotelID
     * @return
     */
    public ArrayList<Object> findByIdFromSQL(long hotelID);

    /**
     * 根据条件从hotel表中查找酒店列表
     * 输入格式：用Object包装列表信息，若HotelPO中有条件未提及，则用'%'表示
     * @param hotelInfo
     * @return
     */
    public ArrayList<ArrayList<Object>> findByConditionsFromSQL(ArrayList<Object> hotelInfo);

    /**
     * 往hotel表中添加一条酒店信息
     * @param hotelInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> hotelInfo);

    /**
     * 在hotel表中删除一条酒店信息
     * @param hotelID 
     * @return
     */
    public ResultMessage deleteFromSQL(long hotelID);

    /**
     * 在hotel表中更新一条酒店信息
     * @param hotelInfo
     * @return
     */
    public ResultMessage updateFromSQL(ArrayList<Object> hotelInfo);

    /**
     * 根据hotelID在room表中查找相应的rooms列表
     * @param hotelID
     * @return
     */
    public ArrayList<ArrayList<Object>> findRoomsByHotelIdFromSQL(long hotelID);


}
