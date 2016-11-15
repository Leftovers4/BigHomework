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
    public void initial() throws RemoteException {

    }

    @Override
    public void finish() throws RemoteException {

    }

    @Override
    public HotelPO findByHotelID(long hotelID) throws RemoteException {
        return new HotelPO("如家", Address.NANJING, TradingArea.XIANLIN_CENTER, "好", "Wifi", null);
    }

    @Override
    public ArrayList<HotelPO> findByHotelPO(HotelPO hotelPO) throws RemoteException {
        ArrayList<HotelPO> list = new ArrayList<>();
        list.add(new HotelPO("如家", Address.NANJING, TradingArea.XIANLIN_CENTER, "好", "Wifi", null));
        return list;
    }

    @Override
    public void insert(HotelPO hotelPO) throws RemoteException {

    }

    @Override
    public void delete(HotelPO hotelPO) throws RemoteException {

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
