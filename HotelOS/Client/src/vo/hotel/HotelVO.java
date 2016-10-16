package vo.hotel;

import vo.order.EvaluationVO;

import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public class HotelVO {

    /**
     * ID
     */
    private long HotelID;

    /**
     * 名称
     */
    private String hotelName;

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
    private ArrayList<RoomVO> rooms;

    /**
     * 历史评价
     */
    private ArrayList<EvaluationVO> evaluations;


    public HotelVO(){}

    /**
     * 用于网站管理人员对酒店信息的查看和修改
     *
     *
     *
     **/
    public HotelPO(String hotelName, Address address, TradingArea tradingArea, String description,
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
