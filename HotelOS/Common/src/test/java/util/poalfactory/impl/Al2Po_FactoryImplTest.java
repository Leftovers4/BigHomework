package util.poalfactory.impl;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import po.promotion.PromotionPO;
import po.user.CreditRecordPO;
import po.user.UserPO;
import util.ALProducer;
import util.CommonMethod;
import util.Const;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Hiki on 12/4/2016.
 */
public class Al2Po_FactoryImplTest {


    Al2Po_FactoryImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new Al2Po_FactoryImpl();
    }

    @Test
    public void toUserPO() throws Exception {
        UserPO userPO = tested.toUserPO(ALProducer.getUser().iterator());
        CommonMethod.printClass(userPO);
    }

    @Test
    public void toPersonnelPO() throws Exception {
        PersonnelPO personnelPO = tested.toPersonnelPO(ALProducer.getPersonnel().iterator());
        CommonMethod.printClass(personnelPO);
    }

    @Test
    public void toHotelPO() throws Exception {
        HotelPO hotelPO = tested.toHotelPO(ALProducer.getHotel().iterator());
        CommonMethod.printClass(hotelPO);

    }

    @Test
    public void toRoomPO() throws Exception {
        RoomPO roomPO = tested.toRoomPO(ALProducer.getRoom().iterator());
        CommonMethod.printClass(roomPO);
    }

    @Test
    public void toOrderPO() throws Exception {
        OrderPO orderPO = tested.toOrderPO(ALProducer.getOrder().iterator());
        CommonMethod.printClass(orderPO);
    }

    @Test
    public void toPromotionPO() throws Exception {
        PromotionPO promotionPO = tested.toPromotionPO(ALProducer.getPromotion().iterator());
        CommonMethod.printClass(promotionPO);
        System.out.println(promotionPO.getPromotionEnterprises().get(0));
    }

    @Test
    public void toCreditRecordPO() throws Exception {
        CreditRecordPO creditRecordPO = tested.toCreditRecordPO(ALProducer.getCreditRecord().iterator());
        CommonMethod.printClass(creditRecordPO);
    }

    @Ignore
    public void timeStampToLocalDatetime() throws Exception {
        Timestamp test1 = Timestamp.valueOf("0001-01-01 00:00:00");
        LocalDateTime a = tested.timeStampToLocalDatetime(test1);
        System.out.println(a);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse("1989-01-01 00:00:15", timeFormatter);

        LocalDateTime b = tested.timeStampToLocalDatetime(Timestamp.valueOf(localDateTime));

        System.out.println(b);

    }

}