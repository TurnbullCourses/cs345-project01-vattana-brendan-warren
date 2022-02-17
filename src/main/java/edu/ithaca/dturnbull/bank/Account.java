package edu.ithaca.dturnbull.bank;

import java.lang.Math;

public class Account {
    protected double balance;
    protected String accountID;

    public Account(double balanceIn, String accountIDIn) {
        if (isAmountValid(balanceIn)) {
            balance = balanceIn;
            accountID = accountIDIn;
        } else {
            throw new IllegalArgumentException("The balance entered has to be positive and has no more than two decimal places.");
        }
    }

    public void checkAccountHistory() {
        
    }

    public double checkAccountBalance() {
        return balance;
    }

    public void withdraw (double amount) throws InsufficientFundsException{
        if (!isAmountValid(amount)) {
            throw new IllegalArgumentException("The amount entered should be postive or have 2 decimal places or less.");
        }

        if (amount < 0){
            throw new IllegalArgumentException();
        }
        if (amount <= balance){
            balance -= amount;
        }
        else {
            throw new InsufficientFundsException("Not enough money");
        }
    }

     /***
     * @param amount to be deposited to the account
     * @throws IllegalArgumentException if the amount entered is invalid (negative or have more than two decimal places)
     * @post the amount is deposited into the account
     */
    public void deposit(double amount) {
        if (!isAmountValid(amount)) {
            throw new IllegalArgumentException("The amount entered should be postive or have 2 decimal places or less.");
        } else {
            balance += amount;
        }
    }

    /***
     * @param recipientAccount you are transferring to
     * @throws IllegalArgumentException if the amount to be transferred entered is invalid
     * @throws InsufficientFundsException if the amount to be transferred is more than the account's remaining balance
     * @post the amount is deducted from your account and transferred to the account associated with the email entered
     */
    public void transfer(double amount, Account recipientAccount) throws IllegalAccessException, InsufficientFundsException {
        withdraw(amount);
        recipientAccount.deposit(amount);
    }

    /***
     * @return false, if the amount is negative
     * @return false, if the amount has more than two decimal places
     */
    public static Boolean isAmountValid(double amount) {
        if (amount < 0) {
            return false;
        }

        String amountString = Double.toString(amount);
        String decimalPlaces = amountString.split("\\.")[1].toString();
        
        if (decimalPlaces.length() > 2) {
            return false;
        }

        return true;
    }

    public static int add(int a, int b) {
        return a+b;
    }

    public static int subtract(int a, int b) {
        // TODO : 
    }
}
