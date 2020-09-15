package com.hotmail.kalebmarc.textfighter.casino;

import com.hotmail.kalebmarc.textfighter.main.Handle;
import com.hotmail.kalebmarc.textfighter.main.Random;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;

public class DiceGame extends BasicCasinoGame{

    public DiceGame() {
        super("------------------------------------------------------------------\n" +
                "                                Dice Game                            \n" +
                "------------------------------------------------------------------",
                "You will pick two numbers between 1, and 6.\n" +
                "Two dice will be rolled. If one of the dice matches one of your   \n" +
                "numbers, you will win double the coins you bet. If both dice      \n" +
                "matches both of your numbers, you will win 5 times the amount     \n" +
                "of coins you bet. If none of the dice matches either of your      \n" +
                "numbers, then you lose all your coins that you have bet.          ",
                "1) Let's play!                                                    \n" +
                "2) Back to casino menu                                            ",
                GameType.DICE);
    }

    @Override
    public int play(int selection) {
        int bet;
        int firstNumber;
        int secondNumber;
        int dice1;
        int dice2;
        int coinsWon = 0;

        //Greeting & Input
        Ui.cls();
        Ui.println(getHeader());
        Ui.println();
        Ui.println("Coins: " + Coins.get());
        Ui.println();
        Ui.println("To begin, enter the amount of coins you would like to bet.. ");
        Ui.println("It must be between 10, and 250.");
        Ui.println("Enter 0 to go back");
        do {//Bet
            bet = Ui.getValidInt();
            if (bet == 0) return -1;
            if (bet > Coins.get()) {
                Ui.cls();
                bet = 0;
                Ui.println("You do not have enough coins. Please enter a smaller amount. (Or enter 0 to go back)");

            }
        } while (bet < 10 || bet > 250);

        Coins.set(-bet, true);

        do {//First Number
            Ui.cls();
            Ui.println(getHeader());
            Ui.println();
            Ui.println("Now, pick your first number.");
            Ui.println("It must be between 1, and 6.");
            firstNumber = Ui.getValidInt();
        } while (firstNumber < 1 || firstNumber > 6);
        do {//Second Number
            Ui.cls();
            Ui.println(getHeader());
            Ui.println();
            Ui.println("Finally, pick your second number.");
            Ui.println("It must be between 1, and 6.");
            secondNumber = Ui.getValidInt();
        } while (secondNumber < 1 || secondNumber > 6);

        //Rolling Dice
        Ui.cls();
        Ui.println("Rolling the two dice...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Handle.error(e.toString());
        }
        dice1 = Random.RInt(6);
        dice2 = Random.RInt(6);
        Ui.println("Results are ready! Press enter to continue.");
        Ui.pause();

        //Results
        boolean fNum = false, sNum = false;
        if (firstNumber == dice1 || firstNumber == dice2) fNum = true;
        if (secondNumber == dice1 || secondNumber == dice2) sNum = true;
        if (fNum ^ sNum) coinsWon = bet * 2;
        if (fNum && sNum) coinsWon = bet * 5;
        Ui.cls();
        Ui.println(getHeader());
        Ui.println("Your bet: " + bet);
        Ui.println("First number: " + firstNumber);
        Ui.println("Second Number: " + secondNumber);
        Ui.println();
        Ui.println("Dice 1: " + dice1);
        Ui.println("Dice 2: " + dice2);
        Ui.println();
        Ui.println("Coins Won: " + coinsWon);
        return coinsWon;
    }

    @Override
    protected int getExitEntry() {
        return 2;
    }
}
