package po.user;

import util.CreditChangedCause;

import java.util.Date;

/**
 * Created by Hiki on 11/15/2016.
 */
class CreditRecordPO {

    /**
     * 信用记录id
     */
    int recordId;

    /**
     * 当前（改变后的信用值）
     */
    int currentCredit;

    /**
     * 改变的信用值
     */
    int changedCredit;

    /**
     * 改变时间
     */
    Date changedTime;

    /**
     * 变更原因
     */
    CreditChangedCause creditChangedCause;

    /**
     * 订单id
     */
    String orderID;

}