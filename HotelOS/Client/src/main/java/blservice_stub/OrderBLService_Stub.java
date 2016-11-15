package blservice_stub;

import blservice.orderblservice.OrderBLService;
import util.OrderType;
import util.ResultMessage;
import vo.order.OrderVO;
import vo.user.CreditVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class OrderBLService_Stub implements OrderBLService {
    @Override
    public OrderVO find(String orderID) {
        return new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null);
    }

    @Override
    public ResultMessage add(OrderVO orderVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modify(OrderVO orderVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage review(OrderVO orderVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage cancel() {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<OrderVO> showList(OrderVO orderVO) {
        ArrayList<OrderVO> list = new ArrayList<OrderVO>();
        list.add(new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null));
        return list;
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
}
