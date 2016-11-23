package dataservice_stub;

import dataservice.userdataservice.UserDataService;
import po.user.CreditPO;
import po.user.MemberPO;
import po.user.UserPO;
import util.MemberType;
import util.ResultMessage;
import util.UserType;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kevin on 2016/10/16.
 */
public class UserDataService_Stub implements UserDataService {
//    @Override
//    public void initial() throws RemoteException {
//
//    }
//
//    @Override
//    public void finish() throws RemoteException {
//
//    }

    @Override
    public ResultMessage login(UserPO userPO) throws RemoteException {
        return null;
    }

    @Override
    public UserPO findByUsername(String username) throws RemoteException {
        return new UserPO("张三", "123456", "李四", true, "12345678999", new MemberPO("张三", MemberType.NORMAL_MEMBER, 1, new Date(), null), new CreditPO("张三", 1000, null));
    }



    @Override
    public void update(UserPO UserPO) throws RemoteException {

    }



    @Override
    public void insert(UserPO UserPO) throws RemoteException {

    }

    @Override
    public void delete(String username) throws RemoteException {

    }

    @Override
    public ArrayList<UserPO> getList() throws RemoteException {
        ArrayList<UserPO> list = new ArrayList<>();
        list.add(new UserPO("张三", "123456", "李四", true, "12345678999", new MemberPO("张三", MemberType.NORMAL_MEMBER, 1, new Date(), null), new CreditPO("张三", 1000, null)));
        return list;
    }

    @Override
    public void changeCredit(CreditPO creditPO) throws RemoteException {

    }


    @Override
    public void update(MemberPO memberPO) throws RemoteException {

    }
}
