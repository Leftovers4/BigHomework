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

    public Order(OrderPO orderPO){
        this.orderPO = orderPO;
    }

    /**
     * 判断订单有无评价
     *
     * @return true（有评价），false（没有评价）
     */
    public boolean hasReview(){
        return orderPO.getReviewPO().getReviewTime() != null;
    }

    /**
     * 判断撤销订单的时间距离最晚执行时间是否小于规定值（当前是6个小时）
     *
     * @param cancelTime 撤销订单的时间
     * @return true（小于规定值），false（大于规定值）
     */
    public boolean isLateCancel(LocalDateTime cancelTime){
        return cancelTime.plusHours(6).isAfter(orderPO.getOrderTimePO().getLastExecuteTime());
    }

    /**
     * 获取订单对房间的占用起止时间
     *
     * @return 长度为2的LocalDateTime数组，0位置为占用开始时间，1位置为占用结束时间
     */
    public LocalDateTime[] getOrderedPeriod(){
        LocalDateTime[] res = new LocalDateTime[2];

        res[0] = orderPO.getOrderTimePO().getCheckinTime() == null ? orderPO.getOrderTimePO().getExpectedCheckinTime() : orderPO.getOrderTimePO().getCheckinTime();
        res[1] = orderPO.getOrderTimePO().getLeaveTime() == null ? orderPO.getOrderTimePO().getExpectedLeaveTime() : orderPO.getOrderTimePO().getLeaveTime();

        return res;
    }

    /**
     * 判断订单是否过期
     *
     * @return true（已过期），false（未过期）
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
