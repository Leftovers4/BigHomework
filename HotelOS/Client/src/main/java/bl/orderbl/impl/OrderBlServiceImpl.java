package bl.orderbl.impl;

import bl.orderbl.OrderBLService;
import util.OrderType;
import util.ResultMessage;
import vo.order.OrderVO;
import vo.user.CreditVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/6.
 */
public class OrderBlServiceImpl implements OrderBLService {
    @Override
    public OrderVO find(String orderID) {
        return null;
    }

    @Override
    public ResultMessage add(OrderVO orderVO) {
        return null;
    }

    @Override
    public ResultMessage modify(OrderVO orderVO) {
        return null;
    }

    @Override
    public ResultMessage review(OrderVO orderVO) {
        return null;
    }

    @Override
    public ResultMessage cancel() {
        return null;
    }

    @Override
    public ArrayList<OrderVO> showList(OrderVO orderVO) {
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
