package data.datahelper.orderdatahelper;

import org.junit.Before;
import org.junit.Test;
import util.ALProducer;
import util.ResultMessage;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 11/26/2016.
 */
public class OrderDataHelperImplTest {

    OrderDataHelperImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new OrderDataHelperImpl();
    }

    @Test
    public void insertToSQL() throws Exception {
        ArrayList<Object> input = ALProducer.getOrder();
        ResultMessage result = tested.insertToSQL(input);
        System.out.println(result.toString());

    }

    @Test
    public void updateFromSQL() throws Exception {
        ArrayList<Object> input = ALProducer.getOrder();
        input.set(2, "leftovers02");
        ResultMessage result = tested.updateFromSQL(input);
        System.out.println(result.toString());
    }

    @Test
    public void findFromSQL() throws Exception {
        // TODO：时间显示会后面加个 .0
        ArrayList<ArrayList<Object>> output = new ArrayList<>();
        output = tested.findFromSQL();
        for (ArrayList<Object> each : output) {
            for (Object a : each) {
                System.out.print(a.toString() + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void findByIdFromSQL() throws Exception {
        ArrayList<Object> output = tested.findByIdFromSQL((String) ALProducer.getOrder().get(0));
        for (Object a : output) {
            System.out.print(a.toString() + " ");
        }
    }
}



