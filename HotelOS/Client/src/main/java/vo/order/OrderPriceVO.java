package vo.order;

/**
 * Created by Hiki on 2016/10/27.
 */
public class OrderPriceVO {

    /**
     * 原始价格
     */
    public double originPrice;


    /**
     * 折后价格
     */
    public double actualPrice;

    public OrderPriceVO(){

    }

    public OrderPriceVO(double originPrice, double actualPrice) {
        this.originPrice = originPrice;
        this.actualPrice = actualPrice;
    }


}
