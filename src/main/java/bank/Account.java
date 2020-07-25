package main.java.bank;

import java.sql.Date;
import java.util.LinkedList;

public interface Account {
    String getAccountType();

    int getMinDeposit();

    int getMonthlyFee();

    int getBalance();

    LinkedList<Transaction> getTransactions();

    Date getDateCreated();
}
