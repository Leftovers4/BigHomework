package dataservice_stub;

import dataservice.personneldataservice.PersonnelDataService;
import po.personnel.PersonnelPO;
import util.PersonnelType;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/13.
 */
public class PersonnelDataService_Stub implements PersonnelDataService{
    @Override
    public boolean canLogin(PersonnelPO personnelPO) throws RemoteException {
        return true;
    }

    @Override
    public ArrayList<PersonnelPO> getList() throws RemoteException {
        ArrayList<PersonnelPO> personnelPOs = new ArrayList<>();

        PersonnelPO personnelPO = new PersonnelPO(1, "123456");

        personnelPOs.add(personnelPO);

        return personnelPOs;
    }

    @Override
    public ArrayList<PersonnelPO> getListByType(PersonnelType personnelType) throws RemoteException {
        return null;
    }

    @Override
    public void insert(PersonnelPO personnelPO) throws RemoteException {

    }

    @Override
    public void delete(PersonnelPO personnelPO) throws RemoteException {

    }

    @Override
    public void update(PersonnelPO personnelPO) throws RemoteException {

    }

    @Override
    public PersonnelPO findByPersonnelID(long personnelID) throws RemoteException {
        PersonnelPO personnelPO = new PersonnelPO(1, "123456");
        return personnelPO;
    }

    @Override
    public void initial() throws RemoteException {

    }

    @Override
    public void finish() throws RemoteException {

    }
}
