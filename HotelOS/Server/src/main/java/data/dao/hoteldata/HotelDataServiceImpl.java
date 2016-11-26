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

    // 实现需要调用的底层类
    private HotelDataHelper hotelDataHelper;

    private RoomDataHelper roomDataHelper;

    private OrderDataHelper orderDataHelper;

    private CommonTransferFactory ctFactory;

    private Al2Po_Factory apFactory;

    private Po2Al_Factory paFactory;

    // 持有的对象
    private HotelPO hotelPO;



    // 将需要调用的底层类初始化
    public HotelDataServiceImpl() {
        hotelDataHelper = new HotelDataHelperImpl();
        roomDataHelper = new RoomDataHelperImpl();
        orderDataHelper = new OrderDataHelperImpl();
        ctFactory = new CommonTransferFactoryImpl();
        apFactory = new Al2Po_FactoryImpl();
        paFactory = new Po2Al_FactoryImpl();
    }

    @Override
    public HotelPO findByHotelID(long hotelID) throws RemoteException {

        // 根据ID获得构造hotelpo需要用到的三个表的信息
        ArrayList<Object> hotelAL = hotelDataHelper.findByIdFromSQL(hotelID);
        ArrayList<ArrayList<Object>> roomALs = roomDataHelper.findRoomsByHotelIdFromSQL(hotelID);
        ArrayList<ArrayList<Object>> orderALs = orderDataHelper.findByHotelIDFromSQL(hotelID);

        // 将三个表的信息整理成Iterator
        Iterator<Object> hotelInfo = ctFactory.alToItr(hotelAL);
        Iterator<Iterator<Object>> roomInfos = ctFactory.alsToItrs(roomALs);
        Iterator<Iterator<Object>> orderInfos = ctFactory.alsToItrs(orderALs);

        // 将hotelInfo转换成po
        hotelPO = apFactory.toHotelPO(hotelInfo, roomInfos, orderInfos);

        return hotelPO;

    }

    @Override
    public ArrayList<HotelPO> findByConditions(HotelPO hotelPO) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<HotelPO> findAll() throws RemoteException {

        // 获取到所有的hotel表行
        ArrayList<ArrayList<Object>> hotelALs = hotelDataHelper.findFromSQL();

        // 将获取的hotel表行转换成Iterator
        Iterator<Iterator<Object>> hotelInfos = ctFactory.alsToItrs(hotelALs);

        // 将每个hotelInfo中的hotelID取出，并生成HotelPO，加到hotelPOs里面去
        ArrayList<HotelPO> hotelPOs = new ArrayList<>();
        while(hotelInfos.hasNext()){
            long hotelID = getIDFromHotelInfo(hotelInfos.next());
            hotelPOs.add(findByHotelID(hotelID));
        }

        return hotelPOs;


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

    /**
     * 从hotel表中取出的hotelInfo获取hotelID
     * @param hotelInfo
     * @return
     */
    private long getIDFromHotelInfo(Iterator<Object> hotelInfo){
        long hotelID = (long) hotelInfo.next();
        return hotelID;
    }

}
