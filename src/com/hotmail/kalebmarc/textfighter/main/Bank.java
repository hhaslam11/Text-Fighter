package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

public class Bank {

    private static double interest;
    private static int balance;

    public static void menu() {

        int amount;

        //Makes sure user level 2
        if (Xp.getLevel() < 2) {
            Ui.cls();
            Ui.println("You have to be at least level 2 to use the bank.");
            Ui.pause();
            return;
        }

        while (true) {

            Ui.cls();
            Ui.println("---------------------------------------");
            Ui.println("                BANK              ");
            Ui.println();
            Ui.println("You can deposit your coins into");
            Ui.println("the bank, so they will be safe if");
            Ui.println("you die. However, you will need to");
            Ui.println("pay " + (interest * 100) + "% of what you're depositing");
            Ui.println("every time (Rounded to the nearest ");
            Ui.println("whole number).");
            Ui.println();
            Ui.println("Balance (Coins in the bank): " + get());
            Ui.println("Coins: " + Coins.get());
            Ui.println();
            Ui.println("1) Deposit");
            Ui.println("2) Withdraw");
            Ui.println("3) Request Loan");
            Ui.println("4) Back");
            Ui.println("---------------------------------------");

            switch (Ui.getValidInt()) {
                case 1:
                    //-----------------------------------------------------------------------------------
                    if (Loan.hasLoan()) {
                        Ui.cls();
                        Ui.println("You can not deposit coins until you pay off your loan!");
                        Ui.pause();
                        break;
                    }
                    Ui.println("How much money would you like to deposit? (You will have to pay " + (interest * 100) + "% of this)");
                    Ui.println("You currently have " + Coins.get() + " coins.");
                    do {
                        amount = Ui.getValidInt();
                        if (amount > Coins.get()) {
                            Ui.println("You don't have enough coins. You only have " + Coins.get() + " coins.");
                            amount = -1;
                        }
                    } while (amount < 0);
                    if (amount == 0) return;

                    //Deposit
                    deposit(amount, interest);
                    //-----------------------------------------------------------------------------------
                    break;
                case 2:
                    //-----------------------------------------------------------------------------------
                    Ui.cls();

                    //Input
                    Ui.println("How much money would you like to withdraw?");
                    Ui.println("You currently have " + get() + " coins in your bank.");
                    do {
                        amount = Ui.getValidInt();
                        if (amount > get()) {
                            Ui.println("You don't have enough coins in your bank. You only have " + get() + " coins.");
                            amount = -1;
                        }
                    } while (amount < 0);

                    //Withdraw
                    withdraw(amount);
                    //-----------------------------------------------------------------------------------
                    break;
                case 3:
                    Loan.menu();
                    break;
                case 4:
                    return;
            }
        }
    }

    public static int get() {
        return balance;
    }

    public static void set(int amount, boolean add) {
        if (!add) {
            balance = amount;
        } else {
            balance += amount;
            if (balance < 0) balance = 0;
        }
    }

    public static void setInterest(double price) {
        interest = price;
    }

    private static void withdraw(int amount) {
        //Calculation
        Coins.set(amount, true);
        set(-amount, true);

        //Result
        Ui.cls();
        Ui.println("Amount withdrawn: " + amount);
        Ui.println("Current Balance: " + get());
        Ui.pause();
    }

    private static void deposit(int amount, double interest) {

        //Get interest
        interest = interest * amount;
        if (amount < 10) interest = 1;

        //Take coins from player
        Coins.set(-amount, true);

        //Take away interest amount
        amount -= Math.round(interest);
        Stats.totalCoinsSpent += Math.round(interest);
        Stats.coinsSpentOnBankInterest += Math.round(interest);

        //Add remaining coins to bank account
        set(amount, true);

        //Display
        Ui.cls();
        Ui.println("Amount Deposited: " + amount + " coins");
        Ui.println("Interest Paid: " + Math.round(interest) + " coins");
        Ui.println("Current Balance: " + get() + " coins");
        Ui.pause();
    }
}
