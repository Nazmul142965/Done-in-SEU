package bd.edu.seu.sp.controller;

import bd.edu.seu.sp.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SecondSceneController {

    @FXML
    private TableColumn<Student, Number> cgpaColumn;

    @FXML
    private TextField cgpaField;

    @FXML
    private TableColumn<Student, Number> idColumn;

    @FXML
    private TextField idField;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TextField nameFiled;

    @FXML
    private TableView<Student> tableView;

    @FXML
    void saveEvent(ActionEvent event) {

    }

}
