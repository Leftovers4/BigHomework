package vo.member;

import java.util.Date;

/**
 * Created by Hiki on 2016/10/16.
 */
public class MemberVO {

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
