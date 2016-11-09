package dataservice_stub;

import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
import po.promotion.PromotionTimePO;
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
        list.add(new PromotionPO(PromotionType.BIRTHDAY_HP, new PromotionTimePO(null, null), 0.9, 1));
        return list;
    }

    @Override
    public ArrayList<PromotionPO> findByPromotionType(PromotionType type) throws RemoteException {
        ArrayList<PromotionPO> list = new ArrayList<>();
        if (type == PromotionType.BIRTHDAY_HP)
            list.add(new PromotionPO(PromotionType.BIRTHDAY_HP, new PromotionTimePO(null, null), 0.9, 1));
        else
            list.add(new PromotionPO(PromotionType.BIRTHDAY_HP, new PromotionTimePO(null, null), 0.9, 1));
        return list;
    }

    @Override
    public PromotionPO findByPromotionID(long promotionID) throws RemoteException {
        return new PromotionPO(PromotionType.BIRTHDAY_HP, new PromotionTimePO(null, null), 0.9, 1);
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
