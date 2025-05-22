package bd.edu.seu.notunproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginController {
    @FXML
    public TextField emailField;

    @FXML
    public PasswordField passwordField;

    public void loginEvent(){
        String email = emailField.getText();
        String password = passwordField.getText();

        System.out.println(email + " , " + password);

        if(email.equals("1234@gmail.com") && password.equals("1234")){
            HelloApplication.changeScene("dashboard");
        }else{
            if(password.equals("")){
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("An error occurred");
                errorAlert.setContentText("Enter password");
                errorAlert.showAndWait();
            }else{
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Error");
                errorAlert.setHeaderText("An error occurred");
                errorAlert.setContentText("Wrong Input ");
                errorAlert.showAndWait();

                System.err.println("Invalid email or password");
            }

        }

    }



    @FXML
    public void goToRegisterEvent() {
        System.err.println("Redirect to Register scene");
        HelloApplication.changeScene("registration");
    }



}

