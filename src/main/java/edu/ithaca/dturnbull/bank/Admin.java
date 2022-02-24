package edu.ithaca.dturnbull.bank;

public class Admin {

    private String adminID;
    private String adminPassword;

    /**
     * Author: Warren K. Watson II
     * Purpose: Constructor
     * @args: adminID, adminPassword
     */
    public Admin (String adminID, String adminPassword){
        this.adminID = adminID;
        this.adminPassword = adminPassword;

    }

    /**
     * Author: Warren K. Watson II
     * Purpose: Checks overall amount of money across every 
     * account in the bank
     * @args: account 
     * @return: account balance
     */
    public double checkOverallMoney(Account account){
        return account.checkAccountBalance();
    }

    /**
     * Author: Warren K. Watson II
     * Purpose: request a report of accounts that seem to 
     * have suspicious activity
     * @args: account 
     * @return: list of accounts
     */
    public Account<ArrayList> requestSuspiciousAccounts(Account account){

    }

    /**
     * Author: Warren K. Watson II
     * Purpose: freezes an account
     * @args: none
     * @return: none
     */
    public void freezeAccount(Account account){

    }

    /**
     * Author: Warren K. Watson II
     * Purpose: unfreezes an account
     * @args: account
     * @return: none
     */
    public void unfreezeAccount(Account account){

    } 
}
