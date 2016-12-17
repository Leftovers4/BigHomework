package bl.hotelbl.impl;

import bl.orderbl.impl.OrderList;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import rmi.RemoteHelper;
import util.RoomType;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class HotelList extends ArrayList<HotelPO> {

    public HotelList(List<HotelPO> hotelPOList) {
        for (int i = 0; i < hotelPOList.size(); i++) {
            this.add(hotelPOList.get(i));
        }
    }

    public HotelList filterByHasRoom(LocalDateTime beginTime, LocalDateTime endTime, List<RoomType> roomTypeList) throws RemoteException {
        HotelList res = new HotelList(new ArrayList<>());

        for (HotelPO hotelPO : this) {
            List<RoomPO> roomPOList = RemoteHelper.getInstance().getHotelDAO().findRoomsByHotelID(hotelPO.getHotelID());

            if (roomTypeList.get(0).equals(RoomType.All)){
                for (int i = 0; i < roomPOList.size(); i++) {
                    if (new Room(roomPOList.get(i)).getBookableRoomAmount(beginTime, endTime) > 0){
                        res.add(hotelPO);
                        break;
                    }
                }
            }else {
                for (int i = 0; i < roomTypeList.size(); i++) {
                    RoomPO roomPO = new RoomList(roomPOList).filterByRoomType(roomTypeList.get(i));

                    //房间类型不存在的情况
                    if (roomPO == null)
                        continue;

                    //房间类型存在的情况
                    if (new Room(roomPO).getBookableRoomAmount(beginTime, endTime) > 0){
                        res.add(hotelPO);
                        break;
                    }
                }
            }

            return res;
        }

        return res;
    }

    public HotelList filterByHasOrdered(String username) throws RemoteException {
        HotelList res = new HotelList(new ArrayList<>());

        List<OrderPO> orderPOList = RemoteHelper.getInstance().getOrderDAO().findByUsername(username);
        for (HotelPO hotelPO : this) {
            for (int i = 0; i < orderPOList.size(); i++) {
                if (hotelPO.getHotelID() == orderPOList.get(i).getHotelID()) {
                    res.add(hotelPO);
                    break;
                }
            }
        }

        return res;
    }

    public HotelList filterByAddress(String address) {
        HotelList res = new HotelList(new ArrayList<>());

        for (HotelPO hotelPO : this) {
            if (hotelPO.getAddress().equals(address)) {
                res.add(hotelPO);
            }
        }

        return res;
    }

    public HotelList filterByTradingArea(String tradingArea) {
        HotelList res = new HotelList(new ArrayList<>());

        for (HotelPO hotelPO : this) {
            if (hotelPO.getTradingArea().equals(tradingArea)) {
                res.add(hotelPO);
            }
        }

        return res;
    }

    public HotelList filterByName(String name) {
        HotelList res = new HotelList(new ArrayList<>());

        for (HotelPO hotelPO : this) {
            if (hotelPO.getHotelName().contains(name)) {
                res.add(hotelPO);
            }
        }

        return res;
    }

    public HotelList filterByPrice(double lowerBound, double upperBound) throws RemoteException {
        HotelList res = new HotelList(new ArrayList<>());

        for (HotelPO hotelPO : this) {
            double price = new RoomList(RemoteHelper.getInstance().getHotelDAO().findRoomsByHotelID(hotelPO.getHotelID())).getHotelPrice();
            if (lowerBound <= price && price <= upperBound) {
                res.add(hotelPO);
            }
        }

        return res;
    }

    public HotelList filterByStar(int lowerBound, int upperBound) {
        HotelList res = new HotelList(new ArrayList<>());

        for (HotelPO hotelPO : this) {
            if (lowerBound <= hotelPO.getStar() && hotelPO.getStar() <= upperBound) {
                res.add(hotelPO);
            }
        }

        return res;
    }

    public HotelList filterByRating(double lowerBound, double upperBound) throws RemoteException {
        HotelList res = new HotelList(new ArrayList<>());

        for (HotelPO hotelPO : this) {
            double rating = new OrderList(RemoteHelper.getInstance().getOrderDAO().findByHotelID(hotelPO.getHotelID())).filterByHasReview().getHotelRating();
            if (lowerBound <= rating && rating <= upperBound) {
                res.add(hotelPO);
            }
        }

        return res;
    }

}
