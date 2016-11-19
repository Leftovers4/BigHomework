package data.datahelper;

import util.ResultMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hiki on 11/19/2016.
 * 所有datahelper类的父类，提供增删改查的各种方法，子类只需调用这些接口就可以实现特定的数据库操作
 * 全部放在这个地方有利于减小耦合，便于当数据库发生改变时处理数据和映射关系
 */
public class DataHelperParent {

    /**
     * 数据库连接
     */
    protected Connection conn;

    /**
     * 未编译的SQL语句
     */
    protected PreparedStatement preparedStatement;

    /**
     * SQL语句
     */
    protected String sql;

    /**
     * 查找的结果集
     */
    protected ResultSet resultSet;

    /**
     * 返回的消息
     */
    protected ArrayList<String> result;

    /*
     * 影响条数（Update, Delete, Insert）
     */
    protected int affectedRows;

    /**
     * 表名 —> 列
     */
    private final static Map<String, ArrayList<String>> TB_TO_COL = new HashMap<String, ArrayList<String>>();



    /**
     * 将两个map表初始化
     */
    static{


    }


    public DataHelperParent(){
        // 连接数据库
        this.conn = DBInit.connect();
        System.out.println("Succeed to connect database...");
    }


    /**
     * 往表中添加一条数据
     * @param tableName 表名
     * @param parameters 参数
     * @return
     */
    public ResultMessage addToSQL(String tableName, String... parameters){
        return ResultMessage.FAIL;

    }


    /**
     * 从表中删除一条数据（根据ID/username）
     * @param tableName 表名
     * @param id 主键
     * @return
     */
    public ResultMessage delFromSQL(String tableName, String id){
        return ResultMessage.FAIL;
    }


    /**
     * 从数据库中更新一条数据（根据ID/username）
     * @param tableName
     * @param newParameters
     * @return
     */
    public ResultMessage updateFromSQL(String tableName, String... newParameters){
        return ResultMessage.FAIL;

    }

    /**
     * 从数据库中获得一条数据（根据ID/username）
     * @param tableName
     * @param id
     * @return
     */
    public ArrayList<String> findFromSQLById(String tableName, String id){
        return null;
    }

    public ArrayList<ArrayList<String>> findFromSQLByType(String tableName, String type){
        return null;
    }















}
