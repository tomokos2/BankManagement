package main.java.bank.accountTypes;

import main.java.bank.Account;

public class CDAccount implements Account {
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
        return 0;
    }
}
