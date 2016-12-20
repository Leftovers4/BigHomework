package bl.promotionbl.impl;

import bl.promotionbl.PromotionBLService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.promotiondataservice.PromotionDataService;
import po.hotel.RoomPO;
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

    HotelDataService hotelDAO;

    PromotionVOCreator promotionVOCreator;

    public PromotionBlServiceImpl() throws RemoteException {
        promotionDAO = RemoteHelper.getInstance().getPromotionDAO();
        hotelDAO = RemoteHelper.getInstance().getHotelDAO();
        promotionVOCreator = new PromotionVOCreator();
    }

    @Override
    public ResultMessage create(PromotionVO promotionVO) throws RemoteException {
        //合作企业已存在的情况
        if(new PromotionList(promotionDAO.findByHotelIDAndType(promotionVO.getHotelID(), promotionVO.promotionType)).hotelCoEnterpriseExists(promotionVO.promotionEnterprises))
            return ResultMessage.CoEnterpriseExists;

        //合作企业不存在的情况
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
        return promotionVOCreator.createAll(promotionDAO.findByHotelIDAndType(hotelID, promotionType), hotelDAO.findRoomsByHotelID(hotelID));
    }

}
