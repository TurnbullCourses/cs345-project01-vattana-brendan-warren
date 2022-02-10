package edu.ithaca.dturnbull.bank;

import java.util.function.Supplier;
import edu.ithaca.dturnbull.bank.Account;
public class SavingAccount extends Account {
    public SavingAccount(String email, String password, double balance) {
        super();
        this.email = email;
        this.password = password;
        this.balance = balance;

    }

    public void compoundInterest(double balance) {
        balance = balance * 1;
    }
}