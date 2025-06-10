package bd.edu.seu.studentadmission;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AdmissionFormController implements Initializable {

    @FXML
    private CheckBox agreeCheckedBox;

    @FXML
    private TextArea bioTextArea;

    @FXML
    private ToggleGroup genderRadio;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ChoiceBox<String> programChoiceBox;

    @FXML
    private Slider ageSlider;

    @FXML
    private ListView<String> admissionListView;

    ObservableList<String> admissionList = FXCollections.observableArrayList();

    @FXML
    void submitEvent(ActionEvent event) {
        String name = nameField.getText();
        String password = passwordField.getText();
        String program = programChoiceBox.getValue();

        RadioButton selectedGenderRadio = (RadioButton) genderRadio.getSelectedToggle();
        String gender = selectedGenderRadio.getText();

        String bio = bioTextArea.getText();

        boolean agree = agreeCheckedBox.isSelected();
        //if(agree){} vitore sout dile ar eita pass na korle kam korbo na

        double age = ageSlider.getValue();

        String value = name + " " + password + " " + program + " " + gender + " " + bio + " " + agree + " " + age;
        admissionList.add(value);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(" I am called");

        admissionList = FXCollections.observableArrayList();
        admissionListView.setItems(admissionList);

        //Choice box
        ObservableList<String> programObservableList = FXCollections.observableArrayList();
        programObservableList.add("CSE");
        programObservableList.add("BBA");
        programObservableList.add("EEE");



        programChoiceBox.setItems(programObservableList);

    }
}
