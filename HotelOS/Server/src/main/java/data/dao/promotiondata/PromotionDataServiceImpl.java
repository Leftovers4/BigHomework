package data.dao.promotiondata;

import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
import util.PromotionType;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class PromotionDataServiceImpl implements PromotionDataService {


    @Override
    public ResultMessage insert(PromotionPO promotionPO) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage delete(long promotionID) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage update(PromotionPO promotionPO) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<PromotionPO> findAll() throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<PromotionPO> findByHotelID(long hotelID) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<PromotionPO> findAllWebPromotion() throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<PromotionPO> findByHotelIDAndType(long hotelID, PromotionType promotionType) throws RemoteException {
        return null;
    }

    @Override
    public PromotionPO findByPromotionID(long promotionID) throws RemoteException {
        return null;
    }
}
