package bl.promotionbl.impl;

import po.promotion.PromotionMRPO;
import po.promotion.PromotionPO;
import po.promotion.PromotionTimePO;
import po.promotion.PromotionTraAreaPO;
import util.Const;
import util.PromotionType;
import vo.promotion.PromotionTimeVO;
import vo.promotion.PromotionVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/12/5.
 */
public class PromotionPOCreator {

    /**
     * Create promotion po.
     *
     * @param promotionVO the promotion vo
     * @return the promotion po
     */
    public PromotionPO create(PromotionVO promotionVO){
        PromotionPO res = new PromotionPO();

        res.setPromotionID(promotionVO.promotionID);
        res.setPromotionType(promotionVO.promotionType);
        res.setHotelID(promotionVO.hotelID);
        res.setDiscount(promotionVO.discount);
        res.setLeastRooms(promotionVO.leastRooms);

        if (promotionVO.promotionType.equals(PromotionType.SpecialTimePromotion)){
            res.getPromotionTimePO().setBeginTime(promotionVO.promotionTimeVO.beginTime);
            res.getPromotionTimePO().setEndTime(promotionVO.promotionTimeVO.endTime);
        }

        if (promotionVO.promotionType.equals(PromotionType.EnterprisePromotion)){
            for (int i = 0; i < promotionVO.promotionEnterprises.size(); i++) {
                res.getPromotionEnterprises().set(i, promotionVO.promotionEnterprises.get(i));
            }
        }

        if (promotionVO.promotionType.equals(PromotionType.VIPSpecialAreaPromotion)){
            for (int i = 0; i < promotionVO.promotionTraAreaVOs.size(); i++) {
                res.getPromotionTraAreaPOs().get(i).setTradingArea(promotionVO.promotionTraAreaVOs.get(i).tradingArea);
                res.getPromotionTraAreaPOs().get(i).setTraDiscount(promotionVO.promotionTraAreaVOs.get(i).traDiscount);
            }
        }

        if (promotionVO.promotionType.equals(PromotionType.UserLevelPromotion)){
            for (int i = 0; i < promotionVO.promotionMRVOs.size(); i++) {
                res.getPromotionMRPOs().get(i).setCredit(promotionVO.promotionMRVOs.get(i).credit);
                res.getPromotionMRPOs().get(i).setMemberDiscount(promotionVO.promotionMRVOs.get(i).memberDiscount);
            }
        }

        return res;
    }

}
