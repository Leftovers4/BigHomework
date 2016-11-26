package data.datahelper.orderdatahelper;

import data.datahelper.DataHelperParent;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public class OrderDataHelperImpl extends DataHelperParent implements OrderDataHelper{

    private final static String ORDER_TABLENAME = TableName.order_info.toString();

    @Override
    public ArrayList<Object> findByIdFromSQL(String orderID) {
        return findFromSQLById(ORDER_TABLENAME, orderID);
    }

    @Override
    public ArrayList<ArrayList<Object>> findByConditionsFromSQL(ArrayList<Object> orderInfo) {
        return findFromSQLByConditions(ORDER_TABLENAME, orderInfo);
    }

    @Override
    public ArrayList<ArrayList<Object>> findByHotelIDFromSQL(long hotelID) {
        // TODO 注意此处依赖与order具体表的列的内容
        ArrayList<Object> builtConditions = new ArrayList<>();
        builtConditions.add("%");
        builtConditions.add(hotelID);
        for(int i = 0; i < 22; i++){
            builtConditions.add("%");
        }
        return findFromSQLByConditions(ORDER_TABLENAME, builtConditions);

    }

    @Override
    public ResultMessage insertToSQL(ArrayList<Object> orderInfo) {
        return insertToSQL(ORDER_TABLENAME, orderInfo);
    }

    @Override
    public ResultMessage updateFromSQL(ArrayList<Object> orderInfo) {
        return updateFromSQL(ORDER_TABLENAME, orderInfo);
    }

    @Override
    public ArrayList<ArrayList<Object>> findFromSQL() {
        return findFromSQL(ORDER_TABLENAME);
    }


}
