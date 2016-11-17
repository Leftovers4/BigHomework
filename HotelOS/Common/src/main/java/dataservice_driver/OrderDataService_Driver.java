package dataservice_driver;

import dataservice.orderdataservice.OrderDataService;
import org.junit.Before;
import org.junit.Test;
import po.order.OrderPO;
import util.OrderType;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class OrderDataService_Driver {
    OrderDataService tested;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByOrderID() throws Exception {
        OrderPO res = tested.findByOrderID("12345620161111001");
        printOrderPO(res);
    }

    @Test
    public void find() throws Exception {
        ArrayList<OrderPO> res = tested.find(new OrderPO("12345620161111001", 123456,"张三", OrderType.ABNORMAL,"如家", null,null, 2, false, null, null,null,null));
        for (int i = 0; i < res.size(); i++) {
            printOrderPO(res.get(i));
        }
    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    private void printOrderPO(OrderPO orderPO){
        System.out.println(orderPO.getOrderID());
        System.out.println(orderPO.getOrderType());
        System.out.println(orderPO.getUsername());
        System.out.println(orderPO.getHotelID());
        System.out.println(orderPO.getHotelName());
        System.out.println(orderPO.getPersonAmount());
        System.out.println(orderPO.getRooms().get(0).getRoomType());
        System.out.println(orderPO.isWithChildren());
        System.out.println(orderPO.getOrderPricePO().getActualPrice());
        System.out.println(orderPO.getOrderPricePO().getOriginPrice());
        System.out.println(orderPO.getOrderTimePO().getGenerateTime());
        System.out.println(orderPO.getOrderTimePO().getLastExecuteTime());
        System.out.println(orderPO.getOrderTimePO().getExecuteTime());
        System.out.println(orderPO.getOrderTimePO().getExpectedLeaveTime());
        System.out.println(orderPO.getOrderTimePO().getCancelTime());
        System.out.println(orderPO.getReviewPO().getReview());
    }
}