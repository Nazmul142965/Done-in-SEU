package bd.edu.seu.notunproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Stage Stage;

    @Override
    public void start(Stage stage) throws IOException {
        Stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("loginController.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String fxml){    // common method

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage.setScene(scene);
        } catch (IOException ex) {
            System.err.println("Failed to load fxml file");
            ex.printStackTrace();

        }
    }
}