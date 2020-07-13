package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.java.services.Navigator;

public class MainScreenController {

    @FXML
    GridPane signInPrompt;

    @FXML
    AnchorPane mainScreen;

    @FXML
    private void onAdminLoginClick(ActionEvent e) {

    }

    @FXML
    private void onRegisterClick(ActionEvent e) {
        Navigator.navigate("newAccountScene.fxml");
    }

    @FXML
    private void onLoginClick(ActionEvent e) {
        mainScreen.toBack();
        signInPrompt.toFront();
    }

    @FXML
    private void closeSignInPrompt(ActionEvent e) {
        signInPrompt.toBack();
    }
}
