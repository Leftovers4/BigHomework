package promotiondata;

import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
import util.PromotionType;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class PromotionDataServiceImpl implements PromotionDataService {
    public void initial() throws RemoteException {

    }

    public void finish() throws RemoteException {

    }

    public ArrayList<PromotionPO> findByHotelID(long hotelID) throws RemoteException {
        return null;
    }

    public ArrayList<PromotionPO> findByPromotionType(PromotionType type) throws RemoteException {
        return null;
    }

    public PromotionPO findByPromotionID(long promotionID) throws RemoteException {
        return null;
    }

    public void insert(PromotionPO promotionPO) throws RemoteException {

    }

    public void delete(PromotionPO promotionPO) throws RemoteException {

    }

    public void update(PromotionPO promotionPO) throws RemoteException {

    }
}
