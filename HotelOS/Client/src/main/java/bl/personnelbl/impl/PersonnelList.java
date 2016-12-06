package bl.personnelbl.impl;

import po.personnel.PersonnelPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class PersonnelList extends ArrayList<PersonnelPO>{

    public PersonnelList(List<PersonnelPO> personnelPOList){
        for (int i = 0; i < personnelPOList.size(); i++) {
            this.add(personnelPOList.get(i));
        }
    }

    public
}
