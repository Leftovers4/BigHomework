package bl.hotelbl.impl;

import bl.orderbl.impl.OrderList;
import po.hotel.HotelPO;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class HotelList extends ArrayList<HotelPO>{

    public HotelList(List<HotelPO> hotelPOList){
        for (int i = 0; i < hotelPOList.size(); i++) {
            this.add(hotelPOList.get(i));
        }
    }

    public HotelList filterByAddress(String address){
        HotelList res = new HotelList(this);

        for (HotelPO hotelPO : this) {
            if (hotelPO.getAddress().equals(address)){
                res.add(hotelPO);
            }
        }

        return res;
    }

    public HotelList filterByTradingArea(String tradingArea){
        HotelList res = new HotelList(this);

        for (HotelPO hotelPO : this) {
            if (hotelPO.getTradingArea().equals(tradingArea)){
                res.add(hotelPO);
            }
        }

        return res;
    }

    public HotelList filterByName(String name){
        HotelList res = new HotelList(this);

        for (HotelPO hotelPO : this) {
            if (hotelPO.getHotelName().contains(name)){
                res.add(hotelPO);
            }
        }

        return res;
    }

    public HotelList filterByPrice(double lowerBound, double upperBound) throws RemoteException {
        HotelList res = new HotelList(this);

        for (HotelPO hotelPO : this) {
            double price = new RoomList(RemoteHelper.getInstance().getHotelDAO().findRoomsByHotelID(hotelPO.getHotelID())).getHotelPrice();
            if (lowerBound <= price && price <= upperBound){
                res.add(hotelPO);
            }
        }

        return res;
    }

    public HotelList filterByStar(int lowerBound, int upperBound){
        HotelList res = new HotelList(this);

        for (HotelPO hotelPO : this) {
            if (lowerBound <= hotelPO.getStar() && hotelPO.getStar() <= upperBound){
                res.add(hotelPO);
            }
        }

        return res;
    }

    public HotelList filterByRating(double lowerBound, double upperBound) throws RemoteException {
        HotelList res = new HotelList(this);

        for (HotelPO hotelPO : this) {
            double rating = new OrderList(RemoteHelper.getInstance().getOrderDAO().findByHotelID(hotelPO.getHotelID())).getHotelRating();
            if (lowerBound <= rating && rating <= upperBound){
                res.add(hotelPO);
            }
        }

        return res;
    }

}
