module bd.edu.seu.studentadmission {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.studentadmission to javafx.fxml;
    exports bd.edu.seu.studentadmission;
}