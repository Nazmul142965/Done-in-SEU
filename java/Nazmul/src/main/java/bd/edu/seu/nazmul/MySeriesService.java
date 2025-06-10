package bd.edu.seu.nazmul;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySeriesService implements MySeriesInterface {
    @Override
    public void insertSeries(MySeries mySeries) {
        try{
            Connection connection = ConnectionSingleton.getConnection();
            String query = "INSERT INTO showlist VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, mySeries.getName());
            preparedStatement.setString(2, mySeries.getSeason());
            preparedStatement.setString(3, mySeries.getYear());
            preparedStatement.setDouble(4, mySeries.getRating());
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Failed to insert series");
            e.printStackTrace();
        }
    }
}
