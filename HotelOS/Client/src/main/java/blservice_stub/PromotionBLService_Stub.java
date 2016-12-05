package blservice_stub;

import bl.promotionbl.PromotionBLService;
import util.PromotionType;
import util.ResultMessage;
import vo.promotion.PromotionVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/10/16.
 */
public class PromotionBLService_Stub implements PromotionBLService {


    @Override
    public ResultMessage create(PromotionVO promotionVO) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage delete(long id) {
        return ResultMessage.Success;
    }

    @Override
    public ResultMessage update(PromotionVO promotionVO) throws RemoteException {
        return null;
    }

    @Override
    public List<PromotionVO> viewPromotionList(long hotelID, PromotionType promotionType) throws RemoteException {
        return null;
    }

    public ResultMessage update(long id) {
        return ResultMessage.Success;
    }

    public ArrayList<PromotionVO> showList(long creator) {
        ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
        list.add(new PromotionVO());
        return list;
    }
}
