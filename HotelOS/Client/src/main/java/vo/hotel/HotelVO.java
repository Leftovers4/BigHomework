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
    public long hotelID;

    /**
     * 名称
     */
    public String hotelName;

    /*
     * 工作人员
     */
    public String hotelWorkerName;

    /**
     * 星级
     */
    public int star;

    /**
     * 地址
     */
    public String address;

    /**
     * 商圈
     */
    public String tradingArea;

    /**
     * 简介
     */
    public String description;

    /**
     * 设施服务
     */
    public String service;

    /**
     * 浏览酒店时显示的酒店价格，是该酒店所有房间的最低价格，也是酒店列表排序的标准之一
     */
    public double price;

    /**
     * 酒店的评分，是该酒店所有用户评分的平均数
     */
    public double rating;

    /**
     * 房间类型
     */
    public List<RoomVO> rooms;

    /**
     * 历史评价
     */
    public List<ReviewVO> reviews;

    /**
     * 特定用户在该酒店的订单列表
     */
    public List<OrderVO> ordersByUserAndHotel;

    /**
     * 传给逻辑：创建包含酒店工作人员修改酒店基本信息的界面信息的对象
     *
     * @param hotelID     酒店的id
     * @param address     地址
     * @param tradingArea 商圈
     * @param description 简介
     * @param service     服务
     */
    public HotelVO(long hotelID, String address, String tradingArea, String description, String service) {
        this.hotelID = hotelID;
        this.address = address;
        this.tradingArea = tradingArea;
        this.description = description;
        this.service = service;
    }

    /**
     * 传给界面：创建包含酒店工作人员查看酒店基本信息的界面信息的对象
     *
     * @param hotelID         酒店的id
     * @param hotelName       酒店名称
     * @param hotelWorkerName 工作人员名称
     * @param star            星级
     * @param rating          评分
     * @param address         地址
     * @param tradingArea     商圈
     * @param description     简介
     * @param service         服务
     */
    public HotelVO(long hotelID, String hotelName, String hotelWorkerName, int star, double rating, String address, String tradingArea, String description, String service) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.hotelWorkerName = hotelWorkerName;
        this.star = star;
        this.rating = rating;
        this.address = address;
        this.tradingArea = tradingArea;
        this.description = description;
        this.service = service;
    }

    /*
     * 排序测试用构造器，别使用
     */
    public HotelVO(int star, double price, double rating) {
        this.star = star;
        this.price = price;
        this.rating = rating;
    }

}
