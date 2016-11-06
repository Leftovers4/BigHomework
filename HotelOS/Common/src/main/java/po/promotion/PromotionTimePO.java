package po.promotion;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/27.
 */
public class PromotionTimePO implements Serializable{

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;


    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;


    public PromotionTimePO(Date beginTime, Date endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}


