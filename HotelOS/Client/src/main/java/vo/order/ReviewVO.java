package vo.order;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class ReviewVO {


    /**
     * 用户名
     */
    public String username;

    /**
     * 酒店ID
     */
    public long hotelID;

    /**
     * 评价时间
     */
    public LocalDateTime reviewTime;

    /**
     * 评分
     */
    private int rating;

    /**
     * 评价内容
     */
    public String review;


    public ReviewVO(){}

    /**
     * 用于客户评价
     */
    public ReviewVO(String username, long hotelID, LocalDateTime reviewTime, int rating, String review) {
        super();
        this.username = username;
        this.hotelID = hotelID;
        this.reviewTime = reviewTime;
        this.rating = rating;
        this.review = review;
    }
}
