package bl.userbl.impl;

import po.user.UserPO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/12/7.
 */
public class UserList extends ArrayList<UserPO> {

    public UserList(List<UserPO> userPOList){
        for (int i = 0; i < userPOList.size(); i++) {
            this.add(userPOList.get(i));
        }
    }

    public boolean isValidUsername(String username){
        for (UserPO userPO : this) {
            if (username.equals(userPO.getUsername()))
                return false;
        }

        return true;
    }

}
