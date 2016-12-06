package po.promotion;

import util.Address;
import util.TradingArea;

import java.io.Serializable;

/**
 * Created by kevin on 2016/11/22.
 */
public class PromotionTraAreaPO implements Serializable{

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    private String tradingArea;

    private double traDiscount;

    public PromotionTraAreaPO(){
        initial();
    }

    public PromotionTraAreaPO(String tradingArea, double traDiscount) {
        initial();
        this.tradingArea = tradingArea;
        this.traDiscount = traDiscount;
    }

    public void initial(){
        this.tradingArea = "";
        this.traDiscount = 1.0;
    }

    public String getTradingArea() {
        return tradingArea;
    }

    public void setTradingArea(String tradingArea) {
        this.tradingArea = tradingArea;
    }

    public double getTraDiscount() {
        return traDiscount;
    }

    public void setTraDiscount(double traDiscount) {
        this.traDiscount = traDiscount;
    }
}
