package main.java.bank.accountTypes;

import main.java.bank.Account;

public class SavingsAccount implements Account {
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
}
