package vo.promotion;

import util.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Hiki on 2016/10/16.
 */
public class PromotionVO {

    /**
     * 营销策略ID
     */
    public long promotionID;

    /**
     * 营销策略类型
     */
    public PromotionType promotionType;

    /**
     * 酒店ID
     */
    public long hotelID;

    /**
     * 折扣
     */
    public double discount;

    /**
     * 最少预订间数
     */
    public int leastRooms;

    /**
     * 房间类型
     */
    public RoomType roomType;

    /**
     * 房间优惠后的价格
     */
    public double bestPrice;

    /**
     * 时间
     */
    public PromotionTimeVO promotionTimeVO;

    /**
     * 合作企业
     */
    public List<String> promotionEnterprises;

    /**
     * 地址商圈
     */
    public List<PromotionTraAreaVO> promotionTraAreaVOs;

    /**
     * 会员等级制度
     */
    public List<PromotionMRVO> promotionMRVOs;

    public PromotionVO(){
        promotionTimeVO = new PromotionTimeVO();
        promotionEnterprises = new ArrayList<>();
        promotionTraAreaVOs = new ArrayList<>();
        for (int i = 0; i < Const.MaxPromotionAddressAmount; i++) {
            promotionTraAreaVOs.add(new PromotionTraAreaVO());
        }
        promotionMRVOs = new ArrayList<>();
        for (int i = 0; i < Const.MaxMemberLevel; i++) {
            promotionMRVOs.add(new PromotionMRVO());
        }
    }

    public long getPromotionID() {
        return promotionID;
    }

    public String getPromotionType() {
        return EnumFactory.getString(promotionType);
    }

    public long getHotelID() {
        return hotelID;
    }

    public double getDiscount() {
        return Math.round(discount*100);
    }

    public int getLeastRooms() {
        return leastRooms;
    }

    public String getRoomType() {
        return EnumFactory.getString(roomType);
    }

    public double getBestPrice() {
        return Math.round(bestPrice);
    }

    public String getBeginTime(){
        return promotionTimeVO.beginTime.format(DateTimeFormat.dateTimeFormat);
    }

    public String getEndTime(){
        return promotionTimeVO.endTime.format(DateTimeFormat.dateTimeFormat);
    }

    public String getComName(){
        return promotionEnterprises.get(0);
    }

    public String getTradingArea() {
        return promotionTraAreaVOs.get(0).tradingArea;
    }

    public double getTraDiscount(){
        return Math.round(promotionTraAreaVOs.get(0).traDiscount*100);
    }
}
