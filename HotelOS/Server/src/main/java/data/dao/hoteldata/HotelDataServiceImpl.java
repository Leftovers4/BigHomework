package data.dao.hoteldata;

import data.dao._poalfactory.Al2Po_Factory;
import data.dao._poalfactory.CommonTransferFactory;
import data.dao._poalfactory.Po2Al_Factory;
import data.dao._poalfactory.impl.Al2Po_FactoryImpl;
import data.dao._poalfactory.impl.CommonTransferFactoryImpl;
import data.dao._poalfactory.impl.Po2Al_FactoryImpl;
import data.datahelper.hoteldatahelper.HotelDataHelper;
import data.datahelper.hoteldatahelper.HotelDataHelperImpl;
import data.datahelper.hoteldatahelper.RoomDataHelper;
import data.datahelper.hoteldatahelper.RoomDataHelperImpl;
import data.datahelper.orderdatahelper.OrderDataHelper;
import data.datahelper.orderdatahelper.OrderDataHelperImpl;
import dataservice.hoteldataservice.HotelDataService;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kevin on 2016/11/16.
 */
public class HotelDataServiceImpl implements HotelDataService {


    @Override
    public HotelPO findByHotelID(long hotelID) throws RemoteException {
        // 获取构造hotelpo的三个表行
        HotelDataHelper hotelDataHelper = new HotelDataHelperImpl();
        RoomDataHelper roomDataHelper = new RoomDataHelperImpl();
        OrderDataHelper orderDataHelper = new OrderDataHelperImpl();

        ArrayList<Object> hotelAL = hotelDataHelper.findByIdFromSQL(hotelID);
        ArrayList<ArrayList<Object>> roomALs = roomDataHelper.findRoomsByHotelIdFromSQL(hotelID);
        ArrayList<ArrayList<Object>> orderALs = orderDataHelper.findByHotelIDFromSQL(hotelID);

        // 将三个表行整理成Iterator
        CommonTransferFactory ctFactory = new CommonTransferFactoryImpl();
        Iterator<Object> hotelInfo = ctFactory.alToItr(hotelAL);
        Iterator<Iterator<Object>> roomInfos = ctFactory.alsToItrs(roomALs);
        Iterator<Iterator<Object>> orderInfos = ctFactory.alsToItrs(orderALs);

        // 将hotelInfo转换成po
        Al2Po_Factory factory = new Al2Po_FactoryImpl();
        HotelPO hotelPO = factory.toHotelPO(hotelInfo, roomInfos, orderInfos);

        return hotelPO;

    }

    @Override
    public ArrayList<HotelPO> findByConditions(HotelPO hotelPO) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<HotelPO> findAll() throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage insert(HotelPO hotelPO) throws RemoteException {

        // 将po转换成hotel表行
        Po2Al_Factory factory = new Po2Al_FactoryImpl();
        ArrayList<Object> hotelInfo = factory.toHotelAl(hotelPO);

        // 写入hotelpo
        HotelDataHelper hotelDataHelper = new HotelDataHelperImpl();
        ResultMessage result = hotelDataHelper.insertToSQL(hotelInfo);

        return result;
    }

    @Override
    public ResultMessage delete(long hotelID) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage update(HotelPO hotelPO) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<RoomPO> findRoomsByHotelID(long hotelID) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage insertRoom(RoomPO roomPO) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage deleteRoom(long roomID) throws RemoteException {
        return null;
    }

    @Override
    public byte[] getImage(long hotelID) throws RemoteException {
        return new byte[0];
    }

    @Override
    public ResultMessage setImage(long hotelID, byte[] image) throws RemoteException {
        return null;
    }
}
