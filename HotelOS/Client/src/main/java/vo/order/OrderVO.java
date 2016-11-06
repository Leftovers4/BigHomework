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
     * 人数
     */
    public int personAmount;


    /**
     * 有无儿童
     */
    public boolean withChildren;


    /**
     * 评价
     */
    public EvaluationVO evaluationVO;


    /**
     * 时间
     */
    public OrderTimeVO orderTimeVO;


    /**
     * 价格
     */
    public OrderPriceVO orderPriceVO;


    /**
     * 用于生成订单
     */
    public OrderVO(String orderID, long hotelID, String username, String hotelName, ArrayList<RoomVO> rooms, int personAmount, boolean withChildren, OrderTimeVO orderTimeVO, OrderPriceVO orderPriceVO) {
        super();
        this.orderID = orderID;
        this.hotelID = hotelID;
        this.username = username;
        this.hotelName = hotelName;
        this.rooms = rooms;
        this.personAmount = personAmount;
        this.withChildren = withChildren;
        this.orderTimeVO = orderTimeVO;
    }
}
