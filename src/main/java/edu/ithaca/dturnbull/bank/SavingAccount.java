package edu.ithaca.dturnbull.bank;

import java.util.function.Supplier;
import edu.ithaca.dturnbull.bank.BankAccount;
public class SavingAccount extends BankAccount {
    double maxDailyWithdrawAmount = 1000;

    public SavingAccount(String email, String password, double balance) {
        super(email, password, balance);
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public void compoundInterest(double balance) {
        balance += balance * 0.025;
    }

    @Override
    public void withdraw (double amount) throws InsufficientFundsException{
        if (!isAmountValid(amount)) {
            throw new IllegalArgumentException("The amount entered should be postive or have 2 decimal places or less.");
        }

        if (amount < 0){
            throw new IllegalArgumentException();
        }
        if (amount <= this.balance && (maxDailyWithdrawAmount - amount > 0)){
            this.balance -= amount;
        }
        else {
            throw new InsufficientFundsException("Not enough money");
        }
    }
}