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
     * 图片
     */
    public byte[] image;

/*--------------------------------------------------------------------------------------------------------------------*/

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
     * 是否预定过
     */
    public boolean hasOrdered;

/*--------------------------------------------------------------------------------------------------------------------*/

    /*
     * 工作人员id
     */
    public long hotelWorkerID;

    /*
     * 工作人员名字
     */
    public String hotelWorkerName;

    public long getHotelID() {
        return hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getStar() {
        return star;
    }

    public String getAddress() {
        return address;
    }

    public String getTradingArea() {
        return tradingArea;
    }

    public String getDescription() {
        return description;
    }

    public String getService() {
        return service;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public long getHotelWorkerID() {
        return hotelWorkerID;
    }

    public String getHotelWorkerName() {
        return hotelWorkerName;
    }

}
