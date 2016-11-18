package po.promotion;

import java.io.Serializable;
import java.time.LocalDate;

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
    private LocalDate beginTime;

    /**
     * 结束时间
     */
    private LocalDate endTime;


    public PromotionTimePO(LocalDate beginTime, LocalDate endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public LocalDate getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDate beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }
}


