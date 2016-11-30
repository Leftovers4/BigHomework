package dataservice.userdataservice;

//TODO 有俩个memberpo
import po.user.CreditRecordPO;
import po.user.MemberPO;
import po.user.UserPO;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/10/16.
 */
public interface UserDataService extends Remote{

    // 增加一个用户
    public ResultMessage insert(UserPO userPO) throws RemoteException;

    // 删除一个用户
    public ResultMessage delete(String username) throws RemoteException;

    // 更新一个用户
    public ResultMessage update(UserPO userPO) throws RemoteException;

    // 查找所有用户
    public ArrayList<UserPO> findAll() throws RemoteException;

    // 根据用户名查找用户
    public UserPO findByUsername(String username) throws RemoteException;

    // 改变用户信用记录
    public ResultMessage changeCredit(ArrayList<CreditRecordPO> creditRecordPOs) throws RemoteException;

    // 更新会员信息
    public ResultMessage update(MemberPO memberPO) throws RemoteException;


}
