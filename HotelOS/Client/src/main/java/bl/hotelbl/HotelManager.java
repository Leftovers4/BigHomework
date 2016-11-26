package bl.hotelbl;

import bl.personnelbl.Personnel;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.personneldataservice.PersonnelDataService;
import po.hotel.HotelPO;
import po.personnel.PersonnelPO;
import rmi.RemoteHelper;
import util.PersonnelType;
import util.ResultMessage;
import util.RoomType;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class HotelManager implements RoomInfoService{

    private HotelDataService hotelDao;
    private PersonnelDataService personnelDao;
    private VoHelper voHelper;
    private PoHelper poHelper;

    public HotelManager(){
        hotelDao = RemoteHelper.getInstance().getHotelDAO();
        personnelDao = RemoteHelper.getInstance().getPersonnelDAO();
        voHelper = new VoHelper();
        poHelper = new PoHelper();
    }

    public ResultMessage addHotel(HotelVO hotelVO){
        try {
            HotelPO hotelPO = poHelper.convert(hotelVO, "new hotel info");

            // TODO: 2016/11/26 返回值问题，返回ResultMessage
            hotelDao.insert(hotelPO);
            return ResultMessage.SUCCESS;
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.CONNECTION_ERROR;
        }
    }

    public ResultMessage deleteHotel(long hotelID) {
        try {
            // TODO: 2016/11/26 返回值问题，返回ResultMessage
            hotelDao.delete(hotelID);
            return ResultMessage.SUCCESS;
        } catch (RemoteException e) {
            e.printStackTrace();
            return ResultMessage.CONNECTION_ERROR;
        }
    }

    public ResultMessage updateHotelInfo(HotelVO hotelVO) {
        try {
            HotelPO originHotelPO = hotelDao.findByHotelID(hotelVO.hotelID);
            HotelPO updatedhotelPO = poHelper.merge(originHotelPO, hotelVO, "update basic hotel info");

            // TODO: 2016/11/26 返回值问题，返回ResultMessage
            hotelDao.update(updatedhotelPO);
            return ResultMessage.SUCCESS;
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
            HotelVO hotelVO = voHelper.create(hotelPO, personnelPO, rating);
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
        return null;
    }

    public ResultMessage deleteRoom(long hotelID, RoomType roomType) {
        return null;
    }

    public ResultMessage updateRoomInfo(RoomVO roomVO) {
        return null;
    }

    public List<RoomVO> findRoomsByHotelID(long hotelID) {
        return null;
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
