package vo.order;

/**
 * Created by Hiki on 2016/10/27.
 */
public class OrderPriceVO {

    /**
     * 原始价格
     */
    private double originPrice;


    /**
     * 折后价格
     */
    private double actualPrice;

    public OrderPriceVO(double originPrice, double actualPrice) {
        this.originPrice = originPrice;
        this.actualPrice = actualPrice;
    }


}
