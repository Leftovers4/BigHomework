package data.datahelper.promotiondatahelper.PromotionExtraInfoHelper;

import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public interface MemberRegulationDataHelper {

    // 格式："level", "credit", "discount"

    /**
     * 往member_regulation表中插入一条会员规则
     * @param mrInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> mrInfo);

    /**
     * 在member_regulation表中删除一条会员规则
     * @param level
     * @return
     */
    public ResultMessage deleteFromSQL(long level);

    /**
     * 在member_regulation表中更新一条会员规则
     * @param mrInfo
     * @return
     */
    public ResultMessage updateFromSQL(ArrayList<Object> mrInfo);

    /**
     * 从member_regulation表中获取所有会员规则
     * @return
     */
    public ArrayList<ArrayList<Object>> findFromSQL();

    /**
     * 根据level从member_regulation表中获取一条会员规则
     * @param level
     * @return
     */
    public ArrayList<Object> findByLevelFromSQL(long level);


}
