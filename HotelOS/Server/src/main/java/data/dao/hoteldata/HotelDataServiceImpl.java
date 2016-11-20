package data.dao.hoteldata;

import dataservice.hoteldataservice.HotelDataService;
import po.hotel.HotelPO;
import po.hotel.RoomPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class HotelDataServiceImpl implements HotelDataService {



    @Override
    public HotelPO findByHotelID(long hotelID) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<HotelPO> findByHotelPO(HotelPO hotelPO) throws RemoteException {
        return null;
    }

    @Override
    public void insert(HotelPO hotelPO) throws RemoteException {

    }

    @Override
    public void delete(long hotelID) throws RemoteException {

    }

    @Override
    public void update(HotelPO hotelPO) throws RemoteException {

    }

    @Override
    public ArrayList<RoomPO> findRooms(long hotelID) throws RemoteException {
        return null;
    }

    @Override
    public double getRating() throws RemoteException {
        return 0;
    }
}
