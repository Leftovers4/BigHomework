package data.dao.hoteldata;

import javafx.beans.property.ReadOnlySetProperty;
import org.junit.Before;
import org.junit.Test;
import util.POProducer;
import util.ResultMessage;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/4/2016.
 */
public class HotelDataServiceImplTest {

    HotelDataServiceImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new HotelDataServiceImpl();
    }

    @Test
    public void insert() throws Exception {
        ResultMessage resultMessage = tested.insert(POProducer.getHotelPO());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void delete() throws Exception {
        ResultMessage resultMessage = tested.delete(POProducer.getHotelPO().getHotelID());
    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

    @Test
    public void findByHotelID() throws Exception {

    }

    @Test
    public void findRoomsByHotelID() throws Exception {

    }

    @Test
    public void findRoomsByID() throws Exception {

    }

    @Test
    public void insertRoom() throws Exception {

    }

    @Test
    public void deleteRoom() throws Exception {

    }

    @Test
    public void updateRoom() throws Exception {

    }

    @Test
    public void getImage() throws Exception {

    }

    @Test
    public void setImage() throws Exception {

    }

}