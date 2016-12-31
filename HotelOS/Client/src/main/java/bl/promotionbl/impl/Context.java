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
     * Instantiates a new Context.
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
     * Gets actual price.
     *
     * @param orderVO the order vo
     * @return the actual price
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
     * Get level int.
     *
     * @param credit the credit
     * @return the int
     */
    public int getLevel(double credit){
        return level.getLevel(credit);
    }

}
