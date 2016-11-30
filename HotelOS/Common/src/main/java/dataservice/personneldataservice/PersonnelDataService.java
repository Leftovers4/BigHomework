package dataservice.personneldataservice;

import dataservice.DataServiceParent;
import po.personnel.PersonnelPO;
import util.PersonnelType;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/11/6.
 */
public interface PersonnelDataService extends Remote{

    // 判断员工是否能够登录
//    public ResultMessage login(PersonnelPO personnelPO) throws RemoteException;

    // 显示员工列表
    public ArrayList<PersonnelPO> findAll() throws RemoteException;

    // 按类型显示员工列表
    public ArrayList<PersonnelPO> findByType(PersonnelType personnelType) throws RemoteException;

    // 新增员工
    public ResultMessage insert(PersonnelPO personnelPO) throws RemoteException;

    // 删除员工
    public ResultMessage delete(long personnelID) throws RemoteException;

    // 更新员工信息
    public ResultMessage update(PersonnelPO personnelPO) throws RemoteException;

    // 根据ID查找员工
    public PersonnelPO findByPersonnelID(long personnelID) throws RemoteException;




}
