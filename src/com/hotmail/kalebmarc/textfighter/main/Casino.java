package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.casino.DiceGame;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;

public class Casino {
    private static final DiceGame dice = new DiceGame();
    private static final String SLOT_HEADER = "------------------------------------------------------------------\n" +
            "                                Slots                             \n" +
            "------------------------------------------------------------------";
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
                    slots();
                    break;
                case 3:
                    return;
                default:
                    break;
            }//Switch
        }//main loop
    }

    private static void slots() {
        while (true) {

            Ui.cls();

            Ui.println(SLOT_HEADER);
            Ui.println("     Coins: " + Coins.get());
            Ui.println("------------------------------------------------------------------");
            Ui.println("                           How to play                            ");
            Ui.println();
            Ui.println("You will pick an amount of coins to bet. Then, 4 slots will spin, ");
            Ui.println("each containing 5 possibilities. You'll win coins depending on how");
            Ui.println("much of the same item you spin.                                   ");
            Ui.println();
            Ui.println("0 the same : Lose amount you bet                                  ");
            Ui.println("2 the same : Lose amount you bet                                  ");
            Ui.println("3 the same : Win 4 times the amount you bet                       ");
            Ui.println("4 the same : Win 8 times the amount you bet                       ");
            Ui.println("------------------------------------------------------------------");
            Ui.println("1) Let's play!                                                    ");
            Ui.println("2) Back to casino menu                                            ");
            Ui.println("------------------------------------------------------------------");

            int menuChoice = Ui.getValidInt();

            switch (menuChoice) {
                case 1:
                    slotsPlay();
                    break;
                case 2:
                    return;
                default:
                    break;
            }//Switch
        }//While
    }

    private static void slotsPlay() {

        int bet;
        int slot;
        int coinsWon = 0;
        String[] slots = {"", "", "", "", ""};
        int[] s = {0, 0, 0, 0, 0, 0};

        //Greetings/Input
        Ui.cls();
        Ui.println(SLOT_HEADER);
        Ui.println();
        Ui.println("Coins: " + Coins.get());
        Ui.println();
        Ui.println("To begin, enter the amount of coins you would like to bet.. ");
        Ui.println("It must be between 10, and 250.");
        do {//Bet
            bet = Ui.getValidInt();
            if (bet == 0) return;
            if (bet > Coins.get()) {
                bet = 0;
                Ui.msg("You do not have enough coins. Please enter a smaller amount, or type 0 to go back.");
            }
        } while (bet < 10 || bet > 250);
        Coins.set(-bet, true);

        //Rolling slots
        //slot1
        slot = Random.RInt(5);
        if (slot == 1) slots[1] = "$";
        if (slot == 2) slots[1] = "%";
        if (slot == 3) slots[1] = "&";
        if (slot == 4) slots[1] = "*";
        if (slot == 5) slots[1] = "@";
        //slot2
        slot = Random.RInt(5);
        if (slot == 1) slots[2] = "$";
        if (slot == 2) slots[2] = "%";
        if (slot == 3) slots[2] = "&";
        if (slot == 4) slots[2] = "*";
        if (slot == 5) slots[2] = "@";
        //slot3
        slot = Random.RInt(5);
        if (slot == 1) slots[3] = "$";
        if (slot == 2) slots[3] = "%";
        if (slot == 3) slots[3] = "&";
        if (slot == 4) slots[3] = "*";
        if (slot == 5) slots[3] = "@";
        //slot4
        slot = Random.RInt(5);
        if (slot == 1) slots[4] = "$";
        if (slot == 2) slots[4] = "%";
        if (slot == 3) slots[4] = "&";
        if (slot == 4) slots[4] = "*";
        if (slot == 5) slots[4] = "@";

        //Result
        Ui.cls();
        Ui.println("Spinning slots...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Handle.error(e.toString());
        }

        for (int i = 1; i < 5; i++) {
            if (slots[i].equals("$")) s[1]++;
            if (slots[i].equals("%")) s[2]++;
            if (slots[i].equals("&")) s[3]++;
            if (slots[i].equals("*")) s[4]++;
            if (slots[i].equals("@")) s[5]++;
        }
        for (int i = 1; i < 5; i++) {
            if (s[i] == 3) coinsWon = bet * 4;
        }
        for (int i = 1; i < 5; i++) {
            if (s[i] == 4) coinsWon = bet * 8;
        }
        Ui.println("Results Ready! Press enter to continue.");
        Ui.pause();
        Ui.println(SLOT_HEADER);
        Ui.println("Your bet: " + bet);
        Ui.println();
        Ui.println("Rolled Slots: " + slots[1] + "  " + slots[2] + "  " + slots[3] + "  " + slots[4]);
        Ui.println();
        Ui.println("Coins Won: " + coinsWon);
        Coins.set(coinsWon, true);
        totalCoinsWon += coinsWon;
        gamesPlayed++;
        Stats.slotGamesPlayed++;
        Ui.pause();
    }
}
