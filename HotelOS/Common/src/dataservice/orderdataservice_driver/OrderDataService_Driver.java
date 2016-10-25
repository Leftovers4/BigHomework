package dataservice.orderdataservice_driver;

import dataservice.orderdataservice.OrderDataService;
import org.junit.Before;
import org.junit.Test;
import po.order.OrderPO;

import java.util.ArrayList;

import static org.junit.Assert.*;

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
        ArrayList<OrderPO> res = tested.find(new OrderPO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null, null, 100, 98));
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
        System.out.println(orderPO.getGenerateTime());
        System.out.println(orderPO.getUsername());
        System.out.println(orderPO.getHotelID());
        System.out.println(orderPO.getHotelName());
        System.out.println(orderPO.getPersonAmount());
        System.out.println(orderPO.getRooms().get(0).getRoomType());
        System.out.println(orderPO.isWithChildren());
        System.out.println(orderPO.getActualPrice());
        System.out.println(orderPO.getLastExecuteTime());
        System.out.println(orderPO.getExecuteTime());
        System.out.println(orderPO.getExpectedLeaveTime());
        System.out.println(orderPO.getCancelTime());
        System.out.println(orderPO.getEvaluationPO().getEvaluation());
    }
}