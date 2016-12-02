package bl.orderbl.impl;

import bl.orderbl.OrderBLService;
import util.OrderType;
import util.ResultMessage;
import vo.order.OrderVO;
import vo.order.OrderVOCreator;
import vo.order.ReviewVO;
import vo.user.CreditVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class OrderBlServiceImpl implements OrderBLService {

    OrderData orderData;
    OrderVOCreator orderVOCreator;

    public OrderBlServiceImpl(){
        orderData = new OrderData();
        orderVOCreator = new OrderVOCreator();
    }

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


/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public List<OrderVO> viewTypeHotelOrderList(long hotelID, OrderType orderType) {
        List<OrderVO> res = new ArrayList<>();
        OrderList orderList = orderData.find(hotelID, orderType);

        for (int i = 0; i < orderList.size(); i++) {
            res.add(orderVOCreator.createOrderVO(orderList.get(i)));
        }

        return res;
    }

    @Override
    public List<OrderVO> viewFullHotelOrderList(long hotelID) {
        List<OrderVO> res = new ArrayList<>();
        OrderList orderList = orderData.find(hotelID);

        for (int i = 0; i < orderList.size(); i++) {
            res.add(orderVOCreator.createOrderVO(orderList.get(i)));
        }

        return res;
    }

}
