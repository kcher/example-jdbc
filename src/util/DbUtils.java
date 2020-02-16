package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtils {

    // public static final String URL = "jdbc:mysql://localhost:3306/imooc";
    /*
    public static final String URL = "jdbc:postgresql://127.0.0.1:5432/vb";
    public static final String USER = "postgres";
    public static final String PASSWORD = "Mars123456";
    */
    public static String URL;
    public static String USER;
    public static String PASSWORD;
    private static Connection conn = null;
    static{
        try {
            Properties prop = new Properties();

            FileInputStream in = new FileInputStream("src/application.properties");
            prop.load(in);

            URL = prop.getProperty("url");
            USER = prop.getProperty("username");
            PASSWORD = prop.getProperty("password");


            //1.加载驱动程序
            // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.postgresql.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return conn;
    }
}
