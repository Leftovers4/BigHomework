package bl.promotionbl.impl;

import bl.userbl.impl.CreditRecordList;
import po.promotion.PromotionPO;
import po.user.CreditRecordPO;
import rmi.RemoteHelper;
import util.Const;
import vo.order.OrderVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class UserLevelPromotion implements Sale, Level{

    private double[] creditConditions;

    private double[] discounts;

    public UserLevelPromotion(PromotionPO promotionPO) {
        //初始化creditConditions
        creditConditions = new double[Const.MaxMemberLevel + 2];
        creditConditions[0] = 0;
        for (int i = 1; i <= Const.MaxMemberLevel; i++) {
            creditConditions[i] = promotionPO.getPromotionMRPOs().get(i - 1).getCredit();
        }
        creditConditions[creditConditions.length - 1] = Double.MAX_VALUE;

        //初始化discounts
        discounts = new double[Const.MaxMemberLevel];
        for (int i = 0; i < Const.MaxMemberLevel; i++) {
            discounts[i] = promotionPO.getPromotionMRPOs().get(i).getMemberDiscount();
        }
    }

    @Override
    public double getActualPrice(OrderVO orderVO) throws RemoteException {
        double price = orderVO.orderPriceVO.originPrice;

        List<CreditRecordPO> creditRecordPOList = RemoteHelper.getInstance().getUserDAO().findCreditRecordsByUsername(orderVO.username);
        int level = getLevel(new CreditRecordList(creditRecordPOList).getCurrentCredit());

        //等级为零的情况
        if (level == 0)
            return price;

        //等级不为零的情况
        return price * discounts[level - 1];
    }

    @Override
    public int getLevel(double credit) {
        for (int i = 0; i < creditConditions.length - 1; i++) {
            if (creditConditions[i] <= credit && credit < creditConditions[i + 1]){
                return i;
            }
        }
        return 0;
    }

}
