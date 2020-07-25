package main.java.bank.accountTypes;

import main.java.bank.Account;
import main.java.bank.Transaction;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class SavingsAccount implements Account {
    private int balance;
    private LocalDateTime dateCreated;
    private LinkedList<Transaction> transactions;

    public SavingsAccount(int balance, LocalDateTime dateCreated, LinkedList<Transaction> transactions) {
        this.balance = balance;
        this.dateCreated = dateCreated;
        this.transactions = transactions;
    }
    @Override
    public String getAccountType() {
        return null;
    }

    @Override
    public int getMinDeposit() {
        return 0;
    }

    @Override
    public int getMonthlyFee() {
        return 0;
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


}
