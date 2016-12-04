package data.dao.hoteldata;

import javafx.beans.property.ReadOnlySetProperty;
import org.junit.Before;
import org.junit.Test;
import po.hotel.HotelPO;
import po.hotel.RoomPO;
import util.CommonMethod;
import util.POProducer;
import util.ResultMessage;

import java.util.ArrayList;

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
        System.out.println(resultMessage.toString());
    }

    @Test
    public void update() throws Exception {
        HotelPO hotelPO = POProducer.getHotelPO();
        hotelPO.setDescription("已修改的描述");
        ResultMessage resultMessage = tested.update(hotelPO);
        System.out.println(resultMessage.toString());
    }

    @Test
    public void findAll() throws Exception {
        ArrayList<HotelPO> hotelPOs = tested.findAll();
        for (HotelPO each : hotelPOs) {
            CommonMethod.printClass(each);
        }


    }

    @Test
    public void findByHotelID() throws Exception {
        HotelPO hotelPO = tested.findByHotelID(POProducer.getHotelPO().getHotelID());
        CommonMethod.printClass(hotelPO);

    }

    @Test
    public void findRoomsByHotelID() throws Exception {
        ArrayList<RoomPO> roomPOs = tested.findRoomsByHotelID(POProducer.getHotelPO().getHotelID());
        for (RoomPO each : roomPOs) {
            CommonMethod.printClass(each);
        }
    }

    @Test
    public void findRoomsByID() throws Exception {
        RoomPO roomPO = tested.findRoomsByID(POProducer.getRoomPO().getroomID());
        if(roomPO != null){
            CommonMethod.printClass(roomPO);
        }


    }

    @Test
    public void insertRoom() throws Exception {
        ResultMessage resultMessage = tested.insertRoom(POProducer.getRoomPO());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void deleteRoom() throws Exception {
        ResultMessage resultMessage = tested.deleteRoom(POProducer.getRoomPO().getroomID());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void updateRoom() throws Exception {
        RoomPO roomPO = POProducer.getRoomPO();
        roomPO.setTotal(1000);
        ResultMessage resultMessage = tested.updateRoom(roomPO);
        System.out.println(resultMessage.toString());
    }

    @Test
    public void getImage() throws Exception {
        // TODO
    }

    @Test
    public void setImage() throws Exception {
        // TODO
    }

}