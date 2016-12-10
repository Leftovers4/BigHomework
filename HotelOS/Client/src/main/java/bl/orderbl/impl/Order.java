package bl.orderbl.impl;

import po.order.OrderPO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    public LocalDateTime[] getOrderedPeriod(){
        LocalDateTime[] res = new LocalDateTime[2];

        res[0] = orderPO.getOrderTimePO().getCheckinTime() == null ? orderPO.getOrderTimePO().getExpectedCheckinTime() : orderPO.getOrderTimePO().getCheckinTime();
        res[1] = orderPO.getOrderTimePO().getLeaveTime() == null ? orderPO.getOrderTimePO().getExpectedLeaveTime() : orderPO.getOrderTimePO().getLeaveTime();

        return res;
    }

}
