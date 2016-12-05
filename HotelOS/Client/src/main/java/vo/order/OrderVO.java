package vo.order;

import util.OrderType;
import util.RoomType;
import vo.hotel.RoomVO;

import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public class OrderVO {


    /**
     * 订单ID
     */
    public String orderID;


    /**
     * 酒店ID
     */
    public long hotelID;


    /**
     * 用户名
     */
    public String username;


    /**
     * 订单类型
     */
    public OrderType orderType;


    /**
     * 酒店名称
     */
    public String hotelName;

    public String hotelAddress;

    public String hotelTradingArea;

    public String hotelService;

    public int roomAmount;

    public RoomType roomType;


    /**
     * 房间号
     * 说明：房间号只有show的功能，故只要用string存储，用空格隔开多个房间
     */
    public String roomNumber;


    /**
     * 入住人数
     */
    public int personAmount;


    /**
     * 有无儿童
     */
    public boolean withChildren;


    /**
     * 评价
     */
    public ReviewVO reviewVO;


    /**
     * 时间
     */
    public OrderTimeVO orderTimeVO;


    /**
     * 价格
     */
    public OrderPriceVO orderPriceVO;


    /**
     * 申诉信息
     */
    public OrderHandleAppealVO orderHandleAppealVO;

}
