package vo.order;

import util.PromotionType;

/**
 * Created by Hiki on 2016/12/11.
 */
public class OrderPromoInfoVO {

    public PromotionType promotionType;

    public double discount;

    public OrderPromoInfoVO(){
        discount = 1;
    }

}
