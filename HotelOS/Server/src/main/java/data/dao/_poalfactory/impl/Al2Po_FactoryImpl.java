package data.dao._poalfactory.impl;

import data.dao._poalfactory.Al2Po_Factory;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import po.promotion.PromotionPO;
import po.user.UserPO;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/22/2016.
 */
public class Al2Po_FactoryImpl implements Al2Po_Factory{


    @Override
    public UserPO toUserAl(ArrayList<Object> userAL) {
        return null;
    }

    @Override
    public PersonnelPO toPersonnelAl(ArrayList<Object> personnelAL) {
        return null;
    }

    @Override
    public HotelPO toHotelAl(ArrayList<Object> hotelAL) {
        return null;
    }

    @Override
    public RoomPO toRoomAl(ArrayList<Object> roomAL) {
        return null;
    }

    @Override
    public OrderPO toOrderAl(ArrayList<Object> orderAL) {
        return null;
    }

    @Override
    public PromotionPO toPromotionAl(ArrayList<Object> promotionAL) {
        return null;
    }
}
