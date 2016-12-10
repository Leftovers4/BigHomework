package blservice_stub;

import bl.hotelbl.HotelBLService;
import util.ResultMessage;
import util.RoomType;
import vo.hotel.HotelConditionsVO;
import vo.hotel.HotelVO;
import vo.hotel.HotelVOCreator;
import vo.hotel.RoomVO;
import vo.order.ReviewVO;

import java.net.HttpCookie;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/10/16.
 */
public class HotelBLService_Stub implements HotelBLService {

    List<RoomVO> list;
    HotelVOCreator logicVOHelper;

    public HotelBLService_Stub(){
         list = new ArrayList<>();
         logicVOHelper = new HotelVOCreator();
    }

    @Override
    public long addHotel(HotelVO hotelVO) {
        return 0;
    }

    @Override
    public ResultMessage deleteHotel(long hotelID) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage updateBasicHotelInfo(HotelVO hotelVO) {
        return ResultMessage.Success;
    }

    @Override
    public List<RoomVO> viewAllHotelRooms(long hotelID) throws RemoteException {
        return null;
    }

    @Override
    public HotelVO findHotelByID(long hotelID) {
        return logicVOHelper.create(1,"如家", "工作人员", 4, 4.3, "南京", "新街口地区", "好", "Wifi");
    }

    public List<HotelVO> findHotelsByConditions(HotelVO hotelVO) {
        ArrayList<HotelVO> list = new ArrayList<HotelVO>();
        list.add(logicVOHelper.create(1, "如家", "工作人员", 4, 4.3, "南京", "新街口地区", "好", "Wifi"));
        return list;
    }

    public List<HotelVO> findHotelsByUsername(String username) {
        return null;
    }

    @Override
    public List<HotelVO> sortHotels(List<HotelVO> hotelVOs, String key, int mode) {
        return null;
    }

    @Override
    public List<HotelVO> searchHotelsByConditions(String username, HotelConditionsVO hotelConditionsVO) throws RemoteException {
        return null;
    }

    @Override
    public List<HotelVO> viewOrderedHotelList(String username) throws RemoteException {
        return null;
    }

    @Override
    public HotelVO viewDetailedHotelInfo(long hotelID, String username) throws RemoteException {
        return null;
    }

    @Override
    public List<HotelVO> viewFullHotelList() throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addRoom(RoomVO roomVO) {
        list.add(roomVO);
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage deleteRoom(long roomID) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage updateRoomInfo(RoomVO roomVO) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage offlineCheckIn(long roomID, int amount) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage offlineCheckOut(long roomID, int amount) throws RemoteException {
        return null;
    }

    @Override
    public int viewOfflineCheckInRoomAmount(long hotelID) throws RemoteException {
        return 0;
    }

    public List<RoomVO> findRoomsByHotelID(long hotelID) {

        list.add(logicVOHelper.create(hotelID,RoomType.Single,10,100));
        list.add(logicVOHelper.create(hotelID,RoomType.Single,20,200));
        list.add(logicVOHelper.create(hotelID,RoomType.Couple,10,300));
        list.add(logicVOHelper.create(hotelID,RoomType.Couple,20,400));
        list.add(logicVOHelper.create(hotelID,RoomType.Couple,30,500));
        return list;
    }

    @Override
    public HotelVO viewBasicHotelInfo(long hotelID) {
        return logicVOHelper.create(1,"如家", "工作人员", 4, 4.3, "南京", "新街口地区", "好", "Wifi");
    }

    public List<ReviewVO> viewHotelReviews(long hotelID) {
        return null;
    }

    public ResultMessage updateBasicHotelInfo(long hotelID, String address, String tradingArea, String description, String service) {
        return null;
    }
}
