package dataservice.memberdataservice;

import dataservice.DataServiceParent;
import po.member.MemberPO;

import java.rmi.RemoteException;

/**
 * Created by Hiki on 2016/10/16.
 */
public interface MemberDataService extends DataServiceParent {

    public MemberPO find(String username) throws RemoteException;

    public void insert(MemberPO memberPO) throws RemoteException;

    public void delete(MemberPO memberPO) throws RemoteException;

    public void update(MemberPO memberPO) throws RemoteException;




}
