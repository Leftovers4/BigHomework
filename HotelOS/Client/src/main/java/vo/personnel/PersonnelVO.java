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

    /**
     * 工作人员类型
     */
    public PersonnelType personnelType;


    public PersonnelVO(long personnelID, String password, PersonnelType personnelType) {
        this.personnelID = personnelID;
        this.password = password;
        this.personnelType = personnelType;
    }

}
