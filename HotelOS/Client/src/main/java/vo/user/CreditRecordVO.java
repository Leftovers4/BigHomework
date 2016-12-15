package vo.user;

import util.CreditChangedCause;
import util.DateTimeFormat;
import util.EnumFactory;

import java.time.LocalDateTime;

/**
 * Created by Hiki on 11/17/2016.
 */
public class CreditRecordVO {

    /**
     * 信用记录id
     */
    public long recordID;

    /**
     * 用户名
     */
    public String username;

    /**
     * 变更时间，具体到秒
     */
    public LocalDateTime changedTime;

    /**
     * 订单号
     */
    public String orderID;

    /**
     * 变更原因，有CancelOrder（订单撤销）, AbnormalOrder（订单异常）, ExecuteOrder（订单执行）, Recharge（充值）
     */
    public CreditChangedCause creditChangedCause;

    /**
     * 信用度变化
     */
    public double changedCredit;

    /**
     * 信用度结果（改变后的信用值）
     */

    public double currentCredit;

    public long getRecordID() {
        return recordID;
    }

    public String getUsername() {
        return username;
    }

    public String getChangedTime() {
        return changedTime.format(DateTimeFormat.dateTimeFormat);
    }

    public String getOrderID() {
        return orderID;
    }

    public String getCreditChangedCause() {
        return EnumFactory.getString(creditChangedCause);
    }

    public double getChangedCredit() {
        return changedCredit;
    }

    public double getCurrentCredit() {
        return currentCredit;
    }

}
