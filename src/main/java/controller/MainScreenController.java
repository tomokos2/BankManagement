package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.java.services.Navigator;

public class MainScreenController {

    @FXML
    GridPane signInPrompt;

    @FXML
    AnchorPane mainScreen;

    @FXML
    TextField idField;

    @FXML
    PasswordField passwordField;

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

    @FXML
    private void validateLoginInfo(ActionEvent e) {
        String id = idField.getText();
        String password = passwordField.getText();
        if (id == null || id.length() == 0 || password == null || password.length() == 0) return;

        if (id.contains(" ") || id.contains(";") || password.contains(" ") || password.contains(";")) return;




    }
}
