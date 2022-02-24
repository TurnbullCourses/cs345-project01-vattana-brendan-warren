package edu.ithaca.dturnbull.bank;
import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    private List<Customer> customerList;
    private List<List<Teller>> tellerList;
    public int nextAccountID = 0;
    public int nextAtmID = 0;
    public int nextBankTellerID = 0;

    public CentralBank() {
        customerList = new ArrayList<>();
        tellerList = new ArrayList<>();
    }
}
