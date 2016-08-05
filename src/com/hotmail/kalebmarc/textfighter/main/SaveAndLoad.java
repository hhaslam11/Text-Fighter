package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.Armour;
import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.player.*;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

class SaveAndLoad {

    private static PrintStream output;
    private static String path = SaveAndLoad.class.getProtectionDomain().getCodeSource().getLocation().getPath() + ".TFsave";
    private static Scanner input;

    public static boolean load() {

        User.promptNameSelection();
        path = path.replace(".jar", "_" + User.name());
        path = path.replaceAll("%20", " ");

        try {
            input = new Scanner(new File(path));
        } catch (Exception e) {
            Ui.cls();
            Ui.println("------------------------------");
            Ui.println("Cannot find save file.  ");
            Ui.println("Starting a new game...  ");
            Ui.println("------------------------------");
            Ui.pause();
            return false;
        }

        try {
            if (!input.nextLine().equals(Version.getFull())) {
                Ui.cls();
                Ui.println("------------------------------------");
                Ui.println("WARNING- This save file is from");
                Ui.println("a different version of TextFighter,");
                Ui.println("and will probably crash the game");
                Ui.println("if you try and load it. Do you");
                Ui.println("want to continue anyways?");
                Ui.println("------------------------------------");
                Ui.println("1) No, start a new game");
                Ui.println("2) Yes, attempt to load");
                switch (Ui.getValidInt()) {
                    case 1:
                        return false;
                    case 2:
                        break;
                    default:
                        return false;
                }
            }

            Health.set(readInt(), readInt());
            FirstAid.set(readInt(), false);
            FirstAid.used = readInt();
            InstaHealth.set(readInt(), false);
            InstaHealth.used = readInt();
            Health.timesDied = readInt();

            //Coins
            Coins.set(readInt(), false);
            Bank.set(readInt(), false);
            Casino.totalCoinsWon = readInt();
            Casino.gamesPlayed = readInt();
            Ach.boughtItem = readBoolean();
            Stats.totalCoinsSpent = readInt();
            Stats.coinsSpentOnBankInterest = readInt();
            Stats.coinsSpentOnWeapons = readInt();
            Stats.coinsSpentOnHealth = readInt();
            Stats.xpBought = readInt();
            Loan.setCurrentLoan(readInt());
            Loan.setNetDue(readInt());

            //Xp
            Xp.setLevel(readInt());
            Xp.setOutOf(readInt());
            Xp.set(readInt(), false);
            Xp.total = readInt();

            //Potions
            Potion.spUsed = readInt();
            Potion.rpUsed = readInt();
            Potion.set("survival", readInt(), false);
            Potion.set("recovery", readInt(), false);


            //Settings
            Settings.setDif(input.nextLine(), false, false);
            if (readBoolean()) Cheats.enable();
            if (readBoolean()) Cheats.lock();
            Settings.difLocked = readBoolean();
            Ui.guiEnabled = readBoolean();

            //Combat
            Stats.kills = readInt();
            Stats.highScore = readInt();
            Stats.totalKills = readInt();
            Weapon.set(readInt());
            for (int i = 0; i < Weapon.arrayWeapon.size(); i++) {
                Weapon.arrayWeapon.get(i).owns = readBoolean();
            }
            for (int i = 0; i < Weapon.arrayWeapon.size(); i++) {
                Weapon.arrayWeapon.get(i).setAmmo(readInt(), false);
            }
            Power.set(readInt(), false);
            Power.used = readInt();
            Stats.totalDamageDealt = readInt();
            Stats.bulletsFired = readInt();
            Stats.bulletsThatHit = readInt();
            for (int i = 0; i < Armour.getArmours().size(); i++) {
                Armour.getArmours().get(i).setOwns(readBoolean());
            }
            Armour.set(readInt());

            //Enemy
            Enemy.set(readInt());
            Enemy.get().setHealth(readInt(), Enemy.get().getHealthMax());

            //Achs
            Ach.moneyMaker = readBoolean();
            Ach.enemySlayer = readBoolean();
            Ach.firstKill = readBoolean();
            Ach.timeForAnUpgrade = readBoolean();
            for (int i = 0; i < Enemy.arrayEnemy.size(); i++) {
                Ach.arrayKilled.set(i, readBoolean());
            }
            Ach.textFighterMaster = readBoolean();
            Ach.YAYPOWER = readBoolean();
            Ach.awwYouCareAboutMe = readBoolean();
            Ach.slayer = readBoolean();
            Ach.nobodysPerfect = readBoolean();
            Ach.makingMoney = readBoolean();
            Ach.gamblingAddiction = readBoolean();
            Ach.level2Fighter = readBoolean();
            Ach.level3Fighter = readBoolean();
            Ach.level4Fighter = readBoolean();
            Ach.level5Fighter = readBoolean();
            Ach.level6Fighter = readBoolean();
            Ach.level7Fighter = readBoolean();
            Ach.level8Fighter = readBoolean();
            Ach.level9Fighter = readBoolean();
            Ach.level10Fighter = readBoolean();
            Ach.honestPlayer = readBoolean();
            Ach.learning = readBoolean();

            //Other Stuff
            About.setViewed(readBoolean());
            Stats.timesCheated = readInt();
            Stats.timesQuit = readInt();
            Stats.itemsCrafted = readInt();
            Stats.diceGamesPlayed = readInt();
            Stats.slotGamesPlayed = readInt();


        } catch (Exception e) {
            Handle.error(e.toString());
            System.exit(1);
        }

        //input.close();
        return true;
    }

