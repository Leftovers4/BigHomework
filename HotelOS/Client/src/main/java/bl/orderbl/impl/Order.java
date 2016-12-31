package bl.orderbl.impl;

import po.order.OrderPO;
import util.OrderType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kevin on 2016/12/1.
 */
public class Order{

    private OrderPO orderPO;

    /**
     * Instantiates a new Order.
     *
     * @param orderPO the order po
     */
    public Order(OrderPO orderPO){
        this.orderPO = orderPO;
    }

    /**
     * Has review boolean.
     *
     * @return the boolean
     */
    public boolean hasReview(){
        return orderPO.getReviewPO().getReviewTime() != null;
    }

    /**
     * Is late cancel boolean.
     *
     * @param cancelTime the cancel time
     * @return the boolean
     */
    public boolean isLateCancel(LocalDateTime cancelTime){
        return cancelTime.plusHours(6).isAfter(orderPO.getOrderTimePO().getLastExecuteTime());
    }

    /**
     * Get ordered period local date time [ ].
     *
     * @return the local date time [ ]
     */
    public LocalDateTime[] getOrderedPeriod(){
        LocalDateTime[] res = new LocalDateTime[2];

        res[0] = orderPO.getOrderTimePO().getCheckinTime() == null ? orderPO.getOrderTimePO().getExpectedCheckinTime() : orderPO.getOrderTimePO().getCheckinTime();
        res[1] = orderPO.getOrderTimePO().getLeaveTime() == null ? orderPO.getOrderTimePO().getExpectedLeaveTime() : orderPO.getOrderTimePO().getLeaveTime();

        return res;
    }

    /**
     * Is overdue boolean.
     *
     * @return the boolean
     */
    public boolean isOverdue(){
        boolean case1;
        boolean case2;

        OrderType orderType = orderPO.getOrderType();
        case1 = orderType.equals(OrderType.Canceled) || orderType.equals(OrderType.Abnormal);
        case2 = orderType.equals(OrderType.Executed) && orderPO.getOrderTimePO().getLeaveTime() != null;

        return case1 || case2;
    }

}
