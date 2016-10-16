package vo.promotion;

import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class PromotionVO {

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
