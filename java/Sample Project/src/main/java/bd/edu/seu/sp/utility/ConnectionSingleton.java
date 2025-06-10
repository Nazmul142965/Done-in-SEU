package bd.edu.seu.sp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "seucse613";
    private static final String DB_Name = "sample_project";
    private static final String  DB_URL = "jdbc:mysql://"+DB_HOST+":"+DB_PORT+"/"+DB_Name;

    private static Connection connection ;
    private static  ConnectionSingleton instance  = new ConnectionSingleton();

    private  ConnectionSingleton(){
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }catch(SQLException e){
            System.out.println("Failed to Connect Database");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
