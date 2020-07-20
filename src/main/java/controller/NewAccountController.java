package main.java.controller;

import javafx.fxml.FXML;
import main.java.services.Navigator;

public class NewAccountController {

    @FXML
    private void onBackToUserSelect() {
        Navigator.navigate("userSelectScene.fxml");
    }

    @FXML
    private void onSubmitForm() { }

}
