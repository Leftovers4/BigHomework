package po.user;

import util.MemberType;

import java.io.Serializable;


/**
 * Created by Hiki on 2016/10/16.
 */
public class ClientPO extends UserPO implements Serializable {

    /**
     * 序列化UID
     */
    private static final long serialVersionUID = 1L;

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
    private CreditPO creditPO;


    public ClientPO(String username, String password, String name, boolean gender, String phone, MemberType memberType, CreditPO creditPO) {
        super(username, password);
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.memberType = memberType;
        this.creditPO = creditPO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public CreditPO getCreditPO() {
        return creditPO;
    }

    public void setCreditPO(CreditPO creditPO) {
        this.creditPO = creditPO;
    }
}

