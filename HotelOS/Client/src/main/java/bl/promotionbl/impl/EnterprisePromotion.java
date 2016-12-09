package bl.promotionbl.impl;

import bl.userbl.impl.User;
import po.promotion.PromotionPO;
import po.user.UserPO;
import rmi.RemoteHelper;
import vo.order.OrderVO;

import java.rmi.RemoteException;

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

}
