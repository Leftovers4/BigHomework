package data.datahelper.userdatahelper;

import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/26/2016.
 */
public interface UserImageHelper {

    // 格式："username", "image_reference"

    /**
     * 根据用户名从user_image表中查找用户头像
     * @param username
     * @return
     */
    public ArrayList<Object> findByIdFromSQL(String username);


    /**
     * 往user_image表中插入一条用户头像信息
     * @param userImageInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> userImageInfo);

}
