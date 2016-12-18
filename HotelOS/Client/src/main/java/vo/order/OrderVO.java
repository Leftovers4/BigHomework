package vo.order;

import util.*;
import vo.hotel.RoomVO;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public class OrderVO {


    /**
     * 订单ID
     */
    public String orderID;


    /**
     * 酒店ID
     */
    public long hotelID;


    /**
     * 用户名
     */
    public String username;


    /**
     * 订单类型
     */
    public OrderType orderType;


    /**
     * 酒店名称
     */
    public String hotelName;

    public String hotelAddress;

    public String hotelTradingArea;

    public String hotelService;

    public int roomAmount;

    public RoomType roomType;

    public boolean hasReview;

    /**
     * 房间号
     * 说明：房间号只有show的功能，故只要用string存储，用空格隔开多个房间
     */
    public String roomNumber;


    /**
     * 入住人数
     */
    public int personAmount;


    /**
     * 有无儿童
     */
    public boolean withChildren;

    /**
     * 订单采用的优惠信息
     */
    public OrderPromoInfoVO orderPromoInfoVO;

    /**
     * 评价
     */
    public ReviewVO reviewVO;


    /**
     * 时间
     */
    public OrderTimeVO orderTimeVO;


    /**
     * 价格
     */
    public OrderPriceVO orderPriceVO;


    /**
     * 申诉信息
     */
    public OrderHandleAppealVO orderHandleAppealVO;

    public OrderVO(){
        this.orderPromoInfoVO = new OrderPromoInfoVO();
        this.orderPriceVO = new OrderPriceVO();
        this.orderTimeVO = new OrderTimeVO();
        this.reviewVO = new ReviewVO();
        this.orderHandleAppealVO = new OrderHandleAppealVO();
    }

    public String getOrderID() {
        return orderID;
    }

    public long getHotelID() {
        return hotelID;
    }

    public String getUsername() {
        return username;
    }

    public String getOrderType() {
        return EnumFactory.getString(orderType);
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public String getHotelTradingArea() {
        return hotelTradingArea;
    }

    public String getHotelService() {
        return hotelService;
    }

    public int getRoomAmount() {
        return roomAmount;
    }

    public String getRoomType() {
        return EnumFactory.getString(roomType);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public int getPersonAmount() {
        return personAmount;
    }

    public boolean isWithChildren() {
        return withChildren;
    }

    public String getCheckinTime() {
        return orderTimeVO.checkinTime == null ? "未入住" : orderTimeVO.checkinTime.format(DateTimeFormat.dateTimeFormat);
    }

    public double getActualPrice() {
        return orderPriceVO.actualPrice;
    }

    public String getGenerateTime() {
        return orderTimeVO.generateTime.format(DateTimeFormat.dateTimeFormat);
    }

    public String getHasReview() {
        return orderType == OrderType.Executed ? (hasReview == true ? "有" : "无") : "-";
    }

}
