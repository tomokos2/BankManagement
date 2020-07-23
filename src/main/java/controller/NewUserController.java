package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.services.BankDatabase;
import main.java.services.Navigator;

import java.sql.Date;

public class NewUserController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private DatePicker birthDateField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField userIDField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordConfirmField;

    @FXML
    private void onSubmitForm(ActionEvent e) {
        String firstName = firstNameField.getText();
        if (!isValid(firstName)) return;
        String lastName = lastNameField.getText();
        if (!isValid(lastName)) return;
        Date date = Date.valueOf(birthDateField.getValue());
        if (!isValid(date.toString())) return;
        String address = addressField.getText();
        if (!isValid(address)) return;
        String userID = userIDField.getText();
        if (!isValid(userID) || userID.contains(" ")) return;
        String password = passwordField.getText();
        if (!isValid(password) || password.contains(" ")) return;
        String passwordConfirm = passwordConfirmField.getText();

        if (!password.equals(passwordConfirm)) {
            return;
        }

        BankDatabase.addClient(firstName, lastName, date, address, userID, password);

        Navigator.navigate("welcomeScene.fxml");
    }

    @FXML
    private void onGoToWelcome() {
        Navigator.navigate("welcomeScene.fxml");
    }

    private boolean isValid(String input) {
        boolean isValid = true;
        if (input.length() == 0) {
            isValid = false;
        }

        return isValid;
    }

}
