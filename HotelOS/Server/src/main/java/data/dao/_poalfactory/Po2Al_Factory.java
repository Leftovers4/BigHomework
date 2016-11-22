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
public interface Po2Al_Factory {

    public ArrayList<Object> toUserAl(UserPO userPO);

    public ArrayList<Object> toPersonnelAl(PersonnelPO personnelPO);

    public ArrayList<Object> toHotelAl(HotelPO hotelPO);

    public ArrayList<Object> toRoomAl(RoomPO roomPO);

    public ArrayList<Object> toOrderAl(OrderPO orderPO);

    public ArrayList<Object> toPromotionAl(PromotionPO promotionPO);

    // TODO promotion类address等类的po创建问题

}
