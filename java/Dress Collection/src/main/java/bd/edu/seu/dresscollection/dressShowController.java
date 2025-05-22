package bd.edu.seu.dresscollection;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class dressShowController implements Initializable {

    @FXML
    private Label quantityList;

    @FXML
    private Label DetailsList;

    @FXML
    private TableColumn<tableDetails, String> boostColumn;

    @FXML
    private Label boostList;

    @FXML
    private Label codeList;
    private boolean codeView = false;

    @FXML
    private TableColumn<tableDetails, String> colorColumn;

    @FXML
    private Label colorList;

    @FXML
    private Label customerList;

    @FXML
    private Label dateList;

    @FXML
    private TableColumn<tableDetails, String> dateColumn;

    @FXML
    private Button deletebutton;

    @FXML
    private Button editbutton;

    @FXML
    private ImageView imageView;

    @FXML
    private TableColumn<tableDetails, String> nameColumn;

    @FXML
    private Label nameList;

    @FXML
    private TableColumn<tableDetails, Number> priceColumn;

    @FXML
    private Label priceList;

    @FXML
    private TableColumn<tableDetails, Number> quantityColumn;

    @FXML
    private TextField searchList;

    @FXML
    private Button showButton;

    @FXML
    private Label sizeList;

    @FXML
    private TableColumn<tableDetails, String> typeColumn;

    @FXML
    private Label typeLIst;

    @FXML
    private TableView<tableDetails> tableView;


    @FXML
    void backEvent(ActionEvent event) {
        System.out.println("dressShowController: Back button clicked.");
        HelloApplication.changeScene("dressInformationUpdate");
    }

    @FXML
    void deleteEvent(ActionEvent event) {
        // Placeholder for delete functionality
        tableDetails selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION);
            confirmDelete.setTitle("Confirm Deletion");
            confirmDelete.setHeaderText("Delete Dress Information");
            confirmDelete.setContentText("Are you sure you want to delete the selected dress: " + selectedItem.getName() + "?\nThis action cannot be undone from the UI easily.");
            confirmDelete.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    globalData.tableDetailsObservableList.remove(selectedItem);

                    System.out.println("dressShowController: Deleted (from view): " + selectedItem.getName());
                    if (globalData.tableDetailsObservableList.isEmpty()) {
                        clearDetailsView();
                    } else if (!tableView.getItems().contains(selectedItem)) {

                        if (!globalData.tableDetailsObservableList.isEmpty()) {
                            tableView.getSelectionModel().selectFirst();
                        } else {
                            clearDetailsView();
                        }
                    }
                }
            });
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select an item from the table to delete.");
            alert.showAndWait();
        }
        System.out.println("dressShowController: Delete button clicked (Not fully implemented for file).");
    }

    @FXML
    void editEvent(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edit Feature");
        alert.setHeaderText(null);
        alert.setContentText("Edit functionality is a work in progress. (Patent Pending!)");
        alert.showAndWait();
        System.out.println("dressShowController: Edit button clicked.");
    }

    @FXML
    void searchEvent(ActionEvent event) {
        String keyword = searchList.getText().trim().toLowerCase();
        System.out.println("dressShowController: Search event triggered. Keyword: '" + keyword + "'");

        if (keyword.isEmpty()) {
            tableView.setItems(globalData.tableDetailsObservableList);
            System.out.println("dressShowController: Search keyword empty, showing all items.");
            return;
        }

        ObservableList<tableDetails> filterList = FXCollections.observableArrayList();
        for (tableDetails item : globalData.tableDetailsObservableList) {
            if (item.getName().toLowerCase().contains(keyword) ||
                    item.getType().toLowerCase().contains(keyword) ||
                    item.getSize().toLowerCase().contains(keyword) ||
                    item.getColor().toLowerCase().contains(keyword) ||
                    (item.getCustomer() != null && item.getCustomer().toLowerCase().contains(keyword)) ||
                    (item.getCoupon() != null && item.getCoupon().toLowerCase().contains(keyword))) {
                filterList.add(item);
            }
        }
        tableView.setItems(filterList);
        System.out.println("dressShowController: Search complete. Found " + filterList.size() + " items.");
        if (filterList.isEmpty()) {
            clearDetailsView();
        } else {
            tableView.getSelectionModel().selectFirst();
        }
    }


    @FXML
    void showEvent(ActionEvent event) {
        System.out.println("dressShowController: Show button clicked.");
        tableDetails selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            // Data is already shown by selection listener, this button primarily toggles code visibility
            System.out.println("dressShowController: Toggling code visibility for: " + selectedItem.getName());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No Selection");
            alert.setHeaderText(null);
            alert.setContentText("Please select an item from the table to show its details.");
            alert.showAndWait();
            System.out.println("dressShowController: Show button clicked, but no item selected.");
            return;
        }

        codeView = !codeView;
        codeList.setVisible(codeView);
        codeList.managedProperty().bind(codeList.visibleProperty());
        System.out.println("dressShowController: Code visibility set to: " + codeView);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("dressShowController: initialize started.");
        globalData.tableDetailsObservableList.clear();
        System.out.println("dressShowController: globalData list cleared.");


        codeList.setVisible(codeView);
        codeList.managedProperty().bind(codeList.visibleProperty());
        System.out.println("dressShowController: Initial codeList visibility set to " + codeView);


        File dataFile = new File("details.txt");
        System.out.println("dressShowController: Attempting to read from: " + dataFile.getAbsolutePath());

        if (!dataFile.exists()) {
            System.err.println("dressShowController ERROR: details.txt does NOT exist at the expected location: " + dataFile.getAbsolutePath());

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data File Error");
            alert.setHeaderText("Could not load dress information.");
            alert.setContentText("The data file (details.txt) was not found at:\n" + dataFile.getAbsolutePath());
            alert.showAndWait();
            return;
        }
        if (!dataFile.canRead()) {
            System.err.println("dressShowController ERROR: Cannot read details.txt!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data File Error");
            alert.setHeaderText("Could not load dress information.");
            alert.setContentText("Cannot read the data file (details.txt) due to permissions at:\n" + dataFile.getAbsolutePath());
            alert.showAndWait();
            return;
        }

        // Use try-with-resources for RandomAccessFile
        try (RandomAccessFile raf = new RandomAccessFile(dataFile, "r")) {
            String line;
            int lineNumber = 0;
            System.out.println("dressShowController: Starting to read lines from details.txt");
            while ((line = raf.readLine()) != null) {
                lineNumber++;
                System.out.println("dressShowController: Reading line " + lineNumber + ": " + line);
                if (line.trim().isEmpty()) {
                    System.out.println("dressShowController: Skipping empty line " + lineNumber);
                    continue;
                }

                String[] parts = line.split(",\\s*");
                System.out.println("dressShowController: Line " + lineNumber + " split into " + parts.length + " parts.");

                if (parts.length >= 12) {
                    try {
                        String name = parts[0].trim();
                        String type = parts[1].trim();
                        String size = parts[2].trim();
                        String color = parts[3].trim();
                        double price = Double.parseDouble(parts[4].trim());
                        String details = parts[5].trim();
                        String dateText = parts[6].trim();
                        int quantity = Integer.parseInt(parts[7].trim());
                        String coupon = parts[8].trim();
                        String customer = parts[9].trim();
                        boolean boost = Boolean.parseBoolean(parts[10].trim());
                        String imagePath = parts[11].trim();

                        System.out.println("dressShowController: Parsed values for line " + lineNumber + " - Name: " + name + ", Date: " + dateText);

                        if (dateText.equalsIgnoreCase("null") || dateText.isEmpty()) {
                            System.out.println("dressShowController: Skipping line " + lineNumber + " due to 'null' or empty date text.");
                            continue;
                        }
                        LocalDate date = LocalDate.parse(dateText);

                        tableDetails tableItem = new tableDetails(name, type, size, color, price, details, date, quantity, coupon, customer, boost, imagePath);
                        globalData.tableDetailsObservableList.add(tableItem);
                        System.out.println("dressShowController: Added item from line " + lineNumber + " to globalData list.");

                    } catch (NumberFormatException nfe) {
                        System.err.println("dressShowController: NumberFormatException on line " + lineNumber + ": " + line + ". Error: " + nfe.getMessage());

                    } catch (DateTimeParseException dtpe) {
                        System.err.println("dressShowController: DateTimeParseException on line " + lineNumber + " (date part: '" + (parts.length > 6 ? parts[6].trim() : "N/A") + "'): " + line + ". Error: " + dtpe.getMessage());

                    } catch (Exception e) {
                        System.err.println("dressShowController: Generic Exception parsing line " + lineNumber + ": " + line);
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("dressShowController: Skipping line " + lineNumber + " due to insufficient parts: " + parts.length + ". Expected at least 12.");
                }
            }
        } catch (IOException e) {
            System.err.println("dressShowController: IOException while reading details.txt:");
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("File Read Error");
            alert.setHeaderText("Error reading dress information.");
            alert.setContentText("An I/O error occurred while trying to read details.txt.\nDetails: " + e.getMessage());
            alert.showAndWait();
        }

        System.out.println("dressShowController: Finished reading. Total items loaded: " + globalData.tableDetailsObservableList.size());


        if (tableView == null) {
            System.err.println("dressShowController ERROR: tableView is NULL. Check FXML fx:id binding.");
            return;
        }

        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getType()));
        colorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
        priceColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()));
        dateColumn.setCellValueFactory(cellData -> {
            LocalDate date = cellData.getValue().getDate();
            return new SimpleStringProperty(date != null ? date.toString() : "N/A");
        });
        quantityColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()));
        boostColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().isBoost() ? "Yes" : "No"));

        tableView.setItems(globalData.tableDetailsObservableList);
        System.out.println("dressShowController: tableView items set. Count: " + globalData.tableDetailsObservableList.size());

        if (!globalData.tableDetailsObservableList.isEmpty()) {
            System.out.println("dressShowController: Setting initial details view with first item.");
            tableView.getSelectionModel().selectFirst();

        } else {
            System.out.println("dressShowController: No items in list, clearing details view.");
            clearDetailsView();
        }

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println("dressShowController: Table selection changed. Showing data for: " + newValue.getName());
                showData(newValue);

                codeList.setVisible(codeView);
            } else {
                System.out.println("dressShowController: Table selection cleared.");
                clearDetailsView();
                codeList.setVisible(false);
            }
        });
        System.out.println("dressShowController: initialize finished.");
    }

    private void showData(tableDetails selectedItem) {
        if (selectedItem == null) {
            System.out.println("dressShowController - showData: selectedItem is null. Clearing details.");
            clearDetailsView();
            return;
        }
        System.out.println("dressShowController - showData: Displaying details for " + selectedItem.getName());
        nameList.setText(selectedItem.getName());
        typeLIst.setText(selectedItem.getType());
        colorList.setText(selectedItem.getColor());
        sizeList.setText(selectedItem.getSize());
        priceList.setText(String.format("%.2f", selectedItem.getPrice()));
        quantityList.setText(String.valueOf(selectedItem.getQuantity()));
        dateList.setText(selectedItem.getDate() != null ? selectedItem.getDate().toString() : "N/A");
        boostList.setText(String.valueOf(selectedItem.isBoost()));
        DetailsList.setText(selectedItem.getDetails());
        customerList.setText(selectedItem.getCustomer());
        codeList.setText(selectedItem.getCoupon());

        if (selectedItem.getQuantity() < 10) {
            quantityList.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        } else {
            quantityList.setStyle("-fx-text-fill: green;");
        }

        try {
            String imagePath = selectedItem.getImage();
            if (imagePath != null && !imagePath.isEmpty()) {
                System.out.println("dressShowController - showData: Loading image: " + imagePath);

                if (!imagePath.startsWith("file:") && !imagePath.startsWith("http:") && !imagePath.startsWith("https:")) {

                    File imgFile = new File(imagePath);
                    if (imgFile.exists()) {
                        imagePath = imgFile.toURI().toString();
                    } else {
                        System.err.println("dressShowController - showData: Image file does not exist at path: " + selectedItem.getImage());
                        imageView.setImage(null);
                        return;
                    }
                }
                imageView.setImage(new Image(imagePath, true));
            } else {
                System.out.println("dressShowController - showData: No image path for " + selectedItem.getName());
                imageView.setImage(null);
            }
        } catch (IllegalArgumentException iae) {
            System.err.println("dressShowController - showData: Invalid URL or image path '" + selectedItem.getImage() + "'. Error: " + iae.getMessage());
            imageView.setImage(null);
        }
        catch (Exception e) {
            System.err.println("dressShowController - showData: Error loading image '" + selectedItem.getImage() + "'. Error: " + e.getMessage());

            imageView.setImage(null);
        }
    }

    private void clearDetailsView() {
        System.out.println("dressShowController: Clearing details view.");
        nameList.setText("");
        typeLIst.setText("");
        colorList.setText("");
        sizeList.setText("");
        priceList.setText("");
        quantityList.setText("");
        quantityList.setStyle("");
        dateList.setText("");
        boostList.setText("");
        DetailsList.setText("");
        customerList.setText("");
        codeList.setText("*****");
        codeList.setVisible(false);
        imageView.setImage(null);
    }
}