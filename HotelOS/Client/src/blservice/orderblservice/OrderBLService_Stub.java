package blservice.orderblservice;

import util.ResultMessage;
import vo.order.OrderVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class OrderBLService_Stub implements OrderBLService {
    @Override
    public OrderVO find(String orderID) {
        return new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null, null, 100, 98);
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
    public ResultMessage evaluate(OrderVO orderVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage cancel() {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<OrderVO> showList(OrderVO orderVO) {
        ArrayList<OrderVO> list = new ArrayList<>();
        list.add(new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null, null, 100, 98));
        return list;
    }
}
