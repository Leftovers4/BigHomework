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
     * 预计离开时间
     */
    private Date expectedLeaveTime;


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


    public OrderTimePO(Date generateTime, Date expectedLeaveTime, Date lastExecuteTime){
        this.generateTime = generateTime;
        this.expectedLeaveTime = expectedLeaveTime;
        this.lastExecuteTime = lastExecuteTime;
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






}
