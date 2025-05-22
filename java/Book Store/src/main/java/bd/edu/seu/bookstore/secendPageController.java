package bd.edu.seu.bookstore;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class secendPageController {

    @FXML
    private Label bookGenre;

    @FXML
    private Label bookName;

    @FXML
    private Label productStatus;

    @FXML
    void backEvent(ActionEvent event) {

        HelloApplication.changeScene("frontPage");
    }

}
