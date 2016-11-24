package po.user;

import util.MemberType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class MemberPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 会员类型
     */
    private MemberType memberType;

    /**
     * 等级
     */
    private int level;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 企业名称
     */
    private String enterprise;


    public MemberPO(){
        initial();
    }

    /**
     * 用于注册会员
     */
    public MemberPO(String username, MemberType memberType, int level, LocalDate birthday, String enterprise) {
        initial();
        this.username = username;
        this.memberType = memberType;
        this.level = level;
        this.birthday = birthday;
        this.enterprise = enterprise;
    }

    private void initial(){
        this.username = "";
        this.memberType = null;
        this.level = 0;
        this.birthday = null;
        this.enterprise = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }
}
