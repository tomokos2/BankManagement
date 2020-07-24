package main.java.bank.accountTypes;

import main.java.bank.Account;
import main.java.bank.Transaction;

public class CDAccount implements Account {
    private int balance;

    public CDAccount(int balance) {
        this.balance = balance;
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
    public Transaction getTransactions() {
        return null;
    }
}
