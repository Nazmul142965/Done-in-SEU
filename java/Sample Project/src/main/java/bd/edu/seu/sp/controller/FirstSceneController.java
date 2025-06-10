package bd.edu.seu.sp.controller;

import bd.edu.seu.sp.model.Product;
import bd.edu.seu.sp.service.ProductService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FirstSceneController {

    @FXML
    private TableColumn<Product, Number> idColumn;

    @FXML
    private TextField idField;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TextField nameFiled;

    @FXML
    private TableColumn<Product, Number> priceColumn;

    @FXML
    private TextField priceField;

    @FXML
    private TableView<Product> tableView;

    @FXML
    void saveEvent(ActionEvent event) {
        String id = idField.getText();
        String name = nameFiled.getText();
        String price = priceField.getText();

        Product product = new Product(Integer.parseInt(id), name, Double.parseDouble(price));
        ProductService productService = new ProductService();
        productService.insert(product);
    }

}
