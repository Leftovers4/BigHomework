package data.datahelper.addressdatahelper;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/10/2016.
 */
public class AddressDataHelperImplTest {

    AddressDataHelperImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new AddressDataHelperImpl();
    }

    @Test
    public void findAllCities() throws Exception {
        ArrayList<String> result = tested.findAllCities();

        for (String each : result) {
            System.out.println(each + " ");
        }

    }

    @Test
    public void findTradingAreaByCity() throws Exception {
        ArrayList<String> result = tested.findTradingAreaByCity("南京市");

        for (String each : result) {
            System.out.println(each + " ");
        }
    }

}