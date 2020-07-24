package main.java.bank;

public interface Account {
    String getAccountType();

    int getMinDeposit();

    int getMonthlyFee();

    int getBalance();

    Transaction getTransactions();
}
