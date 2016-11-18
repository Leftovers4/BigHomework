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
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by kevin on 2016/11/17.
 */
public class RemoteHelper {
    private HotelDataService hotelDAO;
    private OrderDataService orderDAO;
    private PersonnelDataService personnelDAO;
    private PromotionDataService promotionDAO;
    private UserDataService userDAO;

    public RemoteHelper() {
        hotelDAO = new HotelDataServiceImpl();
        orderDAO = new OrderDataServiceImpl();
        personnelDAO = new PersonnelDataServiceImpl();
        promotionDAO = new PromotionDataServiceImpl();
        userDAO = new UserDataServiceImpl();
    }

    public void run() {
        try {
            HotelDataService hotelDAOStub = (HotelDataService) UnicastRemoteObject.exportObject(hotelDAO, 0);
            OrderDataService orderDAOStub = (OrderDataService) UnicastRemoteObject.exportObject(orderDAO, 0);
            PersonnelDataService personnelDAOStub = (PersonnelDataService) UnicastRemoteObject.exportObject(personnelDAO, 0);
            PromotionDataService promotionDAOStub = (PromotionDataService) UnicastRemoteObject.exportObject(promotionDAO, 0);
            UserDataService userDAOStub = (UserDataService) UnicastRemoteObject.exportObject(userDAO, 0);

            String hotelDAOName = "HotelDataService";
            String orderDAOName = "OrderDataService";
            String personnelDAOName = "PersonnelDataService";
            String promotionDAOName = "PromotionDataService";
            String userDAOName = "UserDataService";

            LocateRegistry.createRegistry(1098);
            String networkAddress = "rmi://localhost:1098";
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
}
