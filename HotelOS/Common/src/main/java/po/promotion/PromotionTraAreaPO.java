package po.promotion;

import util.Address;
import util.TradingArea;

/**
 * Created by lib on 2016/11/22.
 */
public class PromotionTraAreaPO {

    private String address;

    private String tradingArea;

    public PromotionTraAreaPO(){
        initial();
    }

    public PromotionTraAreaPO(String address, String tradingArea) {
        initial();
        this.address = address;
        this.tradingArea = tradingArea;
    }

    public void initial(){
        this.address = "";
        this.tradingArea = "";
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
}
