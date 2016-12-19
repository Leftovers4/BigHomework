package bl.orderbl.impl;

import bl.orderbl.OrderBLService;
import bl.promotionbl.impl.PromotionList;
import bl.userbl.impl.CreditRecordList;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.userdataservice.UserDataService;
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
import java.time.LocalDate;
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

    public OrderBlServiceImpl() throws RemoteException {
        orderDAO = RemoteHelper.getInstance().getOrderDAO();
        userDAO = RemoteHelper.getInstance().getUserDAO();
        hotelDAO = RemoteHelper.getInstance().getHotelDAO();
        promotionDAO = RemoteHelper.getInstance().getPromotionDAO();
        orderVOCreator = new OrderVOCreator();
    }

    @Override
    public OrderVO searchOrderByID(String orderID) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderID);

        //订单不存在的情况
        if (orderPO == null)
            return null;

        //订单存在的情况
        return orderVOCreator.createDetailedOrderVO(orderPO);
    }

    @Override
    public List<OrderVO> searchOrderByHotelIDAndUsername(long hotelID, String username) throws RemoteException {
        return orderVOCreator.createAllDetailedOrderVO(new OrderList(orderDAO.findByUsernameAndHotelID(username, hotelID)));
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public List<ReviewVO> viewHotelReviewList(long hotelID) throws RemoteException {
        return orderVOCreator.createAllOrdinaryReviewVO(new OrderList(orderDAO.findByHotelID(hotelID)).filterByHasReview());
    }

    @Override
    public List<ReviewVO> viewHotelReviewListByRating(long hotelID, int rating) throws RemoteException {
        return orderVOCreator.createAllOrdinaryReviewVO(new OrderList(orderDAO.findByHotelID(hotelID)).filterByHasReview().filterByRating(rating));
    }

    @Override
    public List<OrderVO> viewFullHotelOrderList(long hotelID) throws RemoteException {
        return orderVOCreator.createAllDetailedOrderVO(new OrderList(orderDAO.findByHotelID(hotelID)));
    }

    @Override
    public List<OrderVO> viewTypeHotelOrderList(long hotelID, OrderType orderType) throws RemoteException {
        return orderVOCreator.createAllDetailedOrderVO(new OrderList(orderDAO.findByHotelIDAndType(hotelID, orderType)));
    }

    @Override
    public ReviewVO viewOrderReview(String orderID) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderID);

        //订单不存在的情况 todo 这里两种情况都返回了null
        if (orderPO == null)
            return null;

        //订单存在且没有评价的情况
        if (!new Order(orderPO).hasReview())
            return null;

        //订单存在且有评价的情况
        return orderVOCreator.createOrdinaryReviewVO(orderPO);
    }

    @Override
    public ResultMessage onlineCheckIn(OrderVO orderVO) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderVO.orderID);

        //订单不存在的情况
        if (orderPO == null)
            return ResultMessage.DataNotExisted;

        //订单存在且已经入住的情况
        if (orderPO.getOrderTimePO().getCheckinTime() != null)
            return ResultMessage.OrederStatusIncorrect;

        //订单存在且尚未入住的情况
        orderPO.getOrderTimePO().setCheckinTime(orderVO.orderTimeVO.checkinTime);
        orderPO.getOrderTimePO().setExpectedLeaveTime(orderVO.orderTimeVO.expectedLeaveTime);
        orderPO.setRoomNumber(orderVO.roomNumber);

        return orderDAO.update(orderPO);
    }

    @Override
    public ResultMessage onlineCheckOut(OrderVO orderVO) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderVO.orderID);

        //订单不存在的情况
        if (orderPO == null)
            return ResultMessage.DataNotExisted;

        //订单存在且尚未入住的情况
        if (orderPO.getOrderTimePO().getCheckinTime() == null)
            return ResultMessage.OrederStatusIncorrect;

        //订单存在且已经入住且已经离开的情况
        if(orderPO.getOrderTimePO().getLeaveTime() != null)
            return ResultMessage.DataExisted;

        //订单存在且已经入住且尚未离开的情况
        orderPO.getOrderTimePO().setLeaveTime(orderVO.orderTimeVO.leaveTime);

        return orderDAO.update(orderPO);
    }

    @Override
    public ResultMessage executeOrder(String orderID) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderID);

        //订单不存在的情况
        if (orderPO == null)
            return ResultMessage.DataNotExisted;

        //订单存在且状态不正确的情况
        OrderType orderType = orderPO.getOrderType();
        if (orderType.equals(OrderType.Executed) || orderType.equals(OrderType.Canceled))
            return ResultMessage.OrederStatusIncorrect;

        //订单存在且状态正确的情况
            //更新信用记录
        CreditRecordPO creditRecordPO = new CreditRecordPO();
        creditRecordPO.setrecordID(IDProducer.produceGeneralID());
        creditRecordPO.setChangedTime(LocalDateTime.now());
        creditRecordPO.setUsername(orderPO.getUsername());
        creditRecordPO.setCreditChangedCause(CreditChangedCause.ExecuteOrder);
        creditRecordPO.setOrderID(orderID);
        creditRecordPO.setChangedCredit(orderPO.getOrderPricePO().getActualPrice());
        creditRecordPO.setCurrentCredit(new CreditRecordList(userDAO.findCreditRecordsByUsername(orderPO.getUsername())).getCurrentCredit() + creditRecordPO.getChangedCredit());
        ResultMessage resultMessage = userDAO.insertCreditRecord(creditRecordPO);
        if (!resultMessage.equals(ResultMessage.Success))
            return resultMessage;

            //更新订单信息
        orderPO.setOrderType(OrderType.Executed);
        return orderDAO.update(orderPO);
    }

    @Override
    public ResultMessage executeOrder(OrderVO orderVO) throws RemoteException {
        ResultMessage resultMessage = onlineCheckIn(orderVO);

        if (!resultMessage.equals(ResultMessage.Success))
            return resultMessage;

        return executeOrder(orderVO.orderID);
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public ResultMessage cancelOrder(String orderID) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderID);

        //订单不存在的情况
        if (orderPO == null)
            return ResultMessage.DataNotExisted;

        //订单存在且状态不正确的情况
        OrderType orderType = orderPO.getOrderType();
        if (orderType.equals(OrderType.Executed) || orderType.equals(OrderType.Canceled))
            return ResultMessage.OrederStatusIncorrect;

        //订单存在且状态正确的情况
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

            ResultMessage resultMessage = userDAO.insertCreditRecord(creditRecordPO);

            if (!resultMessage.equals(ResultMessage.Success))
                return resultMessage;
        }

        return orderDAO.update(orderPO);
    }

    @Override
    public ResultMessage reviewOrder(ReviewVO reviewVO) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(reviewVO.orderID);

        //订单不存在的情况
        if (orderPO == null)
            return ResultMessage.DataNotExisted;

        //订单存在且有评论的情况
        if (new Order(orderPO).hasReview())
            return ResultMessage.DataExisted;

        //订单存在且没有评论的情况
        orderPO.getReviewPO().setReviewTime(LocalDateTime.now());
        orderPO.getReviewPO().setRating(reviewVO.rating);
        orderPO.getReviewPO().setReview(reviewVO.review);

        return orderDAO.update(orderPO);
    }

    @Override
    public List<OrderVO> viewFullUserOrderList(String username) throws RemoteException {
        List<OrderVO> res = new ArrayList<>();

        List<OrderPO> orderPOList = new OrderList(orderDAO.findByUsername(username));
        for (int i = 0; i < orderPOList.size(); i++) {
            OrderPO orderPO = orderPOList.get(i);
            res.add(orderVOCreator.createExtraOrderVO(orderPO, hotelDAO.findByHotelID(orderPO.getHotelID())));
        }

        return res;
    }

    @Override
    public List<OrderVO> viewTypeUserOrderList(String username, OrderType orderType) throws RemoteException {
        List<OrderVO> res = new ArrayList<>();

        List<OrderPO> orderPOList = new OrderList(orderDAO.findByUsernameAndType(username, orderType));
        for (int i = 0; i < orderPOList.size(); i++) {
            OrderPO orderPO = orderPOList.get(i);
            res.add(orderVOCreator.createExtraOrderVO(orderPO, hotelDAO.findByHotelID(orderPO.getHotelID())));
        }

        return res;
    }

    @Override
    public OrderVO searchExtraOrderByID(String orderID) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderID);

        //订单不存在的情况
        if (orderPO == null)
            return null;

        //订单存在的情况
        return orderVOCreator.createExtraOrderVO(orderPO, hotelDAO.findByHotelID(orderPO.getHotelID()));
    }

    @Override
    public double getOrderActualPrice(OrderVO orderVO) throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<PromotionPO> promotionPOList1 = promotionDAO.findAllWebPromotion();
        List<PromotionPO> promotionPOList2 = promotionDAO.findByHotelID(orderVO.hotelID);

        for (int i = 0; i < promotionPOList2.size(); i++) {
            promotionPOList1.add(promotionPOList2.get(i));
        }

        orderVO.orderTimeVO.generateTime = LocalDateTime.now();
        return new PromotionList(promotionPOList1).getLowestPrice(orderVO);
    }

    @Override
    public ResultMessage addOrder(OrderVO orderVO) throws RemoteException {
        //信用值不足的情况
        if (!(new CreditRecordList(userDAO.findCreditRecordsByUsername(orderVO.username)).canAddOrder()))
            return ResultMessage.CreditNotEnough;

        //信用值足够的情况
        OrderPO orderPO = new OrderPO();

        orderPO.setOrderID(IDProducer.produceOrderID(orderVO.hotelID));
        orderPO.setHotelID(orderVO.hotelID);
        orderPO.setUsername(orderVO.username);
        orderPO.setOrderType(OrderType.Unexecuted);
        orderPO.setHotelName(hotelDAO.findByHotelID(orderVO.hotelID).getHotelName());
        orderPO.setRoomType(orderVO.roomType);
        orderPO.setRoomAmount(orderVO.roomAmount);
        orderPO.setPersonAmount(orderVO.personAmount);
        orderPO.setWithChildren(orderVO.withChildren);
        orderPO.getOrderTimePO().setGenerateTime(LocalDateTime.now());
        orderPO.getOrderTimePO().setExpectedCheckinTime(OrderTimeRule.getExpectedCheckInTime(orderVO.orderTimeVO.expectedCheckinTime.toLocalDate()));
        orderPO.getOrderTimePO().setExpectedLeaveTime(OrderTimeRule.getExpectedLeaveTime(orderVO.orderTimeVO.expectedLeaveTime.toLocalDate()));
        orderPO.getOrderTimePO().setLastExecuteTime(OrderTimeRule.getLastExecuteTime(orderPO.getOrderTimePO().getExpectedCheckinTime()));
        orderPO.getOrderPricePO().setOriginPrice(orderVO.orderPriceVO.originPrice);
        orderPO.getOrderPricePO().setActualPrice(orderVO.orderPriceVO.actualPrice);
        orderPO.setPromotionType(orderVO.orderPromoInfoVO.promotionType);

        return orderDAO.insert(orderPO);
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public ResultMessage handleAppeal(String orderID, double creditPercent) throws RemoteException {
        OrderPO orderPO = orderDAO.findByOrderID(orderID);

        //订单不存在的情况
        if (orderPO == null)
            return ResultMessage.DataNotExisted;

        //订单存在且状态不正确的情况
        if (!orderPO.getOrderType().equals(OrderType.Abnormal))
            return ResultMessage.OrederStatusIncorrect;

        //订单存在且状态正确的情况
        LocalDateTime now = LocalDateTime.now();

            //更新信用记录
        CreditRecordPO creditRecordPO = new CreditRecordPO();
        creditRecordPO.setrecordID(IDProducer.produceGeneralID());
        creditRecordPO.setChangedTime(now);
        creditRecordPO.setUsername(orderPO.getUsername());
        creditRecordPO.setCreditChangedCause(CreditChangedCause.CancelAbnormalOrder);
        creditRecordPO.setOrderID(orderID);
        creditRecordPO.setChangedCredit(orderPO.getOrderPricePO().getActualPrice() * creditPercent);
        creditRecordPO.setCurrentCredit(new CreditRecordList(userDAO.findCreditRecordsByUsername(orderPO.getUsername())).getCurrentCredit() + creditRecordPO.getChangedCredit());
        ResultMessage resultMessage = userDAO.insertCreditRecord(creditRecordPO);
        if (!resultMessage.equals(ResultMessage.Success))
            return resultMessage;

            //更新订单信息
        orderPO.setOrderType(OrderType.Canceled);
        orderPO.getOrderHandleAppealPO().setHaTime(now);
        orderPO.getOrderHandleAppealPO().setHa_result(creditPercent == 0.5 ? HandleAppealResult.RecoverHalf : HandleAppealResult.RecoverAll);
        return orderDAO.update(orderPO);
    }

    @Override
    public List<OrderVO> viewFullOrderList() throws RemoteException {
        return orderVOCreator.createAllDetailedOrderVO(new OrderList(orderDAO.findAll()));
    }

    @Override
    public List<OrderVO> viewTypeOrderList(OrderType orderType) throws RemoteException {
        return orderVOCreator.createAllDetailedOrderVO(new OrderList(orderDAO.findByType(orderType)));
    }

}