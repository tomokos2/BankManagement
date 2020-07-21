package main.java.bank.accountTypes;

import main.java.bank.Account;

public static class RetirementAccount implements Account {
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