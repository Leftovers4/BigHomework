package vo.personnel;

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

    public PersonnelVO(long personnelID, String password) {
        this.personnelID = personnelID;
        this.password = password;
    }


}
