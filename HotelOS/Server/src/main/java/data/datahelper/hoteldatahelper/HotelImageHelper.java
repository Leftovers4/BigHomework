package data.datahelper.hoteldatahelper;

import util.ResultMessage;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Hiki on 11/26/2016.
 */
public interface HotelImageHelper {

    // 格式："hotel_id", "image_reference"

    /**
     * 根据酒店ID从hotel_image表中查找酒店图片
     * @param hotelID
     * @return
     */
    public ArrayList<Object> findByIdFromSQL(long hotelID);


    /**
     * 往hotel_image表中插入一条酒店图片信息
     * @param hotelImageInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> hotelImageInfo);

}
