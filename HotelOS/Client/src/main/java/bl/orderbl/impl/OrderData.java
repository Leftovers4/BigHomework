package bl.orderbl.impl;

import dataservice.orderdataservice.OrderDataService;
import po.order.OrderPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by kevin on 2016/12/1.
 */
public class OrderData {

    private OrderDataService orderDAO;

    public OrderData(){
        orderDAO = RemoteHelper.getInstance().getOrderDAO();
    }

    public OrderList find(long hotelID){
        try {
            OrderList orderList = new OrderList();
            List<OrderPO> orderPOList = orderDAO.findByHotelID(hotelID);

            for (int i = 0; i < orderPOList.size(); i++) {
                orderList.add((Order)(orderPOList.get(i)));
            }

            return orderList;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

}
