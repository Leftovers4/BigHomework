package vo.user;

/**
 * Created by Hiki on 2016/10/27.
 */
public class HotelWorkerVO extends UserVO{

    private long hotelID;

    public HotelWorkerVO(String username, String password, long hotelID) {
        super(username, password);
        this.hotelID = hotelID;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }
}
