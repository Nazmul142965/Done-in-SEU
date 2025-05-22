package bd.edu.seu.bookstore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;

public class frontPageController implements Initializable {

    @FXML
    private ChoiceBox<String> bookGenre;

    @FXML
    private ToggleGroup bookStatus;

    @FXML
    private TextField bookTitleField;

    @FXML
    void saveEvent(ActionEvent event) {

        String title = bookTitleField.getText();
        String genre = bookGenre.getSelectionModel().getSelectedItem();
        String status = null;
        RadioButton select = (RadioButton) bookStatus.getSelectedToggle();
        if (select.isSelected()) {
            status = select.getText();

        }

        if (title.length() > 0 && genre.length() > 0 && status.length() > 0) {
            try {
                RandomAccessFile raf = new RandomAccessFile("storedetails.txt", "rw");
                raf.setLength(0);
                raf.writeBytes(title + "," + genre + "," + status + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            HelloApplication.changeScene("secendPage");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid title.");
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> genres = FXCollections.observableArrayList();
        genres.add("Fiction");
        genres.add("Non Fiction");
        bookGenre.setItems(genres);
    }
}

