package bl.hotelbl.impl;

import dataservice.hoteldataservice.HotelDataService;
import dataservice.personneldataservice.PersonnelDataService;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import rmi.RemoteHelper;
import util.ResultMessage;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;
import vo.hotel.LogicVOHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class HotelData implements RoomInfoService{

    private HotelDataService hotelDao;
    private HotelPOCreator hotelPOCreator;

    public HotelData(){
        hotelDao = RemoteHelper.getInstance().getHotelDAO();
        hotelPOCreator = new HotelPOCreator();
    }

    public Hotel find(long hotelID){
        try {
            return (Hotel)(hotelDao.findByHotelID(hotelID));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultMessage update(Hotel hotel){
        try {
            return hotelDao.update(hotel);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.ServerConnectionFail;
        }
    }



    private PersonnelDataService personnelDao;
    private LogicVOHelper logicVOHelper;

    public HotelData(int i){
        hotelDao = RemoteHelper.getInstance().getHotelDAO();
        personnelDao = RemoteHelper.getInstance().getPersonnelDAO();
        logicVOHelper = new LogicVOHelper();
        hotelPOCreator = new HotelPOCreator();
    }

    public ResultMessage addHotel(HotelVO hotelVO){
        try {
            return hotelDao.insert(hotelPOCreator.create(hotelVO));
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.ServerConnectionFail;
        }
    }

    public ResultMessage deleteHotel(long hotelID) {
        try {
            return hotelDao.delete(hotelID);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.ServerConnectionFail;
        }
    }

    public ResultMessage updateHotelInfo(HotelVO hotelVO) {
        try {
            HotelPO originHotelPO = hotelDao.findByHotelID(hotelVO.hotelID);
            return hotelDao.update(hotelPOCreator.create(originHotelPO, hotelVO));
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.ServerConnectionFail;
        }
    }

    public List<HotelVO> findHotelsByConditions(HotelVO hotelVO) {
        return null;
    }

    public List<HotelVO> findHotelsByUsername(String username) {
        return null;
    }

    public ResultMessage addRoom(RoomVO roomVO) {
        try {
            return hotelDao.insertRoom(hotelPOCreator.create(roomVO));
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.ServerConnectionFail;
        }
    }

    public ResultMessage deleteRoom(long roomID) {
        try {
            return hotelDao.deleteRoom(roomID);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.ServerConnectionFail;
        }
    }

    public ResultMessage updateRoomInfo(RoomVO roomVO) {
        // TODO: 2016/11/27
        return ResultMessage.Success;
    }

    public List<RoomVO> findRoomsByHotelID(long hotelID) {
        try {
            List<RoomPO> roomPOs = hotelDao.findRoomsByHotelID(hotelID);

            List<RoomVO> roomVOs = new ArrayList<>();

            for (RoomPO roomPO: roomPOs) {
                roomVOs.add(logicVOHelper.create(roomPO));
            }

            return roomVOs;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<RoomVO> getRooms() {
        return null;
    }

    @Override
    public ArrayList<RoomVO> setRooms() {
        return null;
    }

}
