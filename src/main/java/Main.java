package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.java.bank.Client;
import main.java.services.BankDatabase;
import main.java.services.Navigator;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            // Discourage resizing
            primaryStage = new Stage(StageStyle.UTILITY);
            Parent root = FXMLLoader.load(getClass().getResource("../resources/welcomeScene.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            Navigator.setStage(primaryStage);

            primaryStage.setOnCloseRequest(event -> {
                BankDatabase.shutDown();
                Client.logout();
            });


        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
