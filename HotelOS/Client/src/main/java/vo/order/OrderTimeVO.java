package vo.order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/27.
 */
public class OrderTimeVO {

    /**
     * 生成订单时间
     */
    public LocalDateTime generateTime;


    /**
     * 预计入住时间
     */
    public LocalDateTime expectedCheckinTime;


    /**
     * 入住时间
     */
    public LocalDateTime checkinTime;


    /**
     * 预计离开时间
     */
    public LocalDateTime expectedLeaveTime;


    /**
     * 离开（退房）时间
     */
    public LocalDateTime leaveTime;


    /**
     * 最晚执行时间
     */
    public LocalDateTime lastExecuteTime;


    /**
     * 执行订单时间
     */
    public LocalDateTime executeTime;


    /**
     * 撤销订单时间
     */
    public LocalDateTime cancelTime;

}
