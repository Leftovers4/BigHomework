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

    /**
     * 根据订单号搜索订单
     *
     * @param orderID 订单号
     * @return 可能为空
     * @throws RemoteException 连接服务器异常
     */
    OrderVO searchOrderByID(String orderID) throws RemoteException;

    /**
     * Search order by hotel id and username list.
     *
     * @param hotelID  the hotel id
     * @param username the username
     * @return the list
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> searchOrderByHotelIDAndUsername(long hotelID, String username) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * View hotel review list list.
     *
     * @param hotelID the hotel id
     * @return the list
     * @throws RemoteException 连接服务器异常
     */
/*
     * 若酒店无评价则返回size为0的表
     */
    List<ReviewVO> viewHotelReviewList(long hotelID) throws RemoteException;

    /**
     * View hotel review list by rating list.
     *
     * @param hotelID the hotel id
     * @param rating  the rating
     * @return the list
     * @throws RemoteException 连接服务器异常
     */
    List<ReviewVO> viewHotelReviewListByRating(long hotelID, int rating) throws RemoteException;

    /**
     * View full hotel order list list.
     *
     * @param hotelID the hotel id
     * @return the list
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewFullHotelOrderList(long hotelID) throws RemoteException;

    /**
     * View type hotel order list list.
     *
     * @param hotelID   the hotel id
     * @param orderType the order type
     * @return the list
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewTypeHotelOrderList(long hotelID, OrderType orderType) throws RemoteException;

    /**
     * View order review review vo.
     *
     * @param orderID the order id
     * @return the review vo
     * @throws RemoteException 连接服务器异常
     */
    ReviewVO viewOrderReview(String orderID) throws RemoteException;

    /**
     * Online check in result message.
     *
     * @param orderVO the order vo
     * @return the result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage onlineCheckIn(OrderVO orderVO) throws RemoteException;

    /**
     * Online check out result message.
     *
     * @param orderVO the order vo
     * @return the result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage onlineCheckOut(OrderVO orderVO) throws RemoteException;

    /**
     * Execute order result message.
     *
     * @param orderID the order id
     * @return the result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage executeOrder(String orderID) throws RemoteException;

    /**
     * Execute order result message.
     *
     * @param orderVO the order vo
     * @return the result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage executeOrder(OrderVO orderVO) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * Cancel order result message.
     *
     * @param orderID the order id
     * @return the result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage cancelOrder(String orderID) throws RemoteException;

    /**
     * Review order result message.
     *
     * @param reviewVO the review vo
     * @return the result message
     * @throws RemoteException the 连接服务器异常
     */
    ResultMessage reviewOrder(ReviewVO reviewVO) throws RemoteException;

    /**
     * View full user order list list.
     *
     * @param username the username
     * @return the list
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewFullUserOrderList(String username) throws RemoteException;

    /**
     * View type user order list list.
     *
     * @param username  the username
     * @param orderType the order type
     * @return the list
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewTypeUserOrderList(String username, OrderType orderType) throws RemoteException;

    /**
     * Search extra order by id order vo.
     *
     * @param orderID the order id
     * @return the order vo
     * @throws RemoteException 连接服务器异常
     */
    OrderVO searchExtraOrderByID(String orderID) throws RemoteException;

    /**
     * Gets order actual price.
     *
     * @param orderVO the order vo
     * @return the order actual price
     * @throws RemoteException           连接服务器异常
     * @throws ClassNotFoundException    the class not found exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    double getOrderActualPrice(OrderVO orderVO) throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException;

    /**
     * Add order result message.
     *
     * @param orderVO the order vo
     * @return the result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage addOrder(OrderVO orderVO) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * Handle appeal result message.
     *
     * @param orderID       the order id
     * @param creditPercent the credit percent
     * @return the result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage handleAppeal(String orderID, double creditPercent) throws RemoteException;

    /**
     * Gets full order list.
     *
     * @return the full order list
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewFullOrderList() throws RemoteException;

    /**
     * Gets type order list.
     *
     * @param orderType the order type
     * @return the type order list
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewTypeOrderList(OrderType orderType) throws RemoteException;

}
