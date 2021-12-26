package com.hotmail.kalebmarc.textfighter.player;

import com.hotmail.kalebmarc.textfighter.farm.Farm;
import com.hotmail.kalebmarc.textfighter.farm.Seed;
import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.main.*;

public class Settings {

    public static boolean difLocked = false;
    private static String difficulty;
    private static boolean godMode = false;

    private Settings() {
    }

    public static void menu() {
        while (true) {

            Ui.cls();
            Ui.println("-------------------------------------------------");
            Ui.println("                  Settings                  ");
            Ui.println();
            Ui.println("1) Switch Difficulties (Currently on " + difficulty + ".)");
            Ui.println("2) Lock Difficulty on " + difficulty);
            Ui.println("3) Lock cheats off (Wont be able to use cheats)");
            Ui.println("4) Toggle popup windows");//TODO State whether enabled or not
            Ui.println("5) Back");
            Ui.println("-------------------------------------------------");

            switch (Ui.getValidInt()) {
                case 1:
                    switchDif();
                    break;
                case 2:
                    lockDif();
                    break;
                case 3:
                    lockCheats();
                    break;
                case 4:
                    if (Ui.guiEnabled) {
                        Ui.guiEnabled = false;
                        Ui.msg("Popup windows disabled");
                    } else {
                        Ui.guiEnabled = true;
                        Ui.msg("Popup windows enabled");
                    }
                    break;
                case 5:
                    return;
            }
        }
    }

    public static void setDif(String dif, boolean firstInit, boolean switchDif) {
        difficulty = dif;
        setConstants(dif, firstInit, switchDif);
    }

    private static void switchDif() {
        /*
         * Make sure difficulty isn't locked
		 */
        if (difLocked) {
            Ui.msg("Difficulty is locked. You cannot switch difficulties.");
            return;
        }

        if (difficulty.equals("Easy")) {
            setDif("Hard", false, true);
        } else {
            setDif("Easy", false, true);
        }
    }

    private static void lockDif() {
        /*
		 * Make sure difficulty isn't already locked
		 */
        if (difLocked) {
            Ui.msg("Difficulty is already locked.");
            return;
        }

        while (true) {
            Ui.cls();
            Ui.println("Are you sure you want to lock the difficulty to " + difficulty + " ?\n"
                    + "You wont be able to change difficulties in the future!");
            Ui.println("1) Continue");
            Ui.println("2) Cancel");
            switch (Ui.getValidInt()) {
                case 1:
                    Ui.msg("Difficulty has been locked to " + difficulty);
                    difLocked = true;
                    return;
                case 2:
                    return;
            }
        }
    }

    private static void lockCheats() {
        /*
		 * Make sure cheats aren't already locked
		 */
        if (Cheats.locked()) {
            Ui.msg("Cheats are already locked.");
            return;
        }

		/*
		 * Makes sure cheats aren't already enabled
		 */
        if (Cheats.enabled()) {
            Ui.msg("Cheats are already enabled. You cannot turn them off.");
            return;
        }

        while (true) {
            Ui.cls();
            Ui.println("Are you sure you want to lock cheats off?");
            Ui.println("You wont be able to use cheats in the future!");
            Ui.println("1) Continue");
            Ui.println("2) Cancel");
            switch (Ui.getValidInt()) {
                case 1:
                    Ui.msg("Cheats have been locked off");
                    Cheats.lock();
                    return;
                case 2:
                    return;
            }
        }
    }

    public static String getDif() {
        return difficulty;
    }

