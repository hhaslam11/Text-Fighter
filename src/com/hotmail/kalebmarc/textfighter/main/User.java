package com.hotmail.kalebmarc.textfighter.main;

/**
 * TODO make more use of this class. Move settings/user prefs here maybe?
 */
public class User {

    private static String playerName = "Player";

    public static String name(){
        return playerName;
    }
    public static void setName(String name){
        playerName = name;
    }
    public static void promptNameSelection(){

        Action.cls();
        Ui.println("Please enter your username.");
        String name = Action.getValidString();

        //Validate
        name = name.trim();
        if(name.equals("")){
            Ui.println("Name cannot be blank. Using default name.");
            name = "Player";
        }

        playerName = name;

    }
}
