package data.dao.orderdata;

import com.sun.org.apache.bcel.internal.generic.POP;
import org.junit.Before;
import org.junit.Test;
import po.order.OrderPO;
import util.CommonMethod;
import util.POProducer;
import util.ResultMessage;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/4/2016.
 */
public class OrderDataServiceImplTest {

    OrderDataServiceImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new OrderDataServiceImpl();
    }

    @Test
    public void insert() throws Exception {
        ResultMessage resultMessage = tested.insert(POProducer.getOrderPO());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void update() throws Exception {
        ResultMessage resultMessage = tested.update(POProducer.getOrderPO());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void findAll() throws Exception {
        ArrayList<OrderPO> orderPOs = tested.findAll();
        for (OrderPO each : orderPOs) {
            CommonMethod.printClass(each);
        }

    }

    @Test
    public void findByOrderID() throws Exception {
        OrderPO orderPO = tested.findByOrderID(POProducer.getOrderPO().getOrderID());
        CommonMethod.printClass(orderPO);
    }

    @Test
    public void findByHotelID() throws Exception {
        ArrayList<OrderPO> orderPOs = tested.findByHotelID(POProducer.getOrderPO().getHotelID());
        for (OrderPO each : orderPOs) {
            CommonMethod.printClass(each);
        }
    }

    @Test
    public void findByHotelIDAndType() throws Exception {
        ArrayList<OrderPO> orderPOs = tested.findByHotelIDAndType(POProducer.getOrderPO().getHotelID(), POProducer.getOrderPO().getOrderType());
        for (OrderPO each : orderPOs) {
            CommonMethod.printClass(each);
        }
    }

    @Test
    public void findByUsername() throws Exception {
        ArrayList<OrderPO> orderPOs = tested.findByUsername(POProducer.getOrderPO().getUsername());
        for (OrderPO each : orderPOs) {
            CommonMethod.printClass(each);
        }
    }

    @Test
    public void findByUsernameAndType() throws Exception {
        ArrayList<OrderPO> orderPOs = tested.findByUsernameAndType(POProducer.getOrderPO().getUsername(), POProducer.getOrderPO().getOrderType());
        for (OrderPO each : orderPOs) {
            CommonMethod.printClass(each);
        }
    }

    @Test
    public void findByUsernameAndHotelID() throws Exception {
        ArrayList<OrderPO> orderPOs = tested.findByUsernameAndHotelID(POProducer.getOrderPO().getUsername(), POProducer.getOrderPO().getHotelID());
        for (OrderPO each : orderPOs) {
            CommonMethod.printClass(each);
        }
    }

}