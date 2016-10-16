package blservice.promotionblservice;

import util.ResultMessage;

/**
 * Created by kevin on 2016/10/16.
 */
public class PromotionBLService_Stub implements PromotionBLService {
    public PromotionBLService_Stub(long promotionID) {

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
        return null;
    }

    @Override
    public ResultMessage del(PromotionVO promotionVO) {
        return null;
    }

    @Override
    public ResultMessage modify(PromotionVO promotionVO) {
        return null;
    }
}
