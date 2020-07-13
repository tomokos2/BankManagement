package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.services.Navigator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Discourage resizing
            primaryStage = new Stage(StageStyle.UTILITY);
            Parent root = FXMLLoader.load(getClass().getResource("../resources/mainScreen.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            Navigator.setStage(primaryStage);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
