package main.java.bank;
import java.time.LocalDateTime;
import java.util.LinkedList;

public interface Account {
    String getAccountType();

    int getMinDeposit();

    int getMonthlyFee();

    int getBalance();

    LinkedList<Transaction> getTransactions();

    LocalDateTime getDateCreated();

    int getId();

    void withdraw(double amount);
    void deposit(double amount);

}
