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
     * 根据酒店ID和用户名搜索订单，一般为获取某用户在某酒店下的订单
     *
     * @param hotelID  酒店ID
     * @param username 用户名
     * @return 某客户在某酒店下的订单
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> searchOrderByHotelIDAndUsername(long hotelID, String username) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * 获取酒店的所有评价
     *
     * @param hotelID 酒店ID
     * @return 酒店的所有评价，若酒店无评价则返回size为0的表
     * @throws RemoteException 连接服务器异常
     */
    List<ReviewVO> viewHotelReviewList(long hotelID) throws RemoteException;

    /**
     * 获取酒店的特定评分的评价
     *
     * @param hotelID 酒店ID
     * @param rating  评分
     * @return 酒店的特定评分的评价，若无则返回size为0的表
     * @throws RemoteException 连接服务器异常
     */
    List<ReviewVO> viewHotelReviewListByRating(long hotelID, int rating) throws RemoteException;

    /**
     * 获取酒店的所有订单
     *
     * @param hotelID 酒店ID
     * @return 酒店的所有订单，若无则返回size为0的表
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewFullHotelOrderList(long hotelID) throws RemoteException;

    /**
     * 获取酒店某类型的订单
     *
     * @param hotelID   酒店ID
     * @param orderType 订单类型
     * @return 酒店某类型的订单，若无则返回size为0的表
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewTypeHotelOrderList(long hotelID, OrderType orderType) throws RemoteException;

    /**
     * 获取订单的评价
     *
     * @param orderID 订单号
     * @return 订单的评价，可能为null
     * @throws RemoteException 连接服务器异常
     */
    ReviewVO viewOrderReview(String orderID) throws RemoteException;

    /**
     * 线上入住
     *
     * @param orderVO 入住信息
     * @return DataNotExisted，OrederStatusIncorrect，数据库返回的result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage onlineCheckIn(OrderVO orderVO) throws RemoteException;

    /**
     * 线上退房
     *
     * @param orderVO 退房信息
     * @return DataNotExisted，OrederStatusIncorrect，DataExisted（已退房），数据库返回的result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage onlineCheckOut(OrderVO orderVO) throws RemoteException;

    /**
     * 执行订单，不包含入住信息
     *
     * @param orderID 订单号
     * @return DataNotExisted，OrederStatusIncorrect，数据库返回的result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage executeOrder(String orderID) throws RemoteException;

    /**
     * 执行订单，包含入住信息
     *
     * @param orderVO 入住信息
     * @return DataNotExisted，OrederStatusIncorrect，数据库返回的result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage executeOrder(OrderVO orderVO) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * 撤销订单
     *
     * @param orderID 订单号
     * @return DataNotExisted，OrederStatusIncorrect，数据库返回的result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage cancelOrder(String orderID) throws RemoteException;

    /**
     * 评价订单
     *
     * @param reviewVO 评价信息
     * @return DataNotExisted（订单不存在），DataExisted（订单已评价），数据库返回的result message
     * @throws RemoteException the 连接服务器异常
     */
    ResultMessage reviewOrder(ReviewVO reviewVO) throws RemoteException;

    /**
     * 获取客户所有的订单
     *
     * @param username 用户名
     * @return 客户所有的订单
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewFullUserOrderList(String username) throws RemoteException;

    /**
     * 获取客户某类型的订单
     *
     * @param username  用户名
     * @param orderType 订单类型
     * @return 客户某类型的订单
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewTypeUserOrderList(String username, OrderType orderType) throws RemoteException;

    /**
     * 根据订单号搜索包含丰富信息的订单
     *
     * @param orderID 订单号
     * @return 包含丰富信息的订单
     * @throws RemoteException 连接服务器异常
     */
    OrderVO searchExtraOrderByID(String orderID) throws RemoteException;

    /**
     * 获取订单实际价格
     *
     * @param orderVO 订单信息
     * @return 订单实际价格
     * @throws RemoteException           连接服务器异常
     * @throws ClassNotFoundException    the class not found exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    double getOrderActualPrice(OrderVO orderVO) throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException;

    /**
     * 新增订单
     *
     * @param orderVO 订单信息
     * @return CreditNotEnough，数据库返回的result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage addOrder(OrderVO orderVO) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * 处理订单申诉
     *
     * @param orderID       订单号
     * @param creditPercent 恢复的信用值比例
     * @return DataNotExisted，OrederStatusIncorrect，数据库返回的result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage handleAppeal(String orderID, double creditPercent) throws RemoteException;

    /**
     * 获取全部订单
     *
     * @return 全部订单
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewFullOrderList() throws RemoteException;

    /**
     * 获取某类型的订单
     *
     * @param orderType 订单类型
     * @return 某类型的订单
     * @throws RemoteException 连接服务器异常
     */
    List<OrderVO> viewTypeOrderList(OrderType orderType) throws RemoteException;

}
