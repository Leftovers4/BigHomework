package data.datahelper.hoteldatahelper;

import util.ResultMessage;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Hiki on 11/26/2016.
 */
public interface HotelImageHelper {

    /**
     * 找出酒店图片，若酒店图片不存在，返回null
     * @param hotelID
     * @return
     */
    public byte[] findHotelImageByHotelID(long hotelID);


    /**
     * 在文件夹中增加（或更新）酒店图片
     * @param imageBytes
     * @return
     */
    public ResultMessage setHotelImage(long hotelID, byte[] imageBytes);

}
