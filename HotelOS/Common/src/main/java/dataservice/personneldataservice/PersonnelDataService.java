package dataservice.personneldataservice;

import dataservice.DataServiceParent;
import po.personnel.PersonnelPO;
import util.PersonnelType;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Hiki on 2016/11/6.
 */
public interface PersonnelDataService extends DataServiceParent{

    // 判断员工是否能够登录
    public boolean canLogin(PersonnelPO personnelPO) throws RemoteException;

    // 显示员工列表
    public ArrayList<PersonnelPO> getList() throws RemoteException;

    // 按类型显示员工列表
    public ArrayList<PersonnelPO> getListByType(PersonnelType personnelType) throws RemoteException;

    // 新增员工
    public void insert(PersonnelPO personnelPO) throws RemoteException;

    // 删除员工
    public void delete(long PersonnelID) throws RemoteException;

    // 更新员工信息
    public void update(PersonnelPO personnelPO) throws RemoteException;

    // 根据ID查找员工
    public PersonnelPO findByPersonnelID(long personnelID) throws RemoteException;




}
