package vo.order;

import util.OrderType;
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


    /**
     * 房间类型及数量
     */
    public ArrayList<RoomVO> rooms;


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


    /**
     * 用于生成订单
     */
    public OrderVO(String orderID, long hotelID, String username, OrderType orderType, String hotelName, ArrayList<RoomVO> rooms, String roomNumber, int personAmount, boolean withChildren, ReviewVO reviewVO, OrderTimeVO orderTimeVO, OrderPriceVO orderPriceVO, OrderHandleAppealVO orderHandleAppealVO) {
        this.orderID = orderID;
        this.hotelID = hotelID;
        this.username = username;
        this.orderType = orderType;
        this.hotelName = hotelName;
        this.rooms = rooms;
        this.roomNumber = roomNumber;
        this.personAmount = personAmount;
        this.withChildren = withChildren;
        this.reviewVO = reviewVO;
        this.orderTimeVO = orderTimeVO;
        this.orderPriceVO = orderPriceVO;
        this.orderHandleAppealVO = orderHandleAppealVO;
    }
}
