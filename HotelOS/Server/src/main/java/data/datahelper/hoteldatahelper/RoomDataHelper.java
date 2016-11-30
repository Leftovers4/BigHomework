package data.datahelper.hoteldatahelper;

import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/22/2016.
 */
public interface RoomDataHelper {

    // 格式："room_id", "hotel_id", "room_type", "total", "available", "price"

    /**
     * 往room表中插入一条room信息
     * @param roomInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> roomInfo);

    /**
     * 在room表中删除一条room信息
     * @param roomID
     * @return
     */
    public ResultMessage deleteFromSQL(long roomID);


    /**
     * 在room表中更新一条room信息
     * @param roomInfo
     * @return
     */
    public ResultMessage updateFromSQL(ArrayList<Object> roomInfo);


    /**
     * 在room表中查找所有的room列表
     * @return
     */
    public ArrayList<ArrayList<Object>> findFromSQL();




}
