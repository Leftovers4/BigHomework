package bl.hotelbl;
import bl.hotelbl.impl.HotelList;
import util.*;
import vo.hotel.HotelConditionsVO;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;
import vo.order.ReviewVO;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Hiki on 2016/10/15.
 */
public interface HotelBLService {

    /**
     * 添加新的酒店
     *
     * @param hotelVO 酒店信息
     * @return 新添加的酒店的ID
     * @throws RemoteException 连接服务器异常
     */
    long addHotel(HotelVO hotelVO) throws RemoteException;

    /**
     * 删除已有的酒店
     *
     * @param hotelID 要被删除的酒店的ID
     * @return 数据库返回的result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage deleteHotel(long hotelID) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * 获取酒店的基本信息
     *
     * @param hotelID 酒店的id
     * @return 返回酒店的基本信息 ，可能为空
     * @throws RemoteException 连接服务器异常
     */
    HotelVO viewBasicHotelInfo(long hotelID) throws RemoteException;

    /**
     * 更新酒店的基本信息
     *
     * @param hotelVO the hotel vo
     * @return SUCCESS或者FAIL ，FAIL表示不存在该酒店
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage updateBasicHotelInfo(HotelVO hotelVO) throws RemoteException;

    /**
     * 查看酒店的所有房间类型信息
     *
     * @param hotelID 酒店的id
     * @return 对应的酒店的所有房间类型信息 ，返回的有可能是空表
     * @throws RemoteException 连接服务器异常
     */
    List<RoomVO> viewAllHotelRooms(long hotelID) throws RemoteException;

    /**
     * 添加新的房间类型
     *
     * @param roomVO 新房间类型的信息
     * @return SUCCESS或者HasExist result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage addRoom(RoomVO roomVO) throws RemoteException;

    /**
     * 删除已有的房间类型
     *
     * @param roomID 房间类型id，房间类型的唯一标识
     * @return SUCCESS或者FAIL ，FAIL表示不存在该房间类型
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage deleteRoom(long roomID) throws RemoteException;

    /**
     * 更新已有房间类型的信息
     *
     * @param roomVO 房间类型信息
     * @return SUCCESS或者FAIL ，FAIL表示不存在该房间类型
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage updateRoomInfo(RoomVO roomVO) throws RemoteException;

    /**
     * 查看完整的房间类型信息
     *
     * @param roomID              房间类型ID
     * @param expectedCheckInTime 入住时间
     * @param expectedLeaveTime   离开时间
     * @return 完整的房间类型信息
     * @throws RemoteException 连接服务器异常
     */
    RoomVO viewFullRoomInfo(long roomID, LocalDateTime expectedCheckInTime, LocalDateTime expectedLeaveTime) throws RemoteException;

    /**
     * Offline check in result message.
     *
     * @param roomID the room id
     * @param amount the amount
     * @return the result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage offlineCheckIn(long roomID, int amount) throws RemoteException;

    /**
     * Offline check out result message.
     *
     * @param roomID the room id
     * @param amount the amount
     * @return the result message
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage offlineCheckOut(long roomID, int amount) throws RemoteException;

    /**
     * View offline check in room amount int.
     *
     * @param hotelID the hotel id
     * @return the int
     * @throws RemoteException 连接服务器异常
     */
    int viewOfflineCheckInRoomAmount(long hotelID) throws RemoteException;

    /**
     * Sets hotel image.
     *
     * @param hotelID the hotel id
     * @param image   the image
     * @return the hotel image
     * @throws RemoteException 连接服务器异常
     */
    ResultMessage setHotelImage(long hotelID, byte[] image) throws RemoteException;

    /**
     * Gets hotel min room num.
     *
     * @param hotelID the hotel id
     * @return the hotel min room num
     * @throws RemoteException 连接服务器异常
     */
    int getHotelMinRoomNum(long hotelID) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * 根据选择的关键字对酒店列表进行排序，有升序和降序两种排序，方法会返回一个新的列表
     *
     * @param hotelVOs 要进行排序的酒店
     * @param key      关键字，有价格，星级，评分，价格为“price”，星级为“star”，评分为“rating”
     * @param mode     排序模式，有升序和降序，升序为0，降序为1
     * @return 经过排序的酒店
     */
    List<HotelVO> sortHotels(List<HotelVO> hotelVOs, String key, int mode);

    /**
     * 客户根据筛选条件搜索酒店，需要先明确地址和商圈
     *
     * @param username          the username
     * @param hotelConditionsVO the hotel conditions vo
     * @return 符合筛选条件的所有酒店的列表 list
     * @throws RemoteException 连接服务器异常
     */
    List<HotelVO> searchHotelsByConditions(String username, HotelConditionsVO hotelConditionsVO) throws RemoteException;

    /**
     * 用户查看自己预订过的酒店
     *
     * @param username 用户名
     * @return 用户名对应的用户预定过的所有酒店的列表 list
     * @throws RemoteException 连接服务器异常
     */
    List<HotelVO> viewOrderedHotelList(String username) throws RemoteException;

    /**
     * 获取酒店的详细信息
     *
     * @param hotelID  酒店ID
     * @param username 用户名
     * @return 酒店的详细信息
     * @throws RemoteException 连接服务异常
     */
    HotelVO viewDetailedHotelInfo(long hotelID, String username) throws RemoteException;

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * 获取全部酒店
     *
     * @return 全部酒店
     * @throws RemoteException 连接服务器异常
     */
    List<HotelVO> viewFullHotelList() throws RemoteException;

}
