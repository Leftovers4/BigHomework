package bl.hotelbl;

import po.hotel.RoomPO;
import util.Address;
import util.TradingArea;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/6.
 */
public class MockHotel extends Hotel{

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
     * 客房数量
     */
    private ArrayList<RoomPO> rooms;

    /**
     * Instantiates a new Mock hotel.
     *
     * @param hotelID     the hotel id
     * @param hotelName   the hotel name
     * @param address     the address
     * @param tradingArea the trading area
     * @param rooms       the rooms
     */
    public MockHotel(long hotelID, String hotelName, Address address, TradingArea tradingArea, ArrayList<RoomPO> rooms) {
        HotelID = hotelID;
        this.hotelName = hotelName;
        this.address = address;
        this.tradingArea = tradingArea;
        this.rooms = rooms;
    }

    /**
     * judge whether the given tradingArea is the trading area of the hotel.
     *
     * @param tradingArea the trading area
     * @return true or false
     */
    public boolean isTradingArea(TradingArea tradingArea){
        return tradingArea == this.tradingArea;
    }

}
