package vo.order;

import java.util.Date;

/**
 * Created by Hiki on 2016/10/27.
 */
public class OrderTimeVO {

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


    public OrderTimeVO(Date generateTime, Date expectedLeaveTime, Date lastExecuteTime){
        this.generateTime = generateTime;
        this.expectedLeaveTime = expectedLeaveTime;
        this.lastExecuteTime = lastExecuteTime;
    }

}
