package data.dao.personneldata;

import dataservice.personneldataservice.PersonnelDataService;
import po.personnel.PersonnelPO;
import util.PersonnelType;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class PersonnelDataServiceImpl implements PersonnelDataService {


    @Override
    public ArrayList<PersonnelPO> findAll() throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<PersonnelPO> findByType(PersonnelType personnelType) throws RemoteException {
        return null;
    }

    @Override
    public void insert(PersonnelPO personnelPO) throws RemoteException {

    }

    @Override
    public void delete(long PersonnelID) throws RemoteException {

    }

    @Override
    public void update(PersonnelPO personnelPO) throws RemoteException {

    }

    @Override
    public PersonnelPO findByPersonnelID(long personnelID) throws RemoteException {
        return null;
    }
}
