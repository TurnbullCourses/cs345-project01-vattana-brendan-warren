package edu.ithaca.dturnbull.bank;

import java.util.function.Supplier;
import edu.ithaca.dturnbull.bank.BankAccount;


class CheckingAccount extends BankAccount {
    public CheckingAccount(String email, String password, double balance) {
        super(email, password, balance);
        this.email = email;
        this.password = email;
        this.balance = balance;
    }
}