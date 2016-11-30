package data.dao.orderdata;

import dataservice.orderdataservice.OrderDataService;
import po.order.OrderPO;
import po.order.ReviewPO;
import util.OrderType;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class OrderDataServiceImpl implements OrderDataService {


    @Override
    public ResultMessage insert(OrderPO orderPO) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage update(OrderPO orderPO) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> findAll() throws RemoteException {
        return null;
    }

    @Override
    public OrderPO findByOrderID(String orderID) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> findByHotelID(long hotelID) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> findByHotelIDAndType(long hotelID, OrderType orderType) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> findByUsername(String username) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> findByUsernameAndType(String username, OrderType orderType) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> findByUsernameAndHotelID(String username, long hotelID) throws RemoteException {
        return null;
    }
}
