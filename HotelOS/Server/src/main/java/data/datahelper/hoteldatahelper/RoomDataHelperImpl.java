package data.datahelper.hoteldatahelper;

import data.datahelper.DataHelperParent;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/22/2016.
 */
public class RoomDataHelperImpl extends DataHelperParent implements RoomDataHelper{

    private static final String ROOM_TABLENAME = TableName.room.toString();


    @Override
    public ResultMessage insertToSQL(ArrayList<Object> roomInfo) {
        return insertToSQL(ROOM_TABLENAME, roomInfo);
    }

    @Override
    public ResultMessage deleteFromSQL(long roomID) {
        return delFromSQL(ROOM_TABLENAME, roomID);
    }

    @Override
    public ResultMessage updateFromSQL(ArrayList<Object> roomInfo) {
        return updateFromSQL(ROOM_TABLENAME, roomInfo);
    }

    @Override
    public ArrayList<ArrayList<Object>> findFromSQL() {
        return findFromSQL(ROOM_TABLENAME);
    }

    @Override
    public ArrayList<Object> findByIDFromSQL(long roomID) {
        return findFromSQLById(ROOM_TABLENAME, roomID);
    }


//    @Override
//    public ArrayList<ArrayList<Object>> findRoomsByHotelIdFromSQL(long hotelID) {
//        // TODO 注意此处依赖与room具体表的列的内容
//        ArrayList<Object> builtConditions = new ArrayList<>();
//        builtConditions.add("%");
//        builtConditions.add(hotelID);
//        builtConditions.add("%");
//        builtConditions.add("%");
//        builtConditions.add("%");
//        builtConditions.add("%");
//
//        return findFromSQLByConditions(ROOM_TABLENAME, builtConditions);
//    }





}
