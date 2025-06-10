module bd.edu.seu.nazmul {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens bd.edu.seu.nazmul to javafx.fxml;
    exports bd.edu.seu.nazmul;

    opens bd.edu.seu.nazmul.controller to javafx.fxml;
    exports bd.edu.seu.nazmul.controller;
}