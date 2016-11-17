package vo.hotel;

import util.RoomType;

/**
 * Created by Hiki on 2016/10/16.
 */
public class RoomVO {


    /**
     * 房间ID
     */
    public long roomId;

    /**
     * 酒店ID
     */
    public long hotelId;

    /**
     * 房间类型
     */
    public RoomType roomType;

    /**
     * 总数量
     */
    public int total;

    /**
     * 可用客房数量
     */
    public int available;

    /**
     * 价格
     */
    public double price;


    public RoomVO(){}


    /**
     * 用于增加房间类型
     */
    public RoomVO(long roomId, long hotelId, RoomType roomType, int total, int available, double price) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.total = total;
        this.available = available;
        this.price = price;
    }
}
