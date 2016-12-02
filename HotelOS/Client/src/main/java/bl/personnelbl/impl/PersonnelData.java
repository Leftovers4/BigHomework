package bl.personnelbl.impl;

import dataservice.personneldataservice.PersonnelDataService;
import rmi.RemoteHelper;

import java.rmi.RemoteException;

/**
 * Created by kevin on 2016/12/1.
 */
public class PersonnelData {

    private PersonnelDataService personnelDao;

    public PersonnelData(){
        personnelDao = RemoteHelper.getInstance().getPersonnelDAO();
    }

    public Personnel findByHotelID(long hotelID){
        try {
            //todo 方法错误，重新调用
            return (Personnel)(personnelDao.findByPersonnelID(hotelID));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Personnel findByPersonnelID(long personnelID){
        try {
            return (Personnel) (personnelDao.findByPersonnelID(personnelID));
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

}
