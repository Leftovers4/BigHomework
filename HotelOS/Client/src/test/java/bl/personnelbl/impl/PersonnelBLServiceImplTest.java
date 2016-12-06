package bl.personnelbl.impl;

import bl.personnelbl.PersonnelBLService;
import org.junit.Before;
import org.junit.Test;
import util.PersonnelType;
import vo.personnel.PersonnelVO;

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

    }

    @Test
    public void viewTypePersonnelList() throws Exception {

    }

    @Test
    public void addHotelWorker() throws Exception {
        PersonnelVO personnelVO = new PersonnelVO();

        personnelVO.hotelID = 145328;
        personnelVO.personnelType = PersonnelType.HotelWorker;
        personnelVO.name = "zhagnsan";
        personnelVO.password = "123456";

        tested.addHotelWorker(personnelVO);
    }

    @Test
    public void addWebMarketer() throws Exception {

    }

    @Test
    public void deletePersonnel() throws Exception {

    }

    @Test
    public void updatePersonnelInfo() throws Exception {

    }

    @Test
    public void searchPersonnelByID() throws Exception {

    }

}