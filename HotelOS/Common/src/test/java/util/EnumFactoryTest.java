package util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 11/26/2016.
 */
public class EnumFactoryTest {


    @Test
    public void getEnum() throws Exception {
        System.out.print(EnumFactory.getEnum("None"));
    }

    @Test
    public void getString() throws Exception {
        System.out.println(EnumFactory.getString(RoomType.BusinessSuite));
    }

}