package vo.hotel;

import util.RoomType;

/**
 * Created by Hiki on 2016/10/16.
 */
public class RoomVO {

    /**
     * 酒店ID
     */
    public long hotelId;

    /**
     * 房间类型
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

    /**
     * 创建包含酒店工作人员录入可用客房界面信息的对象
     *
     * @param hotelId  房间所属酒店的id
     * @param roomType 房间类型，有Single（单人房），Couple（双人房）
     * @param total    该类型房间的总数量
     * @param price    价格
     */
    public RoomVO(long hotelId, RoomType roomType, int total, double price) {
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.total = total;
        this.price = price;
    }

    /**
     * 创建包含所有房间类型信息的对象
     *
     * @param hotelId   房间所属酒店的id
     * @param roomType  房间类型，有Single（单人房），Couple（双人房）
     * @param total     该类型房间的总数量
     * @param available 该类型房间的可用数量
     * @param price     价格
     */
    public RoomVO(long hotelId, RoomType roomType, int total, int available, double price) {
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.total = total;
        this.available = available;
        this.price = price;
    }

}
