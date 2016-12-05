package data.datahelper.userdatahelper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/3/2016.
 */
public class UserImageHelperImplTest {

    UserImageHelperImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new UserImageHelperImpl();
    }

    @Test
    public void findUserImageByUsername() throws Exception {
        byte[] result = tested.findUserImageByUsername("test");
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i]);
        }
    }

    @Test
    public void setUserImage() throws Exception {
        byte[] input = tested.findUserImageByUsername("test");
        System.out.println(tested.setUserImage("testSet ", input));

    }




}