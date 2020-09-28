package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.casino.BlackjackGame;
import com.hotmail.kalebmarc.textfighter.casino.DiceGame;
import com.hotmail.kalebmarc.textfighter.casino.LotteryGame;
import com.hotmail.kalebmarc.textfighter.casino.SlotsGame;
import com.hotmail.kalebmarc.textfighter.player.Coins;

public class Casino {
    public static final DiceGame DICE = new DiceGame();
    public static final SlotsGame SLOTS = new SlotsGame();
    public static final LotteryGame LOTTERY = new LotteryGame();
    public static final BlackjackGame BLACKJACK = new BlackjackGame();

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
            Ui.println("3) Blackjack");
            Ui.println("4) Lottery");
            Ui.println("5) Back");
            Ui.println("------------------------------------------------------------------");

            int menuChoice = Ui.getValidInt();

            switch (menuChoice) {
                case 1:
                    DICE.start();
                    break;
                case 2:
                    SLOTS.start();
                    break;
                case 3:
                    BLACKJACK.start();
                    break;
                case 4:
                    LOTTERY.start();
                    break;
                case 5:
                    return;
                default:
                    break;
            }//Switch
        }//main loop
    }
}
