package bd.edu.seu.notunproject;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class dashboardController {
    @FXML
    public void goToLoginEvent() {
        Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
        errorAlert.setTitle("Logout");
        errorAlert.setHeaderText("Confirm logout");
        errorAlert.setContentText("Want to logout ");
        errorAlert.showAndWait();

        if(errorAlert.getResult() == ButtonType.OK){
            System.err.println("Redirect to Login scene");
            HelloApplication.changeScene("loginController");
        }




    }



}
