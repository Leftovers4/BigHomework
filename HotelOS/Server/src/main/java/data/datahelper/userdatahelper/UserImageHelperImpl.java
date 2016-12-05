package data.datahelper.userdatahelper;

import data.datahelper.DataHelperParent;
import data.datahelper.ImageHelperParent;
import util.ResultMessage;
import util.TableName;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by Hiki on 11/26/2016.
 */
public class UserImageHelperImpl extends ImageHelperParent implements UserImageHelper {

    private final static String UserImageDir = "C:\\Leftovers\\server\\userImage\\";

//    private final static String UserImageDir = "F:/AnimePic/";

    @Override
    public byte[] findUserImageByUsername(String username){
        return findImageByID(UserImageDir, username);
    }

    @Override
    public ResultMessage setUserImage(String username, byte[] imageBytes) {
        return setImage(UserImageDir, username, imageBytes);
    }



}