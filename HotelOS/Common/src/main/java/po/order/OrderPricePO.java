package po.order;

import java.io.Serializable;

/**
 * Created by Hiki on 2016/10/27.
 */
public class OrderPricePO implements Serializable{

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;


    /**
     * 原始价格
     */
    private double originPrice;


    /**
     * 折后价格
     */
    private double actualPrice;

    public OrderPricePO(){
        initial();
    }

    public OrderPricePO(double originPrice, double actualPrice) {
        this.initial();
        this.originPrice = originPrice;
        this.actualPrice = actualPrice;
    }

    private void initial(){
        this.originPrice = 0.0;
        this.actualPrice = 0.0;
    }

    public double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(double originPrice) {
        this.originPrice = originPrice;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }
}
