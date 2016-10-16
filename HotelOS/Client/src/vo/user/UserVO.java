package vo.user;

import util.MemberType;

/**
 * Created by Hiki on 2016/10/16.
 */
public class UserVO {

    /**
     * 用户名
     */
    public String username;

    /**
     * 密码
     */
    public String password;

    /**
     * 姓名
     */
    public String name;

    /**
     * 性别
     */
    public boolean gender;

    /**
     * 联系方式（电话号码）
     */
    public String phone;

    /**
     * 会员类型
     */
    public MemberType memberType;

    /**
     * 信用（包括信用值，信用记录）
     */
    public CreditVO creditPO;

    public UserVO(){}

    /**
     * 在登录时使用
     */
    public UserVO(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    /**
     * 在注册、修改信息时使用
     */
    public UserVO(String username, String password, String name, boolean gender, String phone) {
        super();
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }
}
