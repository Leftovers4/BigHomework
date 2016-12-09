package bl.promotionbl.impl;

import po.promotion.PromotionPO;
import vo.order.OrderVO;

import java.time.LocalDateTime;

/**
 * Created by kevin on 2016/11/6.
 */
public class SpecialTimePromotion implements Sale{

    private LocalDateTime beginTime;

    private LocalDateTime endTime;

    private double discount;

    public SpecialTimePromotion(PromotionPO promotionPO) {
        this.beginTime = promotionPO.getPromotionTimePO().getBeginTime();
        this.endTime = promotionPO.getPromotionTimePO().getEndTime();
        this.discount = promotionPO.getDiscount();
    }

    @Override
    public double getActualPrice(OrderVO orderVO) {
        LocalDateTime generateTime = orderVO.orderTimeVO.generateTime;
        double price = orderVO.orderPriceVO.originPrice;

        if(generateTime.isAfter(beginTime) && generateTime.isBefore(endTime)){
            return price * discount;
        }else {
            return price;
        }
    }

}
