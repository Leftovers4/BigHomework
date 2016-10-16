package blservice.promotionblservice;

import util.PromotionType;
import util.ResultMessage;
import vo.promotion.PromotionVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class PromotionBLService_Stub implements PromotionBLService {
    @Override
    public PromotionVO find(long promotionID) {
        return null;
    }

    @Override
    public ArrayList<PromotionVO> getHotelPromList(long hotelID) {
        return null;
    }

    @Override
    public ArrayList<PromotionVO> getWebPromList(PromotionType type) {
        return null;
    }

    @Override
    public ResultMessage add(PromotionVO promotionVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage del(PromotionVO promotionVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modify(PromotionVO promotionVO) {
        return ResultMessage.SUCCESS;
    }
}
