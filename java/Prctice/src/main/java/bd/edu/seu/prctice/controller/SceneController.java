package bd.edu.seu.prctice.controller;

import bd.edu.seu.prctice.model.Book;
import bd.edu.seu.prctice.services.BookService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class SceneController  implements Initializable {

    @FXML
    private Button deleteButton;

    @FXML
    private TableColumn<Book, Number> idColumn;

    @FXML
    private TextField idField;

    @FXML
    private TableColumn<Book, Number> priceColumn;

    @FXML
    private TableColumn<Book, Number> quantityColumn;

    @FXML
    private Button saveButton;

    @FXML
    private TextField priceField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField searchFiled;

    @FXML
    private TableView<Book> tableView;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TextField titleField;

    @FXML
    private Button updateButton;

    private static Book oldBook;
    private static ObservableList<Book> booksObservableList = FXCollections.observableArrayList();

    @FXML
    void deleteEvent(ActionEvent event) {

    }


    @FXML
    void saveEvent(ActionEvent event) {
        if(idField.getText().isEmpty() || titleField.getText().isEmpty() || priceField.getText().isEmpty() || quantityField.getText().isEmpty()
        ||priceField.getText().isEmpty() || quantityField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Something went wrong");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        }else{
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            System.out.println(id +" " + title + " " + price + " " + quantity );
            Book book = new Book(id, title, price, quantity);
            BookService bookService = new BookService();
            bookService.insertBook(book);

        }


    }

    @FXML
    void searchEvent(KeyEvent event) {

    }

    @FXML
    void selectedRow(MouseEvent event) {
        Book updatedBook= tableView.getSelectionModel().getSelectedItem();
        showData(updatedBook);
    }

    @FXML
    void updateEvent(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateButton.setVisible(false);
        deleteButton.setVisible(false);

        tableMapping();
        defaultTableView();
    }

    public void tableMapping(){
        idColumn.setCellValueFactory(c-> new SimpleIntegerProperty(c.getValue().getId()));
        titleColumn.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getTitle()));
        priceColumn.setCellValueFactory(c-> new SimpleDoubleProperty(c.getValue().getPrice()));
        quantityColumn.setCellValueFactory(c-> new SimpleIntegerProperty(c.getValue().getQuantity()));

        tableView.setItems(booksObservableList);
    }

    public void defaultTableView(){
        BookService bookService = new BookService();
        booksObservableList.setAll(bookService.getBooksObservableList());
    }

    public void showData(Book book){
        oldBook = book;

        idField.setDisable(true);
        saveButton.setVisible(false);

        updateButton.setVisible(true);
        deleteButton.setVisible(true);

        idField.setText(String.valueOf(book.getId()));
        titleField.setText(book.getTitle());
        priceField.setText(String.valueOf(book.getPrice()));
        quantityField.setText(String.valueOf(book.getQuantity()));

    }
}
