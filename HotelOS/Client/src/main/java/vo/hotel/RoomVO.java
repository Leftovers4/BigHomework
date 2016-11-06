package vo.hotel;

import util.RoomType;

/**
 * Created by Hiki on 2016/10/16.
 */
public class RoomVO {

    /**
     * 房间类型
     */
    public RoomType roomType;

    /**
     * 数量
     */
    public int amount;

    /**
     * 价格
     */
    public double price;


    public RoomVO(){}

    /**
     * 用于增加房间类型
     */
    public RoomVO(RoomType roomType, int amount, double price){
        super();
        this.roomType = roomType;
        this.amount = amount;
        this.price = price;
    }
}
