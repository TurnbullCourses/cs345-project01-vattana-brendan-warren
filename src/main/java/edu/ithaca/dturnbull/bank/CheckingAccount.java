package edu.ithaca.dturnbull.bank;

import java.util.function.Supplier;
import edu.ithaca.dturnbull.bank.Account;


class CheckingAccount extends Account {
    public CheckingAccount(String email, String password, double balance) {
        super();
        this.email = email;
        this.password = password;
        this.balance = balance;
    }
}