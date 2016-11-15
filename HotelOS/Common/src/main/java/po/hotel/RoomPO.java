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


    public RoomPO(){}

    /**
     * 用于增加房间类型
     */
    public RoomPO(RoomType roomType, int total, int available, double price) {
        this.roomType = roomType;
        this.total = total;
        this.available = available;
        this.price = price;
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
