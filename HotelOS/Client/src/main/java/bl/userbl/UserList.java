package bl.userbl;

import vo.user.UserVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2016/11/6.
 */
public class UserList {

    private List<UserVO> userVOs;

    public UserList(){
        userVOs = new ArrayList<>();
    }

    public UserList(List<UserVO> userVOs){
        this.userVOs = userVOs;
    }

    public void sort(String key, int mode){

    }

}
