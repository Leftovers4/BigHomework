package bl.orderbl;
import util.*;
import vo.order.OrderVO;
import vo.order.ReviewVO;
import vo.user.CreditVO;

import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/15.
 */
public interface OrderBLService {

    // 添加订单
    ResultMessage addOrder(OrderVO orderVO);

    // 修改订单
    ResultMessage updateOrder(OrderVO orderVO);

    ResultMessage executeOrder(String orderID);

    // 撤销订单
    ResultMessage cancelOrder(String orderID);

    // 评价订单
    ResultMessage reviewOrder(ReviewVO reviewVO);

    // 根据订单ID查找订单
    OrderVO searchOrderByID(String orderID);

    // 根据条件显示订单列表
    // (待推敲) 根据用户、酒店、类型查找订单
    // (待推敲) 根据用户查找预定过的酒店
    ArrayList<OrderVO> viewOrderList(OrderVO orderVO);

    // 根据用户名查找订单列表
    ArrayList<OrderVO> showListByUsername(String username);

    // 根据用户名、订单类型查找订单列表（分类型查找用户历史订单列表）
    ArrayList<OrderVO> showListByUsername_orderType(String username, OrderType orderType);

    // 根据酒店id获得订单评价列表
    ArrayList<CreditVO> showReviewListByHotelID(long hotelID);

    // 改变订单类型
    ResultMessage changeOrderType(String orderID);

    //处理订单申诉
    ResultMessage handleAppeal(String orderID, double credit);

}
