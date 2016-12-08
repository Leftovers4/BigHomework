package rmi;

import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.personneldataservice.PersonnelDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.userdataservice.UserDataService;
import data.dao.hoteldata.HotelDataServiceImpl;
import data.dao.orderdata.OrderDataServiceImpl;
import data.dao.personneldata.PersonnelDataServiceImpl;
import data.dao.promotiondata.PromotionDataServiceImpl;
import data.dao.userdata.UserDataServiceImpl;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by kevin on 2016/11/17.
 */
public class RemoteHelper {

    //单例
    private static RemoteHelper remoteHelper;

    //networkAddress
    private String networkAddress;

    // dao
    private HotelDataService hotelDAO;
    private OrderDataService orderDAO;
    private PersonnelDataService personnelDAO;
    private PromotionDataService promotionDAO;
    private UserDataService userDAO;

    // daoname
    String hotelDAOName;
    String orderDAOName;
    String personnelDAOName;
    String promotionDAOName;
    String userDAOName;

    public static RemoteHelper getInstance() {
        if (remoteHelper == null)
            remoteHelper = new RemoteHelper();

        return remoteHelper;
    }

    private RemoteHelper() {
        initial();
    }

    private void initial() {
        try {
            // 初始化dao
            hotelDAO = new HotelDataServiceImpl();
            orderDAO = new OrderDataServiceImpl();
            personnelDAO = new PersonnelDataServiceImpl();
            promotionDAO = new PromotionDataServiceImpl();
            userDAO = new UserDataServiceImpl();
            // 初始化daoname
            hotelDAOName = "HotelDataService";
            orderDAOName = "OrderDataService";
            personnelDAOName = "PersonnelDataService";
            promotionDAOName = "PromotionDataService";
            userDAOName = "UserDataService";
            //创建注册机
            LocateRegistry.createRegistry(1098);
            //初始化networkAddress
            networkAddress = "rmi://localhost:1098";
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            HotelDataService hotelDAOStub = (HotelDataService) UnicastRemoteObject.exportObject(hotelDAO, 0);
            OrderDataService orderDAOStub = (OrderDataService) UnicastRemoteObject.exportObject(orderDAO, 0);
            PersonnelDataService personnelDAOStub = (PersonnelDataService) UnicastRemoteObject.exportObject(personnelDAO, 0);
            PromotionDataService promotionDAOStub = (PromotionDataService) UnicastRemoteObject.exportObject(promotionDAO, 0);
            UserDataService userDAOStub = userDAOStub = (UserDataService) UnicastRemoteObject.exportObject(userDAO, 0);

            Naming.bind(networkAddress + "/" + hotelDAOName, hotelDAOStub);
            Naming.bind(networkAddress + "/" + orderDAOName, orderDAOStub);
            Naming.bind(networkAddress + "/" + personnelDAOName, personnelDAOStub);
            Naming.bind(networkAddress + "/" + promotionDAOName, promotionDAOStub);
            Naming.bind(networkAddress + "/" + userDAOName, userDAOStub);

            System.out.println("Server successfully launched!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            Naming.unbind(networkAddress + "/" + hotelDAOName);
            Naming.unbind(networkAddress + "/" + orderDAOName);
            Naming.unbind(networkAddress + "/" + personnelDAOName);
            Naming.unbind(networkAddress + "/" + promotionDAOName);
            Naming.unbind(networkAddress + "/" + userDAOName);

            UnicastRemoteObject.unexportObject(hotelDAO, true);
            UnicastRemoteObject.unexportObject(orderDAO, true);
            UnicastRemoteObject.unexportObject(personnelDAO, true);
            UnicastRemoteObject.unexportObject(promotionDAO, true);
            UnicastRemoteObject.unexportObject(userDAO, true);

            System.out.println("Server successfully stopped!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
