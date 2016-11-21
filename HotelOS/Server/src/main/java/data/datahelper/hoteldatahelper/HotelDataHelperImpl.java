package data.datahelper.hoteldatahelper;

import data.datahelper.DataHelperParent;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public class HotelDataHelperImpl extends DataHelperParent implements HotelDataHelper{

    private static final String HOTEL_TABLENAME = TableName.hotel.toString();
    private static final String ROOM_TABLENAME = TableName.room.toString();

    @Override
    public ArrayList<Object> findByIdFromSQL(long hotelID) {
        return findFromSQLById(HOTEL_TABLENAME, hotelID);
    }

    @Override
    public ArrayList<ArrayList<Object>> findByConditionsFromSQL(ArrayList<Object> hotelInfo) {
        return findFromSQLByConditions(HOTEL_TABLENAME, hotelInfo);
    }

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
    public ArrayList<ArrayList<Object>> findRoomsByHotelIdFromSQL(long hotelID) {
        // TODO 注意此处依赖与room具体表的列的内容
        ArrayList<Object> builtConditions = new ArrayList<>();
        builtConditions.add("%");
        builtConditions.add(hotelID);
        builtConditions.add("%");
        builtConditions.add("%");
        builtConditions.add("%");
        builtConditions.add("%");

        return findFromSQLByConditions(ROOM_TABLENAME, builtConditions);
    }
}
