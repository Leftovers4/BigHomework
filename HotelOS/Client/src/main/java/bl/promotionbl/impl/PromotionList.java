package bl.promotionbl.impl;

import po.promotion.PromotionPO;
import vo.order.OrderVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class PromotionList extends ArrayList<PromotionPO>{

    public PromotionList(List<PromotionPO> promotionPOList){
        for (int i = 0; i < promotionPOList.size(); i++) {
            this.add(promotionPOList.get(i));
        }
    }

    public double getLowestPrice(OrderVO orderVO) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, RemoteException {
        double res = orderVO.orderPriceVO.originPrice;

        int index = -1; // 用来记录采用了列表中的第几个优惠策略

        for (int i = 0; i < this.size(); i++) {
            Context context = new Context(this.get(i));
            double actualPrice = context.getActualPrice(orderVO);
            if (actualPrice < res){
                res = actualPrice;
                index = i;
            }
        }

        //在orderVO中记录优惠信息
        if (index != -1){
            orderVO.orderPriceVO.actualPrice = res;
            orderVO.orderPromoInfoVO.promotionType = this.get(index).getPromotionType();
            orderVO.orderPromoInfoVO.discount = this.get(index).getDiscount();
        }

        return res;
    }

}
