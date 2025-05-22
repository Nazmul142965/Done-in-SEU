package bd.edu.seu.notunproject;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    public TextField nameField;

    @FXML
    public TextField emailField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public void registerEvent(){
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        System.out.println(name + " , " + email + " , " + password);
    }

    @FXML
    public void goToLoginEvent(){
        HelloApplication.changeScene("loginController");
    }

}
