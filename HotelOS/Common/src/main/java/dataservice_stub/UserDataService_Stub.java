package dataservice_stub;

import dataservice.userdataservice.UserDataService;
import po.user.CreditRecordPO;
import po.user.MemberPO;
import po.user.UserPO;
import util.MemberType;
import util.ResultMessage;

import java.rmi.RemoteException;
import java.time.LocalDate;
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
    public UserPO findByUsername(String username) throws RemoteException {
        return new UserPO("张三", "123456", "李四", true, "12345678999", new MemberPO("张三", MemberType.NormalMember, 1, LocalDate.now(), null), null);
    }

    @Override
    public ResultMessage insertCreditRecord(CreditRecordPO creditRecordPO) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<CreditRecordPO> findCreditRecordsByUsername(String username) throws RemoteException {
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
    public ArrayList<UserPO> findAll() throws RemoteException {
        ArrayList<UserPO> list = new ArrayList<>();
        list.add(new UserPO("张三", "123456", "李四", true, "12345678999", new MemberPO("张三", MemberType.NormalMember, 1, LocalDate.now(), null), null));
        return list;
    }




}
