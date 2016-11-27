package bl.promotionbl.impl;

import po.promotion.PromotionPO;
import vo.order.OrderVO;

/**
 * Created by kevin on 2016/11/6.
 */
public class UserLevelPromotion implements Sale, Level{
    private double[] creditConditions;
    private double[] discounts;

    public UserLevelPromotion(PromotionPO promotionPO) {
        // TODO: 2016/11/18
        this.creditConditions = creditConditions;
        this.discounts = discounts;
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
