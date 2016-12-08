package po.order;

import po.hotel.RoomPO;
import util.OrderType;
import util.PromotionType;
import util.RoomType;

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
    private RoomType roomType;

    /**
     * 房间数量
     */
    private int roomAmount;

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
     * 订单采用的促销策略类型
     */
    private PromotionType promotionType;


    /**
     * 申诉信息
     */
    private OrderHandleAppealPO orderHandleAppealPO;


    public OrderPO(){
        initial();
    }


    /**
     * 用于生成订单
     */
    public OrderPO(String orderID, long hotelID, String username, OrderType orderType, String hotelName, RoomType roomType, int roomAmount, String roomNumber, int personAmount, boolean withChildren, ReviewPO reviewPO, OrderTimePO orderTimePO, OrderPricePO orderPricePO, PromotionType promotionType, OrderHandleAppealPO orderHandleAppealPO) {
        this.orderID = orderID;
        this.hotelID = hotelID;
        this.username = username;
        this.orderType = orderType;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.roomAmount = roomAmount;
        this.roomNumber = roomNumber;
        this.personAmount = personAmount;
        this.withChildren = withChildren;
        this.reviewPO = reviewPO;
        this.orderTimePO = orderTimePO;
        this.orderPricePO = orderPricePO;
        this.promotionType = promotionType;
        this.orderHandleAppealPO = orderHandleAppealPO;
    }


    private void initial(){
        this.orderID = "";
        this.hotelID = 0;
        this.username = "";
        this.orderType = null;
        this.hotelName = "";
        this.roomType = null;
        this.roomAmount = 0;
        this.roomNumber = "";
        this.personAmount = 0;
        this.withChildren = false;
        this.reviewPO = new ReviewPO();
        this.orderTimePO = new OrderTimePO();
        this.orderPricePO = new OrderPricePO();
        this.promotionType = null;
        this.orderHandleAppealPO = new OrderHandleAppealPO();
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

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(int roomAmount) {
        this.roomAmount = roomAmount;
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

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public OrderHandleAppealPO getOrderHandleAppealPO() {
        return orderHandleAppealPO;
    }

    public void setOrderHandleAppealPO(OrderHandleAppealPO orderHandleAppealPO) {
        this.orderHandleAppealPO = orderHandleAppealPO;
    }
}
