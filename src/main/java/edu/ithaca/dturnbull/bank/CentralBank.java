package edu.ithaca.dturnbull.bank;
import java.util.ArrayList;
import java.util.List;

public class CentralBank {
    public List<Customer> customerList;
    public int nextAccountID = 0;
    public int nextAtmID = 0;
    public int nextBankTellerID = 0;

    public CentralBank() {
        customerList = new ArrayList<>();
    }
}
