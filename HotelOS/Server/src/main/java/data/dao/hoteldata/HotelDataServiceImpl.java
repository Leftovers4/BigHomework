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
import util.TableName;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        HotelPO hotelPO = apFactory.toHotelPO(hotelInfo, roomInfos, orderInfos);

        return hotelPO;

    }

    @Override
    public ArrayList<HotelPO> findByConditions(HotelPO hotelPO) throws RemoteException {
        // 将hotelpo转换成al
        ArrayList<Object> hotelConditionAl = paFactory.toHotelAl(hotelPO);
        // 将hotelal转换成sql能查询的格式
        ArrayList<Object> hotelToFindAl = ctFactory.adaptToSQL(hotelConditionAl, TableName.hotel);

        // 查询hotel表
        ArrayList<ArrayList<Object>> hotelALs = hotelDataHelper.findByConditionsFromSQL(hotelToFindAl);

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
        ArrayList<Object> hotelInfo = paFactory.toHotelAl(hotelPO);

        // 写入hotelpo
        ResultMessage result = hotelDataHelper.insertToSQL(hotelInfo);

        return result;
    }

    @Override
    public ResultMessage delete(long hotelID) throws RemoteException {
        return hotelDataHelper.deleteFromSQL(hotelID);
    }

    @Override
    public ResultMessage update(HotelPO hotelPO) throws RemoteException {

        // 将po转换成hotel表行
        ArrayList<Object> hotelInfo = paFactory.toHotelAl(hotelPO);

        // 更新hotelpo
        ResultMessage result = hotelDataHelper.updateFromSQL(hotelInfo);

        return result;

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
