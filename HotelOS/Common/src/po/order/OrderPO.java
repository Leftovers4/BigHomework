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

    /**
     * 用于生成订单
     */
    public OrderPO(long orderID, long hotelID, String username, String hotelName, ArrayList<RoomPO> rooms, int personAmount, boolean withChildren, Date generateTime, Date expectedLeaveTime, Date lastExecuteTime, double originPrice, double actualPrice) {
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

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
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

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public Date getExpectedLeaveTime() {
        return expectedLeaveTime;
    }

    public void setExpectedLeaveTime(Date expectedLeaveTime) {
        this.expectedLeaveTime = expectedLeaveTime;
    }

    public Date getLastExecuteTime() {
        return lastExecuteTime;
    }

    public void setLastExecuteTime(Date lastExecuteTime) {
        this.lastExecuteTime = lastExecuteTime;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }
}
