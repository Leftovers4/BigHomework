package vo.hotel;

import util.Address;
import util.TradingArea;
import vo.order.ReviewVO;

import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public class HotelVO {

    /**
     * ID
     */
    public long HotelID;

    /**
     * 名称
     */
    public String hotelName;

    /**
     * 星级
     */
    public int star;

    /**
     * 地址
     */
    public Address address;

    /**
     * 商圈
     */
    public TradingArea tradingArea;

    /**
     * 简介
     */
    public String description;

    /**
     * 设施服务
     */
    public String service;

    /**
     * 客房数量
     */
    public ArrayList<RoomVO> rooms;

    /**
     * 历史评价
     */
    public ArrayList<ReviewVO> reviews;


    /**
     * 用于网站管理人员对酒店信息的查看和修改
     *
     *
     *
     **/
    public HotelVO(String hotelName, Address address, TradingArea tradingArea, String description,
                   String service, ArrayList<RoomVO> rooms) {
        super();
        this.hotelName = hotelName;
        this.address = address;
        this.tradingArea = tradingArea;
        this.description = description;
        this.service = service;
        this.rooms = rooms;

    }



}
