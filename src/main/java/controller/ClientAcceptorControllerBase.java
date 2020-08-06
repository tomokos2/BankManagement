package main.java.controller;

import main.java.bank.Client;

public abstract class ClientAcceptorControllerBase {
    Client client;

    public void LoginClient(Client c) {
        client = c;
    }
}
