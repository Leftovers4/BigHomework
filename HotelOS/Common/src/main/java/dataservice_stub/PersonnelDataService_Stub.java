package dataservice_stub;

import dataservice.personneldataservice.PersonnelDataService;
import po.personnel.PersonnelPO;
import util.PersonnelType;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/13.
 */
public class PersonnelDataService_Stub implements PersonnelDataService{


    @Override
    public ArrayList<PersonnelPO> findAll() throws RemoteException {
        ArrayList<PersonnelPO> personnelPOs = new ArrayList<>();

        PersonnelPO personnelPO = new PersonnelPO(1, "123456", PersonnelType.WebMarketer, "A");

        personnelPOs.add(personnelPO);

        return personnelPOs;
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

//    @Override
//    public void delete(PersonnelPO personnelPO) throws RemoteException {
//
//    }

    @Override
    public void update(PersonnelPO personnelPO) throws RemoteException {

    }

    @Override
    public PersonnelPO findByPersonnelID(long personnelID) throws RemoteException {
        PersonnelPO personnelPO = new PersonnelPO(1, "123456", PersonnelType.WebMarketer, "A");
        return personnelPO;
    }

//    @Override
//    public void initial() throws RemoteException {
//
//    }
//
//    @Override
//    public void finish() throws RemoteException {
//
//    }
}
