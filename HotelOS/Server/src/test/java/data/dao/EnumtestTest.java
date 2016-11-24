package data.dao;

import data.dao._poalfactory.impl.Enumtest;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Hiki on 11/24/2016.
 */
public class EnumtestTest {

    Enumtest tested;

    @Before
    public void setUp(){

    }

    @Test
    public void testGetType(){
//        Enumtest a = tested.getType("BOTH");
        System.out.println(Enumtest.getType("BOTH"));
    }


}
