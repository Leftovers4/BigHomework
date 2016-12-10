package bl.personnelbl;

import util.PersonnelType;
import util.ResultMessage;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiki on 2016/10/29.
 */
public interface PersonnelBLService {

    // 员工登录
    public ResultMessage login(long personnelID, String password) throws RemoteException;

    // 员工登出
    public ResultMessage logout(long personnelID);

/*--------------------------------------------------------------------------------------------------------------------*/

    // 显示员工列表
    public List<PersonnelVO> viewFullPersonnelList() throws RemoteException;

    // 按类型显示员工列表
    public List<PersonnelVO> viewTypePersonnelList(PersonnelType personnelType) throws RemoteException;

    // 增加员工
    public long addHotelWorker(PersonnelVO personnelVO) throws RemoteException;

    public long addWebMarketer(PersonnelVO personnelVO) throws RemoteException;

    // 删除员工
    public ResultMessage deletePersonnel(long personnelID) throws RemoteException;

    // 修改员工信息
    public ResultMessage updatePersonnelInfo(PersonnelVO personnelVO) throws RemoteException;

    // 查找员工
    public PersonnelVO searchPersonnelByID(long personnelID) throws RemoteException;

}