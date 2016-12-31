package bl.personnelbl.impl;

import po.personnel.PersonnelPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class PersonnelList extends ArrayList<PersonnelPO>{

    /**
     * Instantiates a new Personnel list.
     *
     * @param personnelPOList the personnel po list
     */
    public PersonnelList(List<PersonnelPO> personnelPOList){
        for (int i = 0; i < personnelPOList.size(); i++) {
            this.add(personnelPOList.get(i));
        }
    }

    /**
     * Filter by hotel id personnel po.
     *
     * @param hotelID the hotel id
     * @return the personnel po
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
