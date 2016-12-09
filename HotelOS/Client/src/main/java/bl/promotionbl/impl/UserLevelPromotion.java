package bl.promotionbl.impl;

import po.promotion.PromotionPO;
import util.Const;
import vo.order.OrderVO;

/**
 * Created by kevin on 2016/11/6.
 */
public class UserLevelPromotion implements Sale, Level{

    private double[] creditConditions;

    private double[] discounts;

    public UserLevelPromotion(PromotionPO promotionPO) {
        //初始化creditConditions
        creditConditions = new double[Const.MaxMemberLevel + 2];
        creditConditions[0] = 0;
        for (int i = 1; i <= Const.MaxMemberLevel; i++) {
            creditConditions[i] = promotionPO.getPromotionMRPOs().get(i - 1).getCredit();
        }
        creditConditions[creditConditions.length - 1] = Double.MAX_VALUE;

        //初始化discounts
        discounts = new double[Const.MaxMemberLevel];
        for (int i = 0; i < Const.MaxMemberLevel; i++) {
            discounts[i] = promotionPO.getPromotionMRPOs().get(i).getMemberDiscount();
        }
    }

    @Override
    public double getActualPrice(OrderVO orderVO) {
        double price = orderVO.orderPriceVO.originPrice;
        //todo  get level
        int level = 0;

        return price * discounts[level];
    }

    @Override
    public int getLevel(double credit) {
        for (int i = 0; i < creditConditions.length - 1; i++) {
            if (creditConditions[i] <= credit && credit < creditConditions[i + 1]){
                return i;
            }
        }
        return -1;
    }

}
