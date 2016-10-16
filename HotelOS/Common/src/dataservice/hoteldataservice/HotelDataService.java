package dataservice.hoteldataservice;

import dataservice.DataServiceParent;

import java.rmi.RemoteException;

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
    public void delete(HotelPO hotelPO) throws RemoteException;

    // 更新酒店信息
    public void update(HotelPO hotelPO) throws RemoteException;





}
