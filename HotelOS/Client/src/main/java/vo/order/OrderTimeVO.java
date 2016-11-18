package vo.order;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/27.
 */
public class OrderTimeVO {

    /**
     * 生成订单时间
     */
    public LocalDate generateTime;


    /**
     * 预计入住时间
     */
    public LocalDate expectedCheckinTime;


    /**
     * 入住时间
     */
    public LocalDate checkinTime;


    /**
     * 预计离开时间
     */
    public LocalDate expectedLeaveTime;


    /**
     * 离开（退房）时间
     */
    public LocalDate leaveTime;


    /**
     * 最晚执行时间
     */
    public LocalDate lastExecuteTime;


    /**
     * 执行订单时间
     */
    public LocalDate executeTime;


    /**
     * 撤销订单时间
     */
    public LocalDate cancelTime;

    public OrderTimeVO(LocalDate generateTime, LocalDate expectedCheckinTime, LocalDate checkinTime, LocalDate expectedLeaveTime, LocalDate leaveTime, LocalDate lastExecuteTime, LocalDate executeTime, LocalDate cancelTime) {
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
