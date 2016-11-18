package bl.promotionbl;

import po.promotion.PromotionPO;
import vo.order.OrderVO;

/**
 * Created by kevin on 2016/11/6.
 */
public class MultipleRoomPromotion implements Sale{
    private int leastRooms;
    private double discount;

    public MultipleRoomPromotion(PromotionPO promotionPO) {
        this.leastRooms = promotionPO.getLeastRooms();
        this.discount = promotionPO.getDiscount();
    }

    @Override
    public double getActualPrice(OrderVO orderVO) {
        double price = orderVO.orderPriceVO.originPrice;

        if (orderVO.rooms.size() >= leastRooms){
            return price * discount;
        }else {
            return price;
        }
    }
}
