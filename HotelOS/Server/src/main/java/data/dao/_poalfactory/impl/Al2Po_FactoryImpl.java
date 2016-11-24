package data.dao._poalfactory.impl;

import data.dao._poalfactory.Al2Po_Factory;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import po.promotion.PromotionPO;
import po.user.UserPO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Hiki on 11/22/2016.
 * description: 把数据库拿过来的list转换成po，使用迭代器模式
 */
public class Al2Po_FactoryImpl implements Al2Po_Factory{


    @Override
    public UserPO toUserAl(Iterator<Object> userAL) {
//        String username = (String) userAL.next();
//        String password = (String) userAL.next();
//        String name = (String) userAL.next();
//        boolean gender = (boolean) userAL.next();
//        String phone = (String) userAL.next();


        return null;

    }

    @Override
    public PersonnelPO toPersonnelAl(Iterator<Object> personnelAL) {
        return null;
    }

    @Override
    public HotelPO toHotelAl(Iterator<Object> hotelAL) {
        return null;
    }

    @Override
    public RoomPO toRoomAl(Iterator<Object> roomAL) {
        return null;
    }

    @Override
    public OrderPO toOrderAl(Iterator<Object> orderAL) {
        return null;
    }

    @Override
    public PromotionPO toPromotionAl(Iterator<Object> promotionAL) {
        return null;
    }
}
