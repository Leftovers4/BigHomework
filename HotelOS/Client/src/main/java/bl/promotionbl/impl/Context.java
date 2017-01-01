package bl.promotionbl.impl;

import po.promotion.PromotionPO;
import vo.order.OrderVO;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.List;


/**
 * Created by kevin on 2016/11/18.
 */
public class Context{

    private Sale sale;

    private Level level;

    /**
     * 利用反射创建具体的促销策略
     *
     * @param promotionPO the promotion po
     * @throws ClassNotFoundException    the class not found exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InstantiationException    the instantiation exception
     * @throws InvocationTargetException the invocation target exception
     */
    public Context(PromotionPO promotionPO) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        super();
        String promotionName = promotionPO.getPromotionType().toString();
        Class<?> promotionClass = Class.forName("bl.promotionbl.impl." + promotionName);
        Constructor<?>[] constructors = promotionClass.getConstructors();
        Promotion promotion = (Promotion) constructors[0].newInstance(promotionPO);

        if (promotion instanceof Sale){
            sale = (Sale)promotion;
        }

        if (promotion instanceof Level){
            level = (Level)promotion;
        }
    }

    /**
     * 获取订单的实际价格
     *
     * @param orderVO 订单信息
     * @return 订单的实际价格
     * @throws RemoteException           the remote exception
     * @throws ClassNotFoundException    the class not found exception
     * @throws InvocationTargetException the invocation target exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     */
    public double getActualPrice(OrderVO orderVO) throws RemoteException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return sale.getActualPrice(orderVO);
    }

    /**
     * 获取客户的等级
     *
     * @param credit 客户当前信用
     * @return 客户的等级
     */
    public int getLevel(double credit){
        return level.getLevel(credit);
    }

}
