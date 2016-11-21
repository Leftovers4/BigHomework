package data.datahelper.promotiondatahelper;

import util.PromotionType;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/20/2016.
 */
public interface PromotionDataHelper {

    /**
     * 根据hotelID在从promotion表中查找促销策略列表
     * TODO 特殊的促销策略必须访问多个表，交给dao处理
     * @param hotelID
     * @return
     */
    public ArrayList<ArrayList<Object>> findByHotelIdFromSQL(long hotelID);

    /**
     * 根据promotionType从promotion表中查找促销策略列表
     * TODO 特殊的促销策略必须访问多个表
     * @param promotionType
     * @return
     */
    public ArrayList<ArrayList<Object>> findByTypeFromSQL(PromotionType promotionType);

    /**
     * 根据promotionID从promotion表中查找一条促销策略
     * TODO 特殊的促销策略必须访问多个表
     * 返回类型："promotion_id", "promotion_type", "discount", "least_rooms", "begin_time", "end_time", "threshold", "reduction"
     * @param promotionID
     * @return
     */
    public ArrayList<Object> findByIdFromSQL(long promotionID);

    /**
     * 在promotion表中插入一条促销策略
     * 输入格式：TODO 可能会有不一样
     * @param promotionInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> promotionInfo);

    /**
     * 从promotion表中删除一条促销策略
     * @param promotionID
     * @return
     */
    public ResultMessage deleteFromSQL(long promotionID);

    /**
     * 在promotion表中更新一条促销策略
     * TODO：有些促销策略需要更新多个表
     * @param promotionInfo
     * @return
     */
    public ResultMessage updateFromSQL(ArrayList<Object> promotionInfo);


    /*-----------------------------------------------------------以下方法访问有自己的表的promotion表-----------------------------------------------------------------*/


    /**
     * 地址&商圈 WP
     */

    public ResultMessage insertAddressToSQL(ArrayList<Object> addInfo);

    public ResultMessage deleteAddressFromSQL(long addressID);

    public ResultMessage updateAddressFromSQL(ArrayList<Object> addInfo);

    public ArrayList<ArrayList<Object>> findAddressFromSQL();

    public ArrayList<Object> findAddressByIdFromSQL(long addressID);

    /**
     * 企业信息 HP
     */
    public ResultMessage insertEnterpriseToSQL(ArrayList<Object> entInfo);

    public ResultMessage deleteEnterpriseFromSQL(long match_id);

    public ResultMessage updateEnterpriseFromSQL(ArrayList<Object> entInfo);

    public ArrayList<ArrayList<Object>> findEnterpriseFromSQL();

    public ArrayList<Object> findEnterpriseByIdFromSQL(long match_id);

    /**
     * 会员等级信息 WP
     */
    public ResultMessage insertMRToSQL(ArrayList<Object> mrInfo);

    public ResultMessage deleteMRFromSQL(long level);

    public ResultMessage updateMRFromSQL(ArrayList<Object> mrInfo);

    public ArrayList<ArrayList<Object>> findMRFromSQL();

    public ArrayList<Object> findMRByLevelFromSQL(long level);



}
