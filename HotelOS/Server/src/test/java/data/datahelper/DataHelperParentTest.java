package data.datahelper;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import util.MemberType;
import util.PersonnelType;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Hiki on 11/19/2016.
 */
public class DataHelperParentTest {

    DataHelperParent tested;

    @Before
    public void setUp() throws Exception {
        tested = new DataHelperParent();
    }

    @Test
    public void testAddToSQL(){
        ArrayList<Object> input = new ArrayList<Object>();
        input.add(120110);
        input.add("password");
        input.add(PersonnelType.HOTEL_WORKER.toString());
        input.add(null);
        ResultMessage result = tested.insertToSQL("personnel", input);
        System.out.println(result.toString());
    }

    @Test
    public void testAddToSQL2(){
        ArrayList<Object> input = new ArrayList<Object>();
        input.add("Hiki");
        input.add("123456");
        input.add("GHB");
        input.add(0);
        input.add("110");
        input.add(MemberType.NONE.toString());
        input.add(1);
        input.add(new Date());
        input.add(null);
        ResultMessage result = tested.insertToSQL("user", input);
        System.out.println(result.toString());


    }


    @Test
    public void testDelFromSQL(){
        ResultMessage result = tested.delFromSQL("personnel", 110110);
        System.out.println(result.toString());
    }

    @Test
    public void testUpdateFromSQL(){
        ArrayList<Object> input = new ArrayList<Object>();
        input.add(120120);
        input.add("pass");
        input.add(PersonnelType.HOTEL_WORKER.toString());
        input.add(null);

        ResultMessage result = tested.updateFromSQL("personnel", input);
        System.out.println(result.toString());

    }

    @Test
    public void testFindFromSQLById(){
        ArrayList<Object> result = tested.findFromSQLById("personnel", "120120");
        if(result != null){
            long personnel_id = (long)result.get(0);
            String password = (String)result.get(1);
            String type = (String)result.get(2);
            System.out.println(personnel_id + " " + password + " " + type);
        }
        else{
            System.out.println("Result is null.");
        }

    }

    @Test
    public void testFindFromSQLById2(){
        ArrayList<Object> result = tested.findFromSQLById("user", "Hiki");
//        System.out.println(result.get(0).toString());
    }

    @Test
    public void testFindFromSQL(){
        ArrayList<ArrayList<Object>> resultContent = tested.findFromSQL("personnel");
        System.out.println(resultContent.get(0).get(2).toString());

    }

    @Test
    public void testFindFromSQLByType(){
        ArrayList<ArrayList<Object>> resultContent = tested.findFromSQLByType("personnel", PersonnelType.HOTEL_WORKER.toString());
        System.out.println(resultContent.get(0).get(2).toString());
        System.out.println(resultContent.get(1).get(2).toString());
        System.out.println(resultContent.get(2).get(2).toString());
//        System.out.println(resultContent.get(3).get(2).toString());

    }

    @Test
    @Ignore
    public void testBuildFindByConditionsSQL(){
        String sql = tested.buildFindByConditionsSQL("personnel");
        System.out.println(sql);
    }

    @Test
    public void testFindFromSQLByConditions(){
        ArrayList<Object> input = new ArrayList<>();
        input.add("%");
        input.add("password");
        input.add(PersonnelType.HOTEL_WORKER.toString());
        input.add("%");
        ArrayList<ArrayList<Object>> resultContent = tested.findFromSQLByConditions("personnel", input);
        for (ArrayList<Object> each : resultContent) {
            for (Object a: each) {
                System.out.print(a.toString() + " ");
            }
            System.out.println();
        }

    }



}
