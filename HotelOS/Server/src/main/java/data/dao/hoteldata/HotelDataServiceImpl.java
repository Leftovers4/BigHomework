package data.dao.hoteldata;

import data.dao.DataServiceImplParent;
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
import po.order.OrderPO;
import po.order.ReviewPO;
import util.ResultMessage;
import util.TableName;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kevin on 2016/11/16.
 */
public class HotelDataServiceImpl extends DataServiceImplParent implements HotelDataService {

    // 需要调用的DataHelper
    private HotelDataHelper hotelDataHelper;

    private RoomDataHelper roomDataHelper;

    // 构成ReviewPO
    private OrderDataHelper orderDataHelper;

    // 将需要调用的底层类初始化
    public HotelDataServiceImpl() {
        super();
        hotelDataHelper = dhFactory.getHotelDataHelper();
        roomDataHelper = dhFactory.getRoomDataHelper();
        orderDataHelper = new OrderDataHelperImpl();

    }

    @Override
    public HotelPO findByHotelID(long hotelID) throws RemoteException {

        // 根据ID获得构造hotelpo需要用到的三个表的信息
        ArrayList<Object> hotelAL = hotelDataHelper.findByIdFromSQL(hotelID);
        // 构造hotelAL的迭代器
        Iterator<Object> hotelInfo = ctFactory.alToItr(hotelAL);
        // 将hotelInfo转换成po
        HotelPO hotelPO = apFactory.toHotelPO(hotelInfo);

        // 根据hotelID获取roomPOs，reviewPOs
        ArrayList<RoomPO> roomPOs = findRoomsByHotelID(hotelID);
        ArrayList<ReviewPO> reviewPOs = new ArrayList<>();
//        ArrayList<OrderPO> orderPOs =


//        ArrayList<ArrayList<Object>> roomALs = roomDataHelper.findRoomsByHotelIdFromSQL(hotelID);
//        ArrayList<ArrayList<Object>> orderALs = orderDataHelper.findByHotelIDFromSQL(hotelID);
//
//        // 将三个表的信息整理成Iterator
//
//        Iterator<Iterator<Object>> roomInfos = ctFactory.alsToItrs(roomALs);
//        Iterator<Iterator<Object>> orderInfos = ctFactory.alsToItrs(orderALs);
//
//        // 将hotelInfo转换成po
//        HotelPO hotelPO = apFactory.toHotelPO(hotelInfo, roomInfos, orderInfos);

        return hotelPO;

    }

//    @Override
//    public ArrayList<HotelPO> findByConditions(HotelPO hotelPO) throws RemoteException {
//        // 将hotelpo转换成al
//        ArrayList<Object> hotelConditionAl = paFactory.toHotelAl(hotelPO);
//        // 将hotelal转换成sql能查询的格式
//        ArrayList<Object> hotelToFindAl = ctFactory.adaptToSQL(hotelConditionAl, TableName.hotel);
//
//        // 查询hotel表
//        ArrayList<ArrayList<Object>> hotelALs = hotelDataHelper.findByConditionsFromSQL(hotelToFindAl);
//
//        // 将获取的hotel表行转换成Iterator
//        Iterator<Iterator<Object>> hotelInfos = ctFactory.alsToItrs(hotelALs);
//
//        // 将每个hotelInfo中的hotelID取出，并生成HotelPO，加到hotelPOs里面去
//        ArrayList<HotelPO> hotelPOs = new ArrayList<>();
//        while(hotelInfos.hasNext()){
//            long hotelID = getIDFromHotelInfo(hotelInfos.next());
//            hotelPOs.add(findByHotelID(hotelID));
//        }
//
//        return hotelPOs;
//    }

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

        // 调用findAllRooms
        ArrayList<RoomPO> roomPOs = findAllRooms();

        // 根据hotelID取出rooms
        ArrayList<RoomPO> result = new ArrayList<>();

        for (RoomPO each : roomPOs) {
            if(each.gethotelID() == hotelID){
                result.add(each);
            }
        }

        return result;

    }

    @Override
    public ResultMessage insertRoom(RoomPO roomPO) throws RemoteException {
        // 将roomPO转换成roomAL
        ArrayList<Object> roomAL = paFactory.toRoomAl(roomPO);

        // 将roomAL存到room表中
        return roomDataHelper.insertToSQL(roomAL);

    }

    @Override
    public ResultMessage deleteRoom(long roomID) throws RemoteException {
        return roomDataHelper.deleteFromSQL(roomID);
    }

    @Override
    public ResultMessage updateRoom(RoomPO roomPO) throws RemoteException {
        // 将roomPO转换成roomAL
        ArrayList<Object> roomAL = paFactory.toRoomAl(roomPO);

        // 在room表中更新
        return roomDataHelper.updateFromSQL(roomAL);

    }

    @Override
    //TODO
    public byte[] getImage(long hotelID) throws RemoteException {
        return new byte[0];
    }

    @Override
    //TODO
    public ResultMessage setImage(long hotelID, byte[] image) throws RemoteException {
        return null;
    }


    /*--------------------------------------------辅助类---------------------------------------------------*/


    /**
     * 在room表中查找所有的roomALs，并转换成po
     * @return
     */
    private ArrayList<RoomPO> findAllRooms(){

        // 在room表中取出所有的roomALs
        ArrayList<ArrayList<Object>> roomALs = roomDataHelper.findFromSQL();

        // 将获取的hotel表行转换成Iterator
        Iterator<Iterator<Object>> roomInfos = ctFactory.alsToItrs(roomALs);

        // 将roomInfos中每一个roomInfo转换成po存到roomPOs中
        ArrayList<RoomPO> roomPOs = new ArrayList<>();
        while(roomInfos.hasNext()){
            roomPOs.add(apFactory.toRoomPO(roomInfos.next()));
        }

        return roomPOs;
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

    /**
     * 从room表中取出的roomInfo获取roomID
     * @param roomInfo
     * @return
     */
    private long getIDFromRoomInfo(Iterator<Object> roomInfo){
        long roomID = (long) roomInfo.next();
        return roomID;
    }



}
