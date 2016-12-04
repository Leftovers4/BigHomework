package data.dao.personneldata;

import org.junit.Before;
import org.junit.Test;
import po.personnel.PersonnelPO;
import util.CommonMethod;
import util.POProducer;
import util.ResultMessage;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Hiki on 12/4/2016.
 */
public class PersonnelDataServiceImplTest {

    PersonnelDataServiceImpl tested;

    @Before
    public void setUp() throws Exception {
        tested = new PersonnelDataServiceImpl();
    }

    @Test
    public void insert() throws Exception {
        ResultMessage resultMessage = tested.insert(POProducer.getPersonnelPO());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void delete() throws Exception {
        ResultMessage resultMessage = tested.delete(POProducer.getPersonnelPO().getPersonnelID());
        System.out.println(resultMessage.toString());
    }

    @Test
    public void update() throws Exception {
        ResultMessage resultMessage = tested.update(POProducer.getPersonnelPO());
        System.out.println(resultMessage.toString());

    }

    @Test
    public void findAll() throws Exception {
        ArrayList<PersonnelPO> personnelPOs = tested.findAll();
        for (PersonnelPO each : personnelPOs) {
            CommonMethod.printClass(each);
        }

    }

    @Test
    public void findByType() throws Exception {
        ArrayList<PersonnelPO> personnelPOs = tested.findByType(POProducer.getPersonnelPO().getPersonnelType());
        for (PersonnelPO each : personnelPOs) {
            CommonMethod.printClass(each);
        }
    }

    @Test
    public void findByPersonnelID() throws Exception {
        PersonnelPO personnelPO = tested.findByPersonnelID(POProducer.getPersonnelPO().getPersonnelID());
        if (personnelPO != null){
            CommonMethod.printClass(personnelPO);
        }
    }

}