package po.promotion;

import util.Address;
import util.TradingArea;

/**
 * Created by lib on 2016/11/22.
 */
public class PromotionTraAreaPO {

    private long addressID;

    private String address;

    private String tradingArea;

    private double discount;

    public PromotionTraAreaPO(){
        initial();
    }

    public PromotionTraAreaPO(long addressID, String address, String tradingArea, double discount) {
        initial();
        this.addressID = addressID;
        this.address = address;
        this.tradingArea = tradingArea;
        this.discount = discount;
    }

    public void initial(){
        this.addressID = 0;
        this.address = "";
        this.tradingArea = "";
        this.discount = 0.0;
    }

    public long getAddressID() {
        return addressID;
    }

    public void setAddressID(long addressID) {
        this.addressID = addressID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTradingArea() {
        return tradingArea;
    }

    public void setTradingArea(String tradingArea) {
        this.tradingArea = tradingArea;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
