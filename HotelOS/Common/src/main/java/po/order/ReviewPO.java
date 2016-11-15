package po.order;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class ReviewPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 酒店ID
     */
    private long hotelID;

    /**
     * 评价时间
     */
    private Date reviewTime;

    /**
     * 评分
     */
    private int rating;

    /**
     * 评价内容
     */
    private String review;


    public ReviewPO(){}


    /**
     * 用于客户评价
     */
    public ReviewPO(String username, long hotelID, Date reviewTime, int rating, String review) {
        super();
        this.username = username;
        this.hotelID = hotelID;
        this.reviewTime = reviewTime;
        this.rating = rating;
        this.review = review;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
