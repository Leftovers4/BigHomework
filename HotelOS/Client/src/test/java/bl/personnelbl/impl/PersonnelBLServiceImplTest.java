package bl.personnelbl.impl;

import bl.personnelbl.PersonnelBLService;
import org.junit.Before;
import org.junit.Test;
import util.PersonnelType;
import vo.personnel.PersonnelVO;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/12/6.
 */
public class PersonnelBLServiceImplTest {

    PersonnelBLService tested;

    @Before
    public void setUp() throws Exception {
        tested = new PersonnelBLServiceImpl();
    }

    @Test
    public void login() throws Exception {

    }

    @Test
    public void logout() throws Exception {

    }

    @Test
    public void viewFullPersonnelList() throws Exception {
        List<PersonnelVO> personnelVOList = tested.viewFullPersonnelList();
    }

    @Test
    public void viewTypePersonnelList() throws Exception {
        List<PersonnelVO> personnelVOList = tested.viewTypePersonnelList(PersonnelType.WebMarketer);
    }

    @Test
    public void addHotelWorker() throws Exception {
        PersonnelVO personnelVO = new PersonnelVO();

        personnelVO.hotelID = 233333;
        personnelVO.name = "lisi";
        personnelVO.password = "654321";

        tested.addHotelWorker(personnelVO);
    }

    @Test
    public void addWebMarketer() throws Exception {
        PersonnelVO personnelVO = new PersonnelVO();

        personnelVO.name = "marketer";
        personnelVO.password = "abc";

        tested.addWebMarketer(personnelVO);
    }

    @Test
    public void deletePersonnel() throws Exception {
        tested.deletePersonnel(659748);
    }

    @Test
    public void updatePersonnelInfo() throws Exception {
        PersonnelVO personnelVO = new PersonnelVO();

        personnelVO.personnelID = 559870;
        personnelVO.name = "hhhhhh";
        personnelVO.password = "000000";

        tested.updatePersonnelInfo(personnelVO);
    }

    @Test
    public void searchPersonnelByID() throws Exception {
        PersonnelVO personnelVO = tested.searchPersonnelByID(159510);
    }

}