package data.datahelper;

import data.datahelper.hoteldatahelper.HotelDataHelper;
import data.datahelper.hoteldatahelper.HotelDataHelperImpl;
import org.junit.Before;
import org.junit.Test;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/22/2016.
 */
public class HotelDataHelperImplTest {

    HotelDataHelperImpl tested;

    @Before
    public void setUp(){
        tested = new HotelDataHelperImpl();
    }

    @Test
    public void testInsertToSQL(){
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
    public void testUpdateFromSQL(){
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
    public void testFindFromSQL(){
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
    public void testFindByIdFromSQL(){
        ArrayList<Object> output = tested.findByIdFromSQL(522000);
        for (Object a : output) {
            System.out.print(a.toString() + " ");
        }
    }

    @Test
    public void testFindByConditionsFromSQL(){
        ArrayList<Object> input = new ArrayList<>();
        input.add("%");
        input.add("%");
        input.add("%");
        input.add("广东揭阳");
        input.add("%");
        input.add("包吃包住");
        input.add("%");

        ArrayList<ArrayList<Object>> output = tested.findByConditionsFromSQL(input);
        for (ArrayList<Object> each : output) {
            for (Object a : each) {
                System.out.print(a.toString() + " ");
            }
            System.out.println();
        }

    }




}
