package vo.hotel;

import util.RoomType;

/**
 * Created by Hiki on 2016/10/16.
 */
public class RoomVO {

    /**
     * 房间类型id，房间类型的唯一标识
     */
    public long roomID;

    /**
     * 酒店ID
     */
    public long hotelID;

    /**
     * 房间类型，有Single（单人房），Couple（双人房）
     */
    public RoomType roomType;

    /**
     * 该类型房间的总数量
     */
    public int total;

    /**
     * 该类型房间的可用数量
     */
    public int available;

    /**
     * 价格
     */
    public double price;

}
