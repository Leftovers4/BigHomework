package dataservice_stub;

import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
import po.promotion.PromotionTimePO;
import util.PromotionType;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class PromotionDataService_Stub implements PromotionDataService {


    @Override
    public ArrayList<PromotionPO> findByHotelID(long hotelID) throws RemoteException {
        ArrayList<PromotionPO> list = new ArrayList<>();
        list.add(new PromotionPO(123456, PromotionType.BirthdayPromotion, 120120, new PromotionTimePO(null, null), 0.9, 1));
        return list;
    }

    @Override
    public ArrayList<PromotionPO> findAllWebPromotion() throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<PromotionPO> findByHotelIDAndType(long hotelID, PromotionType promotionType) throws RemoteException {
        return null;
    }

//    @Override
//    public ArrayList<PromotionPO> findByPromotionType(PromotionType type) throws RemoteException {
//        ArrayList<PromotionPO> list = new ArrayList<>();
//        if (type == PromotionType.BirthdayPromotion)
//            list.add(new PromotionPO(123456, PromotionType.BirthdayPromotion, 120120, new PromotionTimePO(null, null), 0.9, 1));
//        else
//            list.add(new PromotionPO(123456, PromotionType.BirthdayPromotion, 120120, new PromotionTimePO(null, null), 0.9, 1));
//        return list;
//    }

    @Override
    public PromotionPO findByPromotionID(long promotionID) throws RemoteException {
        return new PromotionPO(123456, PromotionType.BirthdayPromotion, 120120, new PromotionTimePO(null, null), 0.9, 1);
    }

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


}
