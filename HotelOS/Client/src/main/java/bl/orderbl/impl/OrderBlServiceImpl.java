package bl.orderbl.impl;

import bl.orderbl.OrderBLService;
import bl.promotionbl.impl.PromotionList;
import bl.userbl.impl.CreditRecord;
import bl.userbl.impl.CreditRecordList;
import com.sun.xml.internal.bind.v2.model.core.ID;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.userdataservice.UserDataService;
import po.hotel.HotelPO;
import po.order.OrderPO;
import po.promotion.PromotionPO;
import po.user.CreditRecordPO;
import rmi.RemoteHelper;
import util.*;
import vo.order.OrderVO;
import vo.order.OrderVOCreator;
import vo.order.ReviewVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class OrderBlServiceImpl implements OrderBLService {

    OrderDataService orderDAO;

    UserDataService userDAO;

    HotelDataService hotelDAO;

    PromotionDataService promotionDAO;

    OrderVOCreator orderVOCreator;

    public OrderBlServiceImpl() {
        orderDAO = RemoteHelper.getInstance().getOrderDAO();
        userDAO = RemoteHelper.getInstance().getUserDAO();
        hotelDAO = RemoteHelper.getInstance().getHotelDAO();
        promotionDAO = RemoteHelper.getInstance().getPromotionDAO();
        orderVOCreator = new OrderVOCreator();
    }

    @Override
    public OrderVO searchOrderByID(String orderID) throws RemoteException {
        return orderVOCreator.createDetailedOrderVO(orderDAO.findByOrderID(orderID));
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public List<ReviewVO> viewHotelReviewList(long hotelID) throws RemoteException {
        List<ReviewVO> res = new ArrayList<>();
        List<OrderPO> orderPOList = orderDAO.findByHotelID(hotelID);

        for (int i = 0; i < orderPOList.size(); i++) {
            OrderPO orderPO = orderPOList.get(i);

            if (new Order(orderPO).hasReview())
                res.add(orderVOCreator.createOrdinaryReviewVO(orderPO));
        }

        return res;
    }

    @Override
    public List<OrderVO> viewFullHotelOrderList(long hotelID) throws RemoteException {
        List<OrderVO> res = new ArrayList<>();
        List<OrderPO> orderPOList = orderDAO.findByHotelID(hotelID);

        for (int i = 0; i < orderPOList.size(); i++) {
            res.add(orderVOCreator.createDetailedOrderVO(orderPOList.get(i)));
        }

        return res;
    }

    @Override
    public List<OrderVO> viewTypeHotelOrderList(long hotelID, OrderType orderType) throws RemoteException {
        List<OrderVO> res = new ArrayList<>();
        List<OrderPO> orderPOList = orderDAO.findByHotelIDAndType(hotelID, orderType);

        for (int i = 0; i < orderPOList.size(); i++) {
            res.add(orderVOCreator.createDetailedOrderVO(orderPOList.get(i)));
        }

        return res;
    }

    @Override
    public ReviewVO viewOrderReview(String orderID) throws RemoteException {
        return orderVOCreator.createOrdinaryReviewVO(orderDAO.findByOrderID(orderID));
    }

    @Override
    public ResultMessage onlineCheckIn(OrderVO orderVO) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderVO.orderID);

        orderPO.getOrderTimePO().setCheckinTime(orderVO.orderTimeVO.checkinTime);
        orderPO.getOrderTimePO().setExpectedLeaveTime(orderVO.orderTimeVO.expectedLeaveTime);
        orderPO.setRoomNumber(orderVO.roomNumber);

        return orderDAO.update(orderPO);
    }

    @Override
    public ResultMessage onlineCheckOut(OrderVO orderVO) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderVO.orderID);

        orderPO.getOrderTimePO().setLeaveTime(orderVO.orderTimeVO.leaveTime);

        return orderDAO.update(orderPO);
    }

    @Override
    public ResultMessage executeOrder(String orderID) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderID);

        orderPO.setOrderType(OrderType.Executed);

        CreditRecordPO creditRecordPO = new CreditRecordPO();

        creditRecordPO.setrecordID(IDProducer.produceGeneralID());
        creditRecordPO.setChangedTime(LocalDateTime.now());
        creditRecordPO.setUsername(orderPO.getUsername());
        creditRecordPO.setCreditChangedCause(CreditChangedCause.ExecuteOrder);
        creditRecordPO.setOrderID(orderID);
        creditRecordPO.setChangedCredit(orderPO.getOrderPricePO().getActualPrice());
        creditRecordPO.setCurrentCredit(new CreditRecordList(userDAO.findCreditRecordsByUsername(orderPO.getUsername())).getCurrentCredit() + creditRecordPO.getChangedCredit());

        userDAO.insertCreditRecord(creditRecordPO);

        return orderDAO.update(orderPO);
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public ResultMessage cancelOrder(String orderID) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderID);

        orderPO.setOrderType(OrderType.Canceled);

        LocalDateTime cancelTime = LocalDateTime.now();
        if (new Order(orderPO).isLateCancel(cancelTime)) {
            CreditRecordPO creditRecordPO = new CreditRecordPO();

            creditRecordPO.setrecordID(IDProducer.produceGeneralID());
            creditRecordPO.setChangedTime(cancelTime);
            creditRecordPO.setUsername(orderPO.getUsername());
            creditRecordPO.setCreditChangedCause(CreditChangedCause.CancelOrder);
            creditRecordPO.setOrderID(orderID);
            creditRecordPO.setChangedCredit(-(orderPO.getOrderPricePO().getActualPrice() / 2));
            creditRecordPO.setCurrentCredit(new CreditRecordList(userDAO.findCreditRecordsByUsername(orderPO.getUsername())).getCurrentCredit() + creditRecordPO.getChangedCredit());

            userDAO.insertCreditRecord(creditRecordPO);
        }

        return orderDAO.update(orderPO);
    }

    @Override
    public ResultMessage reviewOrder(ReviewVO reviewVO) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(reviewVO.orderID);

        orderPO.getReviewPO().setReviewTime(LocalDateTime.now());
        orderPO.getReviewPO().setRating(reviewVO.rating);
        orderPO.getReviewPO().setReview(reviewVO.review);

        return orderDAO.update(orderPO);
    }

    @Override
    public List<OrderVO> viewFullUserOrderList(String username) throws RemoteException {
        List<OrderVO> res = new ArrayList<>();
        List<OrderPO> orderPOList = orderDAO.findByUsername(username);

        for (int i = 0; i < orderPOList.size(); i++) {
            OrderPO orderPO = orderPOList.get(i);
            res.add(orderVOCreator.createExtraOrderVO(orderPO, hotelDAO.findByHotelID(orderPO.getHotelID())));
        }

        return res;
    }

    @Override
    public List<OrderVO> viewTypeUserOrderList(String username, OrderType orderType) throws RemoteException {
        List<OrderVO> res = new ArrayList<>();
        List<OrderPO> orderPOList = orderDAO.findByUsernameAndType(username, orderType);

        for (int i = 0; i < orderPOList.size(); i++) {
            OrderPO orderPO = orderPOList.get(i);
            res.add(orderVOCreator.createExtraOrderVO(orderPO, hotelDAO.findByHotelID(orderPO.getHotelID())));
        }

        return res;
    }

    @Override
    public OrderVO searchExtraOrderByID(String orderID) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderID);
        return orderVOCreator.createExtraOrderVO(orderPO, hotelDAO.findByHotelID(orderPO.getHotelID()));
    }

    @Override
    public double getOrderActualPrice(OrderVO orderVO) throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<PromotionPO> promotionPOList1 = promotionDAO.findAllWebPromotion();
        List<PromotionPO> promotionPOList2 = promotionDAO.findByHotelID(orderVO.hotelID);

        for (int i = 0; i < promotionPOList2.size(); i++) {
            promotionPOList1.add(promotionPOList2.get(i));
        }

        return new PromotionList(promotionPOList1).getLowestPrice(orderVO);
    }

    @Override
    public ResultMessage addOrder(OrderVO orderVO) throws RemoteException {
        OrderPO orderPO = new OrderPO();

        orderPO.setOrderID(IDProducer.produceOrderID(orderVO.hotelID));
        orderPO.setHotelID(orderVO.hotelID);
        orderPO.setUsername(orderVO.username);
        orderPO.setOrderType(OrderType.Unexecuted);
        orderPO.setHotelName(orderVO.hotelName);
        orderPO.setRoomType(orderVO.roomType);
        orderPO.setRoomAmount(orderVO.roomAmount);
        orderPO.setPersonAmount(orderVO.personAmount);
        orderPO.setWithChildren(orderVO.withChildren);
        orderPO.getOrderTimePO().setGenerateTime(LocalDateTime.now());
        orderPO.getOrderTimePO().setExpectedCheckinTime(orderVO.orderTimeVO.expectedCheckinTime);
        orderPO.getOrderTimePO().setExpectedLeaveTime(orderVO.orderTimeVO.expectedLeaveTime);
        orderPO.getOrderTimePO().setLastExecuteTime();
        orderPO.getOrderPricePO().setOriginPrice(orderVO.orderPriceVO.originPrice);
        orderPO.getOrderPricePO().setActualPrice(orderVO.orderPriceVO.actualPrice);

        return orderDAO.insert(orderPO);
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public ResultMessage handleAppeal(String orderID, double credit) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderID);

        LocalDateTime now = LocalDateTime.now();

        orderPO.setOrderType(OrderType.Canceled);
        orderPO.getOrderHandleAppealPO().setHaTime(now);
        if (credit == 0.5)
            orderPO.getOrderHandleAppealPO().setHa_result(HandleAppealResult.Half);
        else
            orderPO.getOrderHandleAppealPO().setHa_result(HandleAppealResult.All);

        CreditRecordPO creditRecordPO = new CreditRecordPO();

        creditRecordPO.setrecordID(IDProducer.produceGeneralID());
        creditRecordPO.setChangedTime(now);
        creditRecordPO.setUsername(orderPO.getUsername());
        creditRecordPO.setCreditChangedCause(CreditChangedCause.CancelAbnormalOrder);
        creditRecordPO.setOrderID(orderID);
        creditRecordPO.setChangedCredit(orderPO.getOrderPricePO().getActualPrice() * credit);
        creditRecordPO.setCurrentCredit(new CreditRecordList(userDAO.findCreditRecordsByUsername(orderPO.getUsername())).getCurrentCredit() + creditRecordPO.getChangedCredit());

        userDAO.insertCreditRecord(creditRecordPO);

        return orderDAO.update(orderPO);
    }

}
