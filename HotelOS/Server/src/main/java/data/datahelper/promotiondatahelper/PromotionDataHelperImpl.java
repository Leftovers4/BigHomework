package data.datahelper.promotiondatahelper;

import data.datahelper.DataHelperParent;
import util.PromotionType;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public class PromotionDataHelperImpl extends DataHelperParent implements PromotionDataHelper{

    private final static String PROMOTION_TABLENAME = TableName.promotion.toString();

    @Override
    public ArrayList<ArrayList<Object>> findByHotelIdFromSQL(long hotelID) {

        // 构造出条件列表
        ArrayList<Object> conditions = new ArrayList<>();
        conditions.add("%"); conditions.add("%");
        conditions.add(hotelID);
        conditions.add("%"); conditions.add("%"); conditions.add("%"); conditions.add("%");

        return findFromSQLByConditions(PROMOTION_TABLENAME, conditions);


    }

    @Override
    public ArrayList<ArrayList<Object>> findByTypeFromSQL(PromotionType promotionType) {
        return findFromSQLByType(PROMOTION_TABLENAME, promotionType.toString());
    }

    @Override
    public ArrayList<Object> findByIdFromSQL(long promotionID) {
        return findFromSQLById(PROMOTION_TABLENAME, promotionID);
    }

    @Override
    public ResultMessage insertToSQL(ArrayList<Object> promotionInfo) {
        return insertToSQL(PROMOTION_TABLENAME, promotionInfo);
    }

    @Override
    public ResultMessage deleteFromSQL(long promotionID) {
        return delFromSQL(PROMOTION_TABLENAME, promotionID);
    }

    @Override
    public ResultMessage updateFromSQL(ArrayList<Object> promotionInfo) {
        return updateFromSQL(PROMOTION_TABLENAME, promotionInfo);
    }
}
