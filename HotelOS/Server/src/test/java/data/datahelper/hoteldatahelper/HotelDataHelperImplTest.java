package data.datahelper.hoteldatahelper;

import org.junit.Before;
import org.junit.Test;
import util.ALProducer;
import util.ResultMessage;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/3/2016.
 */
public class HotelDataHelperImplTest {

    HotelDataHelperImpl tested;

    @Before
    public void setUp(){
        tested = new HotelDataHelperImpl();
    }

    @Test
    public void insertToSQL() throws Exception {
        ArrayList<Object> input = ALProducer.getHotel();
        ResultMessage result = tested.insertToSQL(input);
        System.out.println(result.toString());
    }

    @Test
    public void deleteFromSQL() throws Exception {
        ResultMessage result = tested.deleteFromSQL((long)ALProducer.getHotel().get(0));
        System.out.println(result.toString());
    }

    @Test
    public void updateFromSQL() throws Exception {
        ArrayList<Object> input = ALProducer.getHotel();
        input.set(6, "有特殊服务");
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
//        System.out.println((long)ALProducer.getHotel().get(0));
        ArrayList<Object> output = tested.findByIdFromSQL((long)ALProducer.getHotel().get(0));
        for (Object a : output) {
            System.out.print(a.toString() + " ");
        }
    }

}