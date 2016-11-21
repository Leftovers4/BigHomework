package po.personnel;

import util.PersonnelType;

import java.io.Serializable;

/**
 * Created by Hiki on 2016/11/6.
 */
public class PersonnelPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 工作人员ID
     */
    private long personnelID;

    /**
     * 密码
     */
    private String password;

    /**
     * 工作人员类型
     */
    private PersonnelType personnelType;

    /**
     * 工作人员名字
     */
    private String name;


    public PersonnelPO(long personnelID, String password, PersonnelType personnelType, String name) {
        this.personnelID = personnelID;
        this.password = password;
        this.personnelType = personnelType;
        this.name = name;
    }

    public long getPersonnelID() {
        return personnelID;
    }

    public void setPersonnelID(long personnelID) {
        this.personnelID = personnelID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonnelType getPersonnelType() {
        return personnelType;
    }

    public void setPersonnelType(PersonnelType personnelType) {
        this.personnelType = personnelType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
