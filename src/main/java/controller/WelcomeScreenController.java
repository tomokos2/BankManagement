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
    GridPane adminPrompt;

    @FXML
    TextField adminId;

    @FXML
    TextField adminPassword;

    @FXML
    private void validateAdminLogin() {
        Client admin = getClient(adminId.getText(), adminPassword.getText());
        if (admin == null) {
            System.err.println("No such user found");
        }

        if (admin.getIsAdmin()) {
            // navigate to admin screen
        } else {
            System.err.println("Unauthorized as admin.");
        }
    }

    @FXML
    private void closeAdminPrompt() {
        adminPrompt.toBack();
    }

    @FXML
    private void onAdminLoginClick(ActionEvent e) {
        mainScreen.toBack();


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
        Client client = getClient(idField.getText(), passwordField.getText());


        if (client == null) {
            // error;
            System.err.println("No such user found");
        }

        Client.login(client);

        Navigator.navigate("userSelectScene.fxml");

    }

    private Client getClient(String id, String password) {
        if (id == null || id.length() == 0 || password == null || password.length() == 0) return null;

        if (id.contains(" ") || id.contains(";") || password.contains(" ") || password.contains(";")) return null;

        return BankDatabase.getClient(id, password);
    }
}
