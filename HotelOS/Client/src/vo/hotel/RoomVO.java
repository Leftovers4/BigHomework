package vo.hotel;

/**
 * Created by Hiki on 2016/10/16.
 */
public class RoomVO {

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
