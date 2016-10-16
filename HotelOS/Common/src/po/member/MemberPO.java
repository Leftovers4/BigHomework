package po.member;

import util.MemberType;

import java.io.Serializable;
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
    private Date birthday;

    /**
     * 企业名称
     */
    private String enterprise;


    /**
     * 用于注册会员
     */
    public MemberPO(String username, MemberType memberType, int level, Date birthday, String enterprise) {

        this.username = username;
        this.memberType = memberType;
        this.level = level;
        this.birthday = birthday;
        this.enterprise = enterprise;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }
}
