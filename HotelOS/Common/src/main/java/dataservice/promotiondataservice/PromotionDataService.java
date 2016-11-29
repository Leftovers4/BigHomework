package dataservice.promotiondataservice;

import dataservice.DataServiceParent;
import po.promotion.PromotionPO;
import util.PromotionType;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public interface PromotionDataService extends Remote{

    // 根据酒店ID显示营销策略列表
    public ArrayList<PromotionPO> findByHotelID(long hotelID) throws RemoteException;

    // 查找所有网站营销策略（网站营销策略id为WebHotelID）
    public ArrayList<PromotionPO> findAllWebPromotion() throws RemoteException;

    // 根据酒店id和类型查找促销策略
    public ArrayList<PromotionPO> findByHotelIDAndType(long hotelID, PromotionType promotionType) throws RemoteException;

    // 根据营销策略ID查找营销策略
    public PromotionPO findByPromotionID(long promotionID) throws RemoteException;

    // 增加营销策略
    public ResultMessage insert(PromotionPO promotionPO) throws RemoteException;

    // 删除营销策略
    public ResultMessage delete(long promotionID) throws RemoteException;

    // 更新营销策略
    public ResultMessage update(PromotionPO promotionPO) throws RemoteException;



}
