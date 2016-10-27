package vo.user;

import util.MemberType;

/**
 * Created by Hiki on 2016/10/27.
 */
public class ClientVO extends UserVO{

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
     * 会员类型
     */
    private MemberType memberType;

    /**
     * 信用（包括信用值，信用记录）
     */
    private CreditVO creditVO;


    public ClientVO(String username, String password, String name, boolean gender, String phone, MemberType memberType, CreditVO creditVO) {
        super(username, password);
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.memberType = memberType;
        this.creditVO = creditVO;
    }
}
