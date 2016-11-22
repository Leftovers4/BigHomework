package dataservice.datafactoryservice;

import java.rmi.RemoteException;

import dataservice.personneldataservice.PersonnelDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.DataServiceParent;

/**
 * 数据工厂
 * 
 * @author Hiki
 * @version 2016年10月16日
 */
public interface DataFactoryService {

	public UserDataService getUserDataService() throws RemoteException;

	public PersonnelDataService getPersonnelDataService() throws RemoteException;

	public HotelDataService getHotelDataService() throws RemoteException;

	public OrderDataService getOrderDataService() throws RemoteException;

	public PromotionDataService getPromotionDataService() throws RemoteException;


}
