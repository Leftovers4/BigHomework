package vo.order;

import util.DateTimeFormat;
import util.EnumFactory;
import util.RoomType;

import java.time.LocalDateTime;

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

    public String getOrderID() {
        return orderID;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }

    public String getRoomType() {
        return EnumFactory.getString(roomType);
    }

    public String getReviewTime() {
        return reviewTime.format(DateTimeFormat.dateTimeFormat);
    }

    public String getUsername() {
        return username;
    }

}
