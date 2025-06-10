module bd.edu.seu.seupay {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens bd.edu.seu.seupay to javafx.fxml;
    exports bd.edu.seu.seupay;
}