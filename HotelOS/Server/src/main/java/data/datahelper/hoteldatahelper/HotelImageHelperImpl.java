package data.datahelper.hoteldatahelper;

import data.datahelper.DataHelperParent;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/26/2016.
 */
public class HotelImageHelperImpl extends DataHelperParent implements HotelImageHelper {

    private final static String HOTELIMAGE_TABLENAME = TableName.hotel_image.toString();

    @Override
    public ArrayList<Object> findByIdFromSQL(long hotelID) {
        return findFromSQLById(HOTELIMAGE_TABLENAME, hotelID);

    }

    @Override
    public ResultMessage insertToSQL(ArrayList<Object> hotelImageInfo) {
        return insertToSQL(HOTELIMAGE_TABLENAME, hotelImageInfo);
    }
}
