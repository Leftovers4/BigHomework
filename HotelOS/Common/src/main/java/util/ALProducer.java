package util;

import com.sun.corba.se.spi.ior.ObjectKey;
import po.user.UserPO;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;

/**
 * Created by Hiki on 12/3/2016.
 * description: 用于创建标准arraylist（可补充），便于测试
 */
public class ALProducer {


    private static ArrayList<Object> CreditRecord = new ArrayList<>();
    private static ArrayList<Object> Hotel = new ArrayList<>();
    private static ArrayList<Object> HotelImage = new ArrayList<>();
    private static ArrayList<Object> Order = new ArrayList<>();
    private static ArrayList<Object> Personnel = new ArrayList<>();
    private static ArrayList<Object> Promotion = new ArrayList<>();
    private static ArrayList<Object> Room = new ArrayList<>();
    private static ArrayList<Object> User = new ArrayList<>();
    private static ArrayList<Object> UserImage = new ArrayList<>();

    private final static String username = "leftovers01";
    private final static long personnelID = 100000;
    private final static long hotelID = 522000;
    private final static String hotelName = "榕江大酒店";
//    private final static String date = "2016-01-01";
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");;
    private final static Timestamp datetime = Timestamp.valueOf(LocalDateTime.parse("2016-01-01 11:11:11", formatter));
//    private final static String datetime = "2016-01-01 11:11:11";
    private final static String orderID = hotelID + "20161111" + "000";
    private final static long recordID = 100000;
    private final static long roomID = 121121;
    private final static long promotionID = 999999;
    private final static String address = "广东揭阳";
    private final static String tradingArea = "东山";
    private final static String description = "坐落于榕江左岸。";
    private final static String service = "没有特殊服务";
    private final static String password = "abc123456";
    private final static String enterprise = "南京大学";
    private final static long crID = 10000;
    private final static LocalDate birthday = LocalDate.parse("2016-01-01");
    private final static Date date = Date.valueOf(birthday);



    static{
        // "record_id", "username", "current_credit", "changed_credit", "changed_time", "cause", "order_id"
        CreditRecord = objectsToList(crID, username, 1.0, 0.1, datetime, "Recharge", orderID);
        // "hotel_id", "hotel_name", "star", "address", "trading_area", "description", "service"
        Hotel = objectsToList(hotelID, hotelName, 5, address, tradingArea, description, service);
        // "order_id", "hotel_id", "username", "order_type", "hotel_name", "room_type", "room_amount",
        // "room_number",  "person_amount", "with_children", "generate_time", "expected_checkin_time",
        // "checkin_time", "expected_leave_time", "leave_time", "last_execute_time", "cancel_time", "original_price", "actual_price",
        // "review_time", "rating", "review", "ha_time", "ha_result"
        Order = objectsToList("15165165", hotelID, username, "Abnormal", hotelName, "Single", 2, "511", 2, 0,
                                null, datetime, datetime, datetime, datetime, datetime, datetime,
                                100.0, 80.0, datetime, 4, "好", datetime, "All");
        // "personnel_id", "password", "personnel_type", "name", "hotel_id"
        Personnel = objectsToList(personnelID, password, "HotelWorker", username, hotelID);
        // "promotion_id", "promotion_type", "hotel_id", "discount", "least_rooms", "begin_time", "end_time",
        // "enterprise1", "enterprise2", "enterprise3", "enterprise4", "enterprise5",
        // "trading_area1", "tra_discount1", "trading_area2", "tra_discount2", "trading_area3", "tra_discount3", "trading_area4", "tra_discount4", "trading_area5", "tra_discount5",
        // "credit1", "mem_discount1", "credit2", "mem_discount2", "credit3", "mem_discount3", "credit4", "mem_discount4", "credit5", "mem_discount", "credit6", "mem_discount6"
        Promotion = objectsToList(promotionID, "BirthdayPromotion", hotelID, 0.1, 4, datetime, datetime,
                    enterprise, enterprise, enterprise, enterprise, enterprise,
                    tradingArea, 0.8, tradingArea, 0.8, tradingArea, 0.8, tradingArea, 0.8, tradingArea, 0.8,
                    1000.0, 0.7, 1000.0, 0.7, 1000.0, 0.7, 1000.0, 0.7, 1000.0, 0.7, 1000.0, 0.7);
        // "room_id", "hotel_id", "room_type", "total", "available", "price"
        Room = objectsToList(roomID, hotelID, "Single", 12, 11, 100.0);
        // "username", "password", "name", "gender", "phone", "member_type", "level", "birthday", "enterprise"
        User = objectsToList(Coder.encode(username), Coder.encode(password), Coder.encode("啊"), 1, Coder.encode("11011011010"), "Normal", 5, date, enterprise);

    }




    /**
     * 辅助方法，用于将object转成ArrayList<Object>
     * @param parameters
     * @return
     */
    private static ArrayList<Object> objectsToList(Object... parameters){

        // 获取strings参数的个数
        int n = parameters.length;

        ArrayList<Object> result = new ArrayList<Object>();

        for(int i = 0; i < n; i++){
            result.add(parameters[i]);
        }

        return result;
    }


    public static ArrayList<Object> getCreditRecord() {
        return CreditRecord;
    }

    public static void setCreditRecord(ArrayList<Object> creditRecord) {
        CreditRecord = creditRecord;
    }

    public static ArrayList<Object> getHotel() {
        return Hotel;
    }

    public static void setHotel(ArrayList<Object> hotel) {
        Hotel = hotel;
    }

    public static ArrayList<Object> getHotelImage() {
        return HotelImage;
    }

    public static void setHotelImage(ArrayList<Object> hotelImage) {
        HotelImage = hotelImage;
    }

    public static ArrayList<Object> getOrder() {
        return Order;
    }

    public static void setOrder(ArrayList<Object> order) {
        Order = order;
    }

    public static ArrayList<Object> getPersonnel() {
        return Personnel;
    }

    public static void setPersonnel(ArrayList<Object> personnel) {
        Personnel = personnel;
    }

    public static ArrayList<Object> getPromotion() {
        return Promotion;
    }

    public static void setPromotion(ArrayList<Object> promotion) {
        Promotion = promotion;
    }

    public static ArrayList<Object> getRoom() {
        return Room;
    }

    public static void setRoom(ArrayList<Object> room) {
        Room = room;
    }

    public static ArrayList<Object> getUser() {
        return User;
    }

    public static void setUser(ArrayList<Object> user) {
        User = user;
    }

    public static ArrayList<Object> getUserImage() {
        return UserImage;
    }

    public static void setUserImage(ArrayList<Object> userImage) {
        UserImage = userImage;
    }
}
