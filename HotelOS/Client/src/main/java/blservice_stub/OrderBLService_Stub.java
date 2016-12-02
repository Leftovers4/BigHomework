package blservice_stub;

import bl.orderbl.OrderBLService;
import util.OrderType;
import util.ResultMessage;
import vo.order.OrderVO;
import vo.order.ReviewVO;
import vo.user.CreditVO;

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
    public ResultMessage addOrder(OrderVO orderVO) {
        return ResultMessage.Success;
    }

    @Override
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
    public ResultMessage cancelOrder(String orderID) {
        return ResultMessage.Success;
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

    @Override
    public List<OrderVO> viewFullHotelOrderList(long hotelID) {
        return null;
    }

    @Override
    public List<OrderVO> viewTypeHotelOrderList(long hotelID, OrderType orderType) {
        return null;
    }
}
