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
public interface DataFactoryService extends DataServiceParent{

	public UserDataService getUserDataImpl() throws RemoteException;

	public PersonnelDataService getPersonnelDataImpl() throws RemoteException;

	public HotelDataService getHotelDataImpl() throws RemoteException;

	public OrderDataService getOrderDataImpl() throws RemoteException;

	public PromotionDataService getPromotionDataImpl() throws RemoteException;


}
