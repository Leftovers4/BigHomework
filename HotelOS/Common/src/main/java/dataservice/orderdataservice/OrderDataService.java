package dataservice.orderdataservice;

import dataservice.DataServiceParent;
import po.order.ReviewPO;
import po.order.OrderPO;
import util.OrderType;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public interface OrderDataService extends Remote{

    // 根据订单ID查找订单
    public OrderPO findByOrderID(String orderID) throws RemoteException;

    // 根据筛选条件（订单类型、用户名、酒店ID）查找订单
    public ArrayList<OrderPO> findByConditions(OrderPO orderPO) throws RemoteException;

    // 增加订单
    public ResultMessage insert(OrderPO orderPO) throws RemoteException;

    // 更新订单
    public ResultMessage update(OrderPO orderPO) throws RemoteException;

    // 显示订单列表
    public ArrayList<OrderPO> findAll() throws RemoteException;


}
