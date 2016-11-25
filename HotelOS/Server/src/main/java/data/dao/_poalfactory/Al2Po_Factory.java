package data.dao._poalfactory;

import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.order.ReviewPO;
import po.personnel.PersonnelPO;
import po.promotion.PromotionEntPO;
import po.promotion.PromotionMRPO;
import po.promotion.PromotionPO;
import po.promotion.PromotionTraAreaPO;
import po.user.CreditRecordPO;
import po.user.UserPO;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Hiki on 11/22/2016.
 */
public interface Al2Po_Factory {

    public UserPO toUserPO(Iterator<Object> userAL, Iterator<Iterator<Object>> creditRecordALs);

    public PersonnelPO toPersonnelPO(Iterator<Object> personnelAL);

    public HotelPO toHotelPO(Iterator<Object> hotelAL, Iterator<Iterator<Object>> roomALs, Iterator<Iterator<Object>> order_reviewALs);

    public RoomPO toRoomPO(Iterator<Object> roomAL);

    public OrderPO toOrderPO(Iterator<Object> orderAL);

    public PromotionPO toPromotionPO(Iterator<Object> promotionAL, Iterator<Iterator<Object>> addressALs, Iterator<Iterator<Object>> enterpriseALs, Iterator<Iterator<Object>> mrALs);

    public CreditRecordPO toCreditRecordPO(Iterator<Object> creditRecordAL);

    public PromotionTraAreaPO toPromotionTraAreaPO(Iterator<Object> addressAL);

    public PromotionMRPO toPromotionMRPO(Iterator<Object> mrAL);

    public PromotionEntPO toPromotionEntPO(Iterator<Object> entAL);


    // TODO promotion类enterprise等类的po创建问题

}
