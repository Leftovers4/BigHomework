package bl.orderbl.impl;

import bl.orderbl.OrderBLService;
import org.junit.Before;
import org.junit.Test;
import util.OrderType;
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
    public void viewHotelReviewList() throws Exception {
        List<ReviewVO> reviewVOList = tested.viewHotelReviewList(522000);
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
        ReviewVO reviewVO = tested.viewOrderReview("52200020161111000");
    }

    @Test
    public void onlineCheckIn() throws Exception {
        OrderVO orderVO = new OrderVO();

        orderVO.orderTimeVO.checkinTime = LocalDateTime.now();
        orderVO.roomNumber = "B330";

        tested.onlineCheckIn(orderVO);
    }

    @Test
    public void onlineCheckOut() throws Exception {

    }

    @Test
    public void executeOrder() throws Exception {

    }

    @Test
    public void cancelOrder() throws Exception {

    }

    @Test
    public void reviewOrder() throws Exception {

    }

    @Test
    public void viewFullUserOrderList() throws Exception {

    }

    @Test
    public void viewTypeUserOrderList() throws Exception {

    }

    @Test
    public void searchExtraOrderByID() throws Exception {

    }

    @Test
    public void getOrderActualPrice() throws Exception {

    }

    @Test
    public void addOrder() throws Exception {
        OrderVO orderVO = new OrderVO();

        orderVO.username = "Hiki";
        orderVO.hotelID = 145328;
        orderVO.roomType = RoomType.Couple;
        orderVO.roomAmount = 2;
        orderVO.personAmount = 4;
        orderVO.withChildren = false;
        orderVO.orderPriceVO.originPrice = 250;
        orderVO.orderPriceVO.actualPrice = 200;
        orderVO.orderTimeVO.expectedCheckinTime = LocalDateTime.now();
        orderVO.orderTimeVO.expectedLeaveTime = LocalDateTime.now().plusDays(2);

        tested.addOrder(orderVO);
    }

    @Test
    public void handleAppeal() throws Exception {

    }

}