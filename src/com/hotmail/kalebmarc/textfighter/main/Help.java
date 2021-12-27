package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.farm.Crop;
import com.hotmail.kalebmarc.textfighter.farm.Farm;
import com.hotmail.kalebmarc.textfighter.farm.Seed;
import com.hotmail.kalebmarc.textfighter.item.Armour;

class Help {
    private Help() {
    }

    // TODO Add property
    public static void view() {
        while (true) {
            Ui.cls();
            Ui.println("------------------------------------------------------------");
            Ui.println("                         HELP MENU                          ");
            Ui.println("Here you can find (almost) all the information you need to");
            Ui.println("know about Text-Fighter.");
            Ui.println("------------------------------------------------------------");
            Ui.println("1) Enemy");
            Ui.println("2) Armour");
            Ui.println("3) Weapon");
            Ui.println("4) Health");
            Ui.println("5) Food");
            Ui.println("6) Property");
            Ui.println("7) Seeds");
            Ui.println("8) Crops");
            Ui.println("9) XP");
            Ui.println("10) Cheats");
            Ui.println("11) Achievements");
            Ui.println("12) Back");
            Ui.println("------------------------------------------------------------");
            switch (Ui.getValidInt()) {
                case 1:
                    info_enemy();
                    break;
                case 2:
                    info_armour();
                    break;
                case 3:
                    info_weapons();
                    break;
                case 4:
                    info_health();
                    break;
                case 5:
                    info_food();
                    break;
                case 6:
                    info_property();
                    break;
                case 7:
                    info_seeds();
                    break;
                case 8:
                    info_crops();
                    break;
                case 9:
                    info_xp();
                    break;
                case 10:
                    info_cheats();
                    break;
                case 11:
                    info_achs();
                    break;
                case 12:
                    return;
                default:
                    break;
            }
        }
    }

    private static void info_enemy() {
        while (true) {
            Ui.cls();
            Ui.println("------------------------------------------------------------");
            Ui.println("                         ENEMY INFO                         ");
            Ui.println("Which enemy would you like to know about?");
            Ui.println();
            for (int i = 0; i < Enemy.getEnemies().size(); i++) {
                Ui.println((i + 1) + ") " + Enemy.getEnemies().get(i).getName());
            }
            Ui.println((Enemy.getEnemies().size() + 1) + ") Back");
            Ui.println("------------------------------------------------------------");

            int menuItem = Ui.getValidInt();

            try {
                Enemy.getEnemies().get(menuItem - 1).viewAbout();
            } catch (Exception e) {
                if (menuItem == (Enemy.getEnemies().size() + 1)) return;
                Ui.println(menuItem + " is not an option.");
                Ui.pause();
            }
        }
    }

    private static void info_armour() {
        //Start of armour info
        while (true) {
            Ui.cls();
            Ui.println("--------------------------------------------------");
            Ui.println("                    ARMOUR INFO                   ");
            Ui.println("Which armour type would you like to know about?");
            Ui.println();
            for (int i = 0; i < Armour.getArmours().size(); i++) {
                Ui.println((i + 1) + ") " + Armour.getArmours().get(i).getName());
            }
            Ui.println((Armour.getArmours().size() + 1) + ") Back");
            Ui.println("--------------------------------------------------");

            int menuItem = Ui.getValidInt();

            try {
                Armour.getArmours().get(menuItem - 1).viewAbout();
            } catch (Exception e) {
                if (menuItem == (Armour.getArmours().size() + 1)) return;
                Ui.println(menuItem + " is not an option.");
                Ui.pause();
            }
        }
        //End of armour info
    }

    private static void info_weapons() {
        while (true) {
            Ui.cls();
            Ui.println("------------------------------------------------------------");
            Ui.println("                         WEAPON INFO                        ");
            Ui.println("Which weapon would you like to know about?");
            Ui.println();
            for (int i = 0; i < Weapon.getWeapons().size(); i++) {
                Ui.println((i + 1) + ") " + Weapon.getWeapons().get(i).getName());
            }
            Ui.println((Weapon.getWeapons().size() + 1) + ") Back");
            Ui.println("------------------------------------------------------------");

            int menuItem = Ui.getValidInt();

            try {
                Weapon.getWeapons().get(menuItem - 1).viewAbout();
            } catch (Exception e) {
                if (menuItem == (Weapon.getWeapons().size() + 1)) return;
                Ui.println(menuItem + " is not an option.");
                Ui.pause();
            }
        }
    }

