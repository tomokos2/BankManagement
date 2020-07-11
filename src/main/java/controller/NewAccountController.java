package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.services.BankDatabase;

import java.sql.Date;

public class NewAccountController {

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
        String lastName = lastNameField.getText();
        Date date = Date.valueOf(birthDateField.getValue());
        String address = addressField.getText();
        String userID = userIDField.getText();
        String password = passwordField.getText();
        String passwordConfirm = passwordConfirmField.getText();

        BankDatabase.addClient(firstName, lastName, date, address, userID, password);

        System.out.println("submitted!");
    }

}
