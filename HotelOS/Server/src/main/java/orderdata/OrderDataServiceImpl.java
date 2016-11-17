package orderdata;

import dataservice.orderdataservice.OrderDataService;
import po.order.OrderPO;
import po.order.ReviewPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class OrderDataServiceImpl implements OrderDataService {
    public void initial() throws RemoteException {
        
    }

    public void finish() throws RemoteException {

    }

    public OrderPO findByOrderID(String orderID) throws RemoteException {
        return null;
    }

    public ArrayList<OrderPO> find(OrderPO orderPO) throws RemoteException {
        return null;
    }

    public void insert(OrderPO orderPO) throws RemoteException {

    }

    public void update(OrderPO orderPO) throws RemoteException {

    }

    public ArrayList<OrderPO> getList() throws RemoteException {
        return null;
    }

    public ArrayList<ReviewPO> findReviewListByHotelID(long hotelID) throws RemoteException {
        return null;
    }
}
