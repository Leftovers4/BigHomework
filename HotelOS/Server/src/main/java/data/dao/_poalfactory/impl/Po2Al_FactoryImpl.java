package data.dao._poalfactory.impl;

import data.dao._poalfactory.Po2Al_Factory;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import po.order.OrderPO;
import po.personnel.PersonnelPO;
import po.promotion.PromotionPO;
import po.user.UserPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 11/22/2016.
 */
public class Po2Al_FactoryImpl implements Po2Al_Factory{

    // TODO 注意初始值的设定
    // TODO 类似memberpo 初始值不能为null
    @Override
    public ArrayList<Object> toUserAl(UserPO userPO) {
        ArrayList<Object> userInfoContent = new ArrayList<>();
        userInfoContent.add(userPO.getUsername());
        userInfoContent.add(userPO.getPassword());
        userInfoContent.add(userPO.getName());
        userInfoContent.add(userPO.isGender());
        userInfoContent.add(userPO.getPhone());
        userInfoContent.add(toString(userPO.getMemberPO().getMemberType()));
        userInfoContent.add(userPO.getMemberPO().getLevel());
        userInfoContent.add(toString(userPO.getMemberPO().getBirthday()));
        userInfoContent.add(toString(userPO.getMemberPO().getMemberType()));

        return userInfoContent;
    }

    @Override
    public ArrayList<Object> toPersonnelAl(PersonnelPO personnelPO) {
        ArrayList<Object> personnelInfoContent = new ArrayList<>();
        personnelInfoContent.add(personnelPO.getPersonnelID());
        personnelInfoContent.add(personnelPO.getPassword());
        personnelInfoContent.add(toString(personnelPO.getPersonnelType()));
        personnelInfoContent.add(personnelPO.getName());
        personnelInfoContent.add(personnelPO.getHotelID());

        return personnelInfoContent;
    }

    @Override
    public ArrayList<Object> toHotelAl(HotelPO hotelPO) {
        ArrayList<Object> hotelInfoContent = new ArrayList<>();
        hotelInfoContent.add(hotelPO.getHotelID());
        hotelInfoContent.add(hotelPO.getHotelName());
        hotelInfoContent.add(hotelPO.getStar());
        hotelInfoContent.add(hotelPO.getAddress());
        hotelInfoContent.add(hotelPO.getTradingArea());
        hotelInfoContent.add(hotelPO.getDescription());
        hotelInfoContent.add(hotelPO.getService());

        return hotelInfoContent;
    }

    @Override
    public ArrayList<Object> toRoomAl(RoomPO roomPO) {
        ArrayList<Object> roomInfoContent = new ArrayList<>();
        roomInfoContent.add(roomPO.getRoomId());
        roomInfoContent.add(roomPO.getHotelId());
        roomInfoContent.add(toString(roomPO.getRoomType()));
        roomInfoContent.add(roomPO.getTotal());
        roomInfoContent.add(roomPO.getAvailable());
        roomInfoContent.add(roomPO.getPrice());

        return roomInfoContent;
    }

    @Override
    public ArrayList<Object> toOrderAl(OrderPO orderPO) {
        ArrayList<Object> orderInfoContent = new ArrayList<>();
        orderInfoContent.add(orderPO.getOrderID());
        orderInfoContent.add(orderPO.getHotelID());
        orderInfoContent.add(orderPO.getUsername());
        orderInfoContent.add(toString(orderPO.getOrderType()));
        orderInfoContent.add(orderPO.getHotelName());
        orderInfoContent.add(toString(orderPO.getRoom().getRoomType()));
        orderInfoContent.add(orderPO.getRoom().getTotal());
        orderInfoContent.add(orderPO.getRoomNumber());
        orderInfoContent.add(orderPO.getPersonAmount());
        orderInfoContent.add(orderPO.isWithChildren());
        orderInfoContent.add(toString(orderPO.getOrderTimePO().getGenerateTime()));
        orderInfoContent.add(toString(orderPO.getOrderTimePO().getExpectedCheckinTime()));
        orderInfoContent.add(toString(orderPO.getOrderTimePO().getLeaveTime()));
        orderInfoContent.add(toString(orderPO.getOrderTimePO().getLastExecuteTime()));
        orderInfoContent.add(toString(orderPO.getOrderTimePO().getCancelTime()));
        orderInfoContent.add(orderPO.getOrderPricePO().getOriginPrice());
        orderInfoContent.add(orderPO.getOrderPricePO().getActualPrice());
        orderInfoContent.add(toString(orderPO.getReviewPO().getReviewTime()));
        orderInfoContent.add(orderPO.getReviewPO().getRating());
        orderInfoContent.add(orderPO.getReviewPO().getReview());
        orderInfoContent.add(toString(orderPO.getOrderHandleAppealPO().getHaTime()));
        orderInfoContent.add(toString(orderPO.getOrderHandleAppealPO().getHa_result()));

        return orderInfoContent;
    }

    @Override
    public ArrayList<Object> toPromotionAl(PromotionPO promotionPO) {
        ArrayList<Object> promotionInfoContent = new ArrayList<>();
        promotionInfoContent.add(promotionPO.getPromotionID());
        promotionInfoContent.add(toString(promotionPO.getPromotionType()));
        promotionInfoContent.add(promotionPO.getHotelID());
        promotionInfoContent.add(promotionPO.getLeastRooms());
        promotionInfoContent.add(promotionPO.getDiscount());
        promotionInfoContent.add(promotionPO.getLeastRooms());
        promotionInfoContent.add(toString(promotionPO.getBeginTime()));
        promotionInfoContent.add(toString(promotionPO.getEndTime()));
        // TODO：满减还不用做
        promotionInfoContent.add(0);
        promotionInfoContent.add(0);

        return promotionInfoContent;



    }

/*-------------------------------------------------辅助方法-------------------------------------------------------------*/

    /**
     * 把enum, localdatetime等类型化成string存储
     * @param input
     * @return
     */
    public String toString(Object input){
        if(input == null){
            return "";
        }else{
            return input.toString();
        }
    }





}


