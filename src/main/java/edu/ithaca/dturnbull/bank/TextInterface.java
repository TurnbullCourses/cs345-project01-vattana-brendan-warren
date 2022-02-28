package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

public class TextInterface {
    public static void main(String[] args) throws InsufficientFundsException, IllegalAccessException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to CentralBank!");
        System.out.println("1 - CUSTOMER");
        System.out.println("2 - ADMIN");
        System.out.println("3 - TELLER");
        System.out.println("Enter the number to match your user type:");
        String userType = scan.nextLine();

        switch (userType) {
            case "1" : 
                handleCustomer();
                break;
            case "2" : 
                // handleAdmin();
                break;
            case "3" :
                handleTeller();
                break;
        }

        scan.close();


    }

    private static void handleCustomer() throws InsufficientFundsException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter name:");
        String userName = scan.nextLine();
        System.out.println("Enter password:");
        String password = scan.nextLine();
        Customer myCustomer = new Customer(userName, 001, password);
        myCustomer.addAccount(new CheckingAccount(100, 001));
        myCustomer.addAccount(new SavingAccount(100, 001, 1.08, 500));
        System.out.println("Welcome " + myCustomer.getName() + "! Your ID is customer1 and your password is " + myCustomer.getPassword());
        System.out.println("You have been given a CHECKING and SAVINGS account, each with balance $100.00.");

        String userCore = "ENTER";
        while (userCore != "Q\n") {
            

            switch (userCore) {
                case "1" : 
                    int numAccounts = myCustomer.getAccounts().size();
                    if (numAccounts <= 2) {
                        System.out.println("You have " + numAccounts + " accounts.");
                        System.out.println("Which account?");
                        System.out.println("1 - CHECKING");
                        System.out.println("2 - SAVINGS");
                        int accountType = scan.nextInt();
                        System.out.println("How much do you wish to deposit?");
                        double amount = scan.nextDouble();
                        if (Account.isAmountValid(amount)) {
                            if (accountType == 1) {
                                myCustomer.getAccounts().get(0).deposit(amount);
                                System.out.println("Deposit successful.");
                                System.out.println("New amount of CHECKING account: " + myCustomer.getAccounts().get(0).checkAccountBalance());
                            } else if (accountType == 2) {
                                myCustomer.getAccounts().get(1).deposit(amount);
                                System.out.println("Deposit successful.");
                                System.out.println("New amount of SAVING account: " + myCustomer.getAccounts().get(1).checkAccountBalance());
                            } 
                        } else {
                            System.out.println("Amount invalid.");
                        }
                    }   
                    break;
                case "2" :
                    int acc = myCustomer.getAccounts().size();
                    if (acc <= 2) {
                        System.out.println("You have " + acc + " accounts.");
                        System.out.println("Which account do you wish to check?");
                        System.out.println("1 - CHECKING");
                        System.out.println("2 - SAVINGS");
                        int accountType = scan.nextInt();
                        if (accountType == 1) {
                            System.out.println("CHECKING account balance: " + myCustomer.getAccounts().get(0).checkAccountBalance());
                        } else if (accountType == 2) {
                            System.out.println("SAVING account balance: " + myCustomer.getAccounts().get(1).checkAccountBalance());
                        } 
                    }                           
                    break;
            }
            displayCustomerOptions();
            userCore = scan.nextLine();
        }
        scan.close();
    }

    /*
    private static void handleAdmin() {
        Scanner scan = new Scanner(System.in);
        Admin admin = new Admin("SuperAdmin", "SuperAdminPassword");
        Customer customer1 = new Customer("Doug", "customer1", "password1");
        customer1.addAccount(new CheckingAccount(100, "checking1"));
        customer1.addAccount(new SavingAccount(100, "saving", 1.08, 500));
        System.out.println("Welcome " + admin.getName() + "! Your password is " + admin.getPassword());
        System.out.println("You are working with a customer who has a CHECKING and SAVINGS account.");

        String adminCore = "ENTER";
        while (adminCore != "Q\n") {
            

            switch (adminCore) {
                case "1" : 
                    System.out.println("Which of the customer's accounts would you like to freeze?");
                    System.out.println("1 - CHECKING");
                    System.out.println("2 - SAVINGS");
                    int accountType = scan.nextInt();
                    if (accountType == 1) {
                        customer1.getAccounts().get(0).freeze();
                        System.out.println("Account freeze successful.");
                        System.out.println("CHECKING account FROZEN status: " + customer1.getAccounts().get(0).isFrozen());
                    } else if (accountType == 2) {
                        customer1.getAccounts().get(1).freeze();
                        System.out.println("Account freeze successful.");
                        System.out.println("SAVINGS account FROZEN status: " + customer1.getAccounts().get(1).isFrozen());
                    } 
                    break;
                case "2" :
                    System.out.println("Which of the customer's accounts would you like to freeze?");
                    System.out.println("1 - CHECKING");
                    System.out.println("2 - SAVINGS");
                    int accType = scan.nextInt();
                    if (accType == 1) {
                        customer1.getAccounts().get(0).unfreeze();
                        System.out.println("Account freeze successful.");
                        System.out.println("CHECKING account FROZEN status: " + customer1.getAccounts().get(0).isFrozen());
                    } else if (accType == 2) {
                        customer1.getAccounts().get(1).unfreeze();
                        System.out.println("Account freeze successful.");
                        System.out.println("SAVINGS account FROZEN status: " + customer1.getAccounts().get(1).isFrozen());
                    } 
                    break;
            }
            displayAdminOptions();
            adminCore = scan.nextLine();
        }
        scan.close();
    } 
    */

    private static void handleTeller() throws IllegalAccessException, InsufficientFundsException {
        Scanner scan = new Scanner(System.in);

        Customer customer1 = new Customer("Doug", 001, "password1");
        customer1.addAccount(new CheckingAccount(1000, 01));

        Customer customer2 = new Customer("John", 002, "password2");
        customer2.addAccount(new CheckingAccount(1000, 01));

        System.out.println("Welcome Teller");
        System.out.println("You are working with two customers, Doug and John, who both have an active CHECKING account with $1000.00.");

        String tellerCore = "ENTER";
        while (tellerCore != "Q\n") {
            
            switch (tellerCore) {
                case "1" : 
                    System.out.println("Which customer do you want to transfer from?");
                    System.out.println("1 - DOUG");
                    System.out.println("2 - JOHN");
                    int fromAccount = scan.nextInt();
                    double fromBalance;
                    if (fromAccount == 1) {
                        fromBalance = customer1.getAccounts().get(0).checkAccountBalance();
                    } else if (fromAccount == 2) {
                        fromBalance = customer2.getAccounts().get(0).checkAccountBalance();
                    } else {
                        break;
                    }
                    
                    System.out.println("How much do you want to transfer?");
                    double amount = scan.nextDouble();

                    if (fromBalance > amount) {
                        if (fromAccount == 1) {
                            customer1.getAccounts().get(0).transfer(amount, customer2.getAccounts().get(0));
                            System.out.println("Transfer successful.");
                            System.out.println(customer1.getName() + " successfully transfered $" + amount + " to " + customer2.getName());
                        }
                        if (fromAccount == 2) {
                            customer2.getAccounts().get(0).transfer(amount, customer1.getAccounts().get(0));
                            System.out.println("Transfer successful.");
                            System.out.println(customer2.getName() + " successfully transfered $" + amount + " to " + customer1.getName());
                        } 
                        System.out.println(customer1.getName() + "'s new balance : $" + customer1.getAccounts().get(0).checkAccountBalance());
                        System.out.println(customer2.getName() + "'s new balance : $" + customer2.getAccounts().get(0).checkAccountBalance());
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
            }
            displayTellerOptions();
            tellerCore = scan.nextLine();
        }
        scan.close();
    }

    
    private static void displayCustomerOptions() {
        System.out.println("Choose from the following:");
        System.out.println("1 - DEPOSIT FUNDS");
        System.out.println("2 - CHECK ACCOUNT BALANCE");
        System.out.println("CTRL+C - QUIT"); 
        System.out.println(""); 
    }

    private static void displayAdminOptions() {
        System.out.println("Choose from the following:");
        System.out.println("1 - FREEZE ACCOUNT");
        System.out.println("2 - UNFREEZE ACCOUNT");
        System.out.println("CTRL+C - QUIT"); 
        System.out.println(""); 
    }

    private static void displayTellerOptions() {
        System.out.println("Choose from the following:");
        System.out.println("1 - TRANSFER");
        System.out.println("CTRL+C - QUIT"); 
        System.out.println(""); 
    }

}

