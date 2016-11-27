package bl.orderbl.impl;

import bl.orderbl.OrderBLService;
import util.OrderType;
import util.ResultMessage;
import vo.order.OrderVO;
import vo.order.ReviewVO;
import vo.user.CreditVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/6.
 */
public class OrderBlServiceImpl implements OrderBLService {

    @Override
    public ResultMessage addOrder(OrderVO orderVO) {
        return null;
    }

    @Override
    public ResultMessage updateOrder(OrderVO orderVO) {
        return null;
    }

    @Override
    public ResultMessage executeOrder(String orderID) {
        return null;
    }

    @Override
    public ResultMessage cancelOrder(String orderID) {
        return null;
    }

    @Override
    public ResultMessage reviewOrder(ReviewVO reviewVO) {
        return null;
    }

    @Override
    public OrderVO searchOrderByID(String orderID) {
        return null;
    }

    @Override
    public ArrayList<OrderVO> viewOrderList(OrderVO orderVO) {
        return null;
    }

    @Override
    public ArrayList<OrderVO> showListByUsername(String username) {
        return null;
    }

    @Override
    public ArrayList<OrderVO> showListByUsername_orderType(String username, OrderType orderType) {
        return null;
    }

    @Override
    public ArrayList<CreditVO> showReviewListByHotelID(long hotelID) {
        return null;
    }

    @Override
    public ResultMessage changeOrderType(String orderID) {
        return null;
    }

    @Override
    public ResultMessage handleAppeal(String orderID, double credit) {
        return null;
    }
}
