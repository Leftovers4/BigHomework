package hoteldata;

import dataservice.hoteldataservice.HotelDataService;
import po.hotel.HotelPO;
import po.hotel.RoomPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class HotelDataServiceImpl implements HotelDataService {
    public void initial() throws RemoteException {

    }

    public void finish() throws RemoteException {

    }

    public HotelPO findByHotelID(long hotelID) throws RemoteException {
        return null;
    }

    public ArrayList<HotelPO> findByHotelPO(HotelPO hotelPO) throws RemoteException {
        return null;
    }

    public void insert(HotelPO hotelPO) throws RemoteException {

    }

    public void delete(HotelPO hotelPO) throws RemoteException {

    }

    public void update(HotelPO hotelPO) throws RemoteException {

    }

    public ArrayList<RoomPO> findRooms(long hotelID) throws RemoteException {
        return null;
    }

    public double getRating() throws RemoteException{
        return 0;
    }
}
