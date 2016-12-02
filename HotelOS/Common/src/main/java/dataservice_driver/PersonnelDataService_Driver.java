package dataservice_driver;

import dataservice.personneldataservice.PersonnelDataService;
import org.junit.Before;
import org.junit.Test;
import po.personnel.PersonnelPO;
import util.PersonnelType;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by kevin on 2016/11/13.
 */
public class PersonnelDataService_Driver {
    PersonnelDataService tested;

    @Before
    public void setUp() throws Exception {

    }


//    @Test
//    public void getList() throws Exception {
//        ArrayList<PersonnelPO> personnelPOs = tested.findAll();
//        for (int i = 0; i < personnelPOs.size(); i++) {
//            printPersonnelPO(personnelPOs.get(i));
//        }
//    }

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

//    @Test
//    public void findByPersonnelID() throws Exception {
//        PersonnelPO personnelPO = tested.findByPersonnelID(1);
//        printPersonnelPO(personnelPO);
//    }

    private void printPersonnelPO(PersonnelPO personnelPO){
        System.out.println("--------------------------------------");
        System.out.println("PersonnelPO Item");
        System.out.println("personnelID: " + personnelPO.getPersonnelID());
        System.out.println("password: " + personnelPO.getPassword());
        System.out.println("--------------------------------------");
    }
}