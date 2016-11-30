package dataservice_stub;

import dataservice.orderdataservice.OrderDataService;
import po.order.ReviewPO;
import po.order.OrderPO;
import util.OrderType;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class OrderDataService_Stub implements OrderDataService {


    @Override
    public OrderPO findByOrderID(String orderID) throws RemoteException {
//        return new OrderPO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null);
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

    @Override
    public ArrayList<ReviewPO> findReviewByHotelID(long hotelID) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<ReviewPO> findAllReviews() throws RemoteException {
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
