package data.datahelper.userdatahelper;

import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/26/2016.
 */
public interface UserImageHelper {


    /**
     * 找出用户头像，若用户头像不存在，返回null
     * @param username
     * @return
     */
    public byte[] findUserImageByUsername(String username);


    /**
     * 在文件夹中增加（或更新）用户头像的图片
     * @param imageBytes
     * @return
     */
    public ResultMessage setUserImage(String username, byte[] imageBytes);




}
