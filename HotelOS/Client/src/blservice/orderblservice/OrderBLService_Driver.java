package blservice.orderblservice;

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
        assertEquals(ResultMessage.SUCCESS, tested.add(new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null, null, 100, 98)));
    }

    @Test
    public void modify() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.modify(new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null, null, 100, 98)));
    }

    @Test
    public void evaluate() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.evaluate(new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null, null, 100, 98)));
    }

    @Test
    public void cancel() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.cancel());
    }

    @Test
    public void showList() throws Exception {
        ArrayList<OrderVO> res = tested.showList(new OrderVO("12345620161111001", 123456, "如家", "张三", null, 2, false, null, null, null, 100, 98));
        for (int i = 0; i < res.size(); i++) {
            printOrderVO(res.get(i));
        }
    }

    private void printOrderVO(OrderVO orderVO){
        System.out.println(orderVO.orderID);
        System.out.println(orderVO.orderType);
        System.out.println(orderVO.generateTime);
        System.out.println(orderVO.username);
        System.out.println(orderVO.hotelID);
        System.out.println(orderVO.hotelName);
        System.out.println(orderVO.personAmount);
        System.out.println(orderVO.rooms.get(0).roomType);
        System.out.println(orderVO.withChildren);
        System.out.println(orderVO.actualPrice);
        System.out.println(orderVO.lastExecuteTime);
        System.out.println(orderVO.executeTime);
        System.out.println(orderVO.expectedLeaveTime);
        System.out.println(orderVO.cancelTime);
        System.out.println(orderVO.evaluationVO.evaluation);
    }
}