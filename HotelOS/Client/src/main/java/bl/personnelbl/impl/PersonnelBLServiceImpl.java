package bl.personnelbl.impl;

import bl.personnelbl.PersonnelBLService;
import dataservice.personneldataservice.PersonnelDataService;
import po.personnel.PersonnelPO;
import rmi.RemoteHelper;
import util.IDProducer;
import util.PersonnelType;
import util.ResultMessage;
import vo.personnel.PersonnelVO;
import vo.personnel.PersonnelVOCreator;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class PersonnelBLServiceImpl implements PersonnelBLService{

    PersonnelDataService personnelDAO;

    PersonnelVOCreator personnelVOCreator;

    public PersonnelBLServiceImpl(){
        personnelDAO = RemoteHelper.getInstance().getPersonnelDAO();
        personnelVOCreator = new PersonnelVOCreator();
    }

    @Override
    public ResultMessage login(long personnelID, String password) {
        return null;
    }

    @Override
    public ResultMessage logout(long personnelID) {
        return null;
    }

/*--------------------------------------------------------------------------------------------------------------------*/

    @Override
    public List<PersonnelVO> viewFullPersonnelList() throws RemoteException {
        return personnelVOCreator.createAll(personnelDAO.findAll());
    }

    @Override
    public List<PersonnelVO> viewTypePersonnelList(PersonnelType personnelType) throws RemoteException {
        return personnelVOCreator.createAll(personnelDAO.findByType(personnelType));
    }

    @Override
    public ResultMessage addHotelWorker(PersonnelVO personnelVO) throws RemoteException {
        PersonnelPO personnelPO = new PersonnelPO();

        personnelPO.setPersonnelID(IDProducer.produceGeneralID());
        personnelPO.setPassword(personnelVO.password);
        personnelPO.setPersonnelType(PersonnelType.HotelWorker);
        personnelPO.setName(personnelVO.name);
        personnelPO.setHotelID(personnelVO.hotelID);

        return personnelDAO.insert(personnelPO);
    }

    @Override
    public ResultMessage addWebMarketer(PersonnelVO personnelVO) throws RemoteException {
        PersonnelPO personnelPO = new PersonnelPO();

        personnelPO.setPersonnelID(IDProducer.produceGeneralID());
        personnelPO.setPassword(personnelVO.password);
        personnelPO.setPersonnelType(PersonnelType.WebMarketer);
        personnelPO.setName(personnelVO.name);

        return personnelDAO.insert(personnelPO);
    }

    @Override
    public ResultMessage deletePersonnel(long personnelID) throws RemoteException {
        return personnelDAO.delete(personnelID);
    }

    @Override
    public ResultMessage updatePersonnelInfo(PersonnelVO personnelVO) throws RemoteException {
        PersonnelPO personnelPO = personnelDAO.findByPersonnelID(personnelVO.personnelID);

        personnelPO.setPassword(personnelVO.password);
        personnelPO.setName(personnelVO.name);

        return personnelDAO.update(personnelPO);
    }

    @Override
    public PersonnelVO searchPersonnelByID(long personnelID) throws RemoteException {
        PersonnelPO personnelPO = personnelDAO.findByPersonnelID(personnelID);

        //存在找不到对应的工作人员的情况
        if (personnelPO == null)
            return null;

        return personnelVOCreator.create(personnelPO);
    }

}
