package blservice_driver;

import blservice.personnelblservice.PersonnelBLService;
import org.junit.Before;
import org.junit.Test;
import util.PersonnelType;
import util.ResultMessage;
import vo.personnel.PersonnelVO;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/11/13.
 */
public class PersonnelBLService_Driver {
    PersonnelBLService tested;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void login() throws Exception {
        PersonnelVO personnelVO = new PersonnelVO(1, "123456", PersonnelType.HotelWorker);
        assertEquals(ResultMessage.SUCCESS, tested.login(personnelVO));
    }

    @Test
    public void logout() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.logout());
    }

    @Test
    public void showList() throws Exception {
        ArrayList<PersonnelVO> personnelVOs = personnelVOs = tested.showList();
        for (int i = 0; i < personnelVOs.size(); i++) {
            printPersonnelVO(personnelVOs.get(i));
        }
    }

    @Test
    public void add() throws Exception {
        PersonnelVO personnelVO = new PersonnelVO(1, "123456", PersonnelType.HotelWorker);
        assertEquals(ResultMessage.SUCCESS, tested.add(personnelVO));
    }

    @Test
    public void del() throws Exception {
        assertEquals(ResultMessage.SUCCESS, tested.del(1));
    }

    @Test
    public void modify() throws Exception {
        PersonnelVO personnelVO = new PersonnelVO(1, "123456", PersonnelType.HotelWorker);
        assertEquals(ResultMessage.SUCCESS, tested.modify(personnelVO));
    }

    @Test
    public void find() throws Exception {
        PersonnelVO personnelVO = tested.find(1);
        printPersonnelVO(personnelVO);
    }

    private void printPersonnelVO(PersonnelVO personnelVO){
        System.out.println("--------------------------------------");
        System.out.println("PersonnelVO Item");
        System.out.println("personnelID: " + personnelVO.personnelID);
        System.out.println("password: " + personnelVO.password);
        System.out.println("--------------------------------------");
    }
}