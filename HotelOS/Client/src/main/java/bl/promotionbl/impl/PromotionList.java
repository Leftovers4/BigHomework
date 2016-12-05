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

        for (int i = 0; i < this.size(); i++) {
            Context context = new Context(this.get(i));
            double actualPrice = context.getActualPrice(orderVO);
            if (actualPrice < res){
                res = actualPrice;
            }
        }

        return res;
    }

}
