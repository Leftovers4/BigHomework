package bl.orderbl.impl;

import bl.orderbl.OrderBLService;
import org.junit.Before;
import org.junit.Test;
import util.OrderType;
import util.PromotionType;
import util.ResultMessage;
import util.RoomType;
import vo.hotel.HotelVO;
import vo.order.OrderVO;
import vo.order.ReviewVO;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/12/6.
 */
public class OrderBlServiceImplTest {

    OrderBLService tested;

    @Before
    public void setUp() throws Exception {
        tested = new OrderBlServiceImpl();
    }

    @Test
    public void searchOrderByID() throws Exception {
        OrderVO orderVO = tested.searchOrderByID("45454148498");
    }

    @Test
    public void searchOrderByHotelIDAndUsername() throws Exception {
        List<OrderVO> orderVOList = tested.searchOrderByHotelIDAndUsername(145328, "Hiki");
    }

    @Test
    public void viewHotelReviewList() throws Exception {
        List<ReviewVO> reviewVOList = tested.viewHotelReviewList(522000);
    }

    @Test
    public void viewHotelReviewListByRating() throws Exception {
        List<ReviewVO> reviewVOList = tested.viewHotelReviewListByRating(522000, 4);
    }

    @Test
    public void viewFullHotelOrderList() throws Exception {
        List<OrderVO> orderVOList = tested.viewFullHotelOrderList(522000);
    }

    @Test
    public void viewTypeHotelOrderList() throws Exception {
        List<OrderVO> orderVOList = tested.viewTypeHotelOrderList(522000, OrderType.Canceled);
    }

    @Test
    public void viewOrderReview() throws Exception {
        ReviewVO reviewVO = tested.viewOrderReview("14532820161207423");
    }

    @Test
    public void onlineCheckIn() throws Exception {
        OrderVO orderVO = new OrderVO();

        orderVO.orderID = "14532820161207423";
        orderVO.orderTimeVO.checkinTime = LocalDateTime.now();
        orderVO.orderTimeVO.expectedLeaveTime = LocalDateTime.now();
        orderVO.roomNumber = "B330";

        tested.onlineCheckIn(orderVO);
    }

    @Test
    public void onlineCheckOut() throws Exception {
        OrderVO orderVO = new OrderVO();

        orderVO.orderID = "14532820161207423"; // 提供唯一标识
        orderVO.orderTimeVO.leaveTime = LocalDateTime.now();

        tested.onlineCheckOut(orderVO);
    }

    @Test
    public void executeOrder() throws Exception {
        OrderVO orderVO = new OrderVO();

        orderVO.orderID = "96152920161209324"; //提供唯一标识
        orderVO.orderTimeVO.checkinTime = LocalDateTime.now();
        orderVO.orderTimeVO.expectedLeaveTime = LocalDateTime.now().plusDays(2);
        orderVO.roomNumber = "B330";

        ResultMessage resultMessage = tested.executeOrder(orderVO);
    }

    @Test
    public void cancelOrder() throws Exception {
        ResultMessage resultMessage = tested.cancelOrder("14532820161207423");
    }

    @Test
    public void reviewOrder() throws Exception {
        ReviewVO reviewVO = new ReviewVO();

        reviewVO.orderID = "96152920161209324"; //提供唯一标识
        reviewVO.rating = 4;
        reviewVO.review = "sdjlfkalfkdfjkalj";

        tested.reviewOrder(reviewVO);
    }

    @Test
    public void viewFullUserOrderList() throws Exception {
        List<OrderVO> orderVOList = tested.viewFullUserOrderList("lisi");
    }

    @Test
    public void viewTypeUserOrderList() throws Exception {
        List<OrderVO> orderVOList = tested.viewTypeUserOrderList("lisi", OrderType.Unexecuted);
    }

    @Test
    public void searchExtraOrderByID() throws Exception {
        OrderVO orderVO = tested.searchExtraOrderByID("52200020161111000");
    }

    @Test
    public void getOrderActualPrice() throws Exception {
        OrderVO orderVO = new OrderVO();

        orderVO.username = "Hikii";
        orderVO.hotelID = 961529;
        orderVO.roomType = RoomType.Couple;
        orderVO.roomAmount = 2;
        orderVO.personAmount = 4;
        orderVO.withChildren = false;
        orderVO.orderPriceVO.originPrice = 250;
        orderVO.orderTimeVO.expectedCheckinTime = LocalDateTime.now();
        orderVO.orderTimeVO.expectedLeaveTime = LocalDateTime.now().plusDays(2);

        tested.getOrderActualPrice(orderVO);
    }

    @Test
    public void addOrder() throws Exception {
        OrderVO orderVO = new OrderVO();

        orderVO.username = "Hikii";
        orderVO.hotelID = 362355;
        orderVO.roomType = RoomType.BusinessSuite;
        orderVO.roomAmount = 2;
        orderVO.personAmount = 4;
        orderVO.withChildren = false;
        orderVO.orderPriceVO.originPrice = 250;
        orderVO.orderPriceVO.actualPrice = 200;
        orderVO.orderTimeVO.expectedCheckinTime = LocalDateTime.now();
        orderVO.orderTimeVO.expectedLeaveTime = LocalDateTime.now().plusDays(2);
        orderVO.orderPromoInfoVO.promotionType = PromotionType.BirthdayPromotion;

        ResultMessage resultMessage = tested.addOrder(orderVO);
    }

    @Test
    public void handleAppeal() throws Exception {
        ResultMessage resultMessage = tested.handleAppeal("96152920161216717", 0.5);
    }

    @Test
    public void getFullOrderList() throws Exception {
        List<OrderVO> orderVOList = tested.viewFullOrderList();
    }

    @Test
    public void getTypeOrderList() throws Exception {
        List<OrderVO> orderVOList = tested.viewTypeOrderList(OrderType.Executed);
    }

}