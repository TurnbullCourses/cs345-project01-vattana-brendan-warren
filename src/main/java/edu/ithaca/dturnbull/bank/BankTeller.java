package edu.ithaca.dturnbull.bank;

public class BankTeller extends Teller {
    private int tellerID;
   
    public BankTeller(CentralBank centralBank) {
        tellerID = centralBank.nextBankTellerID;
        centralBank.nextBankTellerID++;
    }
    
}
