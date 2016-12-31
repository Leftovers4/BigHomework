package bl.promotionbl.impl;

import vo.order.OrderVO;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

/**
 * Created by kevin on 2016/11/18.
 */
public interface Sale extends Promotion{
    /**
     * Gets actual price.
     *
     * @param orderVO the order vo
     * @return the actual price
     * @throws RemoteException           the remote exception
     * @throws ClassNotFoundException    the class not found exception
     * @throws InstantiationException    the instantiation exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    double getActualPrice(OrderVO orderVO) throws RemoteException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException;
}
