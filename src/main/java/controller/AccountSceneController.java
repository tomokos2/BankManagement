package main.java.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import main.java.bank.Account;
import main.java.bank.Client;
import main.java.bank.Transaction;
import main.java.services.BankDatabase;
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

    @FXML
    VBox updateBalancePrompt;

    @FXML
    TextField amountField;

    @FXML
    Label promptLabel;

    @FXML
    Button submitBalanceUpdate;

    Account currAccount;

    @FXML
    private void initialize() {
        amountField.textProperty().addListener(NewAccountController.getDigitRestriction(amountField, 100));
        accountType.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            accountScrollContent.getChildren().clear();
            RadioButton rb = (RadioButton)accountType.getSelectedToggle();

            if (rb != null) {
                // Get all accounts of this type
                for (Account a : BankDatabase.getAccounts(Integer.toString(Client.getCurrentClient().getId()), rb.getId())) {
                    Button accountButton = new Button();
                    accountButton.setText("Account Number: " + a.getId());
                    accountButton.setOnAction(e -> {
                        transactionScrollContent.getChildren().clear();
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
        updateBalancePrompt.toFront();
        if (currAccount != null) {
            promptLabel.setText("Enter amount to deposit");
            submitBalanceUpdate.setText("Deposit");
            submitBalanceUpdate.setOnAction(e -> {
                String amount = amountField.getText();
                if (amount != null && !amount.isEmpty()) {
                    currAccount.deposit(Integer.parseInt(amount));
                    closePrompt();
                }
            });
        }
    }

    @FXML
    private void onWithdraw() {
        updateBalancePrompt.toFront();
        if (currAccount != null) {
            promptLabel.setText("Enter amount to withdraw");
            submitBalanceUpdate.setText("Withdraw");
            submitBalanceUpdate.setOnAction(e -> {
                String amount = amountField.getText();
                if (amount != null && !amount.isEmpty()) {
                    currAccount.withdraw(Integer.parseInt(amount));
                    closePrompt();
                }
            });

        }
    }

    @FXML
    private void onTransfer() {
        if (currAccount != null) {

        }
    }

    @FXML
    private void closePrompt() {
        updateBalancePrompt.toBack();
    }
}
