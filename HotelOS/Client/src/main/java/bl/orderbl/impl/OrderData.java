package bl.orderbl.impl;

import dataservice.orderdataservice.OrderDataService;
import po.order.OrderPO;
import rmi.RemoteHelper;
import util.OrderType;
import util.ResultMessage;
import vo.order.OrderVO;

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

    public ResultMessage insert(Order order){
        try {
            return orderDAO.insert(order);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.ServerConnectionFail;
        }
    }

    public ResultMessage update(Order order){
        try {
            return orderDAO.update(order);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.ServerConnectionFail;
        }
    }

    public Order findByOrderID(String orderID){
        try {
            return (Order)(orderDAO.findByOrderID(orderID));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OrderList findByHotelID(long hotelID){
        try {
            return castAllToOrder(orderDAO.findByHotelID(hotelID));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OrderList findByHotelIDAndType(long hotelID, OrderType orderType){
        try {
            return castAllToOrder(orderDAO.findByHotelIDAndType(hotelID, orderType));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OrderList findByUsername(String username){
        try {
            return castAllToOrder(orderDAO.findByUsername(username));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OrderList findByUsernameAndType(String username, OrderType orderType){
        try {
            return castAllToOrder(orderDAO.findByUsernameAndType(username, orderType));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public OrderList findAll(){
        try {
            return castAllToOrder(orderDAO.findAll());
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    private OrderList castAllToOrder(List<OrderPO> orderPOList){
        OrderList orderList = new OrderList();

        for (int i = 0; i < orderPOList.size(); i++) {
            orderList.add((Order)(orderPOList.get(i)));
        }

        return orderList;
    }

}
