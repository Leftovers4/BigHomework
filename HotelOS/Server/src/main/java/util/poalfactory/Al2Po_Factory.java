package util.poalfactory;

import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import po.promotion.PromotionPO;
import po.user.CreditRecordPO;
import po.user.UserPO;

import java.util.Iterator;

/**
 * Created by Hiki on 11/22/2016.
 */
public interface Al2Po_Factory {

    // 特殊需求：用户的账号、密码、姓名（名称）、联系方式必须密文存储
    public UserPO toUserPO(Iterator<Object> userAL);

    public PersonnelPO toPersonnelPO(Iterator<Object> personnelAL);

    public HotelPO toHotelPO(Iterator<Object> hotelAL);

    public RoomPO toRoomPO(Iterator<Object> roomAL);

    public OrderPO toOrderPO(Iterator<Object> orderAL);

    public PromotionPO toPromotionPO(Iterator<Object> promotionAL);

    public CreditRecordPO toCreditRecordPO(Iterator<Object> creditRecordAL);




}
