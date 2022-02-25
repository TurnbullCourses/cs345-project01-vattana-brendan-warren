package edu.ithaca.dturnbull.bank;

class CheckingAccount extends Account {
    public CheckingAccount(double balanceIn, int nextAccountID) {
        super(balanceIn, nextAccountID);
        this.balance = balanceIn;
        this.accountID = nextAccountID;
    }
}