package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static main.java.services.Constants.HOST;
import static main.java.services.Constants.PASSWORD;
import static main.java.services.Constants.USER_NAME;

import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        try {
            DriverManager.getConnection(HOST, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