    private static void info_health() {
        Ui.cls();
        Ui.println("------------------------------------------------------------");
        Ui.println("                        HEALTH INFO                         ");
        Ui.println("You will start off with 100 health, and you can upgrade your");
        Ui.println("health up to 200. Each upgrade will cost 100 coins on easy, ");
        Ui.println("and 150 coins on hard; and it will upgrade your health by 10.");
        Ui.println("You will be able to upgrade once per level.");
        Ui.println("Health deteriorates by fighting enemies.");
        Ui.println("If your health reaches 0, you'll die and you will lose coins.");
        Ui.println("The goal is to eliminate an enemy by reducing his health to 0.");
        Ui.println("If an enemies health is 0 they will die.");
        Ui.println("You'll receive XP points and gain coins if you kill an enemy.");
        Ui.println("Potions are used to increase your health.");
        Ui.println("You start the game with 2 Recovery and 2 Survival Potions.");
        Ui.println("A Recovery Potion increases your health by 25%.");
        Ui.println("A Survival Potion increases your health by 75%.");
        Ui.println("You can purchase more potions at the shop once you've ");
        Ui.println("completed level 2.");
        Ui.println("First Aid Kits are used to increase your health.");
        Ui.println("You start the game with 3 First Aid Kits.");
        Ui.println("A First Aid Kit increases your health by 20 health points.");
        Ui.println("You can purchase more First Aid Kits at the shop.");
        Ui.println("Food is given to you at the beginning of the game.");
        Ui.println("You can eat food to increase your health.");
        Ui.println("If you eat all the food you cannot purchase more at the shop.");
        Ui.println("InstaHealth can also restore your health.");
        Ui.println("If you use an InstaHealth your health will fully recover.");
        Ui.println("InstaHealth can be purchased at the shops after you have ");
        Ui.println("reached level 3.");
        Ui.println("The prices of the items you can purchase at the shop are ");
        Ui.println("determined by which difficulty you are playing on.");
        Ui.println("------------------------------------------------------------");
        Ui.pause();
    }

    private static void info_food() {
        while (true) {
            Ui.cls();
            Ui.println("------------------------------------------------------------");
            Ui.println("                          FOOD INFO                         ");
            Ui.println("Which food would you like to know about?");
            Ui.println();
            for (int i = 0; i < Food.getFoods().size(); i++) {
                Ui.println((i + 1) + ") " + Food.getFoods().get(i).getName());
            }
            Ui.println((Food.getFoods().size() + 1) + ") Back");
            Ui.println("------------------------------------------------------------");

            int menuItem = Ui.getValidInt();

            try {
                Food.getFoods().get(menuItem - 1).viewAbout();
            } catch (Exception e) {
                if (menuItem == (Food.getFoods().size() + 1)) return;
                Ui.println(menuItem + " is not an option.");
                Ui.pause();
            }
        }
    }

    private static void info_property() {
        while (true) {
            int size = Farm.getFarms().size();

            Ui.cls();
            Ui.printhr();
            Ui.println(Ui.getCentred("PROPERTY INFO"));
            Ui.println("Which property would you like to know about?");
            Ui.println();
            Ui.println("Farms:");
            for (int i = 0; i < size; i++) {
                Ui.println(i + 1 + ") " + Farm.getFarms().get(i).getName());
            }
            Ui.println();
            Ui.println((size + 1) + ") Back");

            int menuItem = Ui.getValidInt();

            if (menuItem == size + 1) {
                return;
            }

            if (menuItem <= size) {
                Farm.getFarms().get(menuItem - 1).viewAbout();
            } else {
                Ui.println();
                Ui.println(menuItem + " is not an option.");
                Ui.cls();
                Ui.pause();
            }
        }
    }

    private static void info_seeds() {
        while (true) {
            int size = Seed.getSeeds().size();

            Ui.cls();
            Ui.printhr();
            Ui.println(Ui.getCentred("SEED INFO"));
            Ui.println("Which seed would you like to know about?");
            Ui.println();
            Ui.println("Seeds:");
            for (int i = 0; i < size; i++) {
                Ui.println(i + 1 + ") " + Seed.getSeeds().get(i).getName());
            }
            Ui.println();
            Ui.println((size + 1) + ") Back");

            int menuItem = Ui.getValidInt();

            if (menuItem == size + 1) {
                return;
            }

            if (menuItem <= size) {
                Seed.getSeeds().get(menuItem - 1).viewAbout();
            } else {
                Ui.println();
                Ui.println(menuItem + " is not an option.");
                Ui.cls();
                Ui.pause();
            }
        }
    }

    private static void info_crops() {
        while (true) {
            int size = Crop.getCrops().size();

            Ui.cls();
            Ui.printhr();
            Ui.println(Ui.getCentred("CROP INFO"));
            Ui.println("Which crop would you like to know about?");
            Ui.println();
            Ui.println("Crops:");
            for (int i = 0; i < size; i++) {
                Ui.println(i + 1 + ") " + Crop.getCrops().get(i).getName());
            }
            Ui.println();
            Ui.println((size + 1) + ") Back");

            int menuItem = Ui.getValidInt();

            if (menuItem == size + 1) {
                return;
            }

            if (menuItem <= size) {
                Crop.getCrops().get(menuItem - 1).viewAbout();
            } else {
                Ui.println();
                Ui.println(menuItem + " is not an option.");
                Ui.cls();
                Ui.pause();
            }
        }
    }



