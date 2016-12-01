package bl.orderbl.impl;

import po.order.OrderPO;

import java.time.LocalDateTime;

/**
 * Created by kevin on 2016/12/1.
 */
public class Order extends OrderPO {

    public boolean hasReview(){
        return this.getReviewPO().getReview().equals("");
    }

    public int getRating(){
        return this.getReviewPO().getRating();
    }

    public String getReview(){
        return this.getReviewPO().getReview();
    }

    public LocalDateTime getReviewTime(){
        return this.getReviewPO().getReviewTime();
    }

}
