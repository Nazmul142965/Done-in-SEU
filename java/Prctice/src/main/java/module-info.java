module bd.edu.seu.prctice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens bd.edu.seu.prctice to javafx.fxml;
    exports bd.edu.seu.prctice;

    opens bd.edu.seu.prctice.controller to javafx.fxml;
    exports bd.edu.seu.prctice.controller;
}