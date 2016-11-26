package vo.user;

import vo.user.CreditVO;

import util.MemberType;
import vo.user.MemberVO;

import java.time.LocalDate;

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

    /**
     * 传给逻辑：创建包含用户登录和注册的界面信息的对象
     *
     * @param username 用户名
     * @param password 密码
     */
    public UserVO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 传给逻辑：创建包含用户修改基本信息的界面信息的对象
     *
     * @param username 用户名
     * @param name     姓名
     * @param gender   姓名
     * @param birthday 生日
     * @param phone    联系方式（电话号码）
     */
    public UserVO(String username, String name, boolean gender, LocalDate birthday, String phone) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.memberVO = new MemberVO();
        this.memberVO.birthday = birthday;
        this.phone = phone;
    }

    /**
     * 传给界面：创建包含用户查看基本信息的界面信息的对象
     *
     * @param username   用户名
     * @param name       姓名
     * @param gender     性别
     * @param birthday   生日
     * @param phone      联系方式（电话号码）
     * @param credit     信用
     * @param level      会员等级
     * @param enterprise 企业名称
     */
    public UserVO(String username, String name, boolean gender, LocalDate birthday, String phone, double credit, int level, String enterprise) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.memberVO = new MemberVO();
        this.memberVO.birthday = birthday;
        this.phone = phone;
        this.creditVO = new CreditVO();
        this.creditVO.credit = credit;
        this.memberVO.level = level;
        this.memberVO.enterprise = enterprise;
    }

}
