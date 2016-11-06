package dataservice_stub;

import dataservice.userdataservice.UserDataService;
import po.user.CreditPO;
import po.user.UserPO;
import util.MemberType;
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
        return new UserPO("张三", "123456", "李四", true, "12345678999", MemberType.NORMAL_MEMBER, new CreditPO("张三", 1000, null));
    }

    @Override
    public ArrayList<UserPO> findByType(UserType userType) throws RemoteException {
        ArrayList<UserPO> list = new ArrayList<>();
        list.add(new UserPO("张三", "123456", "李四", true, "12345678999", MemberType.NORMAL_MEMBER, new CreditPO("张三", 1000, null)));
        return list;
    }

    @Override
    public void update(UserPO UserPO) throws RemoteException {

    }

    @Override
    public void delete(UserPO UserPO) throws RemoteException {

    }

    @Override
    public void insert(UserPO UserPO) throws RemoteException {

    }

    @Override
    public ArrayList<UserPO> getList() throws RemoteException {
        ArrayList<UserPO> list = new ArrayList<>();
        list.add(new UserPO("张三", "123456", "李四", true, "12345678999", MemberType.NORMAL_MEMBER, new CreditPO("张三", 1000, null)));
        return list;
    }

    @Override
    public void addCredit(String username, double amount) throws RemoteException {

    }

    @Override
    public void deductCredit(String username, double amount) throws RemoteException {

    }
}
