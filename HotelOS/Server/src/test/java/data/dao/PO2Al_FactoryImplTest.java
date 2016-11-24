package data.dao;

import data.dao._poalfactory.impl.Po2Al_FactoryImpl;
import org.junit.Before;
import org.junit.Test;
import util.PersonnelType;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Hiki on 11/24/2016.
 */
public class PO2Al_FactoryImplTest {

    Po2Al_FactoryImpl tested;

    @Before
    public void setUp(){
        tested = new Po2Al_FactoryImpl();
    }

    @Test
    public void testTypeToString(){
        System.out.println(tested.toString(LocalDateTime.now()));

    }

}
