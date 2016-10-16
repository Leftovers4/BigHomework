package vo.order;

import vo.hotel.RoomVO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class OrderVO {

    /**
     * 订单ID
     */
    private long orderID;


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

    // 生成订单时间
    private Date generateTime;
    // 预计离开时间
    private Date expectedLeaveTime;
    // 最晚执行时间
    private Date lastExecuteTime;
    // 执行订单时间
    private Date executeTime;
    // 撤销订单时间
    private Date cancelTime;

    /**
     * 价格
     */

    // 原始价格
    private double originPrice;
    // 折后价格
    private double actualPrice;


    public OrderVO(){}

    /**
     * 用于生成订单
     */
    public OrderVO(long orderID, long hotelID, String username, String hotelName, ArrayList<RoomVO> rooms, int personAmount, boolean withChildren, Date generateTime, Date expectedLeaveTime, Date lastExecuteTime, double originPrice, double actualPrice) {
        super();
        this.orderID = orderID;
        this.hotelID = hotelID;
        this.username = username;
        this.hotelName = hotelName;
        this.rooms = rooms;
        this.personAmount = personAmount;
        this.withChildren = withChildren;
        this.generateTime = generateTime;
        this.expectedLeaveTime = expectedLeaveTime;
        this.lastExecuteTime = lastExecuteTime;
        this.originPrice = originPrice;
        this.actualPrice = actualPrice;
    }
}
