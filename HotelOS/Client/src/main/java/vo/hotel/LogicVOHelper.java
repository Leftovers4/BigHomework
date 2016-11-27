package vo.hotel;

import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.personnel.PersonnelPO;

/**
 * Created by kevin on 2016/11/25.
 */
public class LogicVOHelper {

    /**
     * 传给界面：创建包含酒店工作人员查看酒店基本信息的界面信息的vo
     *
     * @param hotelPO     数据库中取出的hotelPO
     * @param personnelPO 数据库中取出的personnelPO
     * @param rating      评分
     * @return 包含酒店工作人员查看酒店基本信息的界面信息的vo
     */
    public HotelVO create(HotelPO hotelPO, PersonnelPO personnelPO, double rating) {
        HotelVO res = new HotelVO();

        res.hotelID = hotelPO.getHotelID();
        res.hotelName = hotelPO.getHotelName();
        res.hotelWorkerName = personnelPO.getName();
        res.star = hotelPO.getStar();
        res.rating = rating;
        res.address = hotelPO.getAddress();
        res.tradingArea = hotelPO.getTradingArea();
        res.description = hotelPO.getDescription();
        res.service = hotelPO.getService();

        return res;
    }

    /**
     * 传给界面：创建包含酒店工作人员查看可用客房界面信息的vo
     *
     * @param roomPO 酒店工作人员查看可用客房界面信息
     * @return 包含酒店工作人员查看可用客房界面信息的vo
     */
    public RoomVO create(RoomPO roomPO){
        RoomVO res = new RoomVO();

        res.roomID = roomPO.getroomID();
        res.roomType = roomPO.getRoomType();
        res.total = roomPO.getTotal();
        res.price = roomPO.getPrice();

        return res;
    }

    /*
     * 排序测试用构造器，别使用
     */
    public HotelVO create(int star, double price, double rating) {
        HotelVO res = new HotelVO();

        res.star = star;
        res.price = price;
        res.rating = rating;

        return res;
    }

}
