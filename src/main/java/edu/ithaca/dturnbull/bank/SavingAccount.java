package edu.ithaca.dturnbull.bank;

public class SavingAccount extends Account {

    private double interestRate;
    public double maxWithdrawal;

    public SavingAccount(double balanceIn, String accountIDIn, double interestRateIn, double maxWithdrawal) {
        super(balanceIn, accountIDIn);
        this.interestRate = interestRateIn;
        this.maxWithdrawal = maxWithdrawal;
    }

    public void compoundInterest() {
        super.balance *= this.interestRate;
    }
}