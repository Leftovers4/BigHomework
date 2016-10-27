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
     * 时间
     */
    private PromotionTimePO promotionTimePO;

    /**
     * 折扣
     */
    private double discount;


    public PromotionPO(){}

    /**
     * 用于增加营销策略
     */
    public PromotionPO(PromotionType promotionType, PromotionTimePO promotionTimePO, double discount) {
        super();
        this.promotionType = promotionType;
        this.promotionTimePO = promotionTimePO;
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

    public PromotionTimePO getPromotionTimePO() {
        return promotionTimePO;
    }

    public void setPromotionTimePO(PromotionTimePO promotionTimePO) {
        this.promotionTimePO = promotionTimePO;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
