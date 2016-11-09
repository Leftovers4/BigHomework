package vo.user;

import vo.user.CreditVO;

import util.MemberType;
import vo.user.MemberVO;

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
     * 会员信息
     */
    public MemberVO memberVO;

    /**
     * 信用（包括信用值，信用记录）
     */
    public CreditVO creditVO;


    public UserVO(String username, String password, String name, boolean gender, String phone, MemberVO memberVO, CreditVO creditVO) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.memberVO = memberVO;
        this.creditVO = creditVO;
    }
}
