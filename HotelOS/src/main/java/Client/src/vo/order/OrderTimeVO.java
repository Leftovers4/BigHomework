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
     * 预计离开时间
     */
    public Date expectedLeaveTime;


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


    public OrderTimeVO(Date generateTime, Date expectedLeaveTime, Date lastExecuteTime){
        this.generateTime = generateTime;
        this.expectedLeaveTime = expectedLeaveTime;
        this.lastExecuteTime = lastExecuteTime;
    }

}
