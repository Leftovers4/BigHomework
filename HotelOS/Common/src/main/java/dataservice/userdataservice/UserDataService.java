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

    // 登录
    public ResultMessage login(UserPO userPO) throws RemoteException;

    // 根据用户名查找用户
    public UserPO findByUsername(String username) throws RemoteException;

    // 判断用户能否登录（判断是否能同时登录）
    // public boolean canLogin(UserPO userPO) throws RemoteException;

    // 增加一个用户
    public void insert(UserPO userPO) throws RemoteException;

    // 删除一个用户
    public void delete(String username) throws RemoteException;

    // 更新一个用户
    public void update(UserPO userPO) throws RemoteException;

    // 显示用户列表
    public ArrayList<UserPO> getList() throws RemoteException;

    // 改变用户信用记录
    public void changeCredit(ArrayList<CreditRecordPO> creditRecordPOs) throws RemoteException;

//    // 注册会员
//    public void insertMember(MemberPO memberPO) throws RemoteException;
//
//    // 删除会员
//    public void deleteMember(String username) throws RemoteException;

    // 更新会员信息
    public void update(MemberPO memberPO) throws RemoteException;


}
