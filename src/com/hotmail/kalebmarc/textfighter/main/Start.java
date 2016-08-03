package com.hotmail.kalebmarc.textfighter.main;

class Start {

    public static void main(String args[]) {

        if (args.length != 0 && args[0].equalsIgnoreCase("nogui")) Ui.guiEnabled = false;
        Ui.println("Loading..");

        //Check if current version is a developer version, if so, enable debug menu
        if (Version.get().contains("DEV")) {
            Debug.enable();
        }

        //Displays splash screen for a moment
        Splash.screen();

        //Runs the game
        Menu.load();

        //Clears Console
        Ui.cls();

    }
}

/*
 *
 * To create new enemies:
 *    First, create enemy object at the top of the com.hotmail.kalebmarc.textfighter.Game class.
 *    Change the properties in the com.hotmail.kalebmarc.player.Settings class, in the setConstants method.
 *    Remember to set both easy, and hard properties. Formatting information is given
 *    above all the enemy initializations in setConstants. To edit existing properties,
 *    simply change the values in the same setConstants method. This should automatically
 *    create everything needed; including achievements, and a help section for that enemy.
 *
 * To create new weapons:
 *    Pretty much the same as creating a new enemy. Create the object at the top of the
 *    com.hotmail.kalebmarc.textfighter.Game class. Change the properties in the com.hotmail.kalebmarc.player.Settings class. There's
 *    two different formatting options for the parameters. One for melee, one for a gun.
 *    More information is given in the com.hotmail.kalebmarc.player.Settings class above the section with the rest
 *    of the weapon initializations. Make sure to add both easy, and hard difficulty inits.
 *    You can change pre-existing weapon properties without causing any problems.
 *
 */