    private static void setConstants(String dif, boolean firstInit, boolean changeDif) {
        if (dif.equals("Easy")) {//Sets variables for EASY mode

            //Enemies (Name, health, coindropmin, coindropmax, damagemin, damagemax, xp, levelMin, levelMax, firstinit, changeDif)
            Game.darkElf = new Enemy("Dark Elf", 45, 10, 15, 10, 15, 15, 1, 100, firstInit, changeDif);
            Game.ninja = new Enemy("Ninja", 75, 5, 15, 5, 15, 15, 1, 100, firstInit, changeDif);
            Game.giantSpider = new Enemy("Giant Spider", 35, 5, 10, 5, 10, 10, 1, 100, firstInit, changeDif);
            Game.zombie = new Enemy("Zombie", 20, 5, 15, 5, 15, 15, 1, 100, firstInit, changeDif);
            Game.goblin = new Enemy("Goblin", 60, 10, 20, 10, 20, 20, 1, 100, firstInit, changeDif);
            Game.ghost = new Enemy("Ghost", 85, 15, 25, 15, 25, 25, 1, 100, firstInit, changeDif);
            Game.barbarian = new Enemy("Barbarian", 50, 5, 15, 5, 15, 15, 1, 100, firstInit, changeDif);
            Game.giantAnt = new Enemy("Giant Ant", 30, 5, 10, 5, 10, 10, 1, 100, firstInit, changeDif);
            Game.evilUnicorn = new Enemy("Evil Unicorn", 35, 30, 40, 5, 15, 20, 1, 100, firstInit, changeDif);
            Game.ogre = new Enemy("Ogre", 90, 20, 50, 10, 30, 50, 1, 100, firstInit, changeDif);

            /*Weapons
            * Gun:   (name, ammoUsed, ammoIncludedWithPurchase, buyable, price, ammoPrice, level, chanceOfMissing, critChanceMultiplier,
            *        critDamMultiplierMin, critDamMultiplierMax firstInit, changeDif)
            * Melee: (name, startingWeapon, buyable, price, level, damageMin, damageMax, firstInit, changeDif)
            */

            //Melee:
            Game.fists = new Weapon("Fists", true, false, 0, 0, 5, 10, firstInit, changeDif);
            Game.baseballBat = new Weapon("Baseball Bat", false, true, 120, 1, 10, 15, firstInit, changeDif);
            Game.knife = new Weapon("Knife", false, true, 125, 2, 10, 20, firstInit, changeDif);
            Game.pipe = new Weapon("Pipe", false, false, 0, 0, 5, 20, firstInit, changeDif);
            //Guns:
            Game.pistol = new Weapon("Pistol", 1, 18, true, 250, 1, 4, 15, 1.5, 3, 4, firstInit, changeDif);
            Game.smg = new Weapon("Smg", 10, 75, true, 700, 1, 10, 75, 2.5, 4, 6, firstInit, changeDif);
            Game.shotgun = new Weapon("Shotgun", 1, 12, true, 375, 2, 9, 60, 2, 5, 7, firstInit, changeDif);
            Game.rifle = new Weapon("Rifle", 1, 18, true, 275, 1, 5, 10, 1.25, 6, 7, firstInit, changeDif);
            Game.sniper = new Weapon("Sniper", 1, 10, true, 700, 2, 7, 0, 1, 7, 10, firstInit, changeDif);

            //Properties
            Game.farm = new Farm("Farm", "A farm", 500, 10, 2, firstInit, changeDif);

            //Seeds
            //  Generates crop with the same name
            //      Seed(String name, int price, int count, int level, String description, int growthTime, int minCrops, int maxCrops, int cropSellPrice, boolean firstInit, boolean changeDif)
            //  Requires a separately generated crop
            //       Seed(String name, int price, int count, int level, String description, int growthTime, int minCrops, int maxCrops, Crop crop, boolean firstInit, boolean changeDif)

            Game.wheat = new Seed("Wheat", 20, 3, 10, "Plain old wheat.", 10, 3, 6, 20, firstInit, changeDif);

            //Crops
            //  Crop(String name, int sellPrice, Seed seed, boolean firstInit, boolean changeDif)

            //Price
            Power.price = 25;
            Weapon.BULLET_DAMAGE = 10;
            Weapon.BULLET_CRITICAL_CHANCE = 0.01;
            Weapon.BULLET_CRITICAL_MULTIPLIER = 10;
            FirstAid.price = 5;
            Potion.spPrice = 10;
            Potion.rpPrice = 20;
            InstaHealth.price = 30;
            Bank.setInterest(0.05);
            Health.setUpgradePrice(100);

            //Levels needed
            FirstAid.level = 1;
            Potion.spLevel = 2;
            Potion.rpLevel = 2;
            InstaHealth.level = 3;
            Power.level = 4;

        } else {//Sets variables for HARD mode

            //Enemies (Name, health, coindropmin, coindropmax, damagemin, damagemax, xp, levelMin, levelMax, firstinit, changeDif)
            Game.darkElf = new Enemy("Dark Elf", 55, 15, 20, 15, 20, 15, 1, 100, firstInit, changeDif);
            Game.ninja = new Enemy("Ninja", 85, 10, 20, 10, 20, 15, 1, 100, firstInit, changeDif);
            Game.giantSpider = new Enemy("Giant Spider", 45, 10, 15, 10, 15, 10, 1, 100, firstInit, changeDif);
            Game.zombie = new Enemy("Zombie", 30, 10, 20, 10, 20, 15, 1, 100, firstInit, changeDif);
            Game.goblin = new Enemy("Goblin", 70, 15, 25, 15, 25, 20, 1, 100, firstInit, changeDif);
            Game.ghost = new Enemy("Ghost", 95, 20, 30, 20, 30, 25, 1, 100, firstInit, changeDif);
            Game.barbarian = new Enemy("Barbarian", 50, 5, 15, 5, 15, 15, 1, 100, firstInit, changeDif);
            Game.giantAnt = new Enemy("Giant Ant", 30, 5, 10, 5, 10, 10, 1, 100, firstInit, changeDif);
            Game.evilUnicorn = new Enemy("Evil Unicorn", 35, 20, 40, 5, 15, 20, 1, 100, firstInit, changeDif);
            Game.ogre = new Enemy("Ogre", 100, 20, 50, 10, 30, 50, 1, 100, firstInit, changeDif);

            /*Weapons
            * Gun:   (name, ammoUsed, ammoIncludedWithPurchase, buyable, price, ammoPrice, level, chanceOfMissing, critChanceMultiplier,
            *        critDamMultiplierMin, critDamMultiplierMax firstInit, changeDif)
            * Melee: (name, startingWeapon, buyable, price, level, damageMin, damageMax, firstInit, changeDif)
            */

            //Melee:
            Game.fists = new Weapon("Fists", true, false, 0, 0, 5, 10, firstInit, changeDif);
            Game.baseballBat = new Weapon("Baseball Bat", false, true, 170, 1, 10, 15, firstInit, changeDif);
            Game.knife = new Weapon("Knife", false, true, 175, 2, 10, 20, firstInit, changeDif);
            Game.pipe = new Weapon("Pipe", false, false, 0, 0, 5, 20, firstInit, changeDif);
            //Guns:
            Game.pistol = new Weapon("Pistol", 1, 18, true, 275, 1, 4, 15, 1.25, 2, 3, firstInit, changeDif);
            Game.smg = new Weapon("Smg", 10, 75, true, 800, 1, 10, 75, 1.75, 3, 5, firstInit, changeDif);
            Game.shotgun = new Weapon("Shotgun", 1, 12, true, 415, 2, 9, 60, 1.5, 4, 6, firstInit, changeDif);
            Game.rifle = new Weapon("Rifle", 1, 18, true, 300, 1, 5, 10, 1, 5, 6, firstInit, changeDif);
            Game.sniper = new Weapon("Sniper", 1, 10, true, 750, 2, 7, 0, .75, 7, 9, firstInit, changeDif);

            //Properties
            //  Farm(String name, String description, int price, int level, int fieldCount, boolean firstInit, boolean changeDif)
            Game.farm = new Farm("Farm", "Simply a farm.", 200, 10, 2, firstInit, changeDif);

            //Seeds
            //  Generates crop with the same name
            //      Seed(String name, int price, int count, int level, String description, int growthTime, int minCrops, int maxCrops, int cropSellPrice, boolean firstInit, boolean changeDif)
            //  Requires a separately generated crop
            //       Seed(String name, int price, int count, int level, String description, int growthTime, int minCrops, int maxCrops, Crop crop, boolean firstInit, boolean changeDif)

            Game.wheat = new Seed("Wheat", 20, 3, 10, "Plain old wheat.", 10, 3, 6, 20, firstInit, changeDif);

            //Crops
            //  Crop(String name, int sellPrice, Seed seed, boolean firstInit, boolean changeDif)

            //PRICE
            Power.price = 75;
            Weapon.BULLET_DAMAGE = 5;
            Weapon.BULLET_CRITICAL_CHANCE = 0.01;
            Weapon.BULLET_CRITICAL_MULTIPLIER = 10;
            FirstAid.price = 15;
            Potion.spPrice = 25;
            Potion.rpPrice = 35;
            InstaHealth.price = 45;
            Bank.setInterest(0.10);
            Health.setUpgradePrice(100);

            //Levels needed
            FirstAid.level = 1;
            Potion.spLevel = 2;
            Potion.rpLevel = 2;
            InstaHealth.level = 3;
            Power.level = 4;

        }
        
        if (firstInit) newGameSetup();
    }

    private static void newGameSetup() {

        Coins.set(50, false);
        FirstAid.set(3, false);
        Potion.set("survival", 2, false);
        Potion.set("recovery", 2, false);
        Xp.setAll(0, 500, 1);
        Game.none.setOwns(true);
        Game.none.equipSilent();

    }

    //GOD MODE METHODS
    public static boolean getGodMode() {
        return godMode;
    }

    //Returns message only if god mode is enabled
    public static String godModeMsg() {
        if (godMode) {
            return "Godmode is enabled\n";
        }
        return "";
    }

    public static void toggleGodMode() {
        if (godMode) {
            godMode = false;
            Ui.msg("Godmode has been disabled");
        } else {
            godMode = true;
            Ui.msg("Godmode has been enabled");
        }
    }
}
