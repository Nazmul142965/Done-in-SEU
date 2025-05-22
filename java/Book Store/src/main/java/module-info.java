module bd.edu.seu.bookstore {
    requires javafx.controls;
    requires javafx.fxml;


    opens bd.edu.seu.bookstore to javafx.fxml;
    exports bd.edu.seu.bookstore;
}