    public static void save() {

        path = path.replace(".jar", "_" + User.name());
        path = path.replaceAll("%20", " ");

        try {
            output = new PrintStream(path);
        } catch (Exception e) {
            Handle.error(e.toString());
        }

        //Version
        output.println(Version.getFull());

        //Player Health
        output.println(Health.get());
        output.println(Health.getOutOf());
        output.println(FirstAid.get());
        output.println(FirstAid.used);
        output.println(InstaHealth.get());
        output.println(InstaHealth.used);
        output.println(Health.timesDied);

        //Coins
        output.println(Coins.get());
        output.println(Bank.get());
        output.println(Casino.totalCoinsWon);
        output.println(Casino.gamesPlayed);
        output.println(Ach.boughtItem);
        output.println(Stats.totalCoinsSpent);
        output.println(Stats.coinsSpentOnBankInterest);
        output.println(Stats.coinsSpentOnWeapons);
        output.println(Stats.coinsSpentOnHealth);
        output.println(Stats.xpBought);
        output.println(Loan.getCurrentLoan());
        output.println(Loan.getNetDue());

        //Xp
        output.println(Xp.getLevel());
        output.println(Xp.getOutOf());
        output.println(Xp.get());
        output.println(Xp.total);

        //Potions
        output.println(Potion.spUsed);
        output.println(Potion.rpUsed);
        output.println(Potion.get("survival"));
        output.println(Potion.get("recovery"));

        //Settings
        output.println(Settings.getDif());
        output.println(Cheats.enabled());
        output.println(Cheats.locked());
        output.println(Settings.difLocked);
        output.println(Ui.guiEnabled);

        //Combat
        output.println(Stats.kills);
        output.println(Stats.highScore);
        output.println(Stats.totalKills);
        output.println(Weapon.getIndex(Weapon.get()));
        for (int i = 0; i < Weapon.arrayWeapon.size(); i++) {
            //Weapons owned
            output.println(Weapon.arrayWeapon.get(i).owns());
        }
        for (int i = 0; i < Weapon.arrayWeapon.size(); i++) {
            output.println(Weapon.arrayWeapon.get(i).getAmmo());
        }
        output.println(Power.get());
        output.println(Power.used);
        output.println(Stats.totalDamageDealt);
        output.println(Stats.bulletsFired);
        output.println(Stats.bulletsThatHit);
        for (int i = 0; i < Armour.getArmours().size(); i++) {
            output.println(Armour.getArmours().get(i).isOwns());
        }
        output.println(Armour.get());

        //Enemy
        output.println(Enemy.getIndex(Enemy.get()));
        output.println(Enemy.get().getHealth());

        //Achs
        output.println(Ach.moneyMaker);
        output.println(Ach.enemySlayer);
        output.println(Ach.firstKill);
        output.println(Ach.timeForAnUpgrade);
        for (int i = 0; i < Enemy.arrayEnemy.size(); i++) {
            output.println(Ach.arrayKilled.get(i));
        }
        output.println(Ach.textFighterMaster);
        output.println(Ach.YAYPOWER);
        output.println(Ach.awwYouCareAboutMe);
        output.println(Ach.slayer);
        output.println(Ach.nobodysPerfect);
        output.println(Ach.makingMoney);
        output.println(Ach.gamblingAddiction);
        output.println(Ach.level2Fighter);
        output.println(Ach.level3Fighter);
        output.println(Ach.level4Fighter);
        output.println(Ach.level5Fighter);
        output.println(Ach.level6Fighter);
        output.println(Ach.level7Fighter);
        output.println(Ach.level8Fighter);
        output.println(Ach.level9Fighter);
        output.println(Ach.level10Fighter);
        output.println(Ach.honestPlayer);
        output.println(Ach.learning);

        //Other random stuff
        output.println(About.viewed());
        output.println(Stats.timesCheated);
        output.println(++Stats.timesQuit);
        output.println(Stats.itemsCrafted);
        output.println(Stats.diceGamesPlayed);
        output.println(Stats.slotGamesPlayed);

        //output.close();
    }

    /**
     * @return the next line as an integer
     */
    private static int readInt() {
        return Integer.parseInt(input.nextLine());
    }

    /**
     * @return the next line as a boolean
     */
    private static boolean readBoolean() {
        return Boolean.parseBoolean(input.nextLine());
    }

    /**
     * @return the next line as a String
     */
    private static String readString() {
        return input.nextLine();
    }
}