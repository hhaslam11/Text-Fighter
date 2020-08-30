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
     * Starts the game loop. Ui pauses automatically after each playthrough
     */
    public void start(){
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

            switch (menuChoice) {
                case 1:
                    int coinsWon = play(menuChoice); // Determines what to do after a played game
                    if(coinsWon >= 0){
                        Coins.set(coinsWon, true);
                        Casino.totalCoinsWon += coinsWon;
                        Casino.gamesPlayed++;

                        switch (gameType){ // Determines which stat to increase
                            case DICE:
                                Stats.diceGamesPlayed++;
                                break;
                            case SLOTS:
                                Stats.slotGamesPlayed++;
                                break;
                            case BLACKJACK:
                                Stats.blackjackGamesPlayed++;
                            case LOTTO:
                                Stats.lotteryTicketsBought++;
                        }

                        Ui.pause();
                    }
                    break;
                case 2:
                    return;
                default:
                    break;
            }
        }
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
