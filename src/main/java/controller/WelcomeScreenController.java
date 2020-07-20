package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import main.java.bank.Client;
import main.java.services.BankDatabase;
import main.java.services.Navigator;

public class WelcomeScreenController {

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
        Navigator.navigate("newUserScene.fxml");
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

        Client client = BankDatabase.getClient(id, password);

        if (client == null) {
            // error;
            System.err.println("No such user found");
        }

        Client.login(client);

        Navigator.navigate("userAccountScene.fxml");


    }
}
