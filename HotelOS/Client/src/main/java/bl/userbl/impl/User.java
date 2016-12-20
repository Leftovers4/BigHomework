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

    public boolean isBirthday(LocalDate localDate){
        LocalDate birthday = userPO.getMemberPO().getBirthday();

        //客户没填写生日的情况
        if(birthday == null)
            return false;

        //客户填写了生日的情况
        return birthday.isEqual(localDate);
    }

    public boolean passwordCorrect(String password){
        return password.equals(userPO.getPassword());
    }

    public boolean isEnterpriseName(String enterpriseName){
        String enterprise = userPO.getMemberPO().getEnterprise();

        //客户不是企业会员的情况
        if (enterprise == null || enterprise.equals(""))
            return false;

        //客户是企业会员的情况
        return enterpriseName.equals(enterprise);
    }

    public boolean isMember(){
        return !userPO.getMemberPO().getMemberType().equals(MemberType.None);
    }

}
