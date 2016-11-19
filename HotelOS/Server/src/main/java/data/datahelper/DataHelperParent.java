package data.datahelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Hiki on 11/19/2016.
 * 所有datahelper类的父类，提供增删改查的各种方法
 * 全部放在这个地方有利于减小耦合
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

    /**
     * 影响条数（Update, Delete, Insert）
     */
    protected int affectedRows;






}
