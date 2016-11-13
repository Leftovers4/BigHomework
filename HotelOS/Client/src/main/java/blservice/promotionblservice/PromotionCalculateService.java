package blservice.promotionblservice;

import vo.order.OrderVO;

/**
 * Created by:Hitiger
 * Date: 2016/11/13   Time: 17:35
 * Description:
 */
public interface PromotionCalculateService {

    //计算通过营销策略打折后的订单价格
    public double calculate(OrderVO vo);
}
