package blservice.promotionblservice;
import util.*;

/**
 * Created by Hiki on 2016/10/15.
 */
public interface PromotionBLService {

    // 根据ID查找营销策略
    public PromotionVO (long promotionID);

    // 根据酒店ID查找酒店营销策略列表
    public ArrayList<PromotionVO> getHotelPromList(long hotelID);

    // 根据营销策略类型显示网站营销策略
    public ArrayList<PromotionVO> getWebPromList(PromotionType type);

    // 增加营销策略
    public ResultMessage add(PromotionVO promotionVO);

    // 删除营销策略
    public ResultMessage del(PromotionVO promotionVO);

    // 修改营销策略
    public ResultMessage modify(PromotionVO promotionVO);



}
