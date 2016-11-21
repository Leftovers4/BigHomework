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

    @Override
    public ResultMessage insertAddressToSQL(ArrayList<Object> addInfo) {
        return null;
    }

    @Override
    public ResultMessage deleteAddressFromSQL(long addressID) {
        return null;
    }

    @Override
    public ResultMessage updateAddressFromSQL(ArrayList<Object> addInfo) {
        return null;
    }

    @Override
    public ArrayList<ArrayList<Object>> findAddressFromSQL() {
        return null;
    }

    @Override
    public ArrayList<Object> findAddressByIdFromSQL(long addressID) {
        return null;
    }

    @Override
    public ResultMessage insertEnterpriseToSQL(ArrayList<Object> entInfo) {
        return null;
    }

    @Override
    public ResultMessage deleteEnterpriseFromSQL(long match_id) {
        return null;
    }

    @Override
    public ResultMessage updateEnterpriseFromSQL(ArrayList<Object> entInfo) {
        return null;
    }

    @Override
    public ArrayList<ArrayList<Object>> findEnterpriseFromSQL() {
        return null;
    }

    @Override
    public ArrayList<Object> findEnterpriseByIdFromSQL(long match_id) {
        return null;
    }

    @Override
    public ResultMessage insertMRToSQL(ArrayList<Object> mrInfo) {
        return null;
    }

    @Override
    public ResultMessage deleteMRFromSQL(long level) {
        return null;
    }

    @Override
    public ResultMessage updateMRFromSQL(ArrayList<Object> mrInfo) {
        return null;
    }

    @Override
    public ArrayList<ArrayList<Object>> findMRFromSQL() {
        return null;
    }

    @Override
    public ArrayList<Object> findMRByLevelFromSQL(long level) {
        return null;
    }
}
