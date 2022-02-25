package edu.ithaca.dturnbull.bank;

public class BankTeller extends Teller {
    private int tellerID;
   
    public BankTeller(CentralBank centralBank) {
        super();
        tellerID = centralBank.getNextBankTellerID();
        centralBank.increaseBankTellerID();
    }
    
    public void createAccount(CentralBank centralBank, Customer customer, double balance, Boolean saving) {
        if (saving) {
            Account savingAccount = new SavingAccount(balance, centralBank.getNextAccountID(), 0.05, 1000);
            centralBank.increaseAccountID();
            customer.addAccount(savingAccount);
        } else {
            Account checkingAccount = new CheckingAccount(balance, centralBank.getNextAccountID());
            centralBank.increaseAccountID();
            customer.addAccount(checkingAccount);
        }
    }

    public void closeAccount(CentralBank centralBank, Customer customer, Account account) {
        customer.removeAccount(account);
    }

    public int getID() {
        return tellerID;
    }

    public void registerCustomer(String name, String password) {
        Customer newCustomer = new Customer(name, customerID, password);
        central
    }
}
