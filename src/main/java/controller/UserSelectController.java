package main.java.controller;

import javafx.fxml.FXML;
import main.java.bank.Client;
import main.java.services.Navigator;

public class UserSelectController extends ClientAcceptorControllerBase {

    @FXML
    private void onLogout() {
        Client.logout();
        Navigator.navigate("welcomeScene.fxml");
    }

    @FXML
    private void onAccountClick() {
        Navigator.navigate("userAccountScene.fxml");
    }

    @FXML
    private void onNewAccount() {
        Navigator.navigate("newAccountScene.fxml");
    }
}
