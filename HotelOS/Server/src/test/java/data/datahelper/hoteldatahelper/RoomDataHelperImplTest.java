package data.datahelper.hoteldatahelper;

import org.junit.Before;
import org.junit.Test;
import util.ALProducer;
import util.ResultMessage;
import util.RoomType;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/3/2016.
 */
public class RoomDataHelperImplTest {

    RoomDataHelperImpl tested;

    @Before
    public void setUp(){
        tested = new RoomDataHelperImpl();
    }

    @Test
    public void insertToSQL() throws Exception {
        ArrayList<Object> input = ALProducer.getRoom();
        ResultMessage result = tested.insertToSQL(input);
        System.out.println(result.toString());
    }

    @Test
    public void deleteFromSQL() throws Exception {
        ResultMessage result = tested.deleteFromSQL(110111);
        System.out.println(result.toString());
    }

    @Test
    public void updateFromSQL() throws Exception {
        ArrayList<Object> input = new ArrayList<>();
        input.add(110110);
        input.add(522000);
        input.add(RoomType.Single.toString());
        input.add(5);
        input.add(2);
        input.add(52.0);

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
    public void findByIDFromSQL() throws Exception {
        ArrayList<Object> output = tested.findByIDFromSQL((long)ALProducer.getRoom().get(0));
        for (Object a : output) {
            System.out.print(a.toString() + " ");
        }
    }

}