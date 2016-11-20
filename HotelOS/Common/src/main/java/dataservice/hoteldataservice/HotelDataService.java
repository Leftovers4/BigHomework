package dataservice.hoteldataservice;

import dataservice.DataServiceParent;
import po.hotel.HotelPO;
import po.hotel.RoomPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public interface HotelDataService extends DataServiceParent {

    // 根据酒店ID查找酒店
    public HotelPO findByHotelID(long hotelID) throws RemoteException;

    // 根据筛选条件显示酒店列表
    public ArrayList<HotelPO> findByHotelPO(HotelPO hotelPO) throws RemoteException;

    // 增加酒店
    public void insert(HotelPO hotelPO) throws RemoteException;

    // 删除酒店
    public void delete(long hotelID) throws RemoteException;

    // 更新酒店信息
    public void update(HotelPO hotelPO) throws RemoteException;

    // 获取房间类型及数量
    public ArrayList<RoomPO> findRooms(long hotelID) throws RemoteException;

    // 获得酒店平均评分
    public double getRating() throws RemoteException;

}
