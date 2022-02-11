package edu.ithaca.dturnbull.bank;

public class Teller {

    public String tellerID;

    public Teller(String tellerID) {
        this.tellerID = tellerID;
    }

    protected void transfer(Customer fromCustomer, Customer toCustomer, Account fromAccount, Account toAccount, double amount) throws IllegalAccessException, InsufficientFundsException {
        // TODO : implement transfer()
    }

    protected void deposit(Customer customer, Account account, double amount) throws InsufficientFundsException {
        // TODO : implement deposit()
    }

    protected void withdraw(Customer customer, Account account, double amount) throws InsufficientFundsException {
        // TODO : implement withdraw()
    }

    protected double checkAccountBalance(Customer customer, Account account) throws InsufficientFundsException {
        // TODO : implement withdraw()
        return 0;
    }
}
