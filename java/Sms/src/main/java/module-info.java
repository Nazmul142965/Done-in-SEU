module bd.edu.seu.sms {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.sms to javafx.fxml;
    exports bd.edu.seu.sms;
}