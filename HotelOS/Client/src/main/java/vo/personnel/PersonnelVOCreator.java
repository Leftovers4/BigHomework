package vo.personnel;

import po.personnel.PersonnelPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/12/4.
 */
public class PersonnelVOCreator {

    public PersonnelVO create(PersonnelPO personnelPO){
        PersonnelVO res = new PersonnelVO();

        res.personnelID = personnelPO.getPersonnelID();
        res.personnelType = personnelPO.getPersonnelType();
        res.name = personnelPO.getName();
        res.password = personnelPO.getPassword();
        res.hotelID = personnelPO.getHotelID();

        return res;
    }

    public List<PersonnelVO> createAll(List<PersonnelPO> personnelPOList){
        List<PersonnelVO> res = new ArrayList<>();

        for (int i = 0; i < personnelPOList.size(); i++) {
            res.add(create(personnelPOList.get(i)));
        }

        return res;
    }

}
