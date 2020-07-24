package main.java.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.java.bank.Account;
import main.java.bank.Client;
import main.java.services.BankDatabase;


public class AccountSceneController {

    @FXML
    ScrollPane accountsListScroll;

    @FXML
    ToggleGroup accountType;

    @FXML
    private void initialize() {
        accountType.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioButton rb = (RadioButton)accountType.getSelectedToggle();

            if (rb != null) {
                // Get all accounts of this type
                for (Account a : BankDatabase.getAccounts(Integer.toString(Client.getCurrentClient().getId()), rb.getId())) {
                    Label l = new Label();
                    l.setText(Integer.toString(a.getBalance()));

                }
                // Add them to the list
            }
        });
    }
}
