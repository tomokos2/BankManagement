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
        Transaction t;
        if (amount > balance) {
            // Insufficient funds;
            t = new Transaction(id, LocalDateTime.now(), amount, Transaction.ERROR,
                    "withdraw", Transaction.INSUFFICIENT_FUNDS);
        } else {
            t = new Transaction(id, LocalDateTime.now(), amount, Transaction.SUCCESS, "withdraw", null);
            balance -= amount;
            BankDatabase.updateAccountBalance(id, balance, t);

            transactions.add(t);
        }


    }

    @Override
    public void deposit(double amount) {
        Transaction t;
        t = new Transaction(id, LocalDateTime.now(), amount, Transaction.SUCCESS, "deposit", null);
        balance += amount;
        BankDatabase.updateAccountBalance(id, balance, t);
        transactions.add(t);
    }
}
