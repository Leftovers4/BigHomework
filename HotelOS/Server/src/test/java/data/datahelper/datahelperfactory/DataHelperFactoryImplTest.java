package data.datahelper.datahelperfactory;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/3/2016.
 */
public class DataHelperFactoryImplTest {

    DataHelperFactoryImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new DataHelperFactoryImpl();
    }

    @Test
    public void getHotelDataHelper() throws Exception {
        tested.getHotelDataHelper();
    }

    @Test
    public void getRoomDataHelper() throws Exception {
        tested.getRoomDataHelper();
    }

    @Test
    public void getHotelImageHelper() throws Exception {
        tested.getHotelImageHelper();
    }

    @Test
    public void getOrderDataHelper() throws Exception {
        tested.getOrderDataHelper();
    }

    @Test
    public void getPersonnelDataHelper() throws Exception {
        tested.getPersonnelDataHelper();
    }

    @Test
    public void getPromotionDataHelper() throws Exception {
        tested.getPromotionDataHelper();
    }

    @Test
    public void getUserDataHelper() throws Exception {
        tested.getUserDataHelper();
    }

    @Test
    public void getCreditRecordDataHelper() throws Exception {
        tested.getCreditRecordDataHelper();
    }

    @Test
    public void getUserImageHelper() throws Exception {
        tested.getUserImageHelper();
    }

}