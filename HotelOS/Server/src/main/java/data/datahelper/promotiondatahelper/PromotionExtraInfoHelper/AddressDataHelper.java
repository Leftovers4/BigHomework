package data.datahelper.promotiondatahelper.PromotionExtraInfoHelper;

import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public interface AddressDataHelper {

    // 格式："address_id", "address", "trading_area", "discount"

    /**
     * 往address表中插入一条地址信息
     * @param addInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> addInfo);

    /**
     * 从address表中删除一条地址信息
     * @param addressID
     * @return
     */
    public ResultMessage deleteFromSQL(long addressID);

    /**
     * 在address中更新一条地址信息
     * @param addInfo
     * @return
     */
    public ResultMessage updateFromSQL(ArrayList<Object> addInfo);

    /**
     * 从address表中获取所有地址信息
     * @return
     */
    public ArrayList<ArrayList<Object>> findFromSQL();

    /**
     * 根据ID从address表中查找一条地址信息
     * @param addressID
     * @return
     */
    public ArrayList<Object> findByIdFromSQL(long addressID);


}
