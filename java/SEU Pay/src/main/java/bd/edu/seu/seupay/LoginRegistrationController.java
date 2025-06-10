package bd.edu.seu.seupay;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.*;

public class LoginRegistrationController {

    @FXML
    private TextField loginMobileField;

    @FXML
    private TextField loginPinField;

    @FXML
    private TextField registrationPinField;

    @FXML
    private TextField registrationMobileField;

    @FXML
    private TextField registrationNameField;

    public static String loginMobile;

    @FXML
    void loginEvent(ActionEvent event) {
        String givenMobile = loginMobileField.getText();
        String givenPin = loginPinField.getText();
        System.out.println(givenMobile + ":" + givenPin);

        try{
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM user";
            ResultSet resultSet =statement.executeQuery(query);

            while (resultSet.next()) {
                String mobile = resultSet.getString("mobile");
                String pin = resultSet.getString("pin");

                if(givenMobile.equals(mobile) && givenPin.equals(pin)){
                    loginMobile = mobile;
                    HelloApplication.changeScene("dashboard");
                }

            }


        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @FXML
    void registerEvent(ActionEvent event) {
        String mobile = registrationMobileField.getText();
        String name = registrationNameField.getText();
        String pin = registrationPinField.getText();

        System.out.println(mobile + " " + name + " " + pin);

        try{
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
                    // Insert into user values(  'Nazmul Bhai','0188', '456' );
            String query = "INSERT INTO user VALUES  ('" +name + "', '" + mobile + "', '" + pin + "');";
            System.out.println(query);
            statement.executeUpdate(query);
            System.out.println("Successfully registered!");

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Failed to connect Database");
        }
    }
}
