package data.datahelper;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/5/2016.
 */
public class ImageHelperParentTest {

    ImageHelperParent tested;

    @Before
    public void setUp() throws Exception {
        tested = new ImageHelperParent();
    }

    @Test
    public void findImageByID() throws Exception {
        byte[] result = tested.findImageByID("F:\\AnimePic\\", 110110110);
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i]);
        }
    }

    @Test
    @Ignore
    public void setImage() throws Exception {
        byte[] input = tested.findImageByID("F:\\AnimePic\\", "1920_1080_20120107124238690836");
        System.out.println(tested.setImage("C:\\Leftovers\\server\\userImage\\", "testpng", input));
    }

    @Test
    @Ignore
    public void createDirIfNotExisted() throws Exception {
        tested.createDirIfNotExisted("C:/Leftovers/server/userImage");
    }

}