package po.user;

import java.io.Serializable;

/**
 * Created by Hiki on 2016/10/27.
 */
public class HotelWorkerPO extends UserPO implements Serializable{

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    private long hotelID;

    public HotelWorkerPO(String username, String password, long hotelID) {
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
