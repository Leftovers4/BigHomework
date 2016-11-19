package data.datahelper;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Hiki on 11/18/2016.
 * 这个类用于抽象出数据库（最简单的四个）增删改查的方法，供直接调用
 */
public class SimpleSQLBuilder {


    /**
     * 为每一个数据库表（有主键）建立增删改查的操作
     * @param tableName 表名
     * @param num 参数个数
     * @param parameters 参数
     * @return
     */
    public Map<String, String> buildSQL(String tableName, int num, String... parameters){

        return null;
    }


    /**
     * 插入数据操作
     * @param tableName 表名
     * @param num 参数个数
     * @return
     */
    public String buildInsertSQL(String tableName, int num){

        return null;
    }


    /**
     * 删除数据操作（根据主键删除）
     * @param tableName 表名
     * @param primaryKey 主键
     * @return
     */
    public String buildDeleteSQL(String tableName, String primaryKey){

        return null;
    }


    /**
     * 更新数据操作
     * @param tableName 表名
     * @param num
     * @param parameters
     * @return
     */
    public String buildUpdateSQL(String tableName, int num, String... parameters){
        return null;
    }


    /**
     * 查找数据操作（根据主键查找）
     * @param tableName 表名
     * @param primaryKey 主键
     * @return
     */
    public String buildFindSQL(String tableName, String primaryKey){

        return null;
    }













}
