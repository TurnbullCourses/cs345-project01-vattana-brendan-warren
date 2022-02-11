package edu.ithaca.dturnbull.bank;

import java.util.function.Supplier;
import edu.ithaca.dturnbull.bank.BankAccount;


class CheckingAccount extends BankAccount {
    public CheckingAccount(String email, double startingBalance) {
        super(email, startingBalance);
    }
}