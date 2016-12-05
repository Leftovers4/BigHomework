package blservice_stub;

import bl.orderbl.OrderBLService;
import util.OrderType;
import util.ResultMessage;
import vo.order.OrderVO;
import vo.order.ReviewVO;
import vo.user.CreditVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
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
        return null;
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
