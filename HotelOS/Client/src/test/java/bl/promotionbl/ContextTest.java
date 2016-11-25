package bl.promotionbl;

import org.junit.Test;
import po.promotion.PromotionPO;
import util.OrderType;
import util.PromotionType;
import util.RoomType;
import vo.hotel.RoomVO;
import vo.order.OrderPriceVO;
import vo.order.OrderVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/19.
 */
public class ContextTest {
    Context context;
    PromotionPO promotionPO;
    OrderVO orderVO;

    @Test
    public void getActualPrice() throws Exception {
        promotionPO = new PromotionPO(110110, PromotionType.MultipleRoomPromotion, 522000, null, 0.9, 1);
        context = new Context(promotionPO);
        ArrayList<RoomVO> roomVOs = new ArrayList<>();
        roomVOs.add(new RoomVO(1, RoomType.Couple, 0, 0, 0));
        OrderPriceVO orderPriceVO = new OrderPriceVO(100, 0);
        orderVO = new OrderVO("12345620161111001", 123456,"张三", OrderType.Abnormal,"如家", roomVOs,null, 2, false, null, null,orderPriceVO,null);

        assert 90 == context.getActualPrice(orderVO);
    }

    @Test
    public void getLevel() throws Exception {

    }

}