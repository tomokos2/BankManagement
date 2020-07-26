package main.java.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import main.java.bank.Account;
import main.java.bank.Client;
import main.java.services.BankDatabase;


public class AccountSceneController {

    @FXML
    VBox accountScrollContent;

    @FXML
    ToggleGroup accountType;

    @FXML
    private void initialize() {
        accountType.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioButton rb = (RadioButton)accountType.getSelectedToggle();

            if (rb != null) {
                // Get all accounts of this type
                for (Account a : BankDatabase.getAccounts(Integer.toString(Client.getCurrentClient().getId()), rb.getId())) {
                    Button accountButton = new Button();
                    accountButton.setText("Account Number: " + a.getId());
                    // Set event handler
                    accountScrollContent.getChildren().add(accountButton);
                }
                // Add them to the list
            }
        });
    }
}
