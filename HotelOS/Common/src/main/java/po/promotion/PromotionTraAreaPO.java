package po.promotion;

import util.Address;
import util.TradingArea;

/**
 * Created by lib on 2016/11/22.
 */
public class PromotionTraAreaPO {

    private Address address;

    private TradingArea tradingArea;

    public PromotionTraAreaPO(Address address, TradingArea tradingArea) {
        this.address = address;
        this.tradingArea = tradingArea;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TradingArea getTradingArea() {
        return tradingArea;
    }

    public void setTradingArea(TradingArea tradingArea) {
        this.tradingArea = tradingArea;
    }

}
