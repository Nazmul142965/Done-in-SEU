package bd.edu.seu.nazmul.controller;

import bd.edu.seu.nazmul.MySeries;
import bd.edu.seu.nazmul.MySeriesService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class TvController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField ratingField;

    @FXML
    private TextField seasonField;

    @FXML
    private TextField yearField;

    @FXML
    void saveEvent(ActionEvent event) {

        if (nameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong");
            alert.setContentText("Name is empty");
            alert.showAndWait();
        } else if (ratingField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong");
            alert.setContentText("Rating is empty");
            alert.showAndWait();
        } else if (seasonField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong");
            alert.setContentText("Season is empty");
            alert.showAndWait();
        } else if (yearField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong");
            alert.setContentText("Year is empty");
            alert.showAndWait();
        } else{
            String name = nameField.getText();
            String season = ratingField.getText();
            String year = yearField.getText();
            double rating = Double.parseDouble(ratingField.getText());

            MySeries mySeries = new MySeries(name, season, year, rating);
            MySeriesService mySeriesService = new MySeriesService();
            mySeriesService.insertSeries(mySeries);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Information");
                alert.setContentText("Successfully inserted series");
                alert.showAndWait();


            System.out.println(mySeries);


        }


    }
}


