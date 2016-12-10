package bl.hotelbl.impl;

import bl.hotelbl.HotelBLService;
import bl.personnelbl.impl.PersonnelList;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.personneldataservice.PersonnelDataService;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import rmi.RemoteHelper;
import util.IDProducer;
import util.PersonnelType;
import util.ResultMessage;
import vo.hotel.HotelConditionsVO;
import vo.hotel.HotelVO;
import vo.hotel.HotelVOCreator;
import vo.hotel.RoomVO;
import vo.order.OrderVOCreator;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by kevin on 2016/11/6.
 */
public class HotelBlServiceImpl implements HotelBLService {

    HotelDataService hotelDAO;

    PersonnelDataService personnelDAO;

    OrderDataService orderDAO;

    HotelVOCreator hotelVOCreator;

    OrderVOCreator orderVOCreator;

    public HotelBlServiceImpl() throws RemoteException {
        hotelDAO = RemoteHelper.getInstance().getHotelDAO();
        personnelDAO = RemoteHelper.getInstance().getPersonnelDAO();
        orderDAO = RemoteHelper.getInstance().getOrderDAO();
        hotelVOCreator = new HotelVOCreator();
        orderVOCreator = new OrderVOCreator();
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public long addHotel(HotelVO hotelVO) throws RemoteException {
        HotelPO hotelPO = new HotelPO();

        hotelPO.setHotelID(IDProducer.produceHotelID());
        hotelPO.setHotelName(hotelVO.hotelName);
        hotelPO.setStar(hotelVO.star);
        hotelPO.setAddress(hotelVO.address);
        hotelPO.setTradingArea(hotelVO.tradingArea);

        return hotelPO.getHotelID();
    }

    @Override
    public ResultMessage deleteHotel(long hotelID) throws RemoteException {
        return hotelDAO.delete(hotelID);
    }

    @Override
    public HotelVO findHotelByID(long hotelID) {
        return null;
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public HotelVO viewBasicHotelInfo(long hotelID) throws RemoteException {
        HotelPO hotelPO = hotelDAO.findByHotelID(hotelID);

        //酒店不存在的情况
        if (hotelPO == null)
            return null;

        //酒店存在的情况
        PersonnelPO personnelPO = new PersonnelList(personnelDAO.findByType(PersonnelType.HotelWorker)).filterByHotelID(hotelID);
        List<OrderPO> orderPOList = orderDAO.findByHotelID(hotelID);

        return hotelVOCreator.create(hotelPO, personnelPO, orderPOList);
    }

    @Override
    public ResultMessage updateBasicHotelInfo(HotelVO hotelVO) throws RemoteException {
        HotelPO hotelPO = hotelDAO.findByHotelID(hotelVO.hotelID);

        //酒店不存在的情况
        if (hotelPO == null)
            return ResultMessage.DataNotExisted;

        //酒店存在的情况
        hotelPO.setAddress(hotelVO.address);
        hotelPO.setTradingArea(hotelVO.tradingArea);
        hotelPO.setDescription(hotelVO.description);
        hotelPO.setService(hotelVO.service);

        return hotelDAO.update(hotelPO);
    }

    @Override
    public ResultMessage addRoom(RoomVO roomVO) throws RemoteException {
        //房间类型已存在的情况
        if(new RoomList(hotelDAO.findRoomsByHotelID(roomVO.hotelID)).filterByRoomType(roomVO.roomType) != null)
            return ResultMessage.DataExisted;

        //房间类型不存在的情况
        RoomPO roomPO = new RoomPO();

        roomPO.setroomID(IDProducer.produceGeneralID());
        roomPO.sethotelID(roomVO.hotelID);
        roomPO.setRoomType(roomVO.roomType);
        roomPO.setTotal(roomVO.total);
        roomPO.setAvailable(roomVO.total);
        roomPO.setPrice(roomVO.price);

        return hotelDAO.insertRoom(roomPO);
    }

    @Override
    public ResultMessage deleteRoom(long roomID) throws RemoteException {
        return hotelDAO.deleteRoom(roomID);
    }

    @Override
    public ResultMessage updateRoomInfo(RoomVO roomVO) throws RemoteException {
        RoomPO roomPO = hotelDAO.findRoomByID(roomVO.roomID);

        //房间类型不存在的情况
        if (roomPO == null)
            return ResultMessage.DataNotExisted;

        //房间类型存在的情况
        roomPO.setAvailable(roomPO.getAvailable() + roomVO.total - roomPO.getTotal());
        roomPO.setTotal(roomVO.total);
        roomPO.setPrice(roomVO.price);

        return hotelDAO.updateRoom(roomPO);
    }

    @Override
    public List<RoomVO> viewAllHotelRooms(long hotelID) throws RemoteException {
        return hotelVOCreator.createAllRoomVO(hotelDAO.findRoomsByHotelID(hotelID));
    }

    @Override
    public ResultMessage offlineCheckIn(long roomID, int amount) throws RemoteException {
        RoomPO roomPO = hotelDAO.findRoomByID(roomID);

        roomPO.setAvailable(roomPO.getAvailable() - amount);

        return hotelDAO.updateRoom(roomPO);
    }

    @Override
    public ResultMessage offlineCheckOut(long roomID, int amount) throws RemoteException {
        RoomPO roomPO = hotelDAO.findRoomByID(roomID);

        roomPO.setAvailable(roomPO.getAvailable() + amount);

        return hotelDAO.updateRoom(roomPO);
    }

    @Override
    public int viewOfflineCheckInRoomAmount(long hotelID) throws RemoteException {
        return new RoomList(hotelDAO.findRoomsByHotelID(hotelID)).getOfflineCheckInRoomAmount();
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public List<HotelVO> sortHotels(List<HotelVO> hotelVOs, String key, int mode) {
        HotelVOList hotelList = new HotelVOList(hotelVOs);

        hotelList.sort(key, mode);

        return hotelList;
    }

    @Override
    public List<HotelVO> searchHotelsByConditions(String username, HotelConditionsVO hotelConditionsVO) throws RemoteException {
        HotelList hotelList = new HotelList(hotelDAO.findAll());

        //筛选出地址，商圈，名称，价格，评分，星级符合的
        hotelList = hotelList.filterByAddress(hotelConditionsVO.address).filterByTradingArea(hotelConditionsVO.tradingArea)
                .filterByName(hotelConditionsVO.name).filterByStar(hotelConditionsVO.starLowerBound, hotelConditionsVO.starUpperBound)
                .filterByRating(hotelConditionsVO.ratingLowerBound, hotelConditionsVO.ratingUpperBound)
                .filterByPrice(hotelConditionsVO.priceLowerBound, hotelConditionsVO.priceUpperBound);

        //筛选出房间条件符合的
        if (hotelConditionsVO.expectedCheckInTime != null && hotelConditionsVO.expectedLeaveTime != null){
            //处理预计入住时间
            LocalDateTime beginTime;
            if (hotelConditionsVO.expectedCheckInTime.isEqual(LocalDate.now())){
                if (LocalDateTime.now().isAfter(LocalDateTime.now().withHour(14).withMinute(0).withSecond(0)))
                    beginTime = LocalDateTime.now();
                else
                    beginTime = LocalDateTime.now().withHour(14).withMinute(0).withSecond(0);
            }else {
                beginTime = hotelConditionsVO.expectedCheckInTime.atTime(14, 0, 0);
            }
            //处理预计离开时间
            LocalDateTime endTime = hotelConditionsVO.expectedLeaveTime.atTime(12, 0, 0);

            hotelList = hotelList.filterByHasRoom(beginTime, endTime, hotelConditionsVO.roomType);
        }

        //筛选出自己预定过的
        if (hotelConditionsVO.hasOrdered){
            hotelList = hotelList.filterByHasOrdered(username);
        }

        //创建出hotelVO
        List<HotelVO> res = new ArrayList<>();
        for (int i = 0; i < hotelList.size(); i++) {
            HotelPO hotelPO = hotelList.get(i);
            long hotelID = hotelPO.getHotelID();
            res.add(hotelVOCreator.create(hotelPO, orderDAO.findByHotelID(hotelID)
                    , orderDAO.findByUsernameAndHotelID(username,hotelID), hotelDAO.findRoomsByHotelID(hotelID)));
        }
        return res;
    }

    @Override
    public List<HotelVO> viewOrderedHotelList(String username) throws RemoteException {
        List<HotelVO> res = new ArrayList<>();

        //找出所有预定过的酒店的PO
        List<HotelPO> hotelPOList = new ArrayList<>();
        List<OrderPO> orderPOList = orderDAO.findByUsername(username);
        for (int i = 0; i < orderPOList.size(); i++) {
            hotelPOList.add(hotelDAO.findByHotelID(orderPOList.get(i).getHotelID()));
        }

        //构建出含有订单跟房间信息的酒店VO
        for (int i = 0; i < hotelPOList.size(); i++) {
            HotelPO hotelPO = hotelPOList.get(i);
            long hotelID = hotelPO.getHotelID();
            res.add(hotelVOCreator.create(hotelPO, orderDAO.findByHotelID(hotelID)
                    , orderDAO.findByUsernameAndHotelID(username,hotelID), hotelDAO.findRoomsByHotelID(hotelID)));
        }

        return res;
    }

    @Override
    public HotelVO viewDetailedHotelInfo(long hotelID, String username) throws RemoteException {
        HotelPO hotelPO = hotelDAO.findByHotelID(hotelID);

        //酒店不存在的情况
        if (hotelPO == null)
            return null;

        //酒店存在的情况
        return hotelVOCreator.create(hotelPO, orderDAO.findByHotelID(hotelID), orderDAO.findByUsernameAndHotelID(username, hotelID), hotelDAO.findRoomsByHotelID(hotelID));
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public List<HotelVO> viewFullHotelList() throws RemoteException {
        return hotelVOCreator.createAll(hotelDAO.findAll());
    }

}
