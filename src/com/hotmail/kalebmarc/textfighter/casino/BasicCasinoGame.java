package com.hotmail.kalebmarc.textfighter.casino;

import com.hotmail.kalebmarc.textfighter.main.Casino;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;

public abstract class BasicCasinoGame {
    private final String header;
    private final String description;
    private final String options; //Options are the menu options presented to the player
    protected final GameType gameType;

    protected BasicCasinoGame(String header, String description, String options, GameType gameType) {
        this.header = header;
        this.description = description;
        this.options = options;
        this.gameType = gameType;
    }

    /**
     * Subclasses implement this function to create the respective gameplay
     *
     * @param selection The selection made by the user during the menu screen (typically 1)
     * @return The amount of coins added to the player's inventory. Negative values result in doing nothing. This also includes not increasing the play count etc
     */
    public abstract int play(int selection);

    /**
     * Starts the game loop. Ui pauses automatically after each playthrough. The exit option is determined by the getExitEntry() method
     */
    public void start(){
        this.start(getExitEntry());
    }

    private void start(int exitOption){
        while (true) {
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

            int menuChoice = Ui.getValidInt();

            if (menuChoice < exitOption && menuChoice > 0) {
                int coinsWon = play(menuChoice); // Determines what to do after a played game
                if (coinsWon >= 0) {
                    Coins.set(coinsWon, true);
                    Casino.totalCoinsWon += coinsWon;
                    if (!gameType.equals(GameType.LOTTO))
                        Casino.gamesPlayed++; // Only increases stat for playable games

                    switch (gameType) { // Determines which stat to increase
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
                            if(coinsWon >= 1000)
                                Stats.lotteryWon++; // Lotteries only count as won, when the amount of won coins exceeds 100
                    }

                    Ui.pause();
                }
            } else if (menuChoice == exitOption) {
                return;
            }
        }
    }

    /**
     *  Used to determine the exit entry of the game menu. All options numerically below this one are
     *  given to the play function.
     * @return int The option the user has to pick in order to exit to the casino menu
     */
    protected abstract int getExitEntry();

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
