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
    private MemberVO memberVO;

    /**
     * 信用（包括信用值，信用记录）
     */
    private CreditVO creditVO;


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
