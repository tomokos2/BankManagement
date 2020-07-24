package main.java.bank.accountTypes;

import main.java.bank.Account;
import main.java.bank.Transaction;

public class SavingsAccount implements Account {
    int balance;
    public SavingsAccount(int balance) {
        this.balance = balance;
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
    public Transaction getTransactions() {
        return null;
    }
}
