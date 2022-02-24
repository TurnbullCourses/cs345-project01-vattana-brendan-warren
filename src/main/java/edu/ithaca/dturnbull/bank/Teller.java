package edu.ithaca.dturnbull.bank;
import java.util.ArrayList;

public class Teller {

    public Teller() {
        
    }

    protected void transfer(Customer fromCustomer, Customer toCustomer, Account fromAccount, Account toAccount, double amount) throws IllegalAccessException, InsufficientFundsException {
        ArrayList<Account> fromAccounts = fromCustomer.getAccounts();
        ArrayList<Account> toAccounts = toCustomer.getAccounts();
        if (fromAccounts.contains(fromAccount) && toAccounts.contains(toAccount) ) {
            fromAccount.transfer(amount, toAccount);
        }
    }

    protected void deposit(Customer customer, Account account, double amount) throws InsufficientFundsException {
        ArrayList<Account> accounts = customer.getAccounts();
        if (accounts.contains(account)) {
            account.deposit(amount);
        }
    }

    protected void withdraw(Customer customer, Account account, double amount) throws InsufficientFundsException {
        ArrayList<Account> accounts = customer.getAccounts();
        if (accounts.contains(account)) {
            account.withdraw(amount);
        }
    }

    protected double checkAccountBalance(Customer customer, Account account) throws InsufficientFundsException {
        ArrayList<Account> accounts = customer.getAccounts();
        if (accounts.contains(account)) {
            return account.checkAccountBalance();
        } 
        return -1;
    }
}
