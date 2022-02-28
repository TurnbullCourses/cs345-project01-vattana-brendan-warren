package edu.ithaca.dturnbull.bank;

public class Admin {
    private String adminID;
    private String password;

    public Admin(String adminID, String password) {
        this.adminID = adminID;
        this.password = password;
    }

    public void freezeAccount(Account account) {
        if (!account.isFrozen()) {
            account.freeze();
        }
    }

    public void unfreezeAccount(Account account) {
        if (account.isFrozen()) {
            account.unfreeze();
        }
    }

    public double getCustomerSum(Customer customer) {
        double sum = 0.0;
        for (int i = 0; i < customer.getAccounts().size(); i++) {
            sum += customer.getAccounts().get(i).checkAccountBalance();
        }
        return sum;
    }

    public String getAdminID() {
        return this.adminID;
    }

    public String getPassword() {
        return this.password;
    }
}