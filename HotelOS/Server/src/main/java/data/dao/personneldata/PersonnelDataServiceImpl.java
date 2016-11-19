package data.dao.personneldata;

import dataservice.personneldataservice.PersonnelDataService;
import po.personnel.PersonnelPO;
import util.PersonnelType;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class PersonnelDataServiceImpl implements PersonnelDataService {
    public boolean canLogin(PersonnelPO personnelPO) throws RemoteException {
        return false;
    }

    public ArrayList<PersonnelPO> getList() throws RemoteException {
        return null;
    }

    public ArrayList<PersonnelPO> getListByType(PersonnelType personnelType) throws RemoteException {
        return null;
    }

    public void insert(PersonnelPO personnelPO) throws RemoteException {

    }

    public void delete(PersonnelPO personnelPO) throws RemoteException {

    }

    public void update(PersonnelPO personnelPO) throws RemoteException {

    }

    public PersonnelPO findByPersonnelID(long personnelID) throws RemoteException {
        return null;
    }

    public void initial() throws RemoteException {

    }

    public void finish() throws RemoteException {

    }
}
