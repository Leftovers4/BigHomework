package po.hotel;

import po.order.ReviewPO;
import util.Address;
import util.TradingArea;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 2016/10/16.
 */
public class HotelPO implements Serializable{

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private long hotelID;

    /**
     * 名称
     */
    private String hotelName;

    /**
     * 星级
     */
    private int star;

    /**
     * 地址
     */
    private String address;

    /**
     * 商圈
     */
    private String tradingArea;

    /**
     * 简介
     */
    private String description;

    /**
     * 设施服务
     */
    private String service;

    /**
     * 客房数量
     */
    private List<RoomPO> rooms;

    /**
     * 历史评价
     */
    private List<ReviewPO> reviews;


    public HotelPO(){
        initial();
    }

    /**
     * 用于网站管理人员对酒店信息的查看和修改
     * @param hotelID
     * @param hotelName
     * @param star
     * @param address
     * @param tradingArea
     * @param description
     * @param service
     * @param rooms
     * @param reviews
     */
    public HotelPO(long hotelID, String hotelName, int star, String address, String tradingArea, String description, String service, ArrayList<RoomPO> rooms, ArrayList<ReviewPO> reviews) {
        initial();
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.star = star;
        this.address = address;
        this.tradingArea = tradingArea;
        this.description = description;
        this.service = service;
        this.rooms = rooms;
        this.reviews = reviews;
    }



    private void initial(){
        this.hotelID = 0;
        this.hotelName = "";
        this.star = 0;
        this.address = "";
        this.tradingArea = "";
        this.description = "";
        this.service = "";
        this.rooms = new ArrayList<>();
        this.reviews = new ArrayList<>();

    }


    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTradingArea() {
        return tradingArea;
    }

    public void setTradingArea(String tradingArea) {
        this.tradingArea = tradingArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public List<RoomPO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomPO> rooms) {
        this.rooms = rooms;
    }

    public List<ReviewPO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewPO> reviews) {
        this.reviews = reviews;
    }
}
