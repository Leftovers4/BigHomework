package vo.order;

import util.OrderType;
import vo.hotel.RoomVO;
import vo.hotel.RoomVO;
import java.util.Date;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public class OrderVO {

    /**
     * 订单ID
     */
    private String orderID;


    /**
     * 酒店ID
     */
    private long hotelID;


    /**
     * 用户名
     */
    private String username;


    /**
     * 订单类型
     */
    private OrderType orderType;


    /**
     * 酒店名称
     */
    private String hotelName;


    /**
     * 房间类型及数量
     */
    private ArrayList<RoomVO> rooms;


    /**
     * 人数
     */
    private int personAmount;


    /**
     * 有无儿童
     */
    private boolean withChildren;


    /**
     * 评价
     */
    private EvaluationVO evaluationVO;


    /**
     * 时间
     */
    private OrderTimeVO orderTimeVO;


    /**
     * 价格
     */
    private OrderPriceVO orderPriceVO;


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
