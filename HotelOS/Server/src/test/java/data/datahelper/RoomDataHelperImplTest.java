package data.datahelper;

import data.datahelper.hoteldatahelper.RoomDataHelperImpl;
import org.junit.Before;
import org.junit.Test;
import util.ResultMessage;
import util.RoomType;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/22/2016.
 */
public class RoomDataHelperImplTest {

    RoomDataHelperImpl tested;

    @Before
    public void setUp(){
        tested = new RoomDataHelperImpl();
    }


    @Test
    public void testInsertToSQL(){
        ArrayList<Object> input = new ArrayList<>();
        input.add(110111);
        input.add(522000);
        input.add(RoomType.Single.toString());
        input.add(5);
        input.add(3);
        input.add(52.0);

        ResultMessage result = tested.insertToSQL(input);
        System.out.println(result.toString());
    }

    @Test
    public void testUpdateFromSQL(){
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
    public void testDeleteFromSQL(){
        ResultMessage result = tested.deleteFromSQL(110111);
        System.out.println(result.toString());

    }


}
