package main.java.bank.accountTypes;

import main.java.bank.Account;
import main.java.bank.Transaction;

import java.sql.Date;
import java.util.LinkedList;

public class CDAccount implements Account {
    private int balance;
    private Date dateCreated;
    private LinkedList<Transaction> transactions;

    public CDAccount(int balance, Date dateCreated, LinkedList<Transaction> transactions) {
        this.balance = balance;
        this.dateCreated = dateCreated;
        this.transactions = transactions;
    }

    @Override
    public String getAccountType() {
        return "cd";
    }

    @Override
    public int getMinDeposit() {
        return 0;
    }

    @Override
    public int getMonthlyFee() {
        return 25;
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
    public Date getDateCreated() {
        return dateCreated;
    }
}
