module bd.edu.seu.javafxproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.javafxproject to javafx.fxml;
    exports bd.edu.seu.javafxproject;
}