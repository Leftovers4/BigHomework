package data.dao.datafactory;

import dataservice.datafactoryservice.DataFactoryService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.personneldataservice.PersonnelDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.userdataservice.UserDataService;

import java.rmi.RemoteException;

/**
 * Created by Hiki on 11/20/2016.
 */
public class DataFactoryServiceImpl implements DataFactoryService{
    @Override
    public UserDataService getUserDataImpl() throws RemoteException {
        return null;
    }

    @Override
    public PersonnelDataService getPersonnelDataImpl() throws RemoteException {
        return null;
    }

    @Override
    public HotelDataService getHotelDataImpl() throws RemoteException {
        return null;
    }

    @Override
    public OrderDataService getOrderDataImpl() throws RemoteException {
        return null;
    }

    @Override
    public PromotionDataService getPromotionDataImpl() throws RemoteException {
        return null;
    }
}
