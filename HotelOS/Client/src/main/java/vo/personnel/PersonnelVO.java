package vo.personnel;

/**
 * Created by Hiki on 2016/11/6.
 */
public class PersonnelVO {

    /**
     * 工作人员ID
     */
    private long personnelID;

    /**
     * 密码
     */
    private String password;

    public PersonnelVO(long personnelID, String password) {
        this.personnelID = personnelID;
        this.password = password;
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

}
