package blservice_stub;

import bl.orderbl.OrderBLService;
import util.OrderType;
import util.ResultMessage;
import util.RoomType;
import vo.order.OrderPriceVO;
import vo.order.OrderTimeVO;
import vo.order.OrderVO;
import vo.order.ReviewVO;
import vo.user.CreditVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/10/16.
 */
public class OrderBLService_Stub implements OrderBLService {
    @Override
    public OrderVO searchOrderByID(String orderID) {
//        return new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null);
        return null;
    }

    @Override
    public List<OrderVO> searchOrderByHotelIDAndUsername(long hotelID, String username) throws RemoteException {
        return null;
    }

    @Override
    public List<ReviewVO> viewHotelReviewList(long hotelID) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addOrder(OrderVO orderVO) {
        return ResultMessage.Success;
    }

    public ResultMessage updateOrder(OrderVO orderVO) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage executeOrder(String orderID) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage reviewOrder(ReviewVO reviewVO) {
        return ResultMessage.Success;
    }

    @Override
    public List<OrderVO> viewFullUserOrderList(String username) throws RemoteException {
        return null;
    }

    @Override
    public List<OrderVO> viewTypeUserOrderList(String username, OrderType orderType) throws RemoteException {
        return null;
    }

    @Override
    public OrderVO searchExtraOrderByID(String orderID) throws RemoteException {
        return null;
    }

    @Override
    public double getOrderActualPrice(OrderVO orderVO) throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return 0;
    }

    @Override
    public ResultMessage cancelOrder(String orderID) {
        return ResultMessage.Success;
    }

    public ArrayList<OrderVO> showListByUsername(String username) {
        return null;
    }

    public ArrayList<OrderVO> showListByUsername_orderType(String username, OrderType orderType) {
        return null;
    }

    public ArrayList<CreditVO> showReviewListByHotelID(long hotelID) {
        return null;
    }

    public ResultMessage changeOrderType(String orderID) {
        return null;
    }

    @Override
    public ResultMessage handleAppeal(String orderID, double credit) {
        return null;
    }

    @Override
    public List<OrderVO> viewFullHotelOrderList(long hotelID) {
        ArrayList<OrderVO> list = new ArrayList<>();
        OrderVO orderVO = new OrderVO();
        orderVO.orderID = "12345678912345678";
        orderVO.username = "网红";
        orderVO.orderPriceVO = new OrderPriceVO(250, 200);
        orderVO.orderType = OrderType.Unexecuted;

        ReviewVO reviewVO = new ReviewVO();
        reviewVO.reviewTime = LocalDateTime.of(2016, 11, 12, 21, 00);
        reviewVO.review = "那你提莫无敌非常非常棒棒 象牙蚌啊!";
        reviewVO.rating = 5;
        reviewVO.roomType = RoomType.Couple;
        reviewVO.orderID = orderVO.orderID;
        reviewVO.username = orderVO.username;

        OrderTimeVO orderTimeVO = new OrderTimeVO(LocalDateTime.of(2016, 11, 11, 11, 00), LocalDateTime.of(2016, 11, 11, 20, 00), null, null,
                null, LocalDateTime.of(2016, 11, 12, 21, 00), null, null);

        orderVO.reviewVO = reviewVO;
        orderVO.orderTimeVO = orderTimeVO;
        list.add(orderVO);
        return list;
    }

    @Override
    public List<OrderVO> viewTypeHotelOrderList(long hotelID, OrderType orderType) {
        return null;
    }

    @Override
    public ReviewVO viewOrderReview(String orderID) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage onlineCheckIn(OrderVO orderVO) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage onlineCheckOut(OrderVO orderVO) throws RemoteException {
        return null;
    }
}
