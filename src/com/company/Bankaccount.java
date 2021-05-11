package com.company;

public class Bankaccount {
    private int accountnumber;
    private int accountexists;
    private String accountprefix;
    private int accountbalance;

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountexists(int accountexists) {
        this.accountexists = accountexists;
    }

    public int getAccountexists() {
        return accountexists;
    }

    public void setAccountprefix(String accountprefix) {
        this.accountprefix = accountprefix;
    }

    public String getAccountprefix() {
        return accountprefix;
    }

    public int getAccountbalance() {
        return accountbalance;
    }

    public void setAccountbalance(int accountbalance) {
        this.accountbalance = accountbalance;
    }
}
