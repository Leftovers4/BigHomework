package util;


import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import po.promotion.PromotionPO;
import po.user.CreditRecordPO;
import po.user.UserPO;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Hiki on 12/4/2016.
 */
public class POProducer {

    private static HotelPO hotelPO;
    private static RoomPO roomPO;
    private static OrderPO orderPO;
    private static PersonnelPO personnelPO;
    private static PromotionPO promotionPO;
    private static UserPO userPO;
    private static CreditRecordPO creditRecordPO;

    // 利用AL to PO
    private final static Al2Po_FactoryImpl apFactory = new Al2Po_FactoryImpl();

    // 初始化所有PO
    static{

        hotelPO = apFactory.toHotelPO(ALProducer.getHotel().iterator());
        roomPO = apFactory.toRoomPO(ALProducer.getRoom().iterator());
        orderPO = apFactory.toOrderPO(ALProducer.getOrder().iterator());
        personnelPO = apFactory.toPersonnelPO(ALProducer.getPersonnel().iterator());
        promotionPO = apFactory.toPromotionPO(ALProducer.getPromotion().iterator());
        userPO = apFactory.toUserPO(ALProducer.getUser().iterator());
        creditRecordPO = apFactory.toCreditRecordPO(ALProducer.getCreditRecord().iterator());


    }


    public static HotelPO getHotelPO() {
        return hotelPO;
    }

    public static RoomPO getRoomPO() {
        return roomPO;
    }

    public static OrderPO getOrderPO() {
        return orderPO;
    }

    public static PersonnelPO getPersonnelPO() {
        return personnelPO;
    }

    public static PromotionPO getPromotionPO() {
        return promotionPO;
    }

    public static UserPO getUserPO() {
        return userPO;
    }

    public static CreditRecordPO getCreditRecordPO() {
        return creditRecordPO;
    }



}
