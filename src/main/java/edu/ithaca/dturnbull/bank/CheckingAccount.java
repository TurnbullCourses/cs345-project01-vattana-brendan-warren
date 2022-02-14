package edu.ithaca.dturnbull.bank;

class CheckingAccount extends Account {
    public CheckingAccount(double balanceIn, String accountIDIn) {
        super(balanceIn, accountIDIn);
        this.balance = balanceIn;
        this.accountID = accountIDIn;
    }
}