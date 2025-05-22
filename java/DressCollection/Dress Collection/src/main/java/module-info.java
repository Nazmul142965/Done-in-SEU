module bd.edu.seu.dresscollection {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens bd.edu.seu.dresscollection to javafx.fxml;
    exports bd.edu.seu.dresscollection;
}