package bd.edu.seu.seupay;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {

    @FXML
    private TableColumn<Transaction, Number> amountColumn;

    @FXML
    private Label balanceLabel;

    @FXML
    private TableColumn<Transaction, String> mobileColumn;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Transaction> transactionTable;

    @FXML
    private TableColumn<Transaction, String> typeColumn;

    private ObservableList<Transaction> transactionList;

    @FXML
    void backEvent(ActionEvent event) {
        HelloApplication.changeScene("dashboard");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        amountColumn.setCellValueFactory(c -> new SimpleDoubleProperty(c.getValue().getAmount()));
        mobileColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getMobile()));
        typeColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getType()));

        transactionList = FXCollections.observableArrayList();
        getList();
        transactionTable.setItems(transactionList);

    }

    public void getList() {

        try{
            transactionList.clear();

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
                   transactionList.add(new Transaction(mobile, type, amount));
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

    @FXML
    void searchEvent(KeyEvent event) {
        String searchValue = searchField.getText();
        System.out.println(searchValue);

        ObservableList<Transaction> filteredList = FXCollections.observableArrayList();
        for(Transaction transaction : transactionList){
            if(transaction.getMobile().startsWith(searchValue)||
                  transaction.getType().toLowerCase().contains(searchValue.toLowerCase())){
                filteredList.add(transaction);
            }
        }
    }
}
