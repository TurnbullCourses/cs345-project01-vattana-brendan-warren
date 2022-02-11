package edu.ithaca.dturnbull.bank;

import java.util.function.Supplier;
import edu.ithaca.dturnbull.bank.BankAccount;
public class SavingAccount extends BankAccount {
    public SavingAccount(String email, double startingBalance) {
        super(email, startingBalance);
        
    }

    public void compoundInterest(double balance) {
        balance = balance * 1;
    }
}