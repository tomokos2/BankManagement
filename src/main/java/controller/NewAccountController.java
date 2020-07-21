package main.java.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import main.java.services.Navigator;

public class NewAccountController {

    @FXML
    ToggleGroup accountType;

    @FXML
    private void onBackToUserSelect() {
        Navigator.navigate("userSelectScene.fxml");
    }

    @FXML
    private void onSubmitForm() { }

    @FXML
    private void onSelectAccount() {
        String selected = ((Node) accountType.getSelectedToggle()).getId();
    }

    private int getMinDeposit(String type) {
        switch(type) {
            case "checking":
                return 0;
            case "cd":
                break;
            case "retirement":
                break;
            case "savings":
                break;
            default:
                return 0;
        }
    }

}
