package main.java.bank;

import main.java.services.BankDatabase;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class AccountBase implements Account {
    private int balance;
    private LocalDateTime dateCreated;
    private LinkedList<Transaction> transactions;
    private int id;

    public AccountBase(int id, int balance, LocalDateTime dateCreated, LinkedList<Transaction> transactions) {
        this.balance = balance;
        this.dateCreated = dateCreated;
        this.transactions = transactions;
        this.id = id;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void withdraw(double amount) {
        BankDatabase.updateAccountBalance(id, -1 * amount);
    }

    @Override
    public void deposit(double amount) {
        BankDatabase.updateAccountBalance(id, amount);
    }
}
