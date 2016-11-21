package data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.impl;

import data.datahelper.DataHelperParent;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.EnterpriseDataHelper;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public class EnterpriseDataHelperImpl extends DataHelperParent implements EnterpriseDataHelper{

    private final static String ENTERPRISE_TABLENAME = TableName.enterprise.toString();

    @Override
    public ResultMessage insertToSQL(ArrayList<Object> entInfo) {
        return insertToSQL(ENTERPRISE_TABLENAME, entInfo);
    }

    @Override
    public ResultMessage deleteFromSQL(long matchID) {
        return delFromSQL(ENTERPRISE_TABLENAME, matchID);
    }

    @Override
    public ResultMessage updateFromSQL(ArrayList<Object> entInfo) {
        return updateFromSQL(ENTERPRISE_TABLENAME, entInfo);
    }

    @Override
    public ArrayList<ArrayList<Object>> findFromSQL() {
        return findFromSQL(ENTERPRISE_TABLENAME);
    }

    @Override
    public ArrayList<Object> findByIdFromSQL(long matchID) {
        return findFromSQLById(ENTERPRISE_TABLENAME, matchID);
    }
}
