package data.dao.promotiondata;

import data.dao.DataServiceImplParent;
import data.datahelper.promotiondatahelper.PromotionDataHelper;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.AddressDataHelper;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.EnterpriseDataHelper;
import data.datahelper.promotiondatahelper.PromotionExtraInfoHelper.MemberRegulationDataHelper;
import data.datahelper.userdatahelper.CreditRecordDataHelper;
import data.datahelper.userdatahelper.UserDataHelper;
import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
import util.PromotionType;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class PromotionDataServiceImpl extends DataServiceImplParent implements PromotionDataService {

    // 需要调用的DataHelper
    private PromotionDataHelper promotionDataHelper;

    private AddressDataHelper addDataHelper;

    private EnterpriseDataHelper entDataHelper;

    private MemberRegulationDataHelper mrDataHelper;



    // 将需要调用的底层类初始化
    public PromotionDataServiceImpl(){
        super();

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
