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
     * 数量
     */
    private int amount;

    /**
     * 价格
     */
    private double price;


    /**
     * 用于增加房间类型
     */
    public RoomPO(RoomType roomType, int amount, double price){

        this.roomType = roomType;
        this.amount = amount;
        this.price = price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
