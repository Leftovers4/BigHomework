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
     * Login result message.
     *
     * @param personnelID the personnel id
     * @param password    the password
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public ResultMessage login(long personnelID, String password) throws RemoteException;

    /**
     * Logout result message.
     *
     * @param personnelID the personnel id
     * @return the result message
     */
    public ResultMessage logout(long personnelID);

/*--------------------------------------------------------------------------------------------------------------------*/

    /**
     * View full personnel list list.
     *
     * @return the list
     * @throws RemoteException the remote exception
     */
    public List<PersonnelVO> viewFullPersonnelList() throws RemoteException;

    /**
     * View type personnel list list.
     *
     * @param personnelType the personnel type
     * @return the list
     * @throws RemoteException the remote exception
     */
    public List<PersonnelVO> viewTypePersonnelList(PersonnelType personnelType) throws RemoteException;

    /**
     * Add hotel worker long.
     *
     * @param personnelVO the personnel vo
     * @return the long
     * @throws RemoteException the remote exception
     */
    public long addHotelWorker(PersonnelVO personnelVO) throws RemoteException;

    /**
     * Add web marketer long.
     *
     * @param personnelVO the personnel vo
     * @return the long
     * @throws RemoteException the remote exception
     */
    public long addWebMarketer(PersonnelVO personnelVO) throws RemoteException;

    /**
     * Delete personnel result message.
     *
     * @param personnelID the personnel id
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public ResultMessage deletePersonnel(long personnelID) throws RemoteException;

    /**
     * Update personnel info result message.
     *
     * @param personnelVO the personnel vo
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public ResultMessage updatePersonnelInfo(PersonnelVO personnelVO) throws RemoteException;

    /**
     * Search personnel by id personnel vo.
     *
     * @param personnelID the personnel id
     * @return the personnel vo
     * @throws RemoteException the remote exception
     */
    public PersonnelVO searchPersonnelByID(long personnelID) throws RemoteException;

}