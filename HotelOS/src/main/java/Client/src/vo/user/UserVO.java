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


    public UserVO(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }
}
