package util;

/**
 * Created by Hiki on 11/17/2016.
 */
public enum CreditChangedCause {

    /**
     * 撤销订单
     * 距离最晚执行时间不足6个小时，撤销的同时扣除信用值
     * 信用值 = 订单总价值 * 1/2
     */
    CANCEL_ORDER,

    /**
     * 异常订单
     * 如果时间在超过最晚订单执行时间后还没有办理入住，系统自动将其置为异常订单
     * 信用值 = 订单总价值
     */
    ABNORMAL_ORDER,

    /**
     * 执行订单
     * 两种情况： 1. 正常执行 2. 置为异常订单后补充执行
     * 信用值 = 订单总价值
     */
    EXECUTE_ORDER,

    /**
     * 恢复异常订单
     * 处理申述时
     * 信用值 = 被扣除的信用值（订单总价值）或 1/2
     */
    CANCEL_ABNORMAL_ORDER,

    /**
     * 信用充值
     * 线下充值，由网站营销人员操作
     * 信用值 = 充值额度 * 100
     */
    RECHARGE


}
