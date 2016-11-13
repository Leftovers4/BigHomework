package blservice.promotionblservice;
import util.*;
import vo.promotion.PromotionVO;

import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/15.
 */
public interface PromotionBLService {

    // 增加营销策略
    public ResultMessage create(PromotionVO promotionVO);

    // 根据营销策略ID删除策略
    public ResultMessage delete(long id);

    // 根据营销策略ID更新策略
    public ResultMessage update(long id);

    // 根据用户类型显示营销策略列表
    public ArrayList<PromotionVO> showList(long creator);


}
