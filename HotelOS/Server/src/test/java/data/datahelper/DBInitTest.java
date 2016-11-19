package data.datahelper;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Hiki on 11/18/2016.
 */
public class DBInitTest {

    DBInit tested;

    @Before
    public void setUp() throws Exception {
        tested = new DBInit();
    }

    @Test
    public void testConnect(){
        tested.connect();
    }

    @Test
    public void testConnection(){
        tested.connection();
    }

    @Test
    public void testDisconnect(){
        tested.disconnect();
    }

}
