package bl.userbl.impl;

import po.user.UserPO;
import util.MemberType;

import java.time.LocalDate;

/**
 * Created by kevin on 2016/11/6.
 */
public class User{

    private UserPO userPO;

    public User(UserPO userPO){
        this.userPO = userPO;
    }

    /**
     * 判断给定的日期是不是客户的生日
     *
     * @param localDate 日期
     * @return true（是），false（不是）
     */
    public boolean isBirthday(LocalDate localDate){
        LocalDate birthday = userPO.getMemberPO().getBirthday();

        //客户没填写生日的情况
        if(birthday == null)
            return false;

        //客户填写了生日的情况
        return birthday.isEqual(localDate);
    }

    /**
     * 判断给定的密码是不是客户的密码
     *
     * @param password 密码
     * @return true（正确），false（不正确）
     */
    public boolean passwordCorrect(String password){
        return password.equals(userPO.getPassword());
    }

    /**
     * 判断给定的企业名称是不是客户的企业名称
     *
     * @param enterpriseName 企业名称
     * @return true（是），false（不是）
     */
    public boolean isEnterpriseName(String enterpriseName){
        String enterprise = userPO.getMemberPO().getEnterprise();

        //客户不是企业会员的情况
        if (enterprise == null || enterprise.equals(""))
            return false;

        //客户是企业会员的情况
        return enterpriseName.equals(enterprise);
    }

    /**
     * 判断客户是不是会员
     *
     * @return true（是），false（不是）
     */
    public boolean isMember(){
        return !userPO.getMemberPO().getMemberType().equals(MemberType.None);
    }

}
