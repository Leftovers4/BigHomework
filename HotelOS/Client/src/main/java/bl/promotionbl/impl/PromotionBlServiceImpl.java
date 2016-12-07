package bl.promotionbl.impl;

import bl.promotionbl.PromotionBLService;
import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
import rmi.RemoteHelper;
import util.IDProducer;
import util.PromotionType;
import util.ResultMessage;
import vo.promotion.PromotionVO;
import vo.promotion.PromotionVOCreator;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class PromotionBlServiceImpl implements PromotionBLService {

    PromotionDataService promotionDAO;

    PromotionVOCreator promotionVOCreator;

    public PromotionBlServiceImpl(){
        promotionDAO = RemoteHelper.getInstance().getPromotionDAO();
        promotionVOCreator = new PromotionVOCreator();
    }

    @Override
    public ResultMessage create(PromotionVO promotionVO) throws RemoteException {
        promotionVO.promotionID = IDProducer.produceGeneralID();
        PromotionPO promotionPO = new PromotionPOCreator().create(promotionVO);
        return promotionDAO.insert(promotionPO);
    }

    @Override
    public ResultMessage delete(long id) throws RemoteException {
        return promotionDAO.delete(id);
    }

    @Override
    public ResultMessage update(PromotionVO promotionVO) throws RemoteException {
        PromotionPO promotionPO = promotionDAO.findByPromotionID(promotionVO.promotionID);

        promotionVO.hotelID = promotionPO.getHotelID();
        promotionVO.promotionType = promotionPO.getPromotionType();

        return promotionDAO.update(new PromotionPOCreator().create(promotionVO));
    }

    @Override
    public List<PromotionVO> viewPromotionList(long hotelID, PromotionType promotionType) throws RemoteException {
        return promotionVOCreator.createAll(promotionDAO.findByHotelIDAndType(hotelID, promotionType));
    }

}
