package vo.promotion;

import util.PromotionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Hiki on 2016/10/16.
 */
public class PromotionVO extends Vector<String>{

    /**
     * 营销策略ID
     */
    public long promotionID;

    /**
     * 营销策略类型
     */
    public PromotionType promotionType;

    /**
     * 酒店ID
     */
    public long hotelID;

    /**
     * 折扣
     */
    public double discount;

    /**
     * 最少预订间数
     */
    public int leastRooms;

    /**
     * 时间
     */
    public PromotionTimeVO promotionTimeVO;

    /**
     * 合作企业
     */
    public List<String> promotionEnterprises;

    /**
     * 地址商圈
     */
    public List<PromotionTraAreaVO> promotionTraAreaVOs;

    /**
     * 会员等级制度
     */
    public List<PromotionMRVO> promotionMRVOs;

}
