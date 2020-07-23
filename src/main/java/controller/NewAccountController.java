package main.java.controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import main.java.bank.Client;
import main.java.services.Navigator;


public class NewAccountController {

    String selectedAccount;

    @FXML
    ToggleGroup accountType;

    @FXML
    AnchorPane popupScreen;

    @FXML
    Label idLabel;

    @FXML
    Label nameLabel;

    @FXML
    Label addressLabel;

    @FXML
    Label birthdayLabel;

    @FXML
    PasswordField ssnField;

    @FXML
    TextField driversLicenseField;

    @FXML
    TextField initDepositField;


    @FXML
    private void initialize() {
        Client current = Client.getCurrentClient();
        idLabel.setText(current.getUserId());
        nameLabel.setText(current.getFirstName() + " " + current.getLastName());
        addressLabel.setText(current.getAddress());
        birthdayLabel.setText(current.getBirthDate().toLocalDate().toString());

        driversLicenseField.textProperty().addListener(getDigitRestriction(driversLicenseField, 9));
        ssnField.textProperty().addListener(getDigitRestriction(ssnField, 4));
        initDepositField.textProperty().addListener(getDigitRestriction(initDepositField, 20));
    }

    @FXML
    private void onBackToUserSelect() {
        Navigator.navigate("userSelectScene.fxml");
    }

    @FXML
    private void onSubmitForm() { }

    @FXML
    private void onSelectAccount() {
        selectedAccount = ((Node) accountType.getSelectedToggle()).getId();
        popupScreen.toBack();
    }

    @FXML
    private void onBackToAccountSelect() {
        popupScreen.toFront();
    }

    private ChangeListener<String> getDigitRestriction(TextField textField, int length) {
        return (observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
            if (newValue.length() > length) {
                textField.setText(newValue.substring(0, length));
            }
        };
    }

//    private int getMinDeposit(String type) {
//        switch(type) {
//            case "checking":
//                return 0;
//            case "cd":
//                break;
//            case "retirement":
//                break;
//            case "savings":
//                break;
//            default:
//                return 0;
//        }
//    }

}
