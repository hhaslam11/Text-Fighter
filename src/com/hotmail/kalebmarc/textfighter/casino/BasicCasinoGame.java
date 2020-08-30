package com.hotmail.kalebmarc.textfighter.casino;

public abstract class BasicCasinoGame {
    protected String description, header, options;

    /**
     * Subclasses implement this function to create the respective gameplay
     *
     * @param selection The selection made by the user during the menu screen (typically 1)
     * @return The amount of coins added to the player's inventory. Negative values result in doing nothing. This also includes not increasing the play count etc
     */
    public abstract int play(int selection);

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
