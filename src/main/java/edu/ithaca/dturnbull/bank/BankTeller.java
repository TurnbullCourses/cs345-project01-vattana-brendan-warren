package edu.ithaca.dturnbull.bank;

public class BankTeller extends Teller {
    private int tellerID;
   
    public BankTeller(CentralBank centralBank) {
        super();
        tellerID = centralBank.nextBankTellerID;
        centralBank.nextBankTellerID++;
    }
    
    public void createAccount(CentralBank centralBank, Customer customer, double balance, Boolean saving) {
        if (saving) {
            Account savingAccount = new SavingAccount(balance, centralBank.nextAccountID, 0.05, 1000);
            centralBank.nextAccountID++;
            customer.addAccount(savingAccount);
        } else {
            Account checkingAccount = new CheckingAccount(balance, centralBank.nextAccountID);
            centralBank.nextAccountID++;
            customer.addAccount(checkingAccount);
        }
    }

    public void closeAccount(Customer customer, Account account) {
        customer.removeAccount(account);
    }

    public int getID() {
        return tellerID;
    }
}
