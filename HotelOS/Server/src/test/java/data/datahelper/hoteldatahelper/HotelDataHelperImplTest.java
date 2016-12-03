package data.datahelper.hoteldatahelper;

import org.junit.Before;
import org.junit.Test;
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
        ArrayList<Object> input = new ArrayList<>();
        input.add(522000);
        input.add("榕江大酒店");
        input.add(5);
        input.add("广东揭阳");
        input.add("东山");
        input.add("包吃包住");
        input.add("没有特殊服务");
        ResultMessage result = tested.insertToSQL(input);
        System.out.println(result.toString());
    }

    @Test
    public void deleteFromSQL() throws Exception {

    }

    @Test
    public void updateFromSQL() throws Exception {
        ArrayList<Object> input = new ArrayList<>();
        input.add(522001);
        input.add("榕江中酒店");
        input.add(3);
        input.add("广东潮汕");
        input.add("东山");
        input.add("包吃包住");
        input.add("没有特殊服务");
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
        ArrayList<Object> output = tested.findByIdFromSQL(522000);
        for (Object a : output) {
            System.out.print(a.toString() + " ");
        }
    }

}