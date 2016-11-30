package po.user;

import util.MemberType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Hiki on 2016/10/16.
 */
public class UserPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private boolean gender;

    /**
     * 联系方式（电话号码）
     */
    private String phone;

    /**
     * 会员信息
     */
    private MemberPO memberPO;

    /**
     * 信用（包括信用值，信用记录）
     */
    private List<CreditRecordPO> creditRecordPOs;


    public UserPO(){
        initial();
    }

    public UserPO(String username, String password, String name, boolean gender, String phone, MemberPO memberPO, ArrayList<CreditRecordPO> creditRecordPOs) {
        initial();
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.memberPO = memberPO;
        this.creditRecordPOs = creditRecordPOs;
    }

    private void initial(){
        this.username = "";
        this.password = "";
        this.name = "";
        this.gender = false;
        this.phone = "";
        this.memberPO = new MemberPO();
        this.creditRecordPOs = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MemberPO getMemberPO() {
        return memberPO;
    }

    public void setMemberPO(MemberPO memberPO) {
        this.memberPO = memberPO;
    }

    public List<CreditRecordPO> getCreditRecordPOs() {
        return creditRecordPOs;
    }

    public void setCreditRecordPOs(List<CreditRecordPO> creditRecordPOs) {
        this.creditRecordPOs = creditRecordPOs;
    }
}

