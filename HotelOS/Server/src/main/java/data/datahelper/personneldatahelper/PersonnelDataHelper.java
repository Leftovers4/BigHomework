package data.datahelper.personneldatahelper;

import util.PersonnelType;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Hiki on 11/20/2016.
 */
public interface PersonnelDataHelper {

    /**
     * 根据ID从personnel表查找一个员工
     * 返回格式："personnel_id", "password", "personnel_type", "hotel_id"
     * @param personnelID
     * @return
     */
    public ArrayList<Object> findByIdFromSQL(Long personnelID);

    /**
     * 从personnel表获取所有员工
     * @return
     */
    public ArrayList<ArrayList<Object>> findFromSQL();

    /**
     * 根据type从personnel表查找员工列表
     * @param personnelType
     * @return
     */
    public ArrayList<ArrayList<Object>> findByTypeFromSQL(PersonnelType personnelType);

    /**
     * 在personnel表中插入一条员工数据
     * 输入格式："personnel_id", "password", "personnel_type", "hotel_id"
     * @param personnelInfo
     * @return
     */
    public ResultMessage insertToSQL(ArrayList<Object> personnelInfo);

    /**
     * 在personnel表中删除一条员工数据
     * @param personnelID
     * @return
     */
    public ResultMessage deleteFromSQL(long personnelID);

    /**
     * 在personnel表中更新一条员工数据
     * 输入格式："personnel_id", "password", "personnel_type", "hotel_id"
     * @param personnelInfo
     * @return
     */
    public ResultMessage updateFromSQL(ArrayList<Object> personnelInfo);



}
