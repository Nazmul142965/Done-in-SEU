module bd.edu.seu.sp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens bd.edu.seu.sp to javafx.fxml;
    exports bd.edu.seu.sp;

    opens bd.edu.seu.sp.controller to javafx.fxml;
    exports bd.edu.seu.sp.controller;


}