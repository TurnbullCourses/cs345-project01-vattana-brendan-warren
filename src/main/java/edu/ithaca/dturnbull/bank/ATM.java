package edu.ithaca.dturnbull.bank;

public class ATM extends Teller {
    private int tellerID;
    private String location;
    
    public ATM(CentralBank centralBank, String atmLocation) {
        super();
        tellerID = centralBank.getNextAtmID();
        location = atmLocation;
        centralBank.increaseAtmID();
    }

    public int getID() {
        return tellerID;
    }

}
