package po.personnel;

import java.io.Serializable;

/**
 * Created by Hiki on 2016/10/27.
 */
public class HotelWorkerPO  implements Serializable{

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    private long hotelWorkerID;
    private String password;
    private long hotelID;

    public HotelWorkerPO(long hotelWorkerID, String password, long hotelID) {
        this.hotelWorkerID = hotelWorkerID;
        this.password = password;
        this.hotelID = hotelID;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }
}
