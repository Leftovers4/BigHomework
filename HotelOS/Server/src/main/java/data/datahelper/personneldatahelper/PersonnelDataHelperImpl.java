package data.datahelper.personneldatahelper;

import data.datahelper.DataHelperParent;
import util.PersonnelType;
import util.ResultMessage;
import util.TableName;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/21/2016.
 */
public class PersonnelDataHelperImpl extends DataHelperParent implements PersonnelDataHelper{

    private static final String PERSONNEL_TABLENAME = TableName.personnel.toString();

    @Override
    public ArrayList<Object> findByIdFromSQL(Long personnelID) {
        return findFromSQLById(PERSONNEL_TABLENAME, String.valueOf(personnelID));
    }

    @Override
    public ArrayList<ArrayList<Object>> findFromSQL() {
        return findFromSQL(PERSONNEL_TABLENAME);
    }

//    @Override
//    public ArrayList<ArrayList<Object>> findByTypeFromSQL(PersonnelType personnelType) {
//        return findFromSQLByType(PERSONNEL_TABLENAME, personnelType.toString());
//    }

    @Override
    public ResultMessage insertToSQL(ArrayList<Object> personnelInfo) {
        return insertToSQL(PERSONNEL_TABLENAME, personnelInfo);
    }

    @Override
    public ResultMessage deleteFromSQL(long personnelID) {
        return delFromSQL(PERSONNEL_TABLENAME, personnelID);
    }

    @Override
    public ResultMessage updateFromSQL(ArrayList<Object> personnelInfo) {
        return updateFromSQL(PERSONNEL_TABLENAME, personnelInfo);
    }
}
