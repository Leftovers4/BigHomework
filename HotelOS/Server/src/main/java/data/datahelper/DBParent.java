package data.datahelper;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Hiki on 11/18/2016.
 * 用于数据库初始化和连接
 */
public class DBParent {

    /**
     * 确定连接相关参数
     */
    // private final static String URL = "jdbc:mysql://localhost:3306/hotelos?useUnicode=true&characterEncoding=UTF-8";
    private final static String URL = "jdbc:mysql://localhost:3306/";
    private final static String USER = "root";
    private final static String PWD = "123456";

    /**
     * 数据流
     */
    private static Connection conn;


    /**
     * 连接数据库
     * @return Connection
     */
    public static Connection connect(){
        if(conn == null){
            connection();
        }
        return conn;
    }


    /**
     * 连接
     */
    public static void connection(){

        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 获取连接
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Connect success.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * 断开连接（程序结束时调用）
     */
    public static void disconnect(){
        try{
            conn.close();
            conn = null;
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        DBParent.connect();
    }

}
