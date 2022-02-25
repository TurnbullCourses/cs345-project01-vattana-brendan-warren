package edu.ithaca.dturnbull.bank;

public class ATM extends Teller {
    private int tellerID;
    private String location;
    
    public ATM(CentralBank centralBank, String atmLocation) {
        super();
        tellerID = centralBank.nextBankTellerID;
        location = atmLocation;
        centralBank.nextBankTellerID++;
    }


    public int getID() {
        return tellerID;
    }

}
