module bd.edu.seu.notunproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.notunproject to javafx.fxml;
    exports bd.edu.seu.notunproject;
}