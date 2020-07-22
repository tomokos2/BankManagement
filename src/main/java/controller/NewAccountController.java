package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import main.java.services.Navigator;

public class NewAccountController {

    String selectedAccount;

    @FXML
    ToggleGroup accountType;

    @FXML
    AnchorPane popupScreen;

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
