package bl.hotelbl.impl;

import bl.hotelbl.HotelBLService;
import bl.orderbl.impl.Order;
import bl.orderbl.impl.OrderData;
import bl.orderbl.impl.OrderList;
import bl.personnelbl.impl.Personnel;
import bl.personnelbl.impl.PersonnelData;
import util.Address;
import util.ResultMessage;
import util.TradingArea;
import vo.hotel.HotelVO;
import vo.hotel.LogicVOHelper;
import vo.hotel.RoomVO;
import vo.order.OrderVOCreator;
import vo.order.ReviewVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class HotelBlServiceImpl implements HotelBLService {

    HotelData hotelData;
    PersonnelData personnelData;
    OrderData orderData;
    LogicVOHelper logicVOHelper;
    OrderVOCreator orderVOCreator;

    public HotelBlServiceImpl() {
        hotelData = new HotelData();
        personnelData = new PersonnelData();
        orderData = new OrderData();
        logicVOHelper = new LogicVOHelper();
        orderVOCreator = new OrderVOCreator();
    }

    @Override
    public ResultMessage addHotel(HotelVO hotelVO) {
        return hotelData.addHotel(hotelVO);
    }

    @Override
    public ResultMessage deleteHotel(long hotelID) {
        return hotelData.deleteHotel(hotelID);
    }

    @Override
    public HotelVO findHotelByID(long hotelID) {
        return null;
    }

    @Override
    public List<HotelVO> findHotelsByConditions(HotelVO hotelVO) {
        return null;
    }

    @Override
    public List<HotelVO> findHotelsByUsername(String username) {
        return null;
    }

    @Override
    public void sortHotels(List<HotelVO> hotelVOs, String key, int mode) {
        HotelList hotelList = new HotelList(hotelVOs);
        hotelList.sort(key, mode);
    }

    @Override
    public ResultMessage addRoom(RoomVO roomVO) {
        return hotelData.addRoom(roomVO);
    }

    @Override
    public ResultMessage deleteRoom(long roomID) {
        return hotelData.deleteRoom(roomID);
    }

    @Override
    public ResultMessage updateRoomInfo(RoomVO roomVO) {
        return hotelData.updateRoomInfo(roomVO);
    }

    @Override
    public List<RoomVO> findRoomsByHotelID(long hotelID) {
        return hotelData.findRoomsByHotelID(hotelID);
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public HotelVO viewBasicHotelInfo(long hotelID) {
        Hotel hotel = hotelData.find(hotelID);
        Personnel personnel = personnelData.findByHotelID(hotelID);
        double rating = orderData.findByHotelID(hotelID).getRating();

        return logicVOHelper.create(hotel, personnel, rating);
    }

    @Override
    public List<ReviewVO> viewHotelReviews(long hotelID) {
        List<ReviewVO> res = new ArrayList<>();
        OrderList orderList = orderData.findByHotelID(hotelID);

        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);

            if (order.hasReview())
                res.add(orderVOCreator.create(order));
        }

        return res;
    }

    @Override
    public ResultMessage updateBasicHotelInfo(long hotelID, String address, String tradingArea, String description, String service) {
        return null;
    }

    @Override
    public ResultMessage updateBasicHotelInfo(HotelVO hotelVO) {
        Hotel hotel = hotelData.find(hotelVO.hotelID);

        hotel.setAddress(hotelVO.address);
        hotel.setTradingArea(hotelVO.tradingArea);
        hotel.setDescription(hotelVO.description);
        hotel.setService(hotelVO.service);

        return hotelData.update(hotel);
    }

}
