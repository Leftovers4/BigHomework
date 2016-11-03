package vo.user;

/**
 * Created by Hiki on 2016/10/27.
 */
public class HotelWorkerVO extends UserVO{

    public long hotelID;

    public HotelWorkerVO(String username, String password, long hotelID) {
        super(username, password);
        this.hotelID = hotelID;
    }


}
