package bl.hotelbl;

import org.junit.Before;
import org.junit.Test;
import vo.hotel.HotelVO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/11/25.
 */
public class HotelListTest {

    HotelList tested;
    List<HotelVO> hotelVOs;

    @Before
    public void setUp() throws Exception {
        hotelVOs = new ArrayList<>();

        HotelVO hotelVO1 = new HotelVO(1, 200, 4.5);
        HotelVO hotelVO2 = new HotelVO(2, 152, 3);
        HotelVO hotelVO3 = new HotelVO(3, 263, 2.1);
        HotelVO hotelVO4 = new HotelVO(4, 100, 4.6);
        HotelVO hotelVO5 = new HotelVO(5, 90, 4.9);
        HotelVO hotelVO6 = new HotelVO(6, 500, 1.7);
        HotelVO hotelVO7 = new HotelVO(7, 1000, 3.8);

        hotelVOs.add(hotelVO1);
        hotelVOs.add(hotelVO2);
        hotelVOs.add(hotelVO3);
        hotelVOs.add(hotelVO4);
        hotelVOs.add(hotelVO5);
        hotelVOs.add(hotelVO6);
        hotelVOs.add(hotelVO7);
    }

    @Test
    public void sort() throws Exception {
        tested = new HotelList(hotelVOs);
        tested.sort("price", 0);
    }

}