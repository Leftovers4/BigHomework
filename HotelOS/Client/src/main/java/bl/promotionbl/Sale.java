package bl.promotionbl;

import vo.order.OrderVO;

/**
 * Created by kevin on 2016/11/18.
 */
public interface Sale extends Promotion{
    double getActualPrice(OrderVO orderVO);
}
