package vo.promotion;

import vo.promotion.PromotionTimeVO;
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
     * 时间
     */
    public PromotionTimeVO promotionTimeVO;

    /**
     * 折扣
     */
    public double discount;


    public PromotionVO(){}

    /**
     * 用于增加营销策略
     */
    public PromotionVO(PromotionType promotionType, PromotionTimeVO promotionTimeVO, double discount) {
        super();
        this.promotionType = promotionType;
        this.promotionTimeVO = promotionTimeVO;
        this.discount = discount;
    }
}
