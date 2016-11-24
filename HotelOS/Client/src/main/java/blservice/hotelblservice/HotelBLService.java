package blservice.hotelblservice;
import util.*;
import vo.hotel.HotelVO;
import vo.hotel.RoomVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 2016/10/15.
 */
public interface HotelBLService {

    /**
     * 添加新的酒店
     *
     * @param hotelVO 酒店信息
     * @return SUCCESS或者FAIL，FAIL表示已存在相同的酒店
     */
    public ResultMessage addHotel(HotelVO hotelVO);

    /**
     * 删除已有的酒店
     *
     * @param hotelID 要被删除的酒店的id
     * @return SUCCESS或者FAIL，FAIL表示不存在该酒店
     */
    public ResultMessage deleteHotel(long hotelID);

    /**
     * 更新酒店的基本信息
     *
     * @param hotelVO 酒店信息
     * @return SUCCESS或者FAIL，FAIL表示不存在该酒店
     */
    public ResultMessage updateHotelInfo(HotelVO hotelVO);

    /**
     * 根据酒店id查找酒店
     *
     * @param hotelID 酒店的id
     * @return 酒店的详细信息
     */
    public HotelVO findHotelByID(long hotelID);

    /**
     * 根据筛选条件显示酒店列表，需要先明确地址和商圈
     *
     * @param hotelVO 筛选条件，地址和商圈不能为空
     * @return 符合筛选条件的所有酒店的列表
     */
    public List<HotelVO> findHotelsByConditions(HotelVO hotelVO);

    /**
     * 用户查看自己预订过的酒店
     *
     * @param username 用户名
     * @return 用户名对应的用户预定过的所有酒店的列表
     */
    public List<HotelVO> findHotelsByUsername(String username);

    /**
     * 根据选择的关键字对酒店列表进行排序，有升序和降序两种排序，
     * 注意该方法不会返回一个新的列表，而是对原来的列表的酒店进行排序
     *
     * @param hotelVOs 要进行排序的酒店
     * @param key      关键字，有价格，星级，评分，价格为“price”，星级为“star”，评分为“rating”
     * @param mode     排序模式，有升序和降序，升序为0，降序为1
     */
    public void sortHotels(List<HotelVO> hotelVOs, String key, int mode);

    /**
     * 添加新的房间类型
     *
     * @param roomVO 新房间类型的信息
     * @return SUCCESS或者FAIL，FAIL表示已存在该房间类型
     */
    public ResultMessage addRoom(RoomVO roomVO);

    /**
     * 删除已有的房间类型
     *
     * @param roomType 房间类型，包括单人房和双人房
     * @return SUCCESS或者FAIL，FAIL表示不存在该房间类型
     */
    public ResultMessage deleteRoom(RoomType roomType);

    /**
     * 更新已有房间类型的信息
     *
     * @param roomVO 房间类型信息
     * @return SUCCESS或者FAIL，FAIL表示不存在该房间类型
     */
    public ResultMessage updateRoomInfo(RoomVO roomVO);

    /**
     * 根据酒店的id查找该酒店的所有房间类型信息
     *
     * @param hotelID 酒店的id
     * @return SUCCESS或者FAIL，FAIL表示不存在该酒店
     */
    public List<RoomVO> findRoomsByHotelID(long hotelID);

}
