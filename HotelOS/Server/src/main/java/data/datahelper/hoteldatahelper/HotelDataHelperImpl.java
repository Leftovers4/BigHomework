package data.datahelper.hoteldatahelper;

import data.datahelper.DataHelperParent;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public class HotelDataHelperImpl extends DataHelperParent implements HotelDataHelper{

    // 格式："hotel_id", "hotel_name", "star", "address", "trading_area", "description", "service"

    private static final String HOTEL_TABLENAME = TableName.hotel.toString();


    @Override
    public ResultMessage insertToSQL(ArrayList<Object> hotelInfo) {
        return insertToSQL(HOTEL_TABLENAME, hotelInfo);
    }

    @Override
    public ResultMessage deleteFromSQL(long hotelID) {
        return delFromSQL(HOTEL_TABLENAME, hotelID);
    }

    @Override
    public ResultMessage updateFromSQL(ArrayList<Object> hotelInfo) {
        return updateFromSQL(HOTEL_TABLENAME, hotelInfo);
    }

    @Override
    public ArrayList<ArrayList<Object>> findFromSQL() {
        return findFromSQL(HOTEL_TABLENAME);
    }

    @Override
    public ArrayList<Object> findByIdFromSQL(long hotelID) {
        return findFromSQLById(HOTEL_TABLENAME, hotelID);
    }





    //    @Override
//    public ArrayList<ArrayList<Object>> findByConditionsFromSQL(ArrayList<Object> hotelInfo) {
//        return findFromSQLByConditions(HOTEL_TABLENAME, hotelInfo);
//    }


}
