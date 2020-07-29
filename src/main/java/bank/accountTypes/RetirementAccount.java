package main.java.bank.accountTypes;

import main.java.bank.Account;
import main.java.bank.AccountBase;
import main.java.bank.Transaction;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class RetirementAccount extends AccountBase {

    public RetirementAccount(int id, int balance, LocalDateTime dateCreated, LinkedList<Transaction> transactions) {
        super(id, balance, dateCreated, transactions);
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

}
