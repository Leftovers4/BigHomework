package bl.promotionbl.impl;

import po.promotion.PromotionMRPO;
import po.promotion.PromotionPO;
import po.promotion.PromotionTimePO;
import po.promotion.PromotionTraAreaPO;
import vo.promotion.PromotionTimeVO;
import vo.promotion.PromotionVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/12/5.
 */
public class PromotionPOCreator {

    public PromotionPO create(PromotionVO promotionVO){
        PromotionTimePO promotionTimePO = new PromotionTimePO();
        if (promotionVO.promotionTimeVO != null){
            promotionTimePO.setBeginTime(promotionVO.promotionTimeVO.beginTime);
            promotionTimePO.setEndTime(promotionVO.promotionTimeVO.endTime);
        }

        ArrayList<String> promotionEnterprises = new ArrayList<>();
        if (promotionVO.promotionEnterprises != null){
            for (int i = 0; i < promotionVO.promotionEnterprises.size(); i++) {
                promotionEnterprises.add(promotionVO.promotionEnterprises.get(i));
            }
        }

        ArrayList<PromotionTraAreaPO> promotionTraAreaPOs = new ArrayList<>();
        if (promotionVO.promotionTraAreaVOs != null){
            for (int i = 0; i < promotionVO.promotionTraAreaVOs.size(); i++) {
                PromotionTraAreaPO promotionTraAreaPO = new PromotionTraAreaPO();

                promotionTraAreaPO.setTradingArea(promotionVO.promotionTraAreaVOs.get(i).tradingArea);
                promotionTraAreaPO.setTraDiscount(promotionVO.promotionTraAreaVOs.get(i).traDiscount);

                promotionTraAreaPOs.add(promotionTraAreaPO);
            }
        }

        ArrayList<PromotionMRPO> promotionMRPOs = new ArrayList<>();
        if (promotionVO.promotionMRVOs != null){
            for (int i = 0; i < promotionVO.promotionMRVOs.size(); i++) {
                PromotionMRPO promotionMRPO = new PromotionMRPO();

                promotionMRPO.setCredit(promotionVO.promotionMRVOs.get(i).credit);
                promotionMRPO.setMemberDiscount(promotionVO.promotionMRVOs.get(i).memberDiscount);

                promotionMRPOs.add(promotionMRPO);
            }
        }

        return new PromotionPO(promotionVO.promotionID, promotionVO.promotionType,
                promotionVO.hotelID, promotionVO.discount, promotionVO.leastRooms, promotionTimePO,
                promotionEnterprises, promotionTraAreaPOs, promotionMRPOs);
    }

}
