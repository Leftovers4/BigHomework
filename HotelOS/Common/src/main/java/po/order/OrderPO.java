package po.order;

import po.hotel.RoomPO;
import util.OrderType;

import java.io.Serializable;
import java.util.ArrayList;

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
     * 房间号
     * 说明：房间号只有show的功能，故只要用string存储，用空格隔开多个房间
     */
    private String roomNumber;


    /**
     * 入住人数
     */
    private int personAmount;


    /**
     * 有无儿童
     */
    private boolean withChildren;


    /**
     * 评价
     */
    private ReviewPO reviewPO;


    /**
     * 时间
     */
    private OrderTimePO orderTimePO;


    /**
     * 价格
     */
    private OrderPricePO orderPricePO;


    /**
     * 申诉信息
     */
    private OrderHandleAppealPO orderHandleAppealPO;


    /**
     * 用于生成订单
     */
    public OrderPO(String orderID, long hotelID, String username, OrderType orderType, String hotelName, ArrayList<RoomPO> rooms, String roomNumber, int personAmount, boolean withChildren, ReviewPO reviewPO, OrderTimePO orderTimePO, OrderPricePO orderPricePO, OrderHandleAppealPO orderHandleAppealPO) {
        this.orderID = orderID;
        this.hotelID = hotelID;
        this.username = username;
        this.orderType = orderType;
        this.hotelName = hotelName;
        this.rooms = rooms;
        this.roomNumber = roomNumber;
        this.personAmount = personAmount;
        this.withChildren = withChildren;
        this.reviewPO = reviewPO;
        this.orderTimePO = orderTimePO;
        this.orderPricePO = orderPricePO;
        this.orderHandleAppealPO = orderHandleAppealPO;
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

    public ReviewPO getReviewPO() {
        return reviewPO;
    }

    public void setReviewPO(ReviewPO reviewPO) {
        this.reviewPO = reviewPO;
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public OrderHandleAppealPO getOrderHandleAppealPO() {
        return orderHandleAppealPO;
    }

    public void setOrderHandleAppealPO(OrderHandleAppealPO orderHandleAppealPO) {
        this.orderHandleAppealPO = orderHandleAppealPO;
    }
}
