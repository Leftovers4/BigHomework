package util;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/27/2016.
 * description: 用于记录各个PO转换成Al时的默认值
 * 可用于findByConditions时po到al的转换
 */
public class DefaultAl {

    private final static ArrayList<Object> hotelDefaultAl = new ArrayList<>();

    static {
        // 酒店默认的AL
        // 格式："hotel_id", "hotel_name", "star", "address", "trading_area", "description", "service"
        hotelDefaultAl.add(0);
        hotelDefaultAl.add("");
        hotelDefaultAl.add(0);
        hotelDefaultAl.add("");
        hotelDefaultAl.add("");
        hotelDefaultAl.add("");
        hotelDefaultAl.add("");


    }

    public static ArrayList<Object> getHotelDefaultAl() {
        return hotelDefaultAl;
    }



}
