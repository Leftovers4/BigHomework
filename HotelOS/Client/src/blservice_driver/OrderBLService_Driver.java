package blservice_driver;

import blservice.orderblservice.OrderBLService;
import org.junit.Before;
import org.junit.Test;
import util.ResultMessage;
import vo.order.OrderVO;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/10/16.
 */
public class OrderBLService_Driver {
    OrderBLService tested;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void find() throws Exception {
        OrderVO res = tested.find("12345620161111001");
        printOrderVO(res);
    }

    @Test
    public void add() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.add(new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null)));
    }

    @Test
    public void modify() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.modify(new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null)));
    }

    @Test
    public void evaluate() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.evaluate(new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null)));
    }

    @Test
    public void cancel() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.cancel());
    }

    @Test
    public void showList() throws Exception {
        ArrayList<OrderVO> res = tested.showList(new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null));
        for (int i = 0; i < res.size(); i++) {
            printOrderVO(res.get(i));
        }
    }

    private void printOrderVO(OrderVO orderVO){
        System.out.println(orderVO.orderID);
        System.out.println(orderVO.orderType);
        System.out.println(orderVO.username);
        System.out.println(orderVO.hotelID);
        System.out.println(orderVO.hotelName);
        System.out.println(orderVO.personAmount);
        System.out.println(orderVO.rooms.get(0).roomType);
        System.out.println(orderVO.withChildren);
        System.out.println(orderVO.orderPriceVO.originPrice);
        System.out.println(orderVO.orderPriceVO.actualPrice);
        System.out.println(orderVO.orderTimeVO.generateTime);
        System.out.println(orderVO.orderTimeVO.lastExecuteTime);
        System.out.println(orderVO.orderTimeVO.executeTime);
        System.out.println(orderVO.orderTimeVO.expectedLeaveTime);
        System.out.println(orderVO.orderTimeVO.cancelTime);
        System.out.println(orderVO.evaluationVO.evaluation);
    }
}