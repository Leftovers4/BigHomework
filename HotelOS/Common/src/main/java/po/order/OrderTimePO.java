package po.order;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/27.
 */
public class OrderTimePO implements Serializable{


    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;


    /**
     * 生成订单时间
     */
    private Date generateTime;


    /**
     * 预计入住时间
     */
    private Date expectedCheckinTime;


    /**
     * 入住时间
     */
    private Date checkinTime;


    /**
     * 预计离开时间
     */
    private Date expectedLeaveTime;


    /**
     * 离开（退房）时间
     */
    private Date leaveTime;


    /**
     * 最晚执行时间
     */
    private Date lastExecuteTime;


    /**
     * 执行订单时间
     */
    private Date executeTime;


    /**
     * 撤销订单时间
     */
    private Date cancelTime;


    public OrderTimePO(Date generateTime, Date expectedCheckinTime, Date checkinTime, Date expectedLeaveTime, Date leaveTime, Date lastExecuteTime, Date executeTime, Date cancelTime) {
        this.generateTime = generateTime;
        this.expectedCheckinTime = expectedCheckinTime;
        this.checkinTime = checkinTime;
        this.expectedLeaveTime = expectedLeaveTime;
        this.leaveTime = leaveTime;
        this.lastExecuteTime = lastExecuteTime;
        this.executeTime = executeTime;
        this.cancelTime = cancelTime;
    }

    public Date getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Date generateTime) {
        this.generateTime = generateTime;
    }

    public Date getExpectedLeaveTime() {
        return expectedLeaveTime;
    }

    public void setExpectedLeaveTime(Date expectedLeaveTime) {
        this.expectedLeaveTime = expectedLeaveTime;
    }

    public Date getLastExecuteTime() {
        return lastExecuteTime;
    }

    public void setLastExecuteTime(Date lastExecuteTime) {
        this.lastExecuteTime = lastExecuteTime;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public Date getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }


    public Date getExpectedCheckinTime() {
        return expectedCheckinTime;
    }

    public void setExpectedCheckinTime(Date expectedCheckinTime) {
        this.expectedCheckinTime = expectedCheckinTime;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }
}
