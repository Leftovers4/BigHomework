package data.datahelper.orderdatahelper;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 11/26/2016.
 */
public class OrderDataHelperImplTest {

    OrderDataHelperImpl tested;

    @Before
    public void setUp() throws Exception{
        tested = new OrderDataHelperImpl();
    }



    @Test
    public void findByIdFromSQL() throws Exception {

    }

    @Test
    public void findByConditionsFromSQL() throws Exception {

    }



    @Test
    public void insertToSQL() throws Exception {
        ArrayList<Object> orderInfo = new ArrayList<>();
        orderInfo.add("45454148498");
        orderInfo.add(522000);
        orderInfo.add("Hiki");
        orderInfo.add("Abnormal");
        orderInfo.add("榕江大酒店");
        orderInfo.add("Single");
        orderInfo.add(1);
        orderInfo.add("511");
        orderInfo.add(2);
        orderInfo.add(true);
        orderInfo.add("2012-12-12 11:11:11");
        orderInfo.add("2012-12-12 11:11:11");
        orderInfo.add("2012-12-12 11:11:11");
        orderInfo.add("2012-12-12 11:11:11");
        orderInfo.add("2012-12-12 11:11:11");
        orderInfo.add("2012-12-12 11:11:11");
        orderInfo.add("2012-12-12 11:11:11");
        orderInfo.add(100);
        orderInfo.add(80);
        orderInfo.add("2012-12-12 11:11:11");
        orderInfo.add(1);
        orderInfo.add("Good");
        orderInfo.add("2012-12-12 11:11:11");
        orderInfo.add("All");

        System.out.print(tested.insertToSQL(orderInfo));

    }

    @Test
    public void updateFromSQL() throws Exception {

    }

    @Test
    public void findFromSQL() throws Exception {

    }

}