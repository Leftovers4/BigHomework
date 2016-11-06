package bl.orderbl;

import util.OrderType;

/**
 * Created by kevin on 2016/11/6.
 */
public class MockOrder extends Order {

    /**
     * 订单ID
     */
    private String orderID;

    /**
     * 酒店ID
     */
    private long hotelID;

    /**
     * 用户名
     */
    private String username;

    /**
     * 订单类型
     */
    private OrderType orderType;

    /**
     * 订单实际价格
     */
    private double actualPrice;

    /**
     * Instantiates a new Mock order.
     *
     * @param orderID     the order id
     * @param hotelID     the hotel id
     * @param username    the username
     * @param orderType   the order type
     * @param actualPrice the actual price
     */
    public MockOrder(String orderID, long hotelID, String username, OrderType orderType, double actualPrice) {
        this.orderID = orderID;
        this.hotelID = hotelID;
        this.username = username;
        this.orderType = orderType;
        this.actualPrice = actualPrice;
    }

    /**
     * Gets actual price.
     *
     * @return the actual price
     */
    public double getActualPrice() {
        return actualPrice;
    }

}
