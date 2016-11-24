package vo.hotel;

import util.Address;
import util.TradingArea;
import vo.order.OrderVO;
import vo.order.ReviewVO;

import java.util.ArrayList;
import java.util.List;

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
    public List<RoomVO> rooms;

    /**
     * 历史评价
     */
    public ArrayList<ReviewVO> reviews;

    /**
     * 特定用户在该酒店的订单列表
     */
    public List<OrderVO> ordersByUserAndHotel;

    /**
     * 浏览酒店时显示的酒店价格，是该酒店所有房间的最低价格，也是酒店列表排序的标准之一
     */
    public double price;

    /**
     * 酒店的评分，是该酒店所有用户评分的平均数
     */
    public double rating;

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



    public HotelVO(long hotelID, String hotelName, int star, Address address, TradingArea tradingArea, String description, String service, List<RoomVO> rooms, ArrayList<ReviewVO> reviews, List<OrderVO> ordersByUserAndHotel, double price, double rating) {
        HotelID = hotelID;
        this.hotelName = hotelName;
        this.star = star;
        this.address = address;
        this.tradingArea = tradingArea;
        this.description = description;
        this.service = service;
        this.rooms = rooms;
        this.reviews = reviews;
        this.ordersByUserAndHotel = ordersByUserAndHotel;
        this.price = price;
        this.rating = rating;
    }

    public HotelVO(int star, double price, double rating) {
        this.star = star;
        this.price = price;
        this.rating = rating;
    }
}
