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

    /**
     * 酒店ID
     */
    private long hotelID;


    public PersonnelPO(){
        initial();
    }

    /**
     * 用于普通员工的创建
     * @param personnelID
     * @param password
     * @param personnelType
     * @param name
     */
    public PersonnelPO(long personnelID, String password, PersonnelType personnelType, String name) {
        initial();
        this.personnelID = personnelID;
        this.password = password;
        this.personnelType = personnelType;
        this.name = name;
    }

    /**
     * 用于酒店工作人员的创建
     * @param personnelID
     * @param password
     * @param personnelType
     * @param name
     * @param hotelID
     */
    public PersonnelPO(long personnelID, String password, PersonnelType personnelType, String name, long hotelID){
        initial();
        this.personnelID = personnelID;
        this.password = password;
        this.personnelType = personnelType;
        this.name = name;
        this.hotelID = hotelID;
    }

    /**
     * 初始化数据
     */
    private void initial(){
        this.personnelID = 0;
        this.password = "";
        this.personnelType = null;
        this.name = "";
        this.hotelID = 0;
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

    public long getHotelID() {
        return hotelID;
    }

    public void setHotelID(long hotelID) {
        this.hotelID = hotelID;
    }


}
