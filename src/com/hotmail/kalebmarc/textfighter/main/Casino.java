package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.casino.DiceGame;
import com.hotmail.kalebmarc.textfighter.casino.SlotsGame;
import com.hotmail.kalebmarc.textfighter.player.Coins;

public class Casino {
    private static final DiceGame dice = new DiceGame();
    private static final SlotsGame slots = new SlotsGame();

    public static int totalCoinsWon = 0;
    public static int gamesPlayed = 0;

    private Casino() {
    }

    public static void menu() {

        while (true) {
            Ui.cls();
            Ui.println("------------------------------------------------------------------");
            Ui.println("                      WELCOME TO THE CASINO                       ");
            Ui.println();
            Ui.println("     Coins: " + Coins.get());
            Ui.println("------------------------------------------------------------------");
            Ui.println("1) Dice Game");
            Ui.println("2) Slots");
            Ui.println("3) Back");
            Ui.println("------------------------------------------------------------------");

            int menuChoice = Ui.getValidInt();

            switch (menuChoice) {
                case 1:
                    dice.start();
                    break;
                case 2:
                    slots.start();
                    break;
                case 3:
                    return;
                default:
                    break;
            }//Switch
        }//main loop
    }
}
