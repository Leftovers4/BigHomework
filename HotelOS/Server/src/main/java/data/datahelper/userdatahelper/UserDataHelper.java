package data.datahelper.userdatahelper;

import util.ResultMessage;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Hiki on 11/20/2016.
 */
public interface UserDataHelper {

    // 格式："username", "password", "name", "gender", "phone", "member_type", "level", "birthday", "enterprise"


    /**
     * 在user表中插入一条用户信息
     * @param userInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> userInfo);

    /**
     * 在user表中删除一条用户信息
     * @param username
     * @return
     */
    public ResultMessage deleteFromSQL(String username);

    /**
     * 在user表中更新一条用户信息
     * @param userInfo
     * @return
     */
    public ResultMessage updateFromSQL(ArrayList<Object> userInfo);

    /**
     * 查找user表中的所有用户信息
     * @return
     */
    public ArrayList<ArrayList<Object>> findFromSQL();

    /**
     * 根据用户名在user表中查找一条用户信息
     * @param username
     * @return
     */
    public ArrayList<Object> findByIDFromSQL(String username);


}
