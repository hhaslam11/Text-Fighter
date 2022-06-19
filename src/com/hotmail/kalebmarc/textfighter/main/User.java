package com.hotmail.kalebmarc.textfighter.main;

/**
 * TODO make more use of this class. Move settings/user prefs here maybe?
 */
public class User {

    private static String playerName = "Player";
    //field to indicate if player is the program default player (-1) or a user selected player
    private static int playerDefault = -1;

    public static String name() {
        return playerName;
    }

    public static int getPlayerDefault() {
        return playerDefault;
    }

    public static void setName(String name) {
        playerName = name;
        playerDefault = 1;
    }

    public static void promptNameSelection() {
        Ui.cls();
        Ui.println("Please enter your username.");
        String name = Ui.getValidString();

        //Validate
        name = name.trim();
        if (name.equals("")) {
            Ui.println("Name cannot be blank.");
            promptNameSelection();
        }

        playerName = name;
        playerDefault = 1;

    }
}
