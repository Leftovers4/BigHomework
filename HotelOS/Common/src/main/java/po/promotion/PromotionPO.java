package po.promotion;

import util.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 2016/10/16.
 */
public class PromotionPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 营销策略ID
     */
    private long promotionID;

    /**
     * 营销策略类型
     */
    private PromotionType promotionType;

    /**
     * 酒店ID
     */
    private long hotelID;

    /**
     * 折扣
     */
    private double discount;

    /**
     * 最少预订间数
     */
    private int leastRooms;

    /**
     * 时间
     */
    private PromotionTimePO promotionTimePO;

    /**
     * 合作企业
     */
    private ArrayList<String> promotionEnterprises;

    /**
     * 地址商圈
     */
    private ArrayList<PromotionTraAreaPO> promotionTraAreaPOs;


    /**
     * 会员等级制度
     */
    private ArrayList<PromotionMRPO> promotionMRPOs;


    /**
     * 用于增加营销策略
     */
    public PromotionPO(long promotionID, PromotionType promotionType, long hotelID, double discount) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.hotelID = hotelID;
        this.discount = discount;
    }

    public PromotionPO(long promotionID, PromotionType promotionType, long hotelID, int leastRooms, double discount) {
        initial();        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.hotelID = hotelID;
        this.leastRooms = leastRooms;
        this.discount = discount;
    }

    public PromotionPO(long promotionID, PromotionType promotionType, long hotelID, LocalDateTime beginTime, LocalDateTime endTime, double discount) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.hotelID = hotelID;
        this.promotionTimePO = new PromotionTimePO(beginTime, endTime);
        this.discount = discount;
    }

    public PromotionPO(long promotionID, PromotionType promotionType, long hotelID, PromotionTimePO promotionTimePO, double discount, int leastRooms) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.hotelID = hotelID;
        this.promotionTimePO = promotionTimePO;
        this.discount = discount;
        this.leastRooms = leastRooms;
    }

    public PromotionPO(long promotionID, PromotionType promotionType, ArrayList<String> promotionEnterprises, double discount) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.promotionEnterprises = promotionEnterprises;
        this.discount = discount;
    }

    public PromotionPO(long promotionID, PromotionType promotionType, ArrayList<PromotionMRPO> promotionMRPOs) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.promotionMRPOs = promotionMRPOs;
    }

    public PromotionPO(long promotionID, PromotionType promotionType, ArrayList<PromotionTraAreaPO> promotionTraAreaPOs, ArrayList<PromotionMRPO> promotionMRPOs) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.promotionTraAreaPOs = promotionTraAreaPOs;
        this.promotionMRPOs = promotionMRPOs;
    }

    // 用于从数据库中读取出来一个po
    public PromotionPO(long promotionID, PromotionType promotionType, long hotelID, double discount, int leastRooms, PromotionTimePO promotionTimePO, ArrayList<String> promotionEnterprises, ArrayList<PromotionTraAreaPO> promotionTraAreaPOs, ArrayList<PromotionMRPO> promotionMRPOs) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.hotelID = hotelID;
        this.discount = discount;
        this.leastRooms = leastRooms;
        this.promotionTimePO = promotionTimePO;
        this.promotionEnterprises = promotionEnterprises;
        this.promotionTraAreaPOs = promotionTraAreaPOs;
        this.promotionMRPOs = promotionMRPOs;
    }

    private void initial(){
        hotelID = 0;
        leastRooms = 0;
        discount = 1.0;
        promotionTimePO = new PromotionTimePO();
        promotionEnterprises = new ArrayList<>(Const.MaxPromotionEntpriseAmount);
        promotionTraAreaPOs = new ArrayList<>(Const.MaxPromotionAddressAmount);
        promotionMRPOs = new ArrayList<>(Const.MaxMemberLevel);
        // 初始化合作企业优惠
        for(int i = 0; i < Const.MaxPromotionEntpriseAmount; i++){
            promotionEnterprises.add("");
        }
        // 初始化商圈优惠
        for(int i = 0; i < Const.MaxPromotionAddressAmount; i++){
            promotionTraAreaPOs.add(new PromotionTraAreaPO("", 1.0));
        }
        // 初始化会员等级优惠
        for(int i = 0; i < Const.MaxMemberLevel; i++){
            promotionMRPOs.add(new PromotionMRPO(0.0, 1.0));
        }

    }

    public long getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(long promotionID) {
        this.promotionID = promotionID;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(PromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getLeastRooms() {
        return leastRooms;
    }

    public void setLeastRooms(int leastRooms) {
        this.leastRooms = leastRooms;
    }

    public PromotionTimePO getPromotionTimePO() {
        return promotionTimePO;
    }

    public void setPromotionTimePO(PromotionTimePO promotionTimePO) {
        this.promotionTimePO = promotionTimePO;
    }

    public ArrayList<String> getPromotionEnterprises() {
        return promotionEnterprises;
    }

    public void setPromotionEnterprises(ArrayList<String> promotionEnterprises) {
        this.promotionEnterprises = promotionEnterprises;
    }

    public ArrayList<PromotionTraAreaPO> getPromotionTraAreaPOs() {
        return promotionTraAreaPOs;
    }

    public void setPromotionTraAreaPOs(ArrayList<PromotionTraAreaPO> promotionTraAreaPOs) {
        this.promotionTraAreaPOs = promotionTraAreaPOs;
    }

    public ArrayList<PromotionMRPO> getPromotionMRPOs() {
        return promotionMRPOs;
    }

    public void setPromotionMRPOs(ArrayList<PromotionMRPO> promotionMRPOs) {
        this.promotionMRPOs = promotionMRPOs;
    }
}
