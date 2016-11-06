package vo.Member;

import util.MemberType;

import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class MemberVO {

    /**
     * 用户名
     */
    public String username;

    /**
     * 会员类型
     */
    public MemberType memberType;

    /**
     * 等级
     */
    public int level;

    /**
     * 生日
     */
    public Date birthday;

    /**
     * 企业名称
     */
    public String enterprise;

    public MemberVO() {}

    /**
     * 用于注册会员
     */
    public MemberVO(String username, MemberType memberType, int level, Date birthday, String enterprise) {
        super();
        this.username = username;
        this.memberType = memberType;
        this.level = level;
        this.birthday = birthday;
        this.enterprise = enterprise;
    }
}
