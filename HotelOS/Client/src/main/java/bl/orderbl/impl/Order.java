package bl.orderbl.impl;

import po.order.OrderPO;

import java.time.LocalDateTime;

/**
 * Created by kevin on 2016/12/1.
 */
public class Order{

    private OrderPO orderPO;

    public Order(OrderPO orderPO){
        this.orderPO = orderPO;
    }

    public boolean hasReview(){
        return orderPO.getReviewPO().getReviewTime() != null;
    }

    public boolean isLateCancel(LocalDateTime cancelTime){
        return cancelTime.plusHours(6).isAfter(orderPO.getOrderTimePO().getLastExecuteTime());
    }

}
