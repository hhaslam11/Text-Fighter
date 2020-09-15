package com.hotmail.kalebmarc.textfighter.casino;

import com.hotmail.kalebmarc.textfighter.main.Handle;
import com.hotmail.kalebmarc.textfighter.main.Random;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;

public class SlotsGame extends BasicCasinoGame{

    public SlotsGame() {
        super("------------------------------------------------------------------\n" +
                "                                Slots                             \n" +
                "------------------------------------------------------------------",
                "You will pick an amount of coins to bet. Then, 4 slots will spin, \n" +
                "each containing 5 possibilities. You'll win coins depending on how\n" +
                "much of the same item you spin.                                   \n" +
                        "\n" +
                "0 the same : Lose amount you bet                                  \n" +
                "2 the same : Lose amount you bet                                  \n" +
                "3 the same : Win 4 times the amount you bet                       \n" +
                "4 the same : Win 8 times the amount you bet                       ",
                "1) Let's play!                                                    \n" +
                "2) Back to casino menu                                            ",
                GameType.SLOTS);
    }

    @Override
    public int play(int selection) {
        int bet;
        int slot;
        int coinsWon = 0;
        String[] slots = {"", "", "", "", ""};
        int[] s = {0, 0, 0, 0, 0, 0};

        //Greetings/Input
        Ui.cls();
        Ui.println(getHeader());
        Ui.println();
        Ui.println("Coins: " + Coins.get());
        Ui.println();
        Ui.println("To begin, enter the amount of coins you would like to bet.. ");
        Ui.println("It must be between 10, and 250.");
        do {//Bet
            bet = Ui.getValidInt();
            if (bet == 0) return -1;
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
        Ui.println(getHeader());
        Ui.println("Your bet: " + bet);
        Ui.println();
        Ui.println("Rolled Slots: " + slots[1] + "  " + slots[2] + "  " + slots[3] + "  " + slots[4]);
        Ui.println();
        Ui.println("Coins Won: " + coinsWon);
        return coinsWon;
    }

    @Override
    protected int getExitEntry() {
        return 2;
    }
}
