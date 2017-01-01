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

    /**
     * 根据酒店ID筛选工作人员
     *
     * @param hotelID 酒店ID
     * @return 酒店ID是hotelID的工作人员
     */
    public PersonnelPO filterByHotelID(long hotelID){
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getHotelID() == hotelID){
                return this.get(i);
            }
        }

        return null;
    }

}
