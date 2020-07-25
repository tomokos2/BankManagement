package main.java.bank;

import java.sql.Date;

public class Transaction {
    private int accountId;
    private Date date;
    private int amount;
    private int status;
    private String type;

    public Transaction(int accountId, Date date, int amount, int status, String type) {
        this.accountId = accountId;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.type = type;
    }

    public int getAccountId() {
        return accountId;
    }

    public Date getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getStatusString() {
        if (status == 0) {
            return "Success";
        } else if (status == -1) {
            return "Error";
        } else {
            return "Processing";
        }
    }
}
