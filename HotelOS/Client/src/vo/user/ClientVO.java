package vo.user;

import util.MemberType;

/**
 * Created by Hiki on 2016/10/27.
 */
public class ClientVO extends UserVO{

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
    public CreditVO creditVO;


    public ClientVO(String username, String password, String name, boolean gender, String phone, MemberType memberType, CreditVO creditVO) {
        super(username, password);
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.memberType = memberType;
        this.creditVO = creditVO;
    }
}
