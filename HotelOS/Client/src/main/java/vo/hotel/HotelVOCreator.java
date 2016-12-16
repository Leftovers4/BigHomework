package vo.hotel;

import bl.hotelbl.impl.Room;
import bl.hotelbl.impl.RoomList;
import bl.orderbl.impl.OrderList;
import bl.orderbl.impl.OrderTimeRule;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import rmi.RemoteHelper;
import util.RoomType;
import vo.order.OrderVO;
import vo.order.OrderVOCreator;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/25.
 */
public class HotelVOCreator {

    public HotelVO create(HotelPO hotelPO) throws RemoteException {
        HotelVO res = new HotelVO();

        res.hotelID = hotelPO.getHotelID();
        res.hotelName = hotelPO.getHotelName();
        res.star = hotelPO.getStar();
        res.address = hotelPO.getAddress();
        res.tradingArea = hotelPO.getTradingArea();
        res.description = hotelPO.getDescription();
        res.service = hotelPO.getService();
        res.image = RemoteHelper.getInstance().getHotelDAO().getImage(hotelPO.getHotelID());

        return res;
    }

    public List<HotelVO> createAll(List<HotelPO> hotelPOList) throws RemoteException {
        List<HotelVO> res = new ArrayList<>();

        for (int i = 0; i < hotelPOList.size(); i++) {
            res.add(create(hotelPOList.get(i)));
        }

        return res;
    }

    public HotelVO create(HotelPO hotelPO, PersonnelPO personnelPO, List<OrderPO> orderPOList) throws RemoteException {
        HotelVO res = new HotelVO();

        res.hotelID = hotelPO.getHotelID();
        res.hotelName = hotelPO.getHotelName();
        res.star = hotelPO.getStar();
        res.address = hotelPO.getAddress();
        res.tradingArea = hotelPO.getTradingArea();
        res.description = hotelPO.getDescription();
        res.service = hotelPO.getService();
        res.image = RemoteHelper.getInstance().getHotelDAO().getImage(hotelPO.getHotelID());

        if (personnelPO != null){
            res.hotelWorkerID = personnelPO.getPersonnelID();
            res.hotelWorkerName = personnelPO.getName();
        }

        res.rating = new OrderList(orderPOList).filterByHasReview().getHotelRating();

        return res;
    }

    public HotelVO create(HotelPO hotelPO, List<OrderPO> orderPOListForRating, List<OrderPO> orderPOListForOrders, List<RoomPO> roomPOList) throws RemoteException {
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
        res.image = RemoteHelper.getInstance().getHotelDAO().getImage(hotelPO.getHotelID());

        List<OrderVO> orderVOList = new ArrayList<>();
        for (int i = 0; i < orderPOListForOrders.size(); i++) {
            orderVOList.add(new OrderVOCreator().createDetailedOrderVO(orderPOListForOrders.get(i)));
        }
        res.ordersByUserAndHotel = orderVOList;
        res.hasOrdered = !orderVOList.isEmpty();

        List<RoomVO> roomVOList = new ArrayList<>();
        for (int i = 0; i < roomPOList.size(); i++) {
            roomVOList.add(createGeneralRoomVO(roomPOList.get(i)));
        }
        res.rooms = roomVOList;

        return res;
    }

    public RoomVO createGeneralRoomVO(RoomPO roomPO){
        RoomVO res = new RoomVO();

        res.roomID = roomPO.getroomID();
        res.roomType = roomPO.getRoomType();
        res.total = roomPO.getTotal();
        res.available = roomPO.getAvailable();
        res.price = roomPO.getPrice();

        return res;
    }

    public RoomVO createFullRoomVO(RoomPO roomPO, LocalDateTime expectedCheckInTime, LocalDateTime expectedLeaveTime) throws RemoteException {
        RoomVO res = new RoomVO();

        res.roomID = roomPO.getroomID();
        res.roomType = roomPO.getRoomType();
        res.total = roomPO.getTotal();
        res.available = roomPO.getAvailable();
        res.price = roomPO.getPrice();
        res.bookable = new Room(roomPO).getBookableRoomAmount(expectedCheckInTime, expectedLeaveTime);

        return res;
    }

    public List<RoomVO> createAllRoomVO(List<RoomPO> roomPOList) throws RemoteException {
        List<RoomVO> res = new ArrayList<>();

        for (int i = 0; i < roomPOList.size(); i++) {
            res.add(createFullRoomVO(roomPOList.get(i), LocalDateTime.now(), OrderTimeRule.getOfflineLeaveTime(LocalDateTime.now())));
        }

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
