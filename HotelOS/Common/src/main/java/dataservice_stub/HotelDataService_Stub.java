package dataservice_stub;

import dataservice.hoteldataservice.HotelDataService;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import util.Address;
import util.TradingArea;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class HotelDataService_Stub implements HotelDataService {


    @Override
    public HotelPO findByHotelID(long hotelID) throws RemoteException {
        return new HotelPO(0,"如家", 3, "Nanjing", "Xianli_Center", "好", "Wifi", null, null);
    }

    @Override
    public ArrayList<HotelPO> findByHotelPO(HotelPO hotelPO) throws RemoteException {
        ArrayList<HotelPO> list = new ArrayList<>();
        list.add(new HotelPO(0,"如家", 3, "Nanjing", "Xianli_Center", "好", "Wifi", null, null));
        return list;
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
    public ArrayList<RoomPO> findRooms(long HotelID) throws RemoteException {
        return null;
    }

    @Override
    public double getRating() {
        return 0;
    }
}
