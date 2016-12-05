package bl.promotionbl.impl;

import bl.userbl.impl.User;
import po.promotion.PromotionPO;
import po.user.UserPO;
import rmi.RemoteHelper;
import vo.order.OrderVO;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by kevin on 2016/11/6.
 */
public class BirthdayPromotion implements Sale{
    private double discount;

    public BirthdayPromotion(PromotionPO promotionPO) {
        this.discount = promotionPO.getDiscount();
    }

    @Override
    public double getActualPrice(OrderVO orderVO) throws RemoteException {
        UserPO userPO = RemoteHelper.getInstance().getUserDAO().findByUsername(orderVO.username);
        double price = orderVO.orderPriceVO.originPrice;
        LocalDate today = LocalDate.now();

        if (new User(userPO).isBirthday(today)){
            return price * discount;
        }else {
            return price;
        }
    }
}
