package bl.hotelbl;

import bl.hotelbl.impl.HotelList;
import bl.hotelbl.impl.HotelVOList;
import org.junit.Before;
import org.junit.Test;
import vo.hotel.HotelVO;
import vo.hotel.HotelVOCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/25.
 */
public class HotelListTest {

    HotelVOList tested;
    HotelVOCreator logicVOHelper = new HotelVOCreator();
    List<HotelVO> hotelVOs;

    @Before
    public void setUp() throws Exception {
        hotelVOs = new ArrayList<>();

        HotelVO hotelVO1 = logicVOHelper.create(1, 200, 4.5);
        HotelVO hotelVO2 = logicVOHelper.create(2, 152, 3);
        HotelVO hotelVO3 = logicVOHelper.create(3, 263, 2.1);
        HotelVO hotelVO4 = logicVOHelper.create(4, 100, 4.6);
        HotelVO hotelVO5 = logicVOHelper.create(5, 90, 4.9);
        HotelVO hotelVO6 = logicVOHelper.create(6, 500, 1.7);
        HotelVO hotelVO7 = logicVOHelper.create(7, 1000, 3.8);

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
        tested = new HotelVOList(hotelVOs);
        tested.sort("price", 0);
    }

}