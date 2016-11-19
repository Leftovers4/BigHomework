package data.datahelper;

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
     * tableName与依赖性高的数据库操作的map表
     */
    private final static Map<String, Map<String, String>> TBNAME_TO_SQL = new HashMap<String, Map<String, String>>();

    /**
     * PO与各个表数据库列名的map表，再与tableName匹配
     */
    private final static Map<String, Map<String, String>> TBNAME_TO_COLNAME = new HashMap<String, Map<String, String>>();

    /**
     * 将两个map表初始化
     */
    static{


    }











}
