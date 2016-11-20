package data.dao.promotiondata;

import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
import util.PromotionType;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class PromotionDataServiceImpl implements PromotionDataService {



    @Override
    public ArrayList<PromotionPO> findByHotelID(long hotelID) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<PromotionPO> findByPromotionType(PromotionType type) throws RemoteException {
        return null;
    }

    @Override
    public PromotionPO findByPromotionID(long promotionID) throws RemoteException {
        return null;
    }

    @Override
    public void insert(PromotionPO promotionPO) throws RemoteException {

    }

    @Override
    public void delete(long promotionID) throws RemoteException {

    }

    @Override
    public void update(PromotionPO promotionPO) throws RemoteException {

    }
}
