package dataservice.hoteldataservice;

import dataservice.DataServiceParent;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public interface HotelDataService extends Remote{

    // 增加酒店
    public ResultMessage insert(HotelPO hotelPO) throws RemoteException;

    // 删除酒店
    public ResultMessage delete(long hotelID) throws RemoteException;

    // 更新酒店信息
    public ResultMessage update(HotelPO hotelPO) throws RemoteException;

    // 查找酒店列表
    public ArrayList<HotelPO> findAll() throws RemoteException;

    // 根据酒店ID查找酒店
    public HotelPO findByHotelID(long hotelID) throws RemoteException;


    // 增加房间
    public ResultMessage insertRoom(RoomPO roomPO) throws RemoteException;

    // 删除房间
    public ResultMessage deleteRoom(long roomID) throws RemoteException;

    // 更新房间信息
    public ResultMessage updateRoom(RoomPO roomPO) throws RemoteException;

    // 根据酒店获取房间类型及数量
    public ArrayList<RoomPO> findRoomsByHotelID(long hotelID) throws RemoteException;

    // 根据房间ID查找房间
    public RoomPO findRoomByID(long roomID) throws RemoteException;

    // 获得酒店图片，以二进制字符串传输
    public byte[] getImage(long hotelID) throws RemoteException;

    // 修改酒店图片，以二进制字符串传输
    public ResultMessage setImage(long hotelID, byte[] image) throws RemoteException;


}
