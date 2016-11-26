package data.datahelper.orderdatahelper;

import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/20/2016.
 */
public interface OrderDataHelper {

    // 格式："order_id", "hotel_id", "username", "order_type", "hotel_name", "room_type", "room_amount",
    //      "room_number", "person_amount", "with_children", "generate_time", "expected_checkin_time",
    //      "checkin_time", "leave_time", "last_execute_time", "cancel_time", "original_price", "actual_price",
    //      "review_time", "rating", "review", "ha_time", "ha_result"


    /**
     * 根据id在order表中查找一条订单信息
     * @param orderID
     * @return
     */
    public ArrayList<Object> findByIdFromSQL(String orderID);

    /**
     * 根据输入的条件在order表中查找订单列表
     * 用Object包装列表信息，若OrderPO中有条件未提及，则用'%'表示
     * @param orderInfo
     * @return
     */
    public ArrayList<ArrayList<Object>> findByConditionsFromSQL(ArrayList<Object> orderInfo);

    /**
     * 根据hotelID在order表中查找订单列表
     * 调用findByConditionsFromSQL
     * @param hotelID
     * @return
     */
    public ArrayList<ArrayList<Object>> findByHotelIDFromSQL(long hotelID);

    /**
     * 在order表中插入一条订单数据
     * @param orderInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> orderInfo);

    /**
     * 在order表中更新一条订单数据
     * @param orderInfo
     * @return
     */
    public ResultMessage updateFromSQL(ArrayList<Object> orderInfo);

    /**
     * 在order表中获取所有订单信息
     * @return
     */
    public ArrayList<ArrayList<Object>> findFromSQL();



}