    private static void info_xp() {
        Ui.cls();
        Ui.println("------------------------------------------------------------");
        Ui.println("                              XP                            ");
        Ui.println("Getting XP levels you up, which unlocks more items to buy.  ");
        Ui.println("You start on level one, and you can get up to level 100.    ");
        Ui.println("You need more and more XP for each level. You start needing ");
        Ui.println("only 500 XP to reach level two, then each level you need 500");
        Ui.println("more. So you need 1000 for level 3, 1500 for level 4, etc.  ");
        Ui.println("Each time you level up, your XP gets reset back to 0. You   ");
        Ui.println("get an achievement for each level you reach up to level 10. ");
        Ui.println("You will also receive 100 coins (or 250 coins when you get  ");
        Ui.println("to level 10) Although you can get up to level 100, once you ");
        Ui.println("get to level 10, there's nothing else to unlock.");
        Ui.println();
        Ui.println("How to get XP..");
        Ui.println("There's a few different ways that you can get XP. The main   ");
        Ui.println("way you get XP is by fighting enemies. For every point of   ");
        Ui.println("damage you deal to an enemy, you get 1 XP. Another way is by");
        Ui.println("buying it. You can buy 1 XP for 1 coin. (You can buy as much");
        Ui.println("as you like/as much as you can afford). You will also get   ");
        Ui.println("100 XP for each achievement you unlock. Using a POWER will  ");
        Ui.println("give you 20 XP");
        Ui.println("------------------------------------------------------------");
        Ui.pause();
    }

    private static void info_cheats() {
        Ui.cls();
        Ui.println("------------------------------------------------------------------------");
        Ui.println("                            CHEATS                          ");
        Ui.println("To use a cheat code, make sure to be in the main game menu, ");
        Ui.println("then enter '0'. A star (*) should appear to indicate that   ");
        Ui.println("you can type in a cheat code.                               ");
        Ui.println("WARNING: Using cheats will disable all achievements and the ");
        Ui.println("XP system.                                                  ");
        Ui.println("*Tip: You can lock cheats off in the settings menu to       ");
        Ui.println("      prevent the use of cheats                             ");
        Ui.println();
        Ui.println("List of cheat codes:");
        Ui.println("   Code             | Description");
        Ui.println("                    |            ");
        Ui.println("   moneylover       | Gives you 1000 coins");
        Ui.println("   givemeitall      | Gives you 5000 of every item + all weapons");
        Ui.println("   weaponstash      | Gives you every weapon, and 5000 ammo");
        Ui.println("   nomorepain       | Gives you a bunch of healing supplies");
        Ui.println("   healme           | Sets your health to 100");
        Ui.println("   givemeachallenge | Gives enemy 1000 health");
        Ui.println("   lotsofkills      | Sets kill-streak to 5000");
        Ui.println("   suicide          | Kills you");
        Ui.println("   godmode          | Never dies");
        Ui.println("   loanshark        | Removes current loan");
        Ui.println("   thirstforfood    | Gives you 10 of each type of food");
        Ui.println("------------------------------------------------------------------------");
        Ui.pause();
    }

    private static void info_achs() {
        Ui.cls();
        Ui.println("-------------------------------------------------------------------------");
        Ui.println("                         ACHIEVEMENTS                       ");
        Ui.println("You are rewarded 100 xp for each achievement you get. ");
        Ui.println("If you get all achievements, you will be rewarded with 2500 ");
        Ui.println("coins.");
        Ui.println("");
        Ui.println("List of achievements: ");
        Ui.println("   Achievement            | Description");
        Ui.println("                          | ");
        Ui.println("   Money Maker            | Get 1500 coins");
        Ui.println("   Enemy Slayer           | Kill a total of 100 enemies");
        Ui.println("   First Kill             | Kill one enemy");
        Ui.println("   Time For An Upgrade    | Buy any weapon from the shop");
        for (int i = 0; i < Enemy.getEnemies().size(); i++) {
            Ui.print("   Goodbye, " + Enemy.getEnemies().get(i).getName());
            for (int x = 0; x < (14 - Enemy.getEnemies().get(i).getName().length()); x++) Ui.print(" ");
            Ui.println("| Kill a " + Enemy.getEnemies().get(i).getName());

        }
        Ui.println("   Text-Fighter Master    | Get all other achievements");
        Ui.println("   Yay, POWER!            | Use 5 POWERS");
        Ui.println("   Slayer                 | Deal a total of 1000 damage");
        Ui.println("   Nobody's Perfect       | Die");
        Ui.println("   Making Money           | Win 1000 coins altogether in the Casino");
        Ui.println("   Gambling Addiction     | Complete 75 rounds in the Casino");
        Ui.println("   Level 2 Fighter        | Reach level 2");
        Ui.println("   Level 3 Fighter        | Reach level 3");
        Ui.println("   Level 4 Fighter        | Reach level 4");
        Ui.println("   Level 5 Fighter        | Reach level 5");
        Ui.println("   Level 6 Fighter        | Reach level 6");
        Ui.println("   Level 7 Fighter        | Reach level 7");
        Ui.println("   Level 8 Fighter        | Reach level 8");
        Ui.println("   Level 9 Fighter        | Reach level 9");
        Ui.println("   Level 10 Fighter       | Reach level 10");
        Ui.println("   Honest Player          | Lock cheats off");
        Ui.println("   Learning               | Look at every single help page in one session");
        Ui.println("-------------------------------------------------------------------------");
        Ui.pause();
    }
}