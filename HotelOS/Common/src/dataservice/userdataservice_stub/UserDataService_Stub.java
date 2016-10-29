package dataservice.userdataservice_stub;

import dataservice.userdataservice.UserDataService;
import util.UserType;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/10/16.
 */
public class UserDataService_Stub implements UserDataService {
    @Override
    public void initial() throws RemoteException {

    }

    @Override
    public void finish() throws RemoteException {

    }

    @Override
    public UserPO findByUsername(String username) throws RemoteException {
        return new UserPO("张三", "123456");
    }

    @Override
    public ArrayList<UserPO> findByType(UserType userType) throws RemoteException {
        ArrayList<UserPO> list = new ArrayList<>();
        list.add(new UserPO("张三", "123456"));
        return list;
    }

    @Override
    public void insert(UserPO UserPO) throws RemoteException {

    }

    @Override
    public void delete(UserPO UserPO) throws RemoteException {

    }

    @Override
    public void update(UserPO UserPO) throws RemoteException {

    }

    @Override
    public ArrayList<UserPO> getList() throws RemoteException {
        ArrayList<UserPO> list = new ArrayList<>();
        list.add(new UserPO("张三", "123456"));
        return list;
    }

    @Override
    public void addCredit(String username, double amount) throws RemoteException {

    }

    @Override
    public void deductCredit(String username, double amount) throws RemoteException {

    }
}
