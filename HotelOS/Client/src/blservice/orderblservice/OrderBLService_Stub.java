package blservice.orderblservice;

import util.ResultMessage;
import vo.order.OrderVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class OrderBLService_Stub implements OrderBLService {
    @Override
    public OrderVO find(long orderID) {
        return null;
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
        return null;
    }
}
