package data.dao.userdata;

import dataservice.userdataservice.UserDataService;
import po.user.MemberPO;
import po.user.UserPO;
import util.UserType;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class UserDataServiceImpl implements UserDataService {
    public void initial() throws RemoteException {

    }

    public void finish() throws RemoteException {

    }

    public UserPO findByUsername(String username) throws RemoteException {
        return null;
    }

    public ArrayList<UserPO> findByType(UserType userType) throws RemoteException {
        return null;
    }

    public void insert(UserPO userPO) throws RemoteException {

    }

    public void delete(UserPO userPO) throws RemoteException {

    }

    public void update(UserPO userPO) throws RemoteException {

    }

    public ArrayList<UserPO> getList() throws RemoteException {
        return null;
    }

    public void addCredit(String username, double amount) throws RemoteException {

    }

    public void deductCredit(String username, double amount) throws RemoteException {

    }

    public void insertMember(MemberPO memberPO) throws RemoteException {

    }

    public void deleteMember(String username) throws RemoteException {

    }

    public void update(MemberPO memberPO) throws RemoteException {

    }
}
