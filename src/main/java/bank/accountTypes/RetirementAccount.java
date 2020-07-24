package main.java.bank.accountTypes;

import main.java.bank.Account;
import main.java.bank.Transaction;


public class RetirementAccount implements Account {
    int balance;

    public RetirementAccount(int balance) {
        this.balance = balance;
    }
    @Override
    public String getAccountType() {
        return "retirement";
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
