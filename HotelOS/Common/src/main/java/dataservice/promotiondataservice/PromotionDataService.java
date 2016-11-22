package dataservice.promotiondataservice;

import dataservice.DataServiceParent;
import po.promotion.PromotionPO;
import util.PromotionType;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public interface PromotionDataService {

    // 根据酒店ID显示营销策略列表
    public ArrayList<PromotionPO> findByHotelID(long hotelID) throws RemoteException;

    // 根据营销策略类型显示营销策略列表
    public ArrayList<PromotionPO> findByPromotionType(PromotionType type) throws RemoteException;

    // 根据营销策略ID查找营销策略
    public PromotionPO findByPromotionID(long promotionID) throws RemoteException;

    // 增加营销策略
    public void insert(PromotionPO promotionPO) throws RemoteException;

    // 删除营销策略
    public void delete(long promotionID) throws RemoteException;

    // 更新营销策略
    public void update(PromotionPO promotionPO) throws RemoteException;





}
