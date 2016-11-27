package bl.hotelbl.impl;

import dataservice.hoteldataservice.HotelDataService;
import dataservice.personneldataservice.PersonnelDataService;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.personnel.PersonnelPO;
import rmi.RemoteHelper;
import util.PersonnelType;
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
public class HotelManager implements RoomInfoService{

    private HotelDataService hotelDao;
    private PersonnelDataService personnelDao;
    private LogicVOHelper logicVOHelper;
    private LogicPOHelper logicPOHelper;

    public HotelManager(){
        hotelDao = RemoteHelper.getInstance().getHotelDAO();
        personnelDao = RemoteHelper.getInstance().getPersonnelDAO();
        logicVOHelper = new LogicVOHelper();
        logicPOHelper = new LogicPOHelper();
    }

    public ResultMessage addHotel(HotelVO hotelVO){
        try {
            return hotelDao.insert(logicPOHelper.create(hotelVO));
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.CONNECTION_ERROR;
        }
    }

    public ResultMessage deleteHotel(long hotelID) {
        try {
            return hotelDao.delete(hotelID);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.CONNECTION_ERROR;
        }
    }

    public ResultMessage updateHotelInfo(HotelVO hotelVO) {
        try {
            HotelPO originHotelPO = hotelDao.findByHotelID(hotelVO.hotelID);
            return hotelDao.update(logicPOHelper.create(originHotelPO, hotelVO));
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.CONNECTION_ERROR;
        }
    }

    public HotelVO getBasicHotelInfo(long hotelID) {
        try {
            // TODO: 2016/11/26 personnel接口，order提供计算评分的接口
            HotelPO hotelPO = hotelDao.findByHotelID(hotelID);
            PersonnelPO personnelPO = new PersonnelPO(0, "", PersonnelType.HotelWorker, "工作人员");//personnelDao.findByHotelID(hotelID);
            double rating = 0;

            HotelVO hotelVO = logicVOHelper.create(hotelPO, personnelPO, rating);
            return hotelVO;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
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
            return hotelDao.insertRoom(logicPOHelper.create(roomVO));
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.CONNECTION_ERROR;
        }
    }

    public ResultMessage deleteRoom(long roomID) {
        try {
            return hotelDao.deleteRoom(roomID);
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.CONNECTION_ERROR;
        }
    }

    public ResultMessage updateRoomInfo(RoomVO roomVO) {
        // TODO: 2016/11/27
        return ResultMessage.SUCCESS;
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
