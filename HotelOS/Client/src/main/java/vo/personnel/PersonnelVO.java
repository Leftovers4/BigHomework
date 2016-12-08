package vo.personnel;

import util.PersonnelType;

/**
 * Created by Hiki on 2016/11/6.
 */
public class PersonnelVO {

    /**
     * 工作人员ID
     */
    public long personnelID;

    /**
     * 密码
     */
    public String password;

    /*
     * 名字
     */
    public String name;

    /**
     * 工作人员类型
     */
    public PersonnelType personnelType;

    /*
     * 酒店id
     */
    public long hotelID;

    public long getPersonnelID() {
        return personnelID;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public PersonnelType getPersonnelType() {
        return personnelType;
    }

    public long getHotelID() {
        return hotelID;
    }

}
