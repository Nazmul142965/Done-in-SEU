module bd.edu.seu.hellojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.hellojavafx to javafx.fxml;
    exports bd.edu.seu.hellojavafx;
}