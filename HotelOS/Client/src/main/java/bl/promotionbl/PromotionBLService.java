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

    /**
     * 增加促销策略
     *
     * @param promotionVO 促销策略信息
     * @return 数据库返回的result message
     * @throws RemoteException 服务器连接异常
     */
    ResultMessage create(PromotionVO promotionVO) throws RemoteException;

    /**
     * 删除促销策略
     *
     * @param id 促销策略id
     * @return 数据库返回的result message
     * @throws RemoteException 服务器连接异常
     */
    ResultMessage delete(long id) throws RemoteException;

    /**
     * 更新促销策略
     *
     * @param promotionVO 促销策略信息
     * @return 数据库返回的result message
     * @throws RemoteException 服务器连接异常
     */
    ResultMessage update(PromotionVO promotionVO) throws RemoteException;

    /**
     * 查看促销策略列表
     *
     * @param hotelID       酒店id，如果是网站营销人员，则调用IDProducer.produceHotelIDForWP();
     * @param promotionType 促销策略类型
     * @return 可能为空表
     * @throws RemoteException 服务器连接异常
     */
    List<PromotionVO> viewPromotionList(long hotelID, PromotionType promotionType) throws RemoteException;

}
