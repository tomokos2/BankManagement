package main.java.controller;

import javafx.fxml.FXML;
import main.java.bank.Client;
import main.java.services.Navigator;

public class AdminMainController extends ClientAcceptorControllerBase {

    public void loginAdmin(Client c) {

    }

    @FXML
    private void onAddClientClick() {

    }

    @FXML
    private void onDeleteClientClick() {

    }

    @FXML
    private void onEditClientClick() {

    }

    @FXML
    private void onLogout() {
        Navigator.navigate("welcomeScene.fxml");
    }
}
