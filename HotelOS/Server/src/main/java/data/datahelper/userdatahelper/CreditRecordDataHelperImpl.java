package data.datahelper.userdatahelper;

import data.datahelper.DataHelperParent;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/30/2016.
 */
public class CreditRecordDataHelperImpl extends DataHelperParent implements CreditRecordDataHelper {

    private final static String CR_TABLENAME = TableName.credit_record.toString();


    @Override
    public ResultMessage insertToSQL(ArrayList<Object> crInfo) {
        return insertToSQL(CR_TABLENAME, crInfo);
    }

    @Override
    public ArrayList<ArrayList<Object>> findFromSQL() {
        return findFromSQL(CR_TABLENAME);
    }

    @Override
    public ArrayList<Object> findByIDFromSQL(long crID) {
        return findFromSQLById(CR_TABLENAME, crID);
    }
}
