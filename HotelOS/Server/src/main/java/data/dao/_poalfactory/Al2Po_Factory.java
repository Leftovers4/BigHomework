package data.dao._poalfactory;

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
public interface Al2Po_Factory {

    public UserPO toUserAl(ArrayList<Object> userAL);

    public PersonnelPO toPersonnelAl(ArrayList<Object> personnelAL);

    public HotelPO toHotelAl(ArrayList<Object> hotelAL);

    public RoomPO toRoomAl(ArrayList<Object> roomAL);

    public OrderPO toOrderAl(ArrayList<Object> orderAL);

    public PromotionPO toPromotionAl(ArrayList<Object> promotionAL);

    // TODO promotion类address等类的po创建问题

}
