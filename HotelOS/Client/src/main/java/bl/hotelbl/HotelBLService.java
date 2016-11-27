package bl.hotelbl;
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
    ResultMessage addHotel(HotelVO hotelVO);

    /**
     * 删除已有的酒店
     *
     * @param hotelID 要被删除的酒店的id
     * @return SUCCESS或者FAIL，FAIL表示不存在该酒店
     */
    ResultMessage deleteHotel(long hotelID);

    /**
     * 酒店工作人员查看酒店的基本信息
     *
     * @param hotelID 酒店的id
     * @return SUCCESS或者FAIL，FAIL表示不存在该酒店
     */
    HotelVO getBasicHotelInfo(long hotelID);

    /**
     * 酒店工作人员更新酒店的基本信息
     *
     * @param hotelVO 酒店信息
     * @return SUCCESS或者FAIL，FAIL表示不存在该酒店
     */
    ResultMessage updateBasicHotelInfo(HotelVO hotelVO);

    /**
     * 根据酒店id查找酒店
     *
     * @param hotelID 酒店的id
     * @return 酒店的详细信息
     * @deprecated
     */
    HotelVO findHotelByID(long hotelID);

    /**
     * 客户根据筛选条件搜索酒店，需要先明确地址和商圈
     *
     * @param hotelVO 筛选条件，地址和商圈不能为空
     * @return 符合筛选条件的所有酒店的列表
     */
    List<HotelVO> findHotelsByConditions(HotelVO hotelVO);

    /**
     * 用户查看自己预订过的酒店
     *
     * @param username 用户名
     * @return 用户名对应的用户预定过的所有酒店的列表
     */
    List<HotelVO> findHotelsByUsername(String username);

    /**
     * 根据选择的关键字对酒店列表进行排序，有升序和降序两种排序，
     * 注意该方法不会返回一个新的列表，而是对原来的列表的酒店进行排序
     *
     * @param hotelVOs 要进行排序的酒店
     * @param key      关键字，有价格，星级，评分，价格为“price”，星级为“star”，评分为“rating”
     * @param mode     排序模式，有升序和降序，升序为0，降序为1
     */
    void sortHotels(List<HotelVO> hotelVOs, String key, int mode);

    /**
     * 添加新的房间类型
     *
     * @param roomVO 新房间类型的信息
     * @return SUCCESS或者FAIL，FAIL表示已存在该房间类型
     */
    ResultMessage addRoom(RoomVO roomVO);

    /**
     * 删除已有的房间类型
     *
     * @param roomID 房间类型id，房间类型的唯一标识
     * @return SUCCESS或者FAIL，FAIL表示不存在该房间类型
     */
    ResultMessage deleteRoom(long roomID);

    /**
     * 更新已有房间类型的信息
     *
     * @param roomVO 房间类型信息
     * @return SUCCESS或者FAIL，FAIL表示不存在该房间类型
     */
    ResultMessage updateRoomInfo(RoomVO roomVO);

    /**
     * 查看酒店的所有房间类型信息
     *
     * @param hotelID 酒店的id
     * @return 对应的酒店的所有房间类型信息
     */
    List<RoomVO> findRoomsByHotelID(long hotelID);

}
