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
     * 在promotion表中插入一条促销策略
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
     * @param promotionInfo
     * @return
     */
    public ResultMessage updateFromSQL(ArrayList<Object> promotionInfo);


    /**
     * 在promotion表中查找所有促销策略
     * @return
     */
    public ArrayList<ArrayList<Object>> findFromSQL();


    /**
     * 根据promotionID从promotion表中查找一条促销策略
     * @param promotionID
     * @return
     */
    public ArrayList<Object> findByIdFromSQL(long promotionID);


    //    /**
//     * 根据hotelID在从promotion表中查找促销策略列表
//     * @param hotelID
//     * @return
//     */
//    public ArrayList<ArrayList<Object>> findByHotelIdFromSQL(long hotelID);

//    /**
//     * 根据promotionType从promotion表中查找促销策略列表
//     * @param promotionType
//     * @return
//     */
//    public ArrayList<ArrayList<Object>> findByTypeFromSQL(PromotionType promotionType);


}
