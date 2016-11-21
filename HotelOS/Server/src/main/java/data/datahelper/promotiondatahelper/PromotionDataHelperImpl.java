package data.datahelper.promotiondatahelper;

import data.datahelper.DataHelperParent;
import util.PromotionType;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public class PromotionDataHelperImpl extends DataHelperParent implements PromotionDataHelper{
    @Override
    public ArrayList<ArrayList<Object>> findByHotelIdFromSQL(long hotelID) {
        return null;
    }

    @Override
    public ArrayList<ArrayList<Object>> findByTypeFromSQL(PromotionType promotionType) {
        return null;
    }

    @Override
    public ArrayList<Object> findByIdFromSQL(long promotionID) {
        return null;
    }

    @Override
    public ResultMessage insertToSQL(ArrayList<Object> promotionInfo) {
        return null;
    }

    @Override
    public ResultMessage deleteFromSQL(long promotionID) {
        return null;
    }

    @Override
    public ResultMessage updateFromSQL(ArrayList<Object> promotionInfo) {
        return null;
    }
}
