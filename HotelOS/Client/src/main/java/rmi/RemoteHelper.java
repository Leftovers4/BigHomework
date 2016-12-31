package rmi;

import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.personneldataservice.PersonnelDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.userdataservice.UserDataService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by kevin on 2016/11/16.
 */
public class RemoteHelper {

    public static RemoteHelper remoteHelper;
    private String networkAddress;
    private HotelDataService hotelDAO;
    private OrderDataService orderDAO;
    private PersonnelDataService personnelDAO;
    private PromotionDataService promotionDAO;
    private UserDataService userDAO;

    public static void main(String[] args) throws RemoteException {
        RemoteHelper remoteHelper = RemoteHelper.getInstance();
        HotelDataService hotelDAO = remoteHelper.getHotelDAO();
        ;
        System.out.println(hotelDAO.delete(1));
    }

    private RemoteHelper(){
        networkAddress = "rmi://localhost:1098";
    }

    public static RemoteHelper getInstance(){
        if (remoteHelper == null)
            remoteHelper = new RemoteHelper();
        return remoteHelper;
    }

    public HotelDataService getHotelDAO() throws RemoteException {
        try {
            hotelDAO = (HotelDataService) Naming.lookup(networkAddress + "/" + "HotelDataService");
            System.out.println("Link to server!");
        } catch (NotBoundException e) {
            e.printStackTrace();
            throw new RemoteException();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RemoteException();
        }
        return hotelDAO;
    }

    public OrderDataService getOrderDAO() throws RemoteException {
        try {
            orderDAO = (OrderDataService) Naming.lookup(networkAddress + "/" + "OrderDataService");
            System.out.println("Link to server!");
        } catch (NotBoundException e) {
            e.printStackTrace();
            throw new RemoteException();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RemoteException();
        }
        return orderDAO;
    }

    public PersonnelDataService getPersonnelDAO() throws RemoteException {
        try {
            personnelDAO = (PersonnelDataService) Naming.lookup(networkAddress + "/" + "PersonnelDataService");
            System.out.println("Link to server!");
        } catch (NotBoundException e) {
            e.printStackTrace();
            throw new RemoteException();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RemoteException();
        }
        return personnelDAO;
    }

    public PromotionDataService getPromotionDAO() throws RemoteException {
        try {
            promotionDAO= (PromotionDataService) Naming.lookup(networkAddress + "/" + "PromotionDataService");
            System.out.println("Link to server!");
        } catch (NotBoundException e) {
            e.printStackTrace();
            throw new RemoteException();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RemoteException();
        }
        return promotionDAO;
    }

    public UserDataService getUserDAO() throws RemoteException {
        try {
            userDAO = (UserDataService) Naming.lookup(networkAddress + "/" + "UserDataService");
            System.out.println("Link to server!");
        } catch (NotBoundException e) {
            e.printStackTrace();
            throw new RemoteException();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RemoteException();
        }
        return userDAO;
    }

}
