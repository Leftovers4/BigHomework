package bl.promotionbl;
import bl.promotionbl.impl.Promotion;
import util.*;
import vo.promotion.PromotionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 2016/10/15.
 */
public interface PromotionBLService {

    // 增加营销策略
    ResultMessage create(PromotionVO promotionVO) throws RemoteException;

    // 根据营销策略ID删除策略
    ResultMessage delete(long id) throws RemoteException;

    // 根据营销策略ID更新策略
    ResultMessage update(PromotionVO promotionVO) throws RemoteException;

    // 根据用户类型显示营销策略列表
    List<PromotionVO> viewPromotionList(long hotelID, PromotionType promotionType) throws RemoteException;


}
