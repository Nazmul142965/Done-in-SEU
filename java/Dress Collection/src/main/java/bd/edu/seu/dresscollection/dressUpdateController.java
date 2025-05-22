package bd.edu.seu.dresscollection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class dressUpdateController implements Initializable {
    @FXML
    private RadioButton genderGroup;

    @FXML
    private ChoiceBox<String> availableSizeChecker;

    @FXML
    private CheckBox boostCheckBox;

    @FXML
    private Label boostingError;

    @FXML
    private Label customerError;

    @FXML
    private Label dateError;

    @FXML
    private DatePicker datePicker;

    @FXML
    private Label detailsError;

    @FXML
    private Label discountError;

    @FXML
    private PasswordField discountField;

    @FXML
    private ColorPicker dressColorChecker;

    @FXML
    private Label dressColorError;

    @FXML
    private TextArea dressDetailsArea;

    @FXML
    private Label dressNameError;

    @FXML
    private Spinner<Integer> dressQuantitySpinner;
    SpinnerValueFactory<Integer> dressQuantityValue = new SpinnerValueFactory.IntegerSpinnerValueFactory(-100, 500, 1);

    @FXML
    private ChoiceBox<String> dressTypeChecker;

    @FXML
    private Label dressTypeError;

    @FXML
    private ToggleGroup genderRadio;

    @FXML
    private Label imageError;

    @FXML
    private ImageView imageView;

    @FXML
    private  Boolean isImageUpdated = false;
    private String lastUpdatedImagePath = null;

    @FXML
    private TextField nameField;

    @FXML
    private Label priceError;

    @FXML
    private Slider priceSlider;

    @FXML
    private Label quantityError;

    @FXML
    private Label priceValue;


    @FXML
    private Label saveError;

    @FXML
    private Label sizeError;

    @FXML
    private final Set<String> useDiscounts = new HashSet<>();

    @FXML
    void saveEvent(ActionEvent event) {
        String dressName = nameField.getText();
        if(dressName.isEmpty()){
            dressNameError.setText("Name is Required");
        }else{
            dressNameError.setText(" ");
        }

        String dressType = dressTypeChecker.getValue();
        if(dressType.isEmpty()){
            dressTypeError.setText("Dress Type is Required");
        }else{
            dressTypeError.setText(" ");
        }

        String availableSize = availableSizeChecker.getValue();
        if(availableSize.isEmpty()){
            sizeError.setText("Dress Size is Required");
        }else{
            sizeError.setText(" ");
        }

        String dressColor = dressColorChecker.getValue() != null? dressColorChecker.getValue().toString():"";
        if(dressColor.isEmpty()){
            dressColorError.setText("Dress Color is Required");
        }else{
            dressColorError.setText(" ");
        }

        double price = priceSlider.getValue();
        if(price < 500){
            priceError.setText("Price is can't less than 500");
        }else{
            priceError.setText(" ");
        }


        String dressDetails = dressDetailsArea.getText();
        if(dressDetails.length() > 50){
            detailsError.setText("50 Characters is only allowed");
        }else{
            detailsError.setText(" ");
        }

        LocalDate dressDate = datePicker.getValue();
        if(dressDate == null){
            dateError.setText("Date is required");
        }else if(dressDate.isAfter(LocalDate.now())){
            dateError.setText(" Date can't be set in Future");
        }else{
            dateError.setText(" ");
        }

        int dressQuantity = dressQuantitySpinner.getValue();
        if(dressQuantity < 1){
            quantityError.setText("Quantity is required");
        }else{
            quantityError.setText(" ");
        }


        String discount = discountField.getText();
        if(discount.isEmpty()){
            discountError.setText("Discount is Required");
        }else{
            discountError.setText(" ");
        }

        RadioButton selectedGender = (RadioButton) genderRadio.getSelectedToggle();
        String gender = null;
        if(selectedGender == null){
            customerError.setText("Gender is Required");
        }else{
        gender = selectedGender.getText();
        customerError.setText(" ");
        }

        boolean boost = boostCheckBox.isSelected();

        if(!isImageUpdated){
            imageError.setText("Image is Required");
        }else {
            imageError.setText(" ");
        }
        System.out.println("Dress Name is: " + dressName + "\nDress Type is: " + dressType + "\nDress size is: " + availableSize + "\nDress color is: "
                + dressColor + "\nSlider value is: " + price + "\nDress details: " + dressDetails + "\nPurchase date is: " + dressDate + "\nQuantity is: " + dressQuantity + "\nDiscount is: "
                + discount + "\nCustomer is: " + gender + "\nCheckbox agree?: " + boost + "\nCustomer name: " + lastUpdatedImagePath + "\n");

//        if(!dressNameError.getText().isEmpty() || !dressTypeError.getText().isEmpty() ||
//                !sizeError.getText().isEmpty() || !dressColorError.getText().isEmpty() ||
//                !priceError.getText().isEmpty() || !detailsError.getText().isEmpty() ||
//                !dateError.getText().isEmpty() || !quantityError.getText().isEmpty() ||
//                !customerError.getText().isEmpty() ||!imageError.getText().isEmpty() ||
//                discountError.isVisible()){
//
//            System.out.println("Didnt fill up all the fields");
//            return;
//        }

        String line = dressName + " , " + dressType + " , " + availableSize + " , " + dressColor +
                " , " + price + " , " + dressDetails + " , " + dressDate + " , " +  dressQuantity +
                " , " + discount + " , " + gender + " , " + boost  +" , " + lastUpdatedImagePath +  "\n";

        try {
            RandomAccessFile raf = new RandomAccessFile("details.txt", "rw");
            raf.seek(raf.length());
            raf.writeBytes(line);
            raf.close();
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
        tableDetails tableDetails = new tableDetails(dressName, dressType, availableSize, dressColor, price, dressDetails, dressDate, dressQuantity, discount,gender ,boost , lastUpdatedImagePath);
        globalData.tableDetailsObservableList.add(tableDetails);

        System.out.println("Dress Name is: " + dressName + "\nDress Type is: " + dressType + "\nDress size is: " + availableSize + "\nDress color is: "
                + dressColor + "\nSlider value is: " + price + "\nDress details: " + dressDetails + "\nPurchase date is: " + dressDate + "\nQuantity is: " + dressQuantity + "\nDiscount is: "
                + discount + "\nCustomer is: " + gender + "\nCheckbox agree?: " + boost + "\nCustomer name: " + lastUpdatedImagePath + "\n");

        saveError.setText("Dress Information Saved In TXT file ");
    }

    @FXML
    void updateEvent(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp")
        );
        File file = fileChooser.showOpenDialog(HelloApplication.stage);
        if (file != null) {
            String imagePath = file.toURI().toString();
            imageView.setImage(new Image(imagePath));
            isImageUpdated = true;
            lastUpdatedImagePath = imagePath;
        }
    }
    @FXML
    void showListEvent(ActionEvent event) {
        System.out.println("Showing list");
        HelloApplication.changeScene("dressInformationShow");

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        priceSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
           priceValue.setText(" Price: " + String.format("%.0f", newValue));
        });

        ObservableList<String> typeList = FXCollections.observableArrayList();
        typeList.add("Hoodie");
        typeList.add("Sweater");
        dressTypeChecker.setItems(typeList);

       ObservableList<String> dressSizeList = FXCollections.observableArrayList();
       dressSizeList.add("Medium");
       dressSizeList.add("Large");
       availableSizeChecker.setItems(dressSizeList);


        dressQuantitySpinner.setValueFactory(dressQuantityValue);

    }
}
