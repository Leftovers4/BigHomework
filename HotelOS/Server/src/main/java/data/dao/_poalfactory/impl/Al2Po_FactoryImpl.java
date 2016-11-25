package data.dao._poalfactory.impl;

import data.dao._poalfactory.Al2Po_Factory;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import po.promotion.PromotionPO;
import po.user.CreditRecordPO;
import po.user.MemberPO;
import po.user.UserPO;
import util.CreditChangedCause;
import util.EnumFactory;
import util.MemberType;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Hiki on 11/22/2016.
 * description: 把数据库拿过来的list转换成po，使用迭代器模式
 * 注意顺序和类型转换
 * 若拿过来的表没有内容，则构造的po为null
 */
public class Al2Po_FactoryImpl implements Al2Po_Factory{


    @Override
    public UserPO toUserPO(Iterator<Object> userAL, Iterator<Iterator<Object>> creditRecordALs) {

        // 若user表没有内容，则返回null
        if(!userAL.hasNext()){
            return null;
        }

        // 从user表中获取
        String username = (String) userAL.next();
        String password = (String) userAL.next();
        String name = (String) userAL.next();
        boolean gender = (boolean) userAL.next();
        String phone = (String) userAL.next();
        MemberType memberType = (MemberType) EnumFactory.getEnum((String)userAL.next());
        int level = (int) userAL.next();
        LocalDate birthday = toDate((String)userAL.next());
        String enterprise = (String) userAL.next();

        // 从credit_record表中获取
        ArrayList<CreditRecordPO> creditRecordPOs = new ArrayList<>();

        while(creditRecordALs.hasNext()){
            creditRecordPOs.add(toCreditRecordPO(creditRecordALs.next()));
        }

        MemberPO memberPO = new MemberPO(username, memberType, level, birthday, enterprise);

        UserPO userPO = new UserPO(username, password, name, gender, phone, memberPO, creditRecordPOs);

        return null;

    }

    @Override
    public PersonnelPO toPersonnelPO(Iterator<Object> personnelAL) {
        return null;
    }

    @Override
    public HotelPO toHotelPO(Iterator<Object> hotelAL) {
        return null;
    }

    @Override
    public RoomPO toRoomPO(Iterator<Object> roomAL) {
        return null;
    }

    @Override
    public OrderPO toOrderPO(Iterator<Object> orderAL) {
        return null;
    }

    @Override
    public PromotionPO toPromotionPO(Iterator<Object> promotionAL) {
        return null;
    }

    @Override
    public CreditRecordPO toCreditRecordPO(Iterator<Object> creditRecordAL) {
        if(!creditRecordAL.hasNext()){
            return null;
        }

        long recordID = (long) creditRecordAL.next();
        String username = (String) creditRecordAL.next();
        double currentCredit = (double) creditRecordAL.next();
        double changedCredit = (double) creditRecordAL.next();
        LocalDateTime changedTime = toDateTime((String)creditRecordAL.next());
        CreditChangedCause creditChangedCause = (CreditChangedCause) EnumFactory.getEnum((String)creditRecordAL.next());
        String orderID = (String) creditRecordAL.next();

        return new CreditRecordPO(recordID, username, currentCredit, changedCredit, changedTime, creditChangedCause, orderID);

    }


/*---------------------------------------辅助方法-------------------------------------------------*/

    private static LocalDate toDate(String dateString) throws DateTimeParseException{
        // TODO：是否对输入进行判断
        if(dateString != null && !dateString.equals("")){
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateString, format);
            return date;
        }

        return null;
    }

    private static LocalDateTime toDateTime(String dateTimeString) throws DateTimeParseException{
        // TODO:是否对输入进行判断
        if(dateTimeString != null && !dateTimeString.equals("")){
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, format);
            return dateTime;
        }

        return null;
    }



}
