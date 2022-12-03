package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String username ="root";
            String password ="";
            String url="jdbc:mysql://localhost:3306/manage_hotel";
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
        return  connection;
    }
    public static void closeConnection(Connection connection){
        try {
            if( connection != null ){
                connection.close();
            }
        } catch (SQLException ex){
            ex.getStackTrace();
        }
    }
}
