package data.datahelper.personneldatahelper;

import org.junit.Before;
import org.junit.Test;
import util.ALProducer;
import util.ResultMessage;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/3/2016.
 */
public class PersonnelDataHelperImplTest {

    PersonnelDataHelperImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new PersonnelDataHelperImpl();
    }

    @Test
    public void insertToSQL() throws Exception {
        ArrayList<Object> input = ALProducer.getPersonnel();
        ResultMessage result = tested.insertToSQL(input);
        System.out.println(result.toString());

    }

    @Test
    public void deleteFromSQL() throws Exception {
        ResultMessage result = tested.deleteFromSQL((long)ALProducer.getPersonnel().get(0));
        System.out.println(result.toString());
    }

    @Test
    public void updateFromSQL() throws Exception {
        ArrayList<Object> input = ALProducer.getPersonnel();
        input.set(3, "leftovers03");
        ResultMessage result = tested.updateFromSQL(input);
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
    public void findByIdFromSQL() throws Exception {
        ArrayList<Object> output = tested.findByIdFromSQL((long)ALProducer.getPersonnel().get(0));
        for (Object a : output) {
            System.out.print(a.toString() + " ");
        }
    }

}