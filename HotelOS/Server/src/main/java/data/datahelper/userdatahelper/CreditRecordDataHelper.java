package data.datahelper.userdatahelper;

import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/30/2016.
 */
public interface CreditRecordDataHelper {

    // 格式："record_id", "username", "current_credit", "changed_credit", "changed_time", "cause", "order_id"


    /**
     * 在credit_record表中插入一条信用记录
     * @param crInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> crInfo);


//    /**
//     * 在credit_record表中删除一条信用记录
//     * @param crID
//     * @return
//     */
//    public ResultMessage deleteFromSQL(long crID);

//    /**
//     * 在credit_record表中更新一条信用记录
//     * @param crInfo
//     * @return
//     */
//    public ResultMessage updateFromSQL(ArrayList<Object> crInfo);

    /**
     * 在credit_record表中查找所有信用记录
     * @return
     */
    public ArrayList<ArrayList<Object>> findFromSQL();


    /**
     * 在credit_record表中根据id查找一条信用记录
     * @param crID
     * @return
     */
    public ArrayList<Object> findByIDFromSQL(long crID);

}
