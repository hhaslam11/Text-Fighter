package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Xp;

import static sun.audio.AudioPlayer.player;

public class Loan {

    private static final double INTEREST_RATE = 0.15;
    private static int currentLoan;
    private static int netDue;

    public static void menu() {
        while (true) {
            Ui.cls();
            Ui.println("-------------------------------");
            Ui.println("          PLAYER LOAN          ");
            Ui.println();
            Ui.println("Current interest rate: " + INTEREST_RATE);
            Ui.println("Max loan amount: " + getMaxLoan());
            Ui.println("Current loan: " + currentLoan);
            Ui.println("-------------------------------");
            Ui.println("Net due: " + netDue);
            Ui.println("Interest due: " + (netDue * INTEREST_RATE));
            Ui.println("Gross due: " + getGrossDue());
            Ui.println("-------------------------------");
            Ui.println("1) Get loan");
            Ui.println("2) Pay off loan");
            Ui.println("3) Back");
            switch (Ui.getValidInt()) {
                case 1:
                    createLoan();
                    break;
                case 2:
                    payLoan();
                    break;
                case 3:
                    return;
            }
        }
    }

    private static void createLoan() {

        if (hasLoan()) {
            Ui.cls();
            Ui.println("You can not request a loan while you already have one.");
            Ui.pause();
            return;
        }

        Ui.cls();
        Ui.println("Enter the amount you would like");
        Ui.println("to borrow.");
        Ui.println("Your max amount allowed is " + getMaxLoan());
        int request = Ui.getValidInt();

        Ui.cls();

        if (request > getMaxLoan()) {
            Ui.println("Your max amount you can borrow is " + getMaxLoan() + "!");
            Ui.pause();
            return;
        }
        if (request <= 0) {
            Ui.println("You must enter at least 1 coin.");
            Ui.pause();
            return;
        }

        //Give loan
        Coins.set(request, true);
        currentLoan = request;
        netDue = request;
        Ui.cls();
        Ui.println("You have borrowed " + request + " from the bank.");
        Ui.println("You will not be able to deposit coins into the bank until your loan is fully paid off.");
        Ui.pause();
    }

    private static void payLoan() {
        if (getGrossDue() == 0) {
            Ui.println("You must enter at least 1 coin.");
            Ui.pause();
            return;
        }

        Ui.cls();
        Ui.println("You currently owe " + getGrossDue() + " coins, and have " + Coins.get() + " with you.");
        Ui.println("You will not be able to deposit coins into the bank until your loan is fully paid off.");
        Ui.println("How much would you like to pay off?");
        int amountToPay = Ui.getValidInt();

        Ui.cls();
        if (Coins.get() < amountToPay) {
            Ui.println("You don't have enough coins.");
            Ui.pause();
            return;
        }

        if (amountToPay <= 0) {
            Ui.println("You must enter at least 1 coin.");
            Ui.pause();
            return;
        }

        if (amountToPay > getGrossDue()) {
            Ui.println("You only owe " + getGrossDue() + "! Enter a small amount");
            Ui.pause();
        }
        netDue = getGrossDue() - amountToPay;
        Coins.set(-amountToPay, true);

        Ui.println("You have paid back " + amountToPay + " coins.\nYou now have " + getGrossDue() + " left to pay.");
        if (getGrossDue() == 0) currentLoan = 0;
        Ui.pause();
    }

    private static int getMaxLoan() {
        return Xp.getLevel() * 100;
    }

    public static int getCurrentLoan() {
        return currentLoan;
    }

    public static void setCurrentLoan(int loan) {
        currentLoan = loan;
    }

    public static boolean hasLoan() {
        return getCurrentLoan() > 0;
    }

    public static int getGrossDue() {
        return (int) (netDue + (netDue * INTEREST_RATE));
    }

    public static int getNetDue() {
        return netDue;
    }

    public static void setNetDue(int due) {
        netDue = due;
    }
}
