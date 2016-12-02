package data.dao.promotiondata;

import data.dao.DataServiceImplParent;
import data.datahelper.promotiondatahelper.PromotionDataHelper;
import data.datahelper.userdatahelper.CreditRecordDataHelper;
import data.datahelper.userdatahelper.UserDataHelper;
import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
import util.IDProducer;
import util.PromotionType;
import util.ResultMessage;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kevin on 2016/11/16.
 */
public class PromotionDataServiceImpl extends DataServiceImplParent implements PromotionDataService {

    // 需要调用的DataHelper
    private PromotionDataHelper promotionDataHelper;

    // 将需要调用的底层类初始化
    public PromotionDataServiceImpl(){
        super();
        promotionDataHelper = dhFactory.getPromotionDataHelper();

    }


    @Override
    public ResultMessage insert(PromotionPO promotionPO) throws RemoteException {
        // 将po转换成al
        ArrayList<Object> promotionAL = paFactory.toPromotionAl(promotionPO);
        // 插入到promotion表中
        return promotionDataHelper.insertToSQL(promotionAL);
    }

    @Override
    public ResultMessage delete(long promotionID) throws RemoteException {
        return promotionDataHelper.deleteFromSQL(promotionID);
    }

    @Override
    public ResultMessage update(PromotionPO promotionPO) throws RemoteException {
        // 将po转换成al
        ArrayList<Object> promotionAL = paFactory.toPromotionAl(promotionPO);
        // 更新到promotion表中
        return promotionDataHelper.updateFromSQL(promotionAL);
    }

    @Override
    public ArrayList<PromotionPO> findAll() throws RemoteException {
        // 在promotion表中取出所有的promotionALs
        ArrayList<ArrayList<Object>> promotionALs = promotionDataHelper.findFromSQL();
        // 构造promotionALs的迭代器
        Iterator<Iterator<Object>> promotionInfos = ctFactory.alsToItrs(promotionALs);
        // 转换成po
        ArrayList<PromotionPO> promotionPOs = new ArrayList<>();
        while(promotionInfos.hasNext()){
            promotionPOs.add(apFactory.toPromotionPO(promotionInfos.next()));
        }
        return promotionPOs;
    }

    @Override
    public ArrayList<PromotionPO> findByHotelID(long hotelID) throws RemoteException {
        // 调用findAll
        ArrayList<PromotionPO> promotionPOs = findAll();
        // 取出相应hotelID的promotionPO
        ArrayList<PromotionPO> selectedPromotionPOs = new ArrayList<>();
        for (PromotionPO each : promotionPOs) {
            if(each.getHotelID() == hotelID){
                selectedPromotionPOs.add(each);
            }
        }
        return selectedPromotionPOs;
    }

    @Override
    public ArrayList<PromotionPO> findAllWebPromotion() throws RemoteException {
        // 调用findAll
        ArrayList<PromotionPO> promotionPOs = findAll();
        // 取出相应hotelID的promotionPO
        ArrayList<PromotionPO> selectedPromotionPOs = new ArrayList<>();
        for (PromotionPO each : promotionPOs) {
            if(each.getHotelID() == IDProducer.produceHotelIDForWP()){
                selectedPromotionPOs.add(each);
            }
        }
        return selectedPromotionPOs;
    }

    @Override
    public ArrayList<PromotionPO> findByHotelIDAndType(long hotelID, PromotionType promotionType) throws RemoteException {
        // 调用findAll
        ArrayList<PromotionPO> promotionPOs = findAll();
        // 取出相应hotelID的promotionPO
        ArrayList<PromotionPO> selectedPromotionPOs = new ArrayList<>();
        for (PromotionPO each : promotionPOs) {
            if(each.getHotelID() == hotelID && each.getPromotionType().equals(promotionType)){
                selectedPromotionPOs.add(each);
            }
        }
        return selectedPromotionPOs;
    }

    @Override
    public PromotionPO findByPromotionID(long promotionID) throws RemoteException {
        // 在promotion表中取出相应id的promotionAL
        ArrayList<Object> promotionAL = promotionDataHelper.findByIdFromSQL(promotionID);
        // 构造promotionAL的迭代器
        Iterator<Object> promotionInfo = ctFactory.alToItr(promotionAL);
        // 转换成po
        return apFactory.toPromotionPO(promotionInfo);
    }
}
