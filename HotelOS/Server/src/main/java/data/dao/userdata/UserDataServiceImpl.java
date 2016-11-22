package data.dao.userdata;

import dataservice.userdataservice.UserDataService;
import po.user.CreditPO;
import po.user.MemberPO;
import po.user.UserPO;
import util.ResultMessage;
import util.UserType;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class UserDataServiceImpl implements UserDataService {


    @Override
    public ResultMessage login(UserPO userPO) throws RemoteException {
        return null;
    }

    @Override
    public UserPO findByUsername(String username) throws RemoteException {
        return null;
    }

    @Override
    public void insert(UserPO userPO) throws RemoteException {

    }

    @Override
    public void delete(String username) throws RemoteException {

    }

    @Override
    public void update(UserPO userPO) throws RemoteException {

    }

    @Override
    public ArrayList<UserPO> getList() throws RemoteException {
        return null;
    }

    @Override
    public void changeCredit(CreditPO creditPO) throws RemoteException {

    }

    @Override
    public void update(MemberPO memberPO) throws RemoteException {

    }
}
