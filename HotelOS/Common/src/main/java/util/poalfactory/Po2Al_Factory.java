package util.poalfactory;

import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import po.promotion.PromotionPO;
import po.user.CreditRecordPO;
import po.user.UserPO;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/22/2016.
 */
public interface Po2Al_Factory {

    // 特殊需求：用户的账号、密码、姓名（名称）、联系方式必须密文存储
    public ArrayList<Object> toUserAl(UserPO userPO);

    public ArrayList<Object> toPersonnelAl(PersonnelPO personnelPO);

    public ArrayList<Object> toHotelAl(HotelPO hotelPO);

    public ArrayList<Object> toRoomAl(RoomPO roomPO);

    public ArrayList<Object> toOrderAl(OrderPO orderPO);

    public ArrayList<Object> toPromotionAl(PromotionPO promotionPO);

    public ArrayList<Object> toCreditRecordAl(CreditRecordPO creditRecordPO);


    // TODO promotion类address等类的po创建问题

}
