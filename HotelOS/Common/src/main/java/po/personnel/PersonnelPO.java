package po.personnel;

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

    public PersonnelPO(long personnelID, String password) {
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
