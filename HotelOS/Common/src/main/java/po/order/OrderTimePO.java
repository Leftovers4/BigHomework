package po.order;

import java.io.Serializable;
import java.time.LocalDateTime;
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
    private LocalDateTime generateTime;


    /**
     * 预计入住时间
     */
    private LocalDateTime expectedCheckinTime;


    /**
     * 入住时间
     */
    private LocalDateTime checkinTime;


    /**
     * 预计离开时间
     */
    private LocalDateTime expectedLeaveTime;


    /**
     * 离开（退房）时间
     */
    private LocalDateTime leaveTime;


    /**
     * 最晚执行时间
     */
    private LocalDateTime lastExecuteTime;


    /**
     * 执行订单时间
     */
    private LocalDateTime executeTime;


    /**
     * 撤销订单时间
     */
    private LocalDateTime cancelTime;


    public OrderTimePO(LocalDateTime generateTime, LocalDateTime expectedCheckinTime, LocalDateTime checkinTime, LocalDateTime expectedLeaveTime, LocalDateTime leaveTime, LocalDateTime lastExecuteTime, LocalDateTime executeTime, LocalDateTime cancelTime) {
        this.generateTime = generateTime;
        this.expectedCheckinTime = expectedCheckinTime;
        this.checkinTime = checkinTime;
        this.expectedLeaveTime = expectedLeaveTime;
        this.leaveTime = leaveTime;
        this.lastExecuteTime = lastExecuteTime;
        this.executeTime = executeTime;
        this.cancelTime = cancelTime;
    }

    public LocalDateTime getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(LocalDateTime generateTime) {
        this.generateTime = generateTime;
    }

    public LocalDateTime getExpectedCheckinTime() {
        return expectedCheckinTime;
    }

    public void setExpectedCheckinTime(LocalDateTime expectedCheckinTime) {
        this.expectedCheckinTime = expectedCheckinTime;
    }

    public LocalDateTime getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(LocalDateTime checkinTime) {
        this.checkinTime = checkinTime;
    }

    public LocalDateTime getExpectedLeaveTime() {
        return expectedLeaveTime;
    }

    public void setExpectedLeaveTime(LocalDateTime expectedLeaveTime) {
        this.expectedLeaveTime = expectedLeaveTime;
    }

    public LocalDateTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalDateTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    public LocalDateTime getLastExecuteTime() {
        return lastExecuteTime;
    }

    public void setLastExecuteTime(LocalDateTime lastExecuteTime) {
        this.lastExecuteTime = lastExecuteTime;
    }

    public LocalDateTime getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(LocalDateTime executeTime) {
        this.executeTime = executeTime;
    }

    public LocalDateTime getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(LocalDateTime cancelTime) {
        this.cancelTime = cancelTime;
    }
}
