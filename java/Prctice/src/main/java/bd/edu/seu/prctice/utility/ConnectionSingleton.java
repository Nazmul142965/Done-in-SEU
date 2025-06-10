package bd.edu.seu.prctice.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static final String DU_HOST = "localhost";
    private static final String DU_PORT = "3306";
    private static final String DU_USER = "root";
    private static final String DU_PASS = "seucse613";
    private static final String DU_NAME = "scene";
    private static final String DU_URL ="jdbc:mysql://" + DU_HOST + ":" + DU_PORT + "/" + DU_NAME;
    private static Connection connection;

    private static ConnectionSingleton instance = new ConnectionSingleton();

    public   ConnectionSingleton(){
        try{
            connection = DriverManager.getConnection(DU_URL, DU_USER, DU_PASS);

        }catch(SQLException e){
            System.out.println("Failed to connect to database");
            e.printStackTrace();

        }
    }

    public static Connection getConnection(){
        return connection;
    }

}
