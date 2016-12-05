package bl.promotionbl.impl;

import vo.order.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by kevin on 2016/11/18.
 */
public interface Sale extends Promotion{
    double getActualPrice(OrderVO orderVO) throws RemoteException;
}
