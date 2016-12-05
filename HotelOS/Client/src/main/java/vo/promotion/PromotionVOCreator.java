package vo.promotion;

import po.promotion.PromotionMRPO;
import po.promotion.PromotionPO;
import po.promotion.PromotionTimePO;
import po.promotion.PromotionTraAreaPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/12/5.
 */
public class PromotionVOCreator {

    public PromotionVO create(PromotionPO promotionPO){
        PromotionVO res = new PromotionVO();

        res.promotionID = promotionPO.getPromotionID();
        res.promotionType = promotionPO.getPromotionType();
        res.hotelID = promotionPO.getHotelID();
        res.discount = promotionPO.getDiscount();
        res.leastRooms = promotionPO.getLeastRooms();
        res.promotionTimeVO = create(promotionPO.getPromotionTimePO());
        res.promotionEnterprises = promotionPO.getPromotionEnterprises();
        res.promotionTraAreaVOs = createAllTraAreaVO(promotionPO.getPromotionTraAreaPOs());
        res.promotionMRVOs = createAllMRVO(promotionPO.getPromotionMRPOs());

        return res;
    }

    public List<PromotionVO> createAll(List<PromotionPO> promotionPOList){
        List<PromotionVO> res = new ArrayList<>();

        for (int i = 0; i < promotionPOList.size(); i++) {
            res.add(create(promotionPOList.get(i)));
        }

        return res;
    }

    private PromotionTimeVO create(PromotionTimePO promotionTimePO){
        PromotionTimeVO res = new PromotionTimeVO();

        res.beginTime = promotionTimePO.getBeginTime();
        res.endTime = promotionTimePO.getEndTime();

        return res;
    }

    private List<PromotionTraAreaVO> createAllTraAreaVO(List<PromotionTraAreaPO> promotionTraAreaPOs){
        List<PromotionTraAreaVO> res = new ArrayList<>();

        for (int i = 0; i < promotionTraAreaPOs.size(); i++) {
            PromotionTraAreaVO promotionTraAreaVO = new PromotionTraAreaVO();

            promotionTraAreaVO.tradingArea = promotionTraAreaPOs.get(i).getTradingArea();
            promotionTraAreaVO.traDiscount = promotionTraAreaPOs.get(i).getTraDiscount();

            res.add(promotionTraAreaVO);
        }

        return res;
    }

    private List<PromotionMRVO> createAllMRVO(List<PromotionMRPO> promotionMRPOs){
        List<PromotionMRVO> res = new ArrayList<>();

        for (int i = 0; i < promotionMRPOs.size(); i++) {
            PromotionMRVO promotionMRVO = new PromotionMRVO();

            promotionMRVO.credit = promotionMRPOs.get(i).getCredit();
            promotionMRVO.memberDiscount = promotionMRPOs.get(i).getMemberDiscount();

            res.add(promotionMRVO);
        }

        return res;
    }

}
