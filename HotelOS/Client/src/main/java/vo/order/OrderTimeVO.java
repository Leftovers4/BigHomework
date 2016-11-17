package vo.order;

import java.util.Date;

/**
 * Created by Hiki on 2016/10/27.
 */
public class OrderTimeVO {

    /**
     * 生成订单时间
     */
    public Date generateTime;


    /**
     * 预计入住时间
     */
    public Date expectedCheckinTime;


    /**
     * 入住时间
     */
    public Date checkinTime;


    /**
     * 预计离开时间
     */
    public Date expectedLeaveTime;


    /**
     * 离开（退房）时间
     */
    public Date leaveTime;


    /**
     * 最晚执行时间
     */
    public Date lastExecuteTime;


    /**
     * 执行订单时间
     */
    public Date executeTime;


    /**
     * 撤销订单时间
     */
    public Date cancelTime;

    public OrderTimeVO(Date generateTime, Date expectedCheckinTime, Date checkinTime, Date expectedLeaveTime, Date leaveTime, Date lastExecuteTime, Date executeTime, Date cancelTime) {
        this.generateTime = generateTime;
        this.expectedCheckinTime = expectedCheckinTime;
        this.checkinTime = checkinTime;
        this.expectedLeaveTime = expectedLeaveTime;
        this.leaveTime = leaveTime;
        this.lastExecuteTime = lastExecuteTime;
        this.executeTime = executeTime;
        this.cancelTime = cancelTime;
    }
}
