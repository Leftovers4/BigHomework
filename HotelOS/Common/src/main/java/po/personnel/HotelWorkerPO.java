package po.personnel;

import util.PersonnelType;

import java.io.Serializable;

/**
 * Created by Hiki on 2016/10/27.
 */
public class HotelWorkerPO extends PersonnelPO implements Serializable{

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;


    /**
     * 酒店ID
     */
    private long hotelID;


    public HotelWorkerPO(long personnelID, String password, PersonnelType personnelType, String name, long hotelID) {
        super(personnelID, password, personnelType, name);
        this.hotelID = hotelID;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }
}
