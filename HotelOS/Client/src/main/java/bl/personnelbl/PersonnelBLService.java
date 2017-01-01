package bl.personnelbl;

import util.PersonnelType;
import util.ResultMessage;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * The interface Personnel bl service.
 */
public interface PersonnelBLService {

    /**
     * 工作人员登录
     *
     * @param personnelID 工作人员ID
     * @param password    密码
     * @return UsernameNotExisted，PasswordWrong，Success
     * @throws RemoteException 连接服务器异常
     */
    public ResultMessage login(long personnelID, String password) throws RemoteException;

    /**
     * 工作人员登出
     *
     * @param personnelID 工作人员ID
     * @return Success
     */
    public ResultMessage logout(long personnelID);

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * 获取全部工作人员
     *
     * @return 全部工作人员
     * @throws RemoteException 连接服务器异常
     */
    public List<PersonnelVO> viewFullPersonnelList() throws RemoteException;

    /**
     * 获取某类型的工作人员
     *
     * @param personnelType 工作人员类型，有酒店工作人员，网站营销人员，网站管理人员
     * @return 某类型的工作人员
     * @throws RemoteException 连接服务器异常
     */
    public List<PersonnelVO> viewTypePersonnelList(PersonnelType personnelType) throws RemoteException;

    /**
     * 添加酒店工作人员
     *
     * @param personnelVO 酒店工作人员信息
     * @return 新加的酒店工作人员的ID
     * @throws RemoteException 连接服务器异常
     */
    public long addHotelWorker(PersonnelVO personnelVO) throws RemoteException;

    /**
     * 添加网站营销人员
     *
     * @param personnelVO 网站营销人员信息
     * @return 新加的网站营销人员的ID
     * @throws RemoteException 连接服务器异常
     */
    public long addWebMarketer(PersonnelVO personnelVO) throws RemoteException;

    /**
     * 删除工作人员
     *
     * @param personnelID 工作人员ID
     * @return 数据库返回的result message
     * @throws RemoteException 连接服务器异常
     */
    public ResultMessage deletePersonnel(long personnelID) throws RemoteException;

    /**
     * 更新工作人员信息
     *
     * @param personnelVO 工作人员信息
     * @return DataNotExisted和数据库返回的result message
     * @throws RemoteException 连接服务器异常
     */
    public ResultMessage updatePersonnelInfo(PersonnelVO personnelVO) throws RemoteException;

    /**
     * 根据ID查找工作人员
     *
     * @param personnelID 工作人员ID
     * @return ID对应的工作人员，可能为null
     * @throws RemoteException 连接服务器异常
     */
    public PersonnelVO searchPersonnelByID(long personnelID) throws RemoteException;

}