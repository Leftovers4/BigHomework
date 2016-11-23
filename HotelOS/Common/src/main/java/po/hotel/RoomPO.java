package po.hotel;

import util.RoomType;

import java.io.Serializable;

/**
 * Created by Hiki on 2016/10/16.
 */
public class RoomPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 房间ID
     */
    private long roomId;

    /**
     * 酒店ID
     */
    private long hotelId;

    /**
     * 房间类型
     */
    private RoomType roomType;

    /**
     * 总数量
     */
    private int total;

    /**
     * 可用客房数量
     */
    private int available;

    /**
     * 价格
     */
    private double price;


    /**
     * 无条件构造器
     */
    public RoomPO(){
        this.initial();
    }

    /**
     * 用于增加房间类型
     */
    public RoomPO(long roomId, long hotelId, RoomType roomType, int total, int available, double price) {
        initial();
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.total = total;
        this.available = available;
        this.price = price;
    }


    /**
     * 初始化
     */
    private void initial(){
        this.roomId = 0;
        this.hotelId = 0;
        this.roomType = null;
        this.total = 0;
        this.available = 0;
        this.price = 0.0;
    }




    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
