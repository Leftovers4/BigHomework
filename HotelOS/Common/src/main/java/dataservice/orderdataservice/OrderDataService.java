package dataservice.orderdataservice;

import dataservice.DataServiceParent;
import po.order.ReviewPO;
import po.order.OrderPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public interface OrderDataService extends DataServiceParent {

    // 根据订单ID查找订单
    public OrderPO findByOrderID(String orderID) throws RemoteException;

    // 根据筛选条件（订单类型、用户名、酒店ID）查找订单
    public ArrayList<OrderPO> find(OrderPO orderPO) throws RemoteException;

    // 增加订单
    public void insert(OrderPO orderPO) throws RemoteException;

    // 更新订单
    public void update(OrderPO orderPO) throws RemoteException;

    // 显示订单列表
    public ArrayList<OrderPO> getList() throws RemoteException;

    // 根据酒店id获得订单评价列表
    public ArrayList<ReviewPO> findReviewListByHotelID(long hotelID) throws RemoteException;

    // 根据酒店ID获得评分列表


}
