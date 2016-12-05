package blservice_stub;

import bl.personnelbl.PersonnelBLService;
import util.PersonnelType;
import util.ResultMessage;
import vo.personnel.PersonnelVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/13.
 */
public class PersonnelBLService_Stub implements PersonnelBLService{

    public ResultMessage login(PersonnelVO personnelVO) {
        return ResultMessage.Success;
    }

    public ResultMessage logout() {
        return ResultMessage.Success;
    }

    public ArrayList<PersonnelVO> showList() {
        ArrayList<PersonnelVO> personnelVOs = new ArrayList<PersonnelVO>();

        PersonnelVO personnelVO = new PersonnelVO();

        personnelVOs.add(personnelVO);

        return personnelVOs;
    }

    public ArrayList<PersonnelVO> showListByType(PersonnelType personnelType) {
        return null;
    }

    public ResultMessage add(PersonnelVO personnelVO) {
        return ResultMessage.Success;
    }

    public ResultMessage del(long personnelID) {
        return ResultMessage.Success;
    }

    public ResultMessage modify(PersonnelVO personnelVO) {
        return ResultMessage.Success;
    }

    public PersonnelVO find(long personnelID) {
        PersonnelVO personnelVO = new PersonnelVO();
        return personnelVO;
    }

    @Override
    public ResultMessage login(long personnelID, String password) {
        return null;
    }

    @Override
    public ResultMessage logout(long personnelID) {
        return null;
    }

    @Override
    public List<PersonnelVO> viewFullPersonnelList() throws RemoteException {
        return null;
    }

    @Override
    public List<PersonnelVO> viewTypePersonnelList(PersonnelType personnelType) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addHotelWorker(PersonnelVO personnelVO) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage addWebMarketer(PersonnelVO personnelVO) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage deletePersonnel(long personnelID) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage updatePersonnelInfo(PersonnelVO personnelVO) throws RemoteException {
        return null;
    }

    @Override
    public PersonnelVO searchPersonnelByID(long personnelID) throws RemoteException {
        return null;
    }
}
