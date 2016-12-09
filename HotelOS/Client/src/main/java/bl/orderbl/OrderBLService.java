package bl.orderbl;
import util.*;
import vo.hotel.RoomVO;
import vo.order.OrderVO;
import vo.order.ReviewVO;
import vo.user.CreditVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 2016/10/15.
 */
public interface OrderBLService {

    /*
     * 若搜索不到该订单则返回null
     */
    OrderVO searchOrderByID(String orderID) throws RemoteException;

    List<OrderVO> searchOrderByHotelIDAndUsername(long hotelID, String username) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /*
     * 若酒店无评价则返回size为0的表
     */
    List<ReviewVO> viewHotelReviewList(long hotelID) throws RemoteException;

    List<ReviewVO> viewHotelReviewListByRating(long hotelID, int rating) throws RemoteException;

    List<OrderVO> viewFullHotelOrderList(long hotelID) throws RemoteException;

    List<OrderVO> viewTypeHotelOrderList(long hotelID, OrderType orderType) throws RemoteException;

    ReviewVO viewOrderReview(String orderID) throws RemoteException;

    ResultMessage onlineCheckIn(OrderVO orderVO) throws RemoteException;

    ResultMessage onlineCheckOut(OrderVO orderVO) throws RemoteException;

    ResultMessage executeOrder(String orderID) throws RemoteException;

    ResultMessage executeOrder(OrderVO orderVO) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    ResultMessage cancelOrder(String orderID) throws RemoteException;

    public ResultMessage reviewOrder(ReviewVO reviewVO) throws RemoteException;

    public List<OrderVO> viewFullUserOrderList(String username) throws RemoteException;

    public List<OrderVO> viewTypeUserOrderList(String username, OrderType orderType) throws RemoteException;

    public OrderVO searchExtraOrderByID(String orderID) throws RemoteException;

    double getOrderActualPrice(OrderVO orderVO) throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException;

    ResultMessage addOrder(OrderVO orderVO) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    ResultMessage handleAppeal(String orderID, double creditPercent) throws RemoteException;

}
