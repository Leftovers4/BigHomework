package dataservice_stub;

import dataservice.memberdataservice.MemberDataService;
import po.member.MemberPO;
import util.MemberType;

import java.rmi.RemoteException;

/**
 * Created by kevin on 2016/10/16.
 */
public class MemberDataService_Stub implements MemberDataService {
    @Override
    public void initial() throws RemoteException {

    }

    @Override
    public void finish() throws RemoteException {

    }

    @Override
    public MemberPO find(String username) throws RemoteException {
        return new MemberPO("张三", MemberType.NORMAL_MEMBER, 1, null, null);
    }

    @Override
    public void insert(MemberPO memberPO) throws RemoteException {

    }

    @Override
    public void delete(MemberPO memberPO) throws RemoteException {

    }

    @Override
    public void update(MemberPO memberPO) throws RemoteException {

    }
}
