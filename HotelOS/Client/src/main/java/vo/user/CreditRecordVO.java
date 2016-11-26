package vo.user;

import util.CreditChangedCause;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Hiki on 11/17/2016.
 */
public class CreditRecordVO {

    /**
     * 信用记录id
     */
    long recordId;

    /**
     * 用户名
     */
    String username;

    /**
     * 变更时间，具体到秒
     */
    LocalDateTime changedTime;

    /**
     * 订单号
     */
    String orderID;

    /**
     * 变更原因，有CancelOrder（订单撤销）, AbnormalOrder（订单异常）, ExecuteOrder（订单执行）, Recharge（充值）
     */
    CreditChangedCause creditChangedCause;

    /**
     * 信用度变化
     */
    double changedCredit;

    /**
     * 信用度结果（改变后的信用值）
     */
    double currentCredit;

    /**
     * 传给界面：创建包含用户查看信用记录的界面信息的对象
     *
     * @param changedTime        变更时间
     * @param orderID            订单号
     * @param creditChangedCause 变更原因
     * @param changedCredit      信用度变化
     * @param currentCredit      信用度结果
     */
    public CreditRecordVO(LocalDateTime changedTime, String orderID, CreditChangedCause creditChangedCause, double changedCredit, double currentCredit) {
        this.changedTime = changedTime;
        this.orderID = orderID;
        this.creditChangedCause = creditChangedCause;
        this.changedCredit = changedCredit;
        this.currentCredit = currentCredit;
    }

}
