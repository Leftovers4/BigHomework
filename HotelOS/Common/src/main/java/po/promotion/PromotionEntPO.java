package po.promotion;

/**
 * Created by Hiki on 11/25/2016.
 */
public class PromotionEntPO {

    private long matchID;

    private long hotelID;

    private String enterprise;

    public PromotionEntPO(long matchID, long hotelID, String enterprise) {
        this.matchID = matchID;
        this.hotelID = hotelID;
        this.enterprise = enterprise;
    }

    public long getMatchID() {
        return matchID;
    }

    public void setMatchID(long matchID) {
        this.matchID = matchID;
    }

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }
}
