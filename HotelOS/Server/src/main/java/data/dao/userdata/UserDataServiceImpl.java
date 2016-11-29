package data.dao.userdata;

import dataservice.userdataservice.UserDataService;
import po.user.CreditRecordPO;
import po.user.MemberPO;
import po.user.UserPO;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/16.
 */
public class UserDataServiceImpl implements UserDataService {


    @Override
    public UserPO findByUsername(String username) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage insert(UserPO userPO) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage delete(String username) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage update(UserPO userPO) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<UserPO> getList() throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage changeCredit(ArrayList<CreditRecordPO> creditRecordPOs) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage update(MemberPO memberPO) throws RemoteException {
        return null;
    }
}
