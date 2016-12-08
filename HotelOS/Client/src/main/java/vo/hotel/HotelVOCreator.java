package vo.hotel;

import bl.hotelbl.impl.RoomList;
import bl.orderbl.impl.OrderList;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import util.RoomType;
import vo.order.OrderVO;
import vo.order.OrderVOCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/25.
 */
public class HotelVOCreator {

    public HotelVO create(HotelPO hotelPO, PersonnelPO personnelPO, List<OrderPO> orderPOList) {
        HotelVO res = new HotelVO();

        res.hotelID = hotelPO.getHotelID();
        res.hotelName = hotelPO.getHotelName();
        res.star = hotelPO.getStar();
        res.address = hotelPO.getAddress();
        res.tradingArea = hotelPO.getTradingArea();
        res.description = hotelPO.getDescription();
        res.service = hotelPO.getService();

        res.hotelWorkerID = personnelPO.getPersonnelID();
        res.hotelWorkerName = personnelPO.getName();

        res.rating = new OrderList(orderPOList).filterByHasReview().getHotelRating();

        return res;
    }

    //todo 获取可用房间
    public HotelVO create(HotelPO hotelPO, List<OrderPO> orderPOListForRating, List<OrderPO> orderPOListForOrders, List<RoomPO> roomPOList){
        HotelVO res = new HotelVO();

        res.hotelID = hotelPO.getHotelID();
        res.hotelName = hotelPO.getHotelName();
        res.star = hotelPO.getStar();
        res.address = hotelPO.getAddress();
        res.tradingArea = hotelPO.getTradingArea();
        res.description = hotelPO.getDescription();
        res.service = hotelPO.getService();
        res.price = new RoomList(roomPOList).getHotelPrice();
        res.rating = new OrderList(orderPOListForRating).filterByHasReview().getHotelRating();

        List<OrderVO> orderVOList = new ArrayList<>();
        for (int i = 0; i < orderPOListForOrders.size(); i++) {
            orderVOList.add(new OrderVOCreator().createDetailedOrderVO(orderPOListForOrders.get(i)));
        }
        res.ordersByUserAndHotel = orderVOList;

        List<RoomVO> roomVOList = new ArrayList<>();
        for (int i = 0; i < roomPOList.size(); i++) {
            roomVOList.add(create(roomPOList.get(i)));
        }
        res.rooms = roomVOList;

        return res;
    }

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
