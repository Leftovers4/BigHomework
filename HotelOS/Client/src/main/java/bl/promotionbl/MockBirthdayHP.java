package bl.promotionbl;

import bl.userbl.MockUser;
import bl.userbl.User;
import util.PromotionType;
import vo.order.OrderVO;

/**
 * Created by kevin on 2016/11/6.
 */
public class MockBirthdayHP extends BirthdayHP {

    /**
     * 营销策略ID
     */
    private long promotionID;

    /**
     * 营销策略类型
     */
    private PromotionType promotionType;

    /**
     * 折扣
     */
    private double discount;

    /**
     * Instantiates a new Mock birthday hp.
     *
     * @param promotionID   the promotion id
     * @param promotionType the promotion type
     * @param discount      the discount
     */
    public MockBirthdayHP(long promotionID, PromotionType promotionType, double discount) {
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.discount = discount;
    }

    /**
     * Compute price after applying the promotion
     *
     * @param orderVO the order vo
     * @return price after applying the promotion
     */
    public double compute(OrderVO orderVO){
        // TODO: 2016/11/7
        boolean isBirthday = true;

        if(isBirthday){
            return orderVO.orderPriceVO.originPrice * discount;
        }else {
            return orderVO.orderPriceVO.originPrice;
        }
    }

}
