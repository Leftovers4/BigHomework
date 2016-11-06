package vo.promotion;

import po.promotion.PromotionPO;
import util.PromotionType;

import java.util.Vector;

/**
 * Created by Hiki on 2016/10/16.
 */

/**
 * promotionID      促销策略编号
 * promotionType    促销类型
 * promotionInfo    促销详情
 * @author Kevin
 */
public class PromotionVO extends Vector<String>{

    public PromotionVO(PromotionPO promotionPO){
        this.add(String.valueOf(promotionPO.getPromotionID()));
        switch (promotionPO.getPromotionType()) {
            case BIRTHDAY_HP:
                this.add("生日优惠");
                this.add("折扣： " + String.valueOf(promotionPO.getDiscount()));
                break;
            case ENTERPRISE_HP:
                this.add("合作企业优惠");
                this.add("折扣： " + String.valueOf(promotionPO.getDiscount()));
                break;
            case SPECIAL_TIME_HP:
                this.add("特定期间预订优惠");
                //TODO
                this.add("开始时间： "
                        + "结束时间： "
                        + "折扣： " + String.valueOf(promotionPO.getDiscount()));
                break;
            case MULTI_ROOMS_HP:
                this.add("多间预订优惠");
                this.add("最少预订间数： " + String.valueOf(promotionPO.getLeastRooms()) + "\n"
                        + "折扣： " + String.valueOf(promotionPO.getDiscount()));
                break;
            case USER_LEVEL_WP:
                this.add("会员等级优惠");
                //TODO
                break;
            case SPECIAL_TIME_WP:
                this.add("特定期间预订优惠");
                //TODO
                this.add("开始时间： "
                        + "结束时间： "
                        + "折扣： " + String.valueOf(promotionPO.getDiscount()));
                break;
            case VIP_SPECIAL_AREA_WP:
                this.add("VIP会员特定商圈专属优惠");
                //TODO
                break;
            case LEVEL_STRATEGY_WP:
                this.add("会员等级策略");
                //TODO
                break;
        }
    }

    public PromotionVO(long promotionID, String promotionType, String promotionInfo) {
        this.add(String.valueOf(promotionID));
        this.add(promotionType);
        this.add(promotionInfo);
    }

    public long getPromotionID(){
        return Long.valueOf(this.get(0));
    }

    public String getPromotionType(){
        return this.get(1);
    }

    public String getPromotionInfo(){
        return this.get(2);
    }

}
