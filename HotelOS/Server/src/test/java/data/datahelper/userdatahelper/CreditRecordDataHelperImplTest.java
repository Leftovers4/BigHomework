package data.datahelper.userdatahelper;

import org.junit.Before;
import org.junit.Test;
import util.ALProducer;
import util.ResultMessage;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/3/2016.
 */
public class CreditRecordDataHelperImplTest {

    CreditRecordDataHelperImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new CreditRecordDataHelperImpl();
    }

    @Test
    public void insertToSQL() throws Exception {
        ArrayList<Object> input = ALProducer.getCreditRecord();
        ResultMessage result = tested.insertToSQL(input);
        System.out.println(result.toString());
    }

    @Test
    public void findFromSQL() throws Exception {
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
    public void findByIDFromSQL() throws Exception {
        ArrayList<Object> output = tested.findByIDFromSQL((long)ALProducer.getCreditRecord().get(0));
        for (Object a : output) {
            System.out.print(a.toString() + " ");
        }
    }

}