package vo.order;

import util.EnumFactory;
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

    public String getPromotionType(){
        return EnumFactory.getString(promotionType);
    }

}
