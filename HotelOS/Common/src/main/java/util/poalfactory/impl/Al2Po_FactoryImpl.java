package util.poalfactory.impl;

import util.poalfactory.Al2Po_Factory;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.*;
import po.personnel.PersonnelPO;
import po.promotion.*;
import po.user.CreditRecordPO;
import po.user.MemberPO;
import po.user.UserPO;
import util.*;

import java.sql.Date;
import java.sql.Timestamp;
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
    public UserPO toUserPO(Iterator<Object> userAL) {

        // 若user表没有内容，则返回null
        if(!userAL.hasNext()){
            return null;
        }

        // 从user表中获取
        String username = (String) userAL.next();
        String password = (String) userAL.next();
        String name = (String) userAL.next();
        boolean gender = intToBool((int)userAL.next());
        String phone = (String) userAL.next();
        MemberType memberType = (MemberType) EnumFactory.getEnum((String)userAL.next());
        int level = (int) userAL.next();
//        LocalDate birthday = toDate((String)userAL.next());
        LocalDate birthday = ((Date) userAL.next()).toLocalDate();

        String enterprise = (String) userAL.next();

        // 构造MemberPO
        MemberPO memberPO = new MemberPO(username, memberType, level, birthday, enterprise);

        // 初始化CreditRecordPOs
        ArrayList<CreditRecordPO> creditRecordPOs = new ArrayList<>();

        UserPO userPO = new UserPO(username, password, name, gender, phone, memberPO, creditRecordPOs);

        return userPO;

    }

    @Override
    public PersonnelPO toPersonnelPO(Iterator<Object> personnelAL) {
        // 若personnel表没有内容，则返回null
        if(!personnelAL.hasNext()){
            return null;
        }
        // 从personnel表中获取
        long personnelID = (long) personnelAL.next();
        String password = (String) personnelAL.next();
        PersonnelType personnelType = (PersonnelType) EnumFactory.getEnum((String)personnelAL.next());
        String name = (String) personnelAL.next();
        long hotelID = (long) personnelAL.next();

        PersonnelPO personnelPO = new PersonnelPO(personnelID, password, personnelType, name, hotelID);

        return personnelPO;

    }

    @Override
    public HotelPO toHotelPO(Iterator<Object> hotelAL) {
        // 若hotel表没有内容，则返回null
        if(!hotelAL.hasNext()){
            return null;
        }

        // 从hotel表中获取
        long hotelID = (long) hotelAL.next();
        String hotelName = (String) hotelAL.next();
        int star = (int) hotelAL.next();
        String address = (String) hotelAL.next();
        String tradingArea = (String) hotelAL.next();
        String description = (String) hotelAL.next();
        String service = (String) hotelAL.next();

        // 初始化roomPOs
        ArrayList<RoomPO> roomPOs = new ArrayList<>();

        // 初始化reviewPOs
        ArrayList<ReviewPO> reviewPOs = new ArrayList<>();

        HotelPO hotelPO = new HotelPO(hotelID, hotelName, star, address, tradingArea, description, service, roomPOs, reviewPOs);

        return hotelPO;


    }

    @Override
    public RoomPO toRoomPO(Iterator<Object> roomAL) {
        // 若room表没有内容，则返回null
        if(!roomAL.hasNext()){
            return null;
        }
        // 从room表中获取
        long roomID = (long) roomAL.next();
        long hotelID = (long) roomAL.next();
        RoomType roomType = (RoomType) EnumFactory.getEnum((String)roomAL.next());
        int total = (int) roomAL.next();
        int available = (int) roomAL.next();
        double price = (double) roomAL.next();

        RoomPO roomPO = new RoomPO(roomID, hotelID, roomType, total, available, price);

        return roomPO;
    }

    @Override
    public OrderPO toOrderPO(Iterator<Object> orderAL) {

        // 若order表没有内容，则返回null
        if(!orderAL.hasNext()){
            return null;
        }

        // 从order_info表中获取
        String orderID = (String) orderAL.next();
        long hotelID = (long) orderAL.next();
        String username = (String) orderAL.next();
        OrderType orderType = (OrderType) EnumFactory.getEnum((String)orderAL.next());
        String hotelName = (String) orderAL.next();
        RoomType roomType = (RoomType) EnumFactory.getEnum((String)orderAL.next());
        int roomAmount = (int) orderAL.next();
        String roomNumber = (String) orderAL.next();
        int personAmount = (int) orderAL.next();
        boolean withChilren = intToBool((int) orderAL.next()); // TODO:不确定能不能转换
        // 时间
//        LocalDateTime generateTime = toDateTime((String) orderAL.next());
        LocalDateTime generateTime = timeStampToLocalDatetime((Timestamp) orderAL.next());
        LocalDateTime expectedCheckinTime = timeStampToLocalDatetime((Timestamp) orderAL.next());
        LocalDateTime checkinTime = timeStampToLocalDatetime((Timestamp) orderAL.next());
        LocalDateTime expectedLeaveTime = timeStampToLocalDatetime((Timestamp) orderAL.next());
        LocalDateTime leaveTime = timeStampToLocalDatetime((Timestamp) orderAL.next());
        LocalDateTime lastExecuteTime = timeStampToLocalDatetime((Timestamp) orderAL.next());
        LocalDateTime cancelTime = timeStampToLocalDatetime((Timestamp) orderAL.next());
        // 价格
        double originPrice = (double) orderAL.next();
        double actualPrice = (double) orderAL.next();
        // 评价
        LocalDateTime reviewTime = timeStampToLocalDatetime((Timestamp) orderAL.next());
        int rating = (int) orderAL.next();
        String review = (String) orderAL.next();
        // 处理申诉
        LocalDateTime haTime = timeStampToLocalDatetime((Timestamp) orderAL.next());
        HandleAppealResult haResult = (HandleAppealResult) EnumFactory.getEnum((String)orderAL.next());

        // 生成局部PO
        OrderTimePO orderTimePO = new OrderTimePO(generateTime, expectedCheckinTime, checkinTime, expectedLeaveTime, leaveTime, lastExecuteTime, cancelTime);
        OrderPricePO orderPricePO = new OrderPricePO(originPrice, actualPrice);
        ReviewPO reviewPO = new ReviewPO(username, hotelID, reviewTime, rating, review);
        OrderHandleAppealPO orderHandleAppealPO = new OrderHandleAppealPO(haTime, haResult);

        OrderPO orderPO = new OrderPO(orderID, hotelID, username, orderType, hotelName, roomType, roomAmount, roomNumber, personAmount, withChilren, reviewPO, orderTimePO, orderPricePO, orderHandleAppealPO);

        return orderPO;

    }

    @Override
    public PromotionPO toPromotionPO(Iterator<Object> promotionAL) {
        // 若promotion表没有内容，则返回null
        if(!promotionAL.hasNext()){
            return null;
        }

        // 从promotion表中获取
        long promotionID = (long) promotionAL.next();
        PromotionType promotionType = (PromotionType) EnumFactory.getEnum((String)promotionAL.next());
        long hotelID = (long) promotionAL.next();
        double discount = (double) promotionAL.next();
        int leastRooms = (int) promotionAL.next();
        LocalDateTime beginTime = timeStampToLocalDatetime((Timestamp) promotionAL.next());
        LocalDateTime endTime = timeStampToLocalDatetime((Timestamp) promotionAL.next());

        // 合作企业
        ArrayList<String> promotionEnterprises = new ArrayList<>(Const.MaxPromotionEntpriseAmount);
        for(int i = 0; i < Const.MaxPromotionEntpriseAmount; i++){
            String enterprise = (String) promotionAL.next();
            promotionEnterprises.add(enterprise);
        }


        // 商圈优惠
        ArrayList<PromotionTraAreaPO> promotionTraAreaPOs = new ArrayList<>(Const.MaxPromotionAddressAmount);
        for(int i = 0; i < Const.MaxPromotionAddressAmount; i++){
            String tradingArea = (String) promotionAL.next();
            double traDiscount = (double) promotionAL.next();
            promotionTraAreaPOs.add(new PromotionTraAreaPO(tradingArea, traDiscount));

        }

        // 会员优惠
        ArrayList<PromotionMRPO> promotionMRPOs = new ArrayList<>(Const.MaxMemberLevel);
        for(int i = 0; i < Const.MaxMemberLevel; i++){
            double credit = (double) promotionAL.next();
            double memDiscount = (double) promotionAL.next();

            promotionMRPOs.add(new PromotionMRPO(credit, memDiscount));
        }

        // 构造promotionTimePO
        PromotionTimePO promotionTimePO = new PromotionTimePO(beginTime, endTime);

//        double threshold = (double) promotionAL.next();
//        double reduction = (double) promotionAL.next();

        PromotionPO promotionPO = new PromotionPO(promotionID, promotionType, hotelID, discount, leastRooms,  promotionTimePO, promotionEnterprises, promotionTraAreaPOs, promotionMRPOs);

        return promotionPO;

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
        LocalDateTime changedTime = timeStampToLocalDatetime((Timestamp) creditRecordAL.next());
        CreditChangedCause creditChangedCause = (CreditChangedCause) EnumFactory.getEnum((String)creditRecordAL.next());
        String orderID = (String) creditRecordAL.next();

        return new CreditRecordPO(recordID, username, currentCredit, changedCredit, changedTime, creditChangedCause, orderID);

    }

