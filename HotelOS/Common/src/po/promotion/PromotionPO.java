package po.promotion;

import util.PromotionType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class PromotionPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 营销策略ID
     */
    private long promotionID;

    /**
     * 营销策略类型
     */
    private PromotionType promotionType;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 折扣
     */
    private double discount;


    public PromotionPO(){}

    /**
     * 用于增加营销策略
     */
    public PromotionPO(PromotionType promotionType, Date beginTime, Date endTime, double discount) {
        super();
        this.promotionType = promotionType;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.discount = discount;
    }

    public long getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(long promotionID) {
        this.promotionID = promotionID;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
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

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
