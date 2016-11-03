package po.order;

import po.hotel.RoomPO;
import util.OrderType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class OrderPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

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
    private ArrayList<RoomPO> rooms;


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
    private EvaluationPO evaluationPO;


    /**
     * 时间
     */
    private OrderTimePO orderTimePO;


    /**
     * 价格
     */
    private OrderPricePO orderPricePO;


    /**
     * 用于生成订单
     */
    public OrderPO(String orderID, long hotelID, String username, String hotelName, ArrayList<RoomPO> rooms, int personAmount, boolean withChildren, OrderTimePO orderTimePO, OrderPricePO orderPricePO) {
        super();
        this.orderID = orderID;
        this.hotelID = hotelID;
        this.username = username;
        this.hotelName = hotelName;
        this.rooms = rooms;
        this.personAmount = personAmount;
        this.withChildren = withChildren;
        this.orderTimePO = orderTimePO;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public ArrayList<RoomPO> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<RoomPO> rooms) {
        this.rooms = rooms;
    }

    public int getPersonAmount() {
        return personAmount;
    }

    public void setPersonAmount(int personAmount) {
        this.personAmount = personAmount;
    }

    public boolean isWithChildren() {
        return withChildren;
    }

    public void setWithChildren(boolean withChildren) {
        this.withChildren = withChildren;
    }

    public EvaluationPO getEvaluationPO() {
        return evaluationPO;
    }

    public void setEvaluationPO(EvaluationPO evaluationPO) {
        this.evaluationPO = evaluationPO;
    }

    public OrderTimePO getOrderTimePO() {
        return orderTimePO;
    }

    public void setOrderTimePO(OrderTimePO orderTimePO) {
        this.orderTimePO = orderTimePO;
    }

    public OrderPricePO getOrderPricePO() {
        return orderPricePO;
    }

    public void setOrderPricePO(OrderPricePO orderPricePO) {
        this.orderPricePO = orderPricePO;
    }
}
