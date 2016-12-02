package bl.promotionbl;

import bl.promotionbl.impl.Context;
import org.junit.Test;
import po.promotion.PromotionPO;
import util.OrderType;
import util.PromotionType;
import util.RoomType;
import vo.hotel.LogicVOHelper;
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
        roomVOs.add(new LogicVOHelper().create(1, RoomType.Couple,0, 0));
        OrderPriceVO orderPriceVO = new OrderPriceVO(100, 0);
        OrderVO orderVO = new OrderVO();
        orderVO.orderID = "12345678912345678";
        orderVO.hotelID = 123456;
        orderVO.username = "user1";
        orderVO.orderType = OrderType.Abnormal;
        orderVO.hotelName = "如家";
        orderVO.roomNumber = "A110 A250";
        orderVO.roomAmount = 2;
        orderVO.withChildren = false;
        orderVO.orderPriceVO = orderPriceVO;

        assert 90 == context.getActualPrice(orderVO);
    }

    @Test
    public void getLevel() throws Exception {

    }

}