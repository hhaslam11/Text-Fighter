package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.*;

import javax.swing.*;
import java.util.ArrayList;

public class Enemy {

    //constants
    private static final int FIRST_AID_KIT_MIN = 0;
    private static final int FIRST_AID_KIT_MAX = 2;

    //Enemy List
    public static final ArrayList<Enemy> arrayEnemy = new ArrayList<>();

    //Static Variables
    private static Enemy current;

    //Properties (Constant)
    private String name;
    private int healthMax;
    private int coinDropMin;
    private int coinDropMax;
    private int damageMin;
    private int damageMax;
    private int xp;
    private int levelMin;
    private int levelMax;

    //Variables
    private int health;
    private int firstAidKit;

    public Enemy(String name, int healthMax, int coinDropMin, int coinDropMax,
                 int damageMin, int damageMax, int xp, int levelMin, int levelMax, boolean firstInit, boolean changeDif) {

        this.name = name;
        this.healthMax = healthMax;
        this.coinDropMin = coinDropMin;
        this.coinDropMax = coinDropMax;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.xp = xp;
        this.levelMin = levelMin;
        this.levelMax = levelMax;

        /*
         * Finding a way to only have one boolean here (either firstInit, changeDif, or something else) would be nicer.
         * If the arrays are in the firstInit block, then it would cause problems when loading from a save file; but
         * if they aren't in the !changeDif block, then they make more arrays whenever changing difficulties(which
         * results in duplicate arrays). changeDif and firstInit shouldn't ever both be true. Either only one of
         * them will be true, or none of them will be true (which leaves it to have 3 possible ways it could be,
         * so I don't know how I'd do that, as a boolean can only have 2 values; not 3). Using an integer could
         * possibly work- something like 1=firstInit, 2=changeDif, 3=Save/load. But, using integers like this
         * isn't a very good idea. It'd be too confusing. Maybe there could be a way to figure out one of the 3
         * options from in here, so it'd narrow it down to 2 options, which can be determined be a single boolean.
         * This would be a bit better than using an integer, but harder to implement. One more way is have more
         * than one initializer. Might cause confusion, though. TODO fix this before BETA
         * ===Don't forget to do this with the weapon class, as well===
         */
        if (!changeDif) {
            arrayEnemy.add(this);
            Achievements.setUpEnemyAch(name, this);
        }
        if (firstInit) {//Only call if its the first time initializing the enemy. (Not if changing difficulties)
            this.health = healthMax;
        }
    }

    public static void set(int i) {
        current = arrayEnemy.get(i);
    }

    public static Enemy get() {
        return current;
    }

    public static int getIndex(Enemy i) {
        return arrayEnemy.indexOf(i);
    }

    public static void encounterNew() {
        int playerLevel = Xp.getLevel();

        //current = arrayEnemy.get(Random.RInt(0, arrayEnemy.size() - 1));
        for(int i = 0; i < arrayEnemy.size(); i++) {
            if(arrayEnemy.get(i).levelMin <= playerLevel && playerLevel <= arrayEnemy.get(i).levelMax) {
                current = arrayEnemy.get(i);
            }
        }

        current.health = current.healthMax;
        current.firstAidKit = Random.RInt(FIRST_AID_KIT_MIN, FIRST_AID_KIT_MAX);
        com.hotmail.kalebmarc.textfighter.player.Xp.setBattleXp(0, false);
        Ui.popup("You have encountered a " + current.getName(), "Encounter", JOptionPane.INFORMATION_MESSAGE);

    }

    private static void testFoundPipe() {
        int found = Random.RInt(100);
        if (found <= 2 && !Game.pipe.owns) {
            Game.pipe.owns = true;
            Weapon.set(Game.pipe);
            Ui.popup("You have found an old pipe!", "You found something!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            die();
            return true;
        }
        return false;
    }

    void dealDamage() {
        int damage = Random.RInt(this.damageMin, this.damageMax);
        Health.takeDamage(damage);
    }

    private void die() {

        //Get rewards & store in temp vars
        int tempCoin = Random.RInt(coinDropMin, coinDropMax);
        int tempHealth = Random.RInt(0, 2);
        xp += com.hotmail.kalebmarc.textfighter.player.Xp.getBattleXp();
        com.hotmail.kalebmarc.textfighter.player.Xp.setBattleXp(0, false);

        //Prompt enemy death
        Ui.popup("You have defeated an enemy, dealing " + Weapon.get().getDamageDealt() + " damage! You've found " + tempCoin + " coins, and " + xp + "Xp!", "You've defeated an enemy!", JOptionPane.PLAIN_MESSAGE);

        //Rewards
        testFoundPipe();
        Coins.set(tempCoin, true);
        switch (tempHealth) {
            case 0:
                Health.gain(10);
                break;
            case 1:
                Potion.set("survival", 1, true);
                break;
            case 2:
                Potion.set("recovery", 1, true);
                break;
        }
        Xp.set(xp, true);
        Stats.kills++;
        Stats.totalKills++;

        //Get Achievement
        Achievements.getEnemyAch(Enemy.get());

        encounterNew();
    }

    public boolean useFirstAidKit(){
        if (this.firstAidKit <= 0) {
            return false;
        } else {
            this.firstAidKit--;
            this.takeDamage(-20);
            Ui.msg("The " + this.name + " has used a first-aid kit. They gained 20 health");
            return true;
        }
    }

    public int getFirstAidKit(){
        return this.firstAidKit;
    }

    public void setFirstAidKit(int amount){
        this.firstAidKit = amount;
    }

    public void setDamage(int min, int max) {
        this.damageMin = min;
        this.damageMax = max;
    }

    public void setCoinDrop(int min, int max) {
        this.coinDropMin = min;
        this.coinDropMax = max;
    }

    public void setHealth(int current, int max) {
        this.health = current;
        this.healthMax = max;
    }

    public int getHealth() {
        return health;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public String getHeathStr() {
        return (health + "/" + healthMax);
    }

    public String getName() {
        return name;
    }

    public void viewAbout() {
        final int BORDER_LENGTH = 39;

        //Start of weapon Info
        Ui.cls();
        for (int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//Make line
        Ui.println();
        for (int i = 0; i < ((BORDER_LENGTH / 2) - (this.getName().length() / 2)); i++)
            Ui.print(" ");//Set correct spacing to get name in middle of box
        Ui.println(this.getName());
        Ui.println("Health: " + this.getHealthMax());
        Ui.println("Damage: " + this.damageMin + "-" + this.damageMax);
        Ui.println("Coin Drop: " + this.coinDropMin + "-" + this.coinDropMax);
        Ui.println();
        Ui.println("XP Dropped: " + this.xp + "Xp");
        for (int i = 0; i < 39; i++) Ui.print("-");//Make line
        Ui.pause();
        Ui.cls();
        //End of weapon Info
    }
}
