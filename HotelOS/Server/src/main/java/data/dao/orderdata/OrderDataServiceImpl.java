package data.dao.orderdata;

import dataservice.orderdataservice.OrderDataService;
import po.order.OrderPO;
import po.order.ReviewPO;

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
    public ArrayList<OrderPO> find(OrderPO orderPO) throws RemoteException {
        return null;
    }

    @Override
    public void insert(OrderPO orderPO) throws RemoteException {

    }

    @Override
    public void update(OrderPO orderPO) throws RemoteException {

    }

    @Override
    public ArrayList<OrderPO> getList() throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<ReviewPO> findReviewListByHotelID(long hotelID) throws RemoteException {
        return null;
    }
}
