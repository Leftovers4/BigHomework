package data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.impl;

import data.datahelper.DataHelperParent;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.MemberRegulationDataHelper;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public class MemberRegulationDataHelperImpl extends DataHelperParent implements MemberRegulationDataHelper{

    private final static String MR_TABLENAME = TableName.member_regulation.toString();

    @Override
    public ResultMessage insertToSQL(ArrayList<Object> mrInfo) {
        return insertToSQL(MR_TABLENAME, mrInfo);
    }

    @Override
    public ResultMessage deleteFromSQL(long level) {
        return delFromSQL(MR_TABLENAME, level);
    }

    @Override
    public ResultMessage updateFromSQL(ArrayList<Object> mrInfo) {
        return updateFromSQL(MR_TABLENAME, mrInfo);
    }

    @Override
    public ArrayList<ArrayList<Object>> findFromSQL() {
        return findFromSQL(MR_TABLENAME);
    }

    @Override
    public ArrayList<Object> findByLevelFromSQL(long level) {
        return findFromSQLById(MR_TABLENAME, level);
    }
}
