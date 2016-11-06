package blservice_stub;

import blservice.promotionblservice.PromotionBLService;
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
        return new PromotionVO(1, "生日特惠", "折扣： 0.9");
    }

    @Override
    public ArrayList<PromotionVO> getHotelPromList(long hotelID) {
        ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
        list.add(new PromotionVO(1, "生日特惠", "折扣： 0.9"));
        return list;
    }

    @Override
    public ArrayList<PromotionVO> getWebPromList() {
        ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
        list.add(new PromotionVO(1, "生日特惠", "折扣： 0.9"));
        return list;
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
