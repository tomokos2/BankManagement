package main.java.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import main.java.bank.Account;
import main.java.bank.Client;
import main.java.bank.Transaction;
import main.java.services.BankDatabase;

import java.beans.EventHandler;
import java.util.LinkedList;


public class AccountSceneController {

    @FXML
    AnchorPane shader;

    @FXML
    VBox accountScrollContent;

    @FXML
    VBox transactionScrollContent;

    @FXML
    ToggleGroup accountType;

    @FXML
    Label balanceField;

    Account currAccount;

    @FXML
    private void initialize() {
        accountType.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            RadioButton rb = (RadioButton)accountType.getSelectedToggle();

            if (rb != null) {
                // Get all accounts of this type
                for (Account a : BankDatabase.getAccounts(Integer.toString(Client.getCurrentClient().getId()), rb.getId())) {
                    Button accountButton = new Button();
                    accountButton.setText("Account Number: " + a.getId());
                    accountButton.setOnAction(e -> {
                        LinkedList<Transaction> transactions = a.getTransactions();
                        for (Transaction t : transactions) {
                            Label tLabel = new Label();
                            tLabel.setText("Amount: " + t.getAmount() + ", Date: " + t.getDate().toString() +
                                    ", Status: " + t.getStatusString() + ", Type: " + t.getType());
                            transactionScrollContent.getChildren().add(tLabel);

                        }
                        currAccount = a;
                        balanceField.setText(Integer.toString(a.getBalance()));
                    });
                    shader.toBack();
                    // Set event handler
                    accountScrollContent.getChildren().add(accountButton);
                }
                // Add them to the list
            }
        });
    }

    @FXML
    private void onDeposit() {
        if (currAccount != null) {

        }
    }

    @FXML
    private void onWithdraw() {

    }

    @FXML
    private void onTransfer() {

    }
}
