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

    public MockBirthdayHP(long promotionID, PromotionType promotionType, double discount) {
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.discount = discount;
    }

    double compute(OrderVO orderVO){
        boolean isBirthday;
    }
}
