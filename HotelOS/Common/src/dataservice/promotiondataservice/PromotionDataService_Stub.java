package dataservice.promotiondataservice;

import po.promotion.PromotionPO;
import util.PromotionType;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class PromotionDataService_Stub implements PromotionDataService {
    @Override
    public void initial() throws RemoteException {

    }

    @Override
    public void finish() throws RemoteException {

    }

    @Override
    public ArrayList<PromotionPO> findByHotelID(long hotelID) throws RemoteException {
        ArrayList<PromotionPO> list = new ArrayList<>();
        list.add(new PromotionPO(PromotionType.HOTEL_PROMOTION, null, null, 9));
        return list;
    }

    @Override
    public ArrayList<PromotionPO> findByPromotionType(PromotionType type) throws RemoteException {
        ArrayList<PromotionPO> list = new ArrayList<>();
        if (type == PromotionType.HOTEL_PROMOTION)
            list.add(new PromotionPO(PromotionType.HOTEL_PROMOTION, null, null, 9));
        else
            list.add(new PromotionPO(PromotionType.WEB_PROMOTION, null, null, 9));
        return list;
    }

    @Override
    public PromotionPO findByPromotionID(long promotionID) throws RemoteException {
        return new PromotionPO(PromotionType.HOTEL_PROMOTION, null, null, 9);
    }

    @Override
    public void insert(PromotionPO promotionPO) throws RemoteException {

    }

    @Override
    public void delete(PromotionPO promotionPO) throws RemoteException {

    }

    @Override
    public void update(PromotionPO promotionPO) throws RemoteException {

    }
}
