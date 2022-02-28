package edu.ithaca.dturnbull.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    protected double balance;
    protected int accountID;
    protected List<List<Double>> history;
    protected List<Double> withdrawals;
    protected List<Double> deposits;
    protected boolean active;
    protected boolean saving = false;

    public Account(double balanceIn, int accountIDIn) {
        if (isAmountValid(balanceIn)) {
            balance = balanceIn;
            accountID = accountIDIn;
        } else {
            throw new IllegalArgumentException("The balance entered has to be positive and has no more than two decimal places.");
        }
        
        history = new ArrayList<>();
        deposits = new ArrayList<>();
        withdrawals = new ArrayList<>();
        history.add(deposits);
        history.add(withdrawals);
        active = true;
    }

    public List<List<Double>> checkAccountHistory() {
        return history;
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
            withdrawals.add(amount);
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
            deposits.add(amount);
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

    /***
     * @return none
     * sets active variable to false
     */
    public void freeze() {
        this.active = false;
    }

    /***
     * @return none
     * sets active variable to true
     */
    public void unfreeze() {
        this.active = true;
    }

    /***
     * @return none
     * returns status of active variable
     */
    public boolean isFrozen() {
        return !this.active;
    }

    public static int add(int a, int b) {
        return a+b;
    }

    public static int subtract(int a, int b){
        return a-b;
    }
}
