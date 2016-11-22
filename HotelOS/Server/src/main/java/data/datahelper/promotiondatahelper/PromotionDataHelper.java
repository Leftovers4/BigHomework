package data.datahelper.promotiondatahelper;

import util.PromotionType;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/20/2016.
 */
public interface PromotionDataHelper {

    // 格式："promotion_id", "promotion_type", "discount", "least_rooms", "begin_time", "end_time", "threshold", "reduction"

    /**
     * 根据hotelID在从promotion表中查找促销策略列表
     * TODO 特殊的促销策略必须访问多个表，逻辑交给dao处理
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





}
