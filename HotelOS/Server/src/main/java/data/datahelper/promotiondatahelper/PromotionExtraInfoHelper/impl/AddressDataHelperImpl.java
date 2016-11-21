package data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.impl;

import data.datahelper.DataHelperParent;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.AddressDataHelper;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public class AddressDataHelperImpl extends DataHelperParent implements AddressDataHelper{

    private final static String ADDRESS_TABLENAME = TableName.address.toString();

    @Override
    public ResultMessage insertToSQL(ArrayList<Object> addInfo) {
        return insertToSQL(ADDRESS_TABLENAME, addInfo);
    }

    @Override
    public ResultMessage deleteFromSQL(long addressID) {
        return delFromSQL(ADDRESS_TABLENAME, addressID);
    }

    @Override
    public ResultMessage updateFromSQL(ArrayList<Object> addInfo) {
        return updateFromSQL(ADDRESS_TABLENAME, addInfo);
    }

    @Override
    public ArrayList<ArrayList<Object>> findFromSQL() {
        return findFromSQL(ADDRESS_TABLENAME);
    }

    @Override
    public ArrayList<Object> findByIdFromSQL(long addressID) {
        return findFromSQLById(ADDRESS_TABLENAME, addressID);
    }
}
