package com.hotmail.kalebmarc.textfighter.casino;

import com.hotmail.kalebmarc.textfighter.main.Casino;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;

public abstract class BasicCasinoGame {
    protected final GameType gameType;
    private final String header;
    private final String description;
    private final String options;

    protected BasicCasinoGame(String header, String description, String options, GameType gameType) {
        this.header = header;
        this.description = description;
        this.options = options;
        this.gameType = gameType;
    }

    public abstract int play(int selection);

    public void start() {
        while (true) {
            displayGameMenu();
            int menuChoice = Ui.getValidInt();

            if (isValidGameChoice(menuChoice)) {
                int coinsWon = play(menuChoice);
                if (coinsWon >= 0) {
                    processGameOutcome(coinsWon);
                }
            } else if (menuChoice == getExitEntry()) {
                return;
            }
        }
    }

    protected abstract int getExitEntry();

    private void displayGameMenu() {
        Ui.cls();
        Ui.println(header);
        Ui.println("     Coins: " + Coins.get());
        Ui.println("------------------------------------------------------------------");
        Ui.println("                           How to play                            ");
        Ui.println();
        Ui.println(description);
        Ui.println("------------------------------------------------------------------");
        Ui.println(options);
        Ui.println("------------------------------------------------------------------");
    }

    private boolean isValidGameChoice(int choice) {
        return choice > 0 && choice < getExitEntry();
    }

    private void processGameOutcome(int coinsWon) {
        Coins.set(coinsWon, true);
        Casino.totalCoinsWon += coinsWon;

        if (!gameType.equals(GameType.LOTTO)) {
            Casino.gamesPlayed++;
        }

        switch (gameType) {
            case DICE:
                Stats.diceGamesPlayed++;
                break;
            case SLOTS:
                Stats.slotGamesPlayed++;
                break;
            case BLACKJACK:
                Stats.blackjackGamesPlayed++;
                break;
            case LOTTO:
                if (coinsWon >= Coins.LOTTERY_THRESHOLD) {
                    Stats.lotteryWon++;
                }
                break;
        }

        Ui.pause();
    }

    public String getDescription() {
        return description;
    }

    public String getHeader() {
        return header;
    }

    public String getOptions() {
        return options;
    }
}
