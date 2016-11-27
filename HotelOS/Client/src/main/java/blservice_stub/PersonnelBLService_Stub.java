package blservice_stub;

import bl.personnelbl.PersonnelBLService;
import util.PersonnelType;
import util.ResultMessage;
import vo.personnel.PersonnelVO;

import java.util.ArrayList;

/**
 * Created by kevin on 2016/11/13.
 */
public class PersonnelBLService_Stub implements PersonnelBLService{
    @Override
    public ResultMessage login(PersonnelVO personnelVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage logout() {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ArrayList<PersonnelVO> showList() {
        ArrayList<PersonnelVO> personnelVOs = new ArrayList<PersonnelVO>();

        PersonnelVO personnelVO = new PersonnelVO(1, "123456", PersonnelType.HotelWorker);

        personnelVOs.add(personnelVO);

        return personnelVOs;
    }

    @Override
    public ArrayList<PersonnelVO> showListByType(PersonnelType personnelType) {
        return null;
    }

    @Override
    public ResultMessage add(PersonnelVO personnelVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage del(long personnelID) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public ResultMessage modify(PersonnelVO personnelVO) {
        return ResultMessage.SUCCESS;
    }

    @Override
    public PersonnelVO find(long personnelID) {
        PersonnelVO personnelVO = new PersonnelVO(1, "123456", PersonnelType.HotelWorker);
        return personnelVO;
    }
}
