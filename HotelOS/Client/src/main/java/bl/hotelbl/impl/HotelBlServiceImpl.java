package bl.hotelbl.impl;

import bl.hotelbl.HotelBLService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.personneldataservice.PersonnelDataService;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import rmi.RemoteHelper;
import util.IDProducer;
import util.ResultMessage;
import vo.hotel.HotelConditionsVO;
import vo.hotel.HotelVO;
import vo.hotel.HotelVOCreator;
import vo.hotel.RoomVO;
import vo.order.OrderVOCreator;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class HotelBlServiceImpl implements HotelBLService {

    HotelDataService hotelDAO;

    PersonnelDataService personnelDAO;

    OrderDataService orderDAO;

    HotelVOCreator hotelVOCreator;

    OrderVOCreator orderVOCreator;

    public HotelBlServiceImpl() {
        hotelDAO = RemoteHelper.getInstance().getHotelDAO();
        personnelDAO = RemoteHelper.getInstance().getPersonnelDAO();
        orderDAO = RemoteHelper.getInstance().getOrderDAO();
        hotelVOCreator = new HotelVOCreator();
        orderVOCreator = new OrderVOCreator();
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public ResultMessage addHotel(HotelVO hotelVO) throws RemoteException {
        HotelPO hotelPO = new HotelPO();

        hotelPO.setHotelID(IDProducer.produceHotelID());
        hotelPO.setHotelName(hotelVO.hotelName);
        hotelPO.setStar(hotelVO.star);

        return hotelDAO.insert(hotelPO);
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
        //酒店工作人员已登录，所以必然存在该酒店
        HotelPO hotelPO = hotelDAO.findByHotelID(hotelID);
        PersonnelPO personnelPO = null; // todo personnelDAO.
        List<OrderPO> orderPOList = orderDAO.findByHotelID(hotelID);

        return hotelVOCreator.create(hotelPO, personnelPO, orderPOList);
    }

    @Override
    public ResultMessage updateBasicHotelInfo(HotelVO hotelVO) throws RemoteException {
        //酒店工作人员已登录，所以必然存在该酒店
        HotelPO hotelPO = hotelDAO.findByHotelID(hotelVO.hotelID);

        hotelPO.setAddress(hotelVO.address);
        hotelPO.setTradingArea(hotelVO.tradingArea);
        hotelPO.setDescription(hotelVO.description);
        hotelPO.setService(hotelVO.service);

        return hotelDAO.update(hotelPO);
    }

    @Override
    public ResultMessage addRoom(RoomVO roomVO) throws RemoteException {
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
        //roomPO非空
        RoomPO roomPO = null; //todo hotelDAO.findRoomByID(roomVO.roomID);

        roomPO.setTotal(roomVO.total);
        roomPO.setPrice(roomVO.price);

        return hotelDAO.updateRoom(roomPO);
    }

    @Override
    public List<RoomVO> viewAllHotelRooms(long hotelID) throws RemoteException {
        //返回的有可能是空表
        List<RoomVO> res = new ArrayList<>();
        List<RoomPO> roomPOList = hotelDAO.findRoomsByHotelID(hotelID);

        for (RoomPO roomPO : roomPOList) {
            res.add(hotelVOCreator.create(roomPO));
        }

        return res;
    }

    @Override
    public ResultMessage offlineCheckIn(RoomVO roomVO, int amount) throws RemoteException {
        //roomPO非空
        RoomPO roomPO = null; //todo hotelDAO.findRoomByID(roomVO.roomID);

        roomPO.setAvailable(roomPO.getAvailable() - amount);

        return hotelDAO.updateRoom(roomPO);
    }

    @Override
    public ResultMessage offlineCheckOut(RoomVO roomVO, int amount) throws RemoteException {
        //roomPO非空
        RoomPO roomPO = null; //todo hotelDAO.findRoomByID(roomVO.roomID);

        roomPO.setAvailable(roomPO.getAvailable() + amount);

        return hotelDAO.updateRoom(roomPO);
    }

    @Override
    public int viewOfflineCheckInRoomAmount(long hotelID) throws RemoteException {
        return new RoomList(hotelDAO.findRoomsByHotelID(hotelID)).getOfflineCheckInRoomAmount();
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public void sortHotels(List<HotelVO> hotelVOs, String key, int mode) {
        HotelVOList hotelList = (HotelVOList) hotelVOs;
        hotelList.sort(key, mode);
    }

    @Override
    public List<HotelVO> searchHotelsByConditions(String username, HotelConditionsVO hotelConditionsVO) throws RemoteException {
        HotelList hotelList = new HotelList(hotelDAO.findAll());

        hotelList = hotelList.filterByAddress(hotelConditionsVO.address).filterByTradingArea(hotelConditionsVO.tradingArea)
                .filterByName(hotelConditionsVO.name).filterByStar(hotelConditionsVO.starLowerBound, hotelConditionsVO.starUpperBound)
                .filterByRating(hotelConditionsVO.ratingLowerBound, hotelConditionsVO.ratingUpperBound)
                .filterByPrice(hotelConditionsVO.priceLowerBound, hotelConditionsVO.priceUpperBound);


        if (hotelConditionsVO.hasOrdered){

        }

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
        List<HotelPO> hotelPOList = null; //todo

        for (int i = 0; i < hotelPOList.size(); i++) {
            HotelPO hotelPO = hotelPOList.get(i);
            long hotelID = hotelPO.getHotelID();
            res.add(hotelVOCreator.create(hotelPO, orderDAO.findByHotelID(hotelID)
                    , orderDAO.findByUsernameAndHotelID(username,hotelID), hotelDAO.findRoomsByHotelID(hotelID)));
        }

        return res;
    }

}
