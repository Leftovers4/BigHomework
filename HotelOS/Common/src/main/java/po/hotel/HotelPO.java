package po.hotel;

import po.order.EvaluationPO;
import util.Address;
import util.TradingArea;

import java.io.Serializable;
import java.util.ArrayList;

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
    private long HotelID;

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
    private Address address;

    /**
     * 商圈
     */
    private TradingArea tradingArea;

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
    private ArrayList<RoomPO> rooms;

    /**
     * 历史评价
     */
    private ArrayList<EvaluationPO> evaluations;



    /**
     * 用于网站管理人员对酒店信息的查看和修改
     *
     *
     *
     **/
    public HotelPO(String hotelName, Address address, TradingArea tradingArea, String description,
                   String service, ArrayList<RoomPO> rooms) {
        super();
        this.hotelName = hotelName;
        this.address = address;
        this.tradingArea = tradingArea;
        this.description = description;
        this.service = service;
        this.rooms = rooms;

    }

    public long getHotelID() {
        return HotelID;
    }

    public void setHotelID(long hotelID) {
        HotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TradingArea getTradingArea() {
        return tradingArea;
    }

    public void setTradingArea(TradingArea tradingArea) {
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

    public ArrayList<RoomPO> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<RoomPO> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<EvaluationPO> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(ArrayList<EvaluationPO> evaluations) {
        this.evaluations = evaluations;
    }
}
