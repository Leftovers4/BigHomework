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

    // 增加订单
    public ResultMessage insert(OrderPO orderPO) throws RemoteException;

    // 更新订单
    public ResultMessage update(OrderPO orderPO) throws RemoteException;

    // 显示订单列表
    public ArrayList<OrderPO> findAll() throws RemoteException;

    // 根据ID查找订单
    public OrderPO findByOrderID(String orderID) throws RemoteException;

    // 根据hotelID查找订单
    public ArrayList<OrderPO> findByHotelID(long hotelID) throws RemoteException;

    // 根据OrderType查找订单
    public ArrayList<OrderPO> findByType(OrderType orderType) throws RemoteException;

    // 根据hotelID和OrderType查找订单
    public ArrayList<OrderPO> findByHotelIDAndType(long hotelID, OrderType orderType) throws RemoteException;

    // 根据username查找订单
    public ArrayList<OrderPO> findByUsername(String username) throws RemoteException;

    // 根据username和OrderType查找订单
    public ArrayList<OrderPO> findByUsernameAndType(String username, OrderType orderType) throws RemoteException;

    // 根据username和hotelID查找订单
    public ArrayList<OrderPO> findByUsernameAndHotelID(String username, long hotelID) throws RemoteException;

//    // 根据筛选条件（订单类型、用户名、酒店ID）查找订单
//    public ArrayList<OrderPO> findByConditions(OrderPO orderPO) throws RemoteException;

//    // 根据hotelID获得订单中的reviews
//    public ArrayList<ReviewPO> findReviewByHotelID(long hotelID) throws RemoteException;
//
//    // 获得所有订单的reviews
//    public ArrayList<ReviewPO> findAllReviews() throws RemoteException;

}
