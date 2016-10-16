package blservice.orderblservice;
import util.*;
import vo.order.OrderVO;

import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/15.
 */
public interface OrderBLService {

    // 根据订单ID查找订单
    public OrderVO find(String orderID);

    // 添加订单
    public ResultMessage add(OrderVO orderVO);

    // 修改订单
    public ResultMessage modify(OrderVO orderVO);

    // 评价订单
    public ResultMessage evaluate(OrderVO orderVO);

    // 撤销订单
    public ResultMessage cancel();

    // 根据条件显示订单列表
    // (待推敲) 根据用户、酒店、类型查找订单
    // (待推敲) 根据用户查找预定过的酒店
    public ArrayList<OrderVO> showList(OrderVO orderVO);




}
