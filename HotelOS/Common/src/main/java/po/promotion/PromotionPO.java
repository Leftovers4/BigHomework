package po.promotion;

import util.Address;
import util.PromotionType;
import util.TradingArea;
import util.UserLevel;

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
     * 最少预订间数
     */
    private int leastRooms;

    /**
     * 折扣
     */
    private double discount;

    /**
     * 时间
     */
    private PromotionTimePO promotionTimePO;

    /**
     * 地址商圈
     */
    private ArrayList<PromotionTraAreaPO> promotionTraAreaPOs;

    /**
     * 合作企业
     */
    private ArrayList<PromotionEntPO> promotionEntPOs;

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

    public PromotionPO(long promotionID, PromotionType promotionType, ArrayList<PromotionEntPO> enterprises, double discount) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.promotionEntPOs = enterprises;
        this.discount = discount;
    }

    public PromotionPO(long promotionID, PromotionType promotionType, ArrayList<PromotionMRPO> promotionMRPOs) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.promotionMRPOs = promotionMRPOs;
    }

    public PromotionPO(long promotionID, PromotionType promotionType, String address, String tradingArea, ArrayList<PromotionMRPO> promotionMRPOs) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        // TODO 传入的是地址商圈列表 需要修改的地方
//        this.promotionTraAreaPO = new PromotionTraAreaPO(address, tradingArea);
        this.promotionMRPOs = promotionMRPOs;
    }

    // 用于从数据库中读取出来一个po
    public PromotionPO(long promotionID, PromotionType promotionType, long hotelID, int leastRooms, double discount, PromotionTimePO promotionTimePO, ArrayList<PromotionTraAreaPO> promotionTraAreaPOs, ArrayList<PromotionEntPO> promotionEntPOs, ArrayList<PromotionMRPO> promotionMRPOs) {
        initial();
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.hotelID = hotelID;
        this.leastRooms = leastRooms;
        this.discount = discount;
        this.promotionTimePO = promotionTimePO;
        this.promotionTraAreaPOs = promotionTraAreaPOs;
        this.promotionEntPOs = promotionEntPOs;
        this.promotionMRPOs = promotionMRPOs;
    }

    private void initial(){
        hotelID = 0;
        leastRooms = 0;
        discount = 1;
        promotionTimePO = new PromotionTimePO();
        promotionTraAreaPOs = new ArrayList<>();
        promotionEntPOs = new ArrayList<>();
        promotionMRPOs = new ArrayList<>();
        for(int i = 0; i < UserLevel.MAX_LEVEL; i++){
            promotionMRPOs.add(new PromotionMRPO(i+1, 0.0, 0.0));
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

    public int getLeastRooms() {
        return leastRooms;
    }

    public void setLeastRooms(int leastRooms) {
        this.leastRooms = leastRooms;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDateTime getBeginTime(){
        return this.promotionTimePO.getBeginTime();
    }

    public LocalDateTime getEndTime(){
        return this.promotionTimePO.getEndTime();
    }

    public void setPromotionTimePO(LocalDateTime beginTime, LocalDateTime endTime) {
        this.promotionTimePO.setBeginTime(beginTime);
        this.promotionTimePO.setEndTime(endTime);
    }


    public PromotionTimePO getPromotionTimePO() {
        return promotionTimePO;
    }

    public void setPromotionTimePO(PromotionTimePO promotionTimePO) {
        this.promotionTimePO = promotionTimePO;
    }

    public ArrayList<PromotionTraAreaPO> getPromotionTraAreaPOs() {
        return promotionTraAreaPOs;
    }

    public void setPromotionTraAreaPOs(ArrayList<PromotionTraAreaPO> promotionTraAreaPOs) {
        this.promotionTraAreaPOs = promotionTraAreaPOs;
    }

    public ArrayList<PromotionEntPO> getPromotionEntPOs() {
        return promotionEntPOs;
    }

    public void setPromotionEntPOs(ArrayList<PromotionEntPO> promotionEntPOs) {
        this.promotionEntPOs = promotionEntPOs;
    }

    public void setPromotionMRPOs(ArrayList<PromotionMRPO> promotionMRPOs) {
        this.promotionMRPOs = promotionMRPOs;
    }

    public ArrayList<PromotionMRPO> getPromotionMRPOs() {
        return promotionMRPOs;
    }
}
