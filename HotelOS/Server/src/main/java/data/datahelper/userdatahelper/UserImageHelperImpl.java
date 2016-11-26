package data.datahelper.userdatahelper;

import data.datahelper.DataHelperParent;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/26/2016.
 */
public class UserImageHelperImpl extends DataHelperParent implements UserImageHelper {

    private final static String USERIMAGE_TABLENAME = TableName.user_image.toString();

    @Override
    public ArrayList<Object> findByIdFromSQL(String username) {
        return findFromSQLById(USERIMAGE_TABLENAME, username);
    }

    @Override
    public ResultMessage insertToSQL(ArrayList<Object> userImageInfo) {
        return insertToSQL(USERIMAGE_TABLENAME, userImageInfo);
    }
}
