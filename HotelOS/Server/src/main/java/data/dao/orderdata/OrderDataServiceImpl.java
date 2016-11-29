package data.dao.orderdata;

import dataservice.orderdataservice.OrderDataService;
import po.order.OrderPO;
import po.order.ReviewPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class OrderDataServiceImpl implements OrderDataService {


    @Override
    public OrderPO findByOrderID(String orderID) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<OrderPO> findByConditions(OrderPO orderPO) throws RemoteException {
        return null;
    }

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
}
