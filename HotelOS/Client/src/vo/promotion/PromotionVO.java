package vo.promotion;

import util.PromotionType;

import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class PromotionVO {

    /**
     * 营销策略ID
     */
    public long promotionID;

    /**
     * 营销策略类型
     */
    public PromotionType promotionType;

    /**
     * 开始时间
     */
    public Date beginTime;

    /**
     * 结束时间
     */
    public Date endTime;

    /**
     * 折扣
     */
    public double discount;


    public PromotionVO(){}

    /**
     * 用于增加营销策略
     */
    public PromotionVO(PromotionType promotionType, Date beginTime, Date endTime, double discount) {
        super();
        this.promotionType = promotionType;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.discount = discount;
    }
}
