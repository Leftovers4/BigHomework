package data.dao.datafactory;

import data.dao.hoteldata.HotelDataServiceImpl;
import data.dao.orderdata.OrderDataServiceImpl;
import data.dao.personneldata.PersonnelDataServiceImpl;
import data.dao.promotiondata.PromotionDataServiceImpl;
import data.dao.userdata.UserDataServiceImpl;
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
    public UserDataService getUserDataService() throws RemoteException {
        return new UserDataServiceImpl();
    }

    @Override
    public PersonnelDataService getPersonnelDataService() throws RemoteException {
        return new PersonnelDataServiceImpl();
    }

    @Override
    public HotelDataService getHotelDataService() throws RemoteException {
        return new HotelDataServiceImpl();
    }

    @Override
    public OrderDataService getOrderDataService() throws RemoteException {
        return new OrderDataServiceImpl();
    }

    @Override
    public PromotionDataService getPromotionDataService() throws RemoteException {
        return new PromotionDataServiceImpl();
    }
}
