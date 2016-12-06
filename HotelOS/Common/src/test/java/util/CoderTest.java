package util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/6/2016.
 */
public class CoderTest {

    @Test
    @Before
    public void encode() throws Exception {
        System.out.println(Coder.decode(""));
    }

    @Test
    public void decode() throws Exception {
        System.out.println(Coder.decode(Coder.encode("")));
    }

}