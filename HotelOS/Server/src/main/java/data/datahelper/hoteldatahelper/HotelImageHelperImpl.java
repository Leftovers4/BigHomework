package data.datahelper.hoteldatahelper;

import data.datahelper.ImageHelperParent;
import util.ResultMessage;

/**
 * Created by Hiki on 12/5/2016.
 */
public class HotelImageHelperImpl extends ImageHelperParent implements HotelImageHelper{

    private final static String HotelImageDir = "C:\\Leftovers\\server\\hotelImage\\";


    @Override
    public byte[] findHotelImageByHotelID(long hotelID) {
        return findImageByID(HotelImageDir, hotelID);
    }

    @Override
    public ResultMessage setHotelImage(long hotelID, byte[] imageBytes) {
        return setImage(HotelImageDir, hotelID, imageBytes);
    }
}
