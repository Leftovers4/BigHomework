package vo.hotel;

import bl.hotelbl.impl.Hotel;
import bl.personnelbl.impl.Personnel;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.personnel.PersonnelPO;
import util.RoomType;

/**
 * Created by kevin on 2016/11/25.
 */
public class LogicVOHelper {

    /**
     * 传给界面：创建包含酒店工作人员查看酒店基本信息的界面信息的vo
     *
     * @param hotel     包含数据库中取出的hotelPO的信息
     * @param personnel 包含数据库中取出的personnelPO的信息
     * @param rating      评分
     * @return 包含酒店工作人员查看酒店基本信息的界面信息的vo
     */
    public HotelVO create(Hotel hotel, Personnel personnel, double rating) {
        HotelVO res = new HotelVO();

        res.hotelID = hotel.getHotelID();
        res.hotelName = hotel.getHotelName();
        res.star = hotel.getStar();
        res.address = hotel.getAddress();
        res.tradingArea = hotel.getTradingArea();
        res.description = hotel.getDescription();
        res.service = hotel.getService();

        res.hotelWorkerID = personnel.getPersonnelID();
        res.hotelWorkerName = personnel.getName();

        res.rating = rating;

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
     * stub用构造器，别使用
     */
    public HotelVO create(long hotelID, String hotelName, String hotelWorkerName, int star,
                          double rating, String address, String tradingArea, String description, String service){
        HotelVO res = new HotelVO();

        res.hotelID = hotelID;
        res.hotelName = hotelName;
        res.hotelWorkerName = hotelWorkerName;
        res.star = star;
        res.rating = rating;
        res.address = address;
        res.tradingArea = tradingArea;
        res.description = description;
        res.service = service;

        return res;
    }

    /*
     * stub用构造器，别使用
     */
    public RoomVO create(long roomID, RoomType roomType, int total, double price){
        RoomVO res = new RoomVO();

        res.roomID = roomID;
        res.roomType = roomType;
        res.total = total;
        res.price = price;

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
