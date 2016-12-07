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
        return userPO.getMemberPO().getBirthday().isEqual(localDate);
    }

    public boolean passwordCorrect(String password){
        return password.equals(userPO.getPassword());
    }

}
