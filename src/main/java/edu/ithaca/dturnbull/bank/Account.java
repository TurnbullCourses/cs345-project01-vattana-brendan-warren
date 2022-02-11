package edu.ithaca.dturnbull.bank;

public class Account {
    protected double balance;
    protected String accountID;

    public Account(double balanceIn, String accountIDIn) {
        balance = balanceIn;
        accountID = accountIDIn;
    }
}
