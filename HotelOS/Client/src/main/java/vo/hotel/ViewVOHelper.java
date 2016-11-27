package vo.hotel;

import util.RoomType;

/**
 * Created by kevin on 2016/11/27.
 */
public class ViewVOHelper {

    /**
     * 传给逻辑：创建包含网站管理人员添加酒店的界面信息的vo
     *
     * @param hotelName 酒店名称
     * @param star      星级
     * @return 包含网站管理人员添加酒店的界面信息的vo
     */
    public HotelVO create(String hotelName, int star) {
        HotelVO res = new HotelVO();

        res.hotelName = hotelName;
        res.star = star;

        return res;
    }

    /**
     * 传给逻辑：创建包含酒店工作人员修改酒店基本信息的界面信息的vo
     *
     * @param hotelID     酒店的id
     * @param address     地址
     * @param tradingArea 商圈
     * @param description 简介
     * @param service     服务
     * @return 包含酒店工作人员修改酒店基本信息的界面信息的vo
     */
    public HotelVO create(long hotelID, String address, String tradingArea, String description, String service) {
        HotelVO res = new HotelVO();

        res.hotelID = hotelID;
        res.address = address;
        res.tradingArea = tradingArea;
        res.description = description;
        res.service = service;

        return res;
    }

    /**
     * 传给逻辑：创建包含酒店工作人员录入可用客房界面信息的vo
     *
     * @param hotelID  房间类型所属酒店的id
     * @param roomType 房间类型，有Single（单人房），Couple（双人房）
     * @param total    该类型房间的总数量
     * @param price    价格
     * @return 包含酒店工作人员录入可用客房界面信息的vo
     */
    public RoomVO create(long hotelID, RoomType roomType, int total, double price) {
        RoomVO res = new RoomVO();

        res.hotelID = hotelID;
        res.roomType = roomType;
        res.total = total;
        res.price = price;

        return res;
    }

    /**
     * 传给逻辑：创建包含酒店工作人员录入可用客房界面信息的vo
     *
     * @param roomID 房间类型id
     * @param total  该房间类型的房间总数量
     * @param price  该房间类型的价格
     * @return 包含酒店工作人员录入可用客房界面信息的vo
     */
    public RoomVO create(long roomID, int total, double price){
        RoomVO res = new RoomVO();

        res.total = total;
        res.price = price;

        return res;
    }

}
