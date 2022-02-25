package edu.ithaca.dturnbull.bank;

public class SavingAccount extends Account{
    private double interestRate;
    public double maxWithdrawal;

    public SavingAccount(double balanceIn, int nextAccountID, double interestRateIn, double maxWithdrawal) {
        super(balanceIn, nextAccountID);
        this.balance = balanceIn;
        this.accountID = nextAccountID;
        this.interestRate = interestRateIn;
        this.maxWithdrawal = maxWithdrawal;
        this.saving = true;
    }   

    public void compoundInterest() {
        super.balance *= this.interestRate;
    }

    public int getAccountID() {
        return accountID;
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