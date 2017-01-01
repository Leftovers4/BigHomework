package bl.promotionbl.impl;

import bl.userbl.impl.User;
import po.promotion.PromotionPO;
import po.user.UserPO;
import rmi.RemoteHelper;
import vo.order.OrderVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class EnterprisePromotion implements Sale{

    private PromotionPO promotionPO;

    public EnterprisePromotion(PromotionPO promotionPO){
        this.promotionPO = promotionPO;
    }

    @Override
    public double getActualPrice(OrderVO orderVO) throws RemoteException {
        double price = orderVO.orderPriceVO.originPrice;
        UserPO userPO = RemoteHelper.getInstance().getUserDAO().findByUsername(orderVO.username);

        for (String enterprise : promotionPO.getPromotionEnterprises()) {
            if (new User(userPO).isEnterpriseName(enterprise))
                return price * promotionPO.getDiscount();
        }

        return price;
    }

    /**
     * 根据给定的企业判断其是否已经是酒店的合作企业
     *
     * @param enterprise 企业
     * @return true（已经是酒店的合作企业），false（不是酒店的合作企业）
     */
    public boolean hotelCoEnterpriseExists(String enterprise){
        boolean res = false;

        List<String> coEnterprises = promotionPO.getPromotionEnterprises();
        for (String coEnterprise: coEnterprises) {
            if (enterprise.equals(coEnterprise)){
                res = true;
                break;
            }
        }

        return res;
    }

}
