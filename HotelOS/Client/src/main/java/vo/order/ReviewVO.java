package vo.order;

import util.RoomType;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class ReviewVO {

    /*
     * 订单id
     */
    public String orderID;

    /**
     * 评价内容
     */
    public String review;

    /**
     * 评分
     */
    public int rating;

    /*
     * 房间类型
     */
    public RoomType roomType;

    /**
     * 评价时间
     */
    public LocalDateTime reviewTime;

    /**
     * 用户名
     */
    public String username;

}
