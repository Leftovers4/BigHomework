package data.datahelper.promotiondatahelper.PromotionExtraInfoHelper;

import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public interface EnterpriseDataHelper {

    // 格式："match_id", "hotel_id", "enterprise"

    /**
     * 往enterprise表中插入一条企业信息
     * @param entInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> entInfo);

    /**
     * 在enterprise表中删除一条企业信息
     * @param matchID
     * @return
     */
    public ResultMessage deleteFromSQL(long matchID);

    /**
     * 在enterprise表中更新一条企业信息
     * @param entInfo
     * @return
     */
    public ResultMessage updateFromSQL(ArrayList<Object> entInfo);

    /**
     * 从enterprise表中获取所有企业信息
     * @return
     */
    public ArrayList<ArrayList<Object>> findFromSQL();

    /**
     * 根据ID从enterprise表中查找一条企业信息
     * @param matchID
     * @return
     */
    public ArrayList<Object> findByIdFromSQL(long matchID);


}
