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
import java.util.Iterator;

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
        if(orderPO == null){
            return ResultMessage.NullInput;
        }

        // 将orderPO转换成orderAL
        ArrayList<Object> orderAL = paFactory.toOrderAl(orderPO);

        // 将orderAL写入order表中
        return orderDataHelper.insertToSQL(orderAL);

    }

    @Override
    public ResultMessage update(OrderPO orderPO) throws RemoteException {

        if(orderPO == null){
            return ResultMessage.NullInput;
        }

        // 将orderPO转换成orderAL
        ArrayList<Object> orderAL = paFactory.toOrderAl(orderPO);

        // 将orderAL写入order表中
        return orderDataHelper.updateFromSQL(orderAL);
    }

    @Override
    public ArrayList<OrderPO> findAll() throws RemoteException {

        // 在order表中取出所有的orderALs
        ArrayList<ArrayList<Object>> orderALs = orderDataHelper.findFromSQL();

        // 构造orderALs的迭代器
        Iterator<Iterator<Object>> orderInfos = ctFactory.alsToItrs(orderALs);

        // 转换成orderPOs
        ArrayList<OrderPO> orderPOs = new ArrayList<>();
        while(orderInfos.hasNext()){
            orderPOs.add(apFactory.toOrderPO(orderInfos.next()));
        }

        return orderPOs;

    }

    @Override
    public OrderPO findByOrderID(String orderID) throws RemoteException {

        // 在order表中找出orderAL
        ArrayList<Object> orderAL = orderDataHelper.findByIdFromSQL(orderID);

        // 构造orderAL的迭代器
        Iterator<Object> orderInfo = ctFactory.alToItr(orderAL);

        // 转换成orderPO
        OrderPO orderPO = apFactory.toOrderPO(orderInfo);

        return orderPO;

    }

    @Override
    public ArrayList<OrderPO> findByHotelID(long hotelID) throws RemoteException {
        // 调用findAll
        ArrayList<OrderPO> orderPOs = findAll();

        // 选择出相应的orderPOs
        ArrayList<OrderPO> selectedOrderPOs = new ArrayList<>();
        for(OrderPO each : orderPOs){
            if(each.getHotelID() == hotelID){
                selectedOrderPOs.add(each);
            }
        }

        return selectedOrderPOs;
    }

    @Override
    public ArrayList<OrderPO> findByType(OrderType orderType) throws RemoteException {
        // 调用findAll
        ArrayList<OrderPO> orderPOs = findAll();

        // 选择出相应的orderPOs
        ArrayList<OrderPO> selectedOrderPOs = new ArrayList<>();
        for(OrderPO each : orderPOs){
            if(each.getOrderType().equals(orderType)){
                selectedOrderPOs.add(each);
            }
        }

        return selectedOrderPOs;
    }

    @Override
    public ArrayList<OrderPO> findByHotelIDAndType(long hotelID, OrderType orderType) throws RemoteException {
        // 调用findAll
        ArrayList<OrderPO> orderPOs = findAll();

        // 选择出相应的orderPOs
        ArrayList<OrderPO> selectedOrderPOs = new ArrayList<>();
        for(OrderPO each : orderPOs){
            if(each.getHotelID() == hotelID && each.getOrderType().equals(orderType)){
                selectedOrderPOs.add(each);
            }
        }

        return selectedOrderPOs;
    }

    @Override
    public ArrayList<OrderPO> findByUsername(String username) throws RemoteException {
        // 调用findAll
        ArrayList<OrderPO> orderPOs = findAll();

        // 选择出相应的orderPOs
        ArrayList<OrderPO> selectedOrderPOs = new ArrayList<>();
        for(OrderPO each : orderPOs){
            if(each.getUsername().equals(username)){
                selectedOrderPOs.add(each);
            }
        }

        return selectedOrderPOs;
    }

    @Override
    public ArrayList<OrderPO> findByUsernameAndType(String username, OrderType orderType) throws RemoteException {
        // 调用findAll
        ArrayList<OrderPO> orderPOs = findAll();

        // 选择出相应的orderPOs
        ArrayList<OrderPO> selectedOrderPOs = new ArrayList<>();
        for(OrderPO each : orderPOs){
            if(each.getUsername().equals(username) && each.getOrderType().equals(orderType)){
                selectedOrderPOs.add(each);
            }
        }

        return selectedOrderPOs;
    }

    @Override
    public ArrayList<OrderPO> findByUsernameAndHotelID(String username, long hotelID) throws RemoteException {
        // 调用findAll
        ArrayList<OrderPO> orderPOs = findAll();

        // 选择出相应的orderPOs
        ArrayList<OrderPO> selectedOrderPOs = new ArrayList<>();
        for(OrderPO each : orderPOs){
            if(each.getUsername().equals(username) && each.getHotelID() == hotelID){
                selectedOrderPOs.add(each);
            }
        }

        return selectedOrderPOs;
    }

//    @Override
//    public ArrayList<ReviewPO> findReviewByHotelID(long hotelID) throws RemoteException{
//        // 调用findAll
//        ArrayList<OrderPO> orderPOs = findAll();
//
//        // 选择出相应的reviewPOs
//        ArrayList<ReviewPO> selectedOrderReviewPOs = new ArrayList<>();
//        for(OrderPO each : orderPOs) {
//            if (each.getHotelID() == hotelID) {
//                selectedOrderReviewPOs.add(each.getReviewPO());
//            }
//        }
//
//        return selectedOrderReviewPOs;
//    }
//
//    @Override
//    public ArrayList<ReviewPO> findAllReviews() throws RemoteException {
//        // 调用findAll
//        ArrayList<OrderPO> orderPOs = findAll();
//
//        // 获得所有reviews
//        ArrayList<ReviewPO> reviewPOs = new ArrayList<>();
//        for (OrderPO each : orderPOs) {
//            reviewPOs.add(each.getReviewPO());
//        }
//
//        return reviewPOs;
//    }


}
