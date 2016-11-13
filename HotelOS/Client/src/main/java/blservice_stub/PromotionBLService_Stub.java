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
    public ResultMessage create(PromotionVO promotionVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage delete(long id) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage update(long id) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<PromotionVO> showList(long creator) {
        ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
        list.add(new PromotionVO(1, "生日特惠", "折扣： 0.9"));
        return list;
    }
}
