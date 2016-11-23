package po.user;

import util.CreditChangedCause;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hiki on 11/15/2016.
 */
public class CreditRecordPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 信用记录id
     */
    int recordId;

    /**
     * 用户名
     */
    String username;

    /**
     * 当前（改变后的信用值）
     */
    double currentCredit;

    /**
     * 改变的信用值
     */
    double changedCredit;

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

    public CreditRecordPO(){
        initial();
    }

    public CreditRecordPO(int recordId, String username, double currentCredit, double changedCredit, Date changedTime, CreditChangedCause creditChangedCause, String orderID) {
        initial();
        this.recordId = recordId;
        this.username = username;
        this.currentCredit = currentCredit;
        this.changedCredit = changedCredit;
        this.changedTime = changedTime;
        this.creditChangedCause = creditChangedCause;
        this.orderID = orderID;
    }

    private void initial(){
        this.recordId = 0;
        this.username = "";
        this.currentCredit = 0.0;
        this.changedCredit = 0.0;
        this.changedTime = null;
        this.creditChangedCause = null;
        this.orderID = "";
    }


    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getCurrentCredit() {
        return currentCredit;
    }

    public void setCurrentCredit(double currentCredit) {
        this.currentCredit = currentCredit;
    }

    public double getChangedCredit() {
        return changedCredit;
    }

    public void setChangedCredit(double changedCredit) {
        this.changedCredit = changedCredit;
    }

    public Date getChangedTime() {
        return changedTime;
    }

    public void setChangedTime(Date changedTime) {
        this.changedTime = changedTime;
    }

    public CreditChangedCause getCreditChangedCause() {
        return creditChangedCause;
    }

    public void setCreditChangedCause(CreditChangedCause creditChangedCause) {
        this.creditChangedCause = creditChangedCause;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}
