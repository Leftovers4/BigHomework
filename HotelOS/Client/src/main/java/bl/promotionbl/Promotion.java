package bl.promotionbl;

import blservice.promotionblservice.PromotionCalculateService;
import vo.order.OrderVO;

/**
 * Created by kevin on 2016/11/6.
 */
public class Promotion implements PromotionCalculateService{
    @Override
    public double calculate(OrderVO vo) {
        return 0;
    }
}
