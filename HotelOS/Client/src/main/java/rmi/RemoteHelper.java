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

    private RemoteHelper() {
        networkAddress = "rmi://localhost:1098";
    }

    /**
     * 单例模式：接管RemoteHelper实例的创建
     *
     * @return RemoteHelper实例
     */
    public static RemoteHelper getInstance() {
        if (remoteHelper == null)
            remoteHelper = new RemoteHelper();
        return remoteHelper;
    }

    /**
     * 获取hotelDAO
     *
     * @return hotelDAO
     * @throws RemoteException 连接服务器异常
     */
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

    /**
     * 获取orderDAO
     *
     * @return orderDAO
     * @throws RemoteException 连接服务器异常
     */
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

    /**
     * 获取personnelDAO
     *
     * @return personnelDAO
     * @throws RemoteException 连接服务器异常
     */
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

    /**
     * 获取promotionDAO
     *
     * @return promotionDAO
     * @throws RemoteException 连接服务器异常
     */
    public PromotionDataService getPromotionDAO() throws RemoteException {
        try {
            promotionDAO = (PromotionDataService) Naming.lookup(networkAddress + "/" + "PromotionDataService");
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

    /**
     * 获取userDAO
     *
     * @return userDAO
     * @throws RemoteException 连接服务器异常
     */
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
