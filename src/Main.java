import util.DbUtils;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello World!");
        Connection connection = DbUtils.getConnection();
        String sql = "select * from sys_user";
        // PreparedStatement ptmt = connection.prepareStatement(sql);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString(2));
        }

    }
}
