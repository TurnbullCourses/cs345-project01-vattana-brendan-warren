package edu.ithaca.dturnbull.bank;

public class SavingAccount extends Account {

    private double interestRate;
    public double maxWithdrawal;

    public SavingAccount(double balanceIn, String accountIDIn, double interestRateIn, double maxWithdrawal) {
        super(balanceIn, accountIDIn);
        this.balance = balanceIn;
        this.accountID = accountIDIn;
        this.interestRate = interestRateIn;
        this.maxWithdrawal = maxWithdrawal;
    }

    public void compoundInterest() {
        super.balance *= this.interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (!isAmountValid(amount)) {
            throw new IllegalArgumentException("The amount entered should be postive or have 2 decimal places or less.");
        }

        if (amount < 0){
            throw new IllegalArgumentException();
        }
        if (amount <= balance && (maxWithdrawal - amount >= 0)){
            balance -= amount;
            withdrawals.add(amount);
        }
        else {
            throw new InsufficientFundsException("Not enough money");
        }
    }
}