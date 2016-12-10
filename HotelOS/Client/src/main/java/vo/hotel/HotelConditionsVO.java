package vo.hotel;

import util.RoomType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/12/4.
 */
public class HotelConditionsVO {

    public String address;

    public String tradingArea;

    public String name;

    public int starLowerBound;

    public int starUpperBound;

    public double priceLowerBound;

    public double priceUpperBound;

    public double ratingLowerBound;

    public double ratingUpperBound;

    public LocalDate expectedCheckInTime;

    public LocalDate expectedLeaveTime;

    public List<RoomType> roomTypeList;

    public boolean hasOrdered;

    public HotelConditionsVO(){
        address = "";
        tradingArea = "";
        name = "";
        starLowerBound = 0;
        starUpperBound = Integer.MAX_VALUE;
        priceLowerBound = 0;
        priceUpperBound = Double.MAX_VALUE;
        ratingLowerBound = 0;
        ratingUpperBound = Double.MAX_VALUE;
        expectedCheckInTime = null;
        expectedLeaveTime = null;
        roomTypeList = new ArrayList<>();
        hasOrdered = false;
    }

}
