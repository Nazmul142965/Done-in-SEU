package bd.edu.seu.seupay;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {

    @FXML
    private TextField depositAmountField;

    @FXML
    private TextField depositMobileField;

    @FXML
    private TextField withdrawAmountField;

    @FXML
    private TextField withdrawMobileField;

    @FXML
    private Label balanceLabel;

    @FXML
    void transEvent(ActionEvent event) {
        HelloApplication.changeScene("transaction");
    }

    @FXML
    void depositEvent(ActionEvent event) {
        String depositMobile = depositMobileField.getText();
        double depositAmount = Double.parseDouble(depositAmountField.getText());

        try{

            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query ="INSERT INTO transaction VALUES('" + depositMobile + "','Deposit'," + depositAmount + " );";
            statement.execute(query);
            System.out.println("Deposit Successful");
            updateBalance();

        }catch(SQLException ex){
            System.out.println("Failed to connect database");
            ex.printStackTrace();

        }

    }

    @FXML
    void withdrawEvent(ActionEvent event) {
        String withdrawMobile = withdrawMobileField.getText();
        double withdrawAmount = Double.parseDouble(withdrawAmountField.getText());

        try{
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query ="INSERT INTO transaction VALUES('" + withdrawMobile + "','Withdraw'," + withdrawAmount + " );";
            statement.execute(query);
            System.out.println("Withdraw Successful");
            updateBalance();

        }catch(SQLException ex){
            System.out.println("Failed to connect database");
            ex.printStackTrace();

        }

    }

    public void updateBalance() {
        try{
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM transaction;";
            ResultSet resultSet = statement.executeQuery(query);
            double balance = 0;

            while(resultSet.next()){
                String mobile = resultSet.getString("mobile");
                String type = resultSet.getString("type");
                double amount = resultSet.getDouble("amount");

                if(mobile.equals(LoginRegistrationController.loginMobile)){
                    if(type.equals("Deposit")){
                        balance = balance + amount;
                    }else{
                        balance = balance - amount;
                    }
                }
            }
            balanceLabel.setText(balance + "");
        }catch(SQLException ex){
            System.out.println("Failed to connect database");
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       updateBalance();

    }
}
