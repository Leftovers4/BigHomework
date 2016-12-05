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

    // 插入新的用户信用记录
    public ResultMessage insertCreditRecord(CreditRecordPO creditRecordPO) throws RemoteException;

    // 根据用户名查找信用记录列表
    public ArrayList<CreditRecordPO> findCreditRecordsByUsername(String username) throws RemoteException;

    // 获得用户头像，以二进制字符串传输
    public byte[] getImage(String username) throws RemoteException;

    // 修改用户头像，以二进制字符串传输
    public ResultMessage setImage(String username, byte[] image) throws RemoteException;


}