//    @Override
//    public PromotionTraAreaPO toPromotionTraAreaPO(Iterator<Object> addressAL) {
//        if(!addressAL.hasNext()){
//            return null;
//        }
//
//        // 从address表获取
//        long addressID = (long) addressAL.next();
//        String address = (String) addressAL.next();
//        String tradingArea = (String) addressAL.next();
//        double discount = (double) addressAL.next();
//
//        PromotionTraAreaPO promotionTraAreaPO = new PromotionTraAreaPO(addressID, address, tradingArea, discount);
//
//        return promotionTraAreaPO;
//    }

//    @Override
//    public PromotionMRPO toPromotionMRPO(Iterator<Object> mrAls) {
//        if(!mrAls.hasNext()){
//            return null;
//        }
//
//        // 从member_regulation表中获取
//        int level = (int) mrAls.next();
//        double credit = (double) mrAls.next();
//        double discount = (double) mrAls.next();
//
//        PromotionMRPO promotionMRPO = new PromotionMRPO(level, credit, discount);
//
//        return promotionMRPO;
//    }




/*---------------------------------------辅助方法-------------------------------------------------*/

    private static LocalDate toDate(String dateString) throws DateTimeParseException{
        // 若输入格式错误，返回null
        if(dateString != null && !dateString.equals("")){
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateString, format);
            return date;
        }

        return null;
    }

    private static LocalDateTime toDateTime(String dateTimeString) throws DateTimeParseException{
        // 若输入格式错误，返回null
        if(dateTimeString != null && !dateTimeString.equals("")){
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, format);
            return dateTime;
        }

        return null;
    }

    private static boolean intToBool(int bool){
        if(bool == 0){
            return false;
        }else {
            return true;
        }

    }

    private static LocalDateTime timeStampToLocalDatetime(Timestamp timestamp){
        return timestamp.toLocalDateTime();
    }



}
