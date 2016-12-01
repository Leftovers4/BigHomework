package data.datahelper.promotiondatahelper;

import util.PromotionType;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/20/2016.
 */
public interface PromotionDataHelper {

//    格式："promotion_id", "promotion_type", "hotel_id", "discount", "least_rooms", "begin_time", "end_time",
//         "enterprise1", "enterprise2", "enterprise3", "enterprise4", "enterprise5",
//         "trading_area1", "tra_discount1", "trading_area2", "tra_discount2", "trading_area3", "tra_discount3", "trading_area4", "tra_discount4", "trading_area5", "tra_discount5",
//         "credit1", "mem_discount1", "credit2", "mem_discount2", "credit3", "mem_discount3", "credit4", "mem_discount4", "credit5", "mem_discount", "credit6", "mem_discount6"

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
