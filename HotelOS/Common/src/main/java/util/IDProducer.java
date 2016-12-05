package util;

import java.time.LocalDate;
import java.util.Random;

/**
 * Created by lib on 2016/11/30.
 * 负责随机id的生成
 */
public class IDProducer {

    private static final int MAX_HOTELID = 999999;

    private static final int MAX_GENERALID = 1000000;

    private static final int HOTELID_FOR_WP = 999999;

    private static final int MIN_GENERALID = 100000;

    private static final int MAX_ORDERID = 1000;

    private static final int MIN_ORDERID = 100;

    public static int produceHotelID(){
        return new Random().nextInt(MAX_HOTELID - MIN_GENERALID) + MIN_GENERALID;
    }

    public static int produceGeneralID(){
        return new Random().nextInt(MAX_GENERALID - MIN_GENERALID) + MIN_GENERALID;
    }

    public static int produceHotelIDForWP(){return HOTELID_FOR_WP;}

    public static String produceOrderID(long hotelID){
        String res = "";

        res += hotelID;
        LocalDate today = LocalDate.now();
        res += today.getYear();
        res += today.getMonth();
        res += today.getDayOfMonth();
        res += new Random().nextInt(MAX_ORDERID - MIN_ORDERID) + MIN_ORDERID;

        return res;
    }

}
