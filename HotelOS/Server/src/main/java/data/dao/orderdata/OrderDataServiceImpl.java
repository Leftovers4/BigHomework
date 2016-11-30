package data.dao.orderdata;

import data.dao.DataServiceImplParent;
import data.datahelper.orderdatahelper.OrderDataHelper;
import data.datahelper.userdatahelper.CreditRecordDataHelper;
import data.datahelper.userdatahelper.UserDataHelper;
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
public class OrderDataServiceImpl extends DataServiceImplParent implements OrderDataService {

    // 需要调用的DataHelper
    private OrderDataHelper orderDataHelper;

    // 将需要调用的底层类初始化
    public OrderDataServiceImpl(){
        super();
        orderDataHelper = dhFactory.getOrderDataHelper();
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

    @Override
    public ArrayList<ReviewPO> findReviewByHotelID(long hotelID) throws RemoteException{
        return null;
    }

    @Override
    public ArrayList<ReviewPO> findAllReviews() throws RemoteException {
        return null;
    }


}
