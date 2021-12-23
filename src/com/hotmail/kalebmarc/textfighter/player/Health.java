package com.hotmail.kalebmarc.textfighter.player;

import com.hotmail.kalebmarc.textfighter.item.Armour;
import com.hotmail.kalebmarc.textfighter.main.Enemy;
import com.hotmail.kalebmarc.textfighter.main.Handle;
import com.hotmail.kalebmarc.textfighter.main.Ui;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;

public class Health {

    public static int timesDied;
    private static int health;
    private static int outOf;
    //Constants
    private static int UPGRADE_PRICE;

    private Health() {
    }

    public static String getStr() {
        return health + "/" + outOf;
    }

    public static int get() {
        return health;
    }

    public static int getOutOf() {
        return outOf;
    }

    public static void set(int h) {
        health = h;
    }

    public static void set(int h, int hOutOf) {
        health = h;
        outOf = hOutOf;
    }

    public static void setUpgradePrice(int price) {
        UPGRADE_PRICE = price;
    }

    public static void gain(int h) {
        health += h;
        if (health > outOf) {
            health = outOf;
        }
    }

    private static void lose(int h) {
        health -= h;
        if (health <= 0) {
            die();
        }
    }

    public static void die() {
        float randomCoinLoss = ThreadLocalRandom.current().nextInt(25, 51); //random between 25% and 50%
        int coinsLost = Math.round(Coins.get() * (randomCoinLoss / 100));
        Ui.popup("You have died! You lost " + coinsLost + " coin(s). ", "You've died!", JOptionPane.WARNING_MESSAGE);
        Coins.set(-(coinsLost), true);
        Stats.kills = 0;
        Health.set(Health.getOutOf());
        timesDied++;
    }

    public static void takeDamage(int damage) {

        if (Settings.getGodMode()) {
            damage = 0;
        }

        double resist = Armour.getEquipped().getDamResist() / 100.0;
        damage = (int) (damage - (damage * resist));

        Ui.cls();
        Ui.println("----------------------------------------------------");
        Ui.println("You have been hit by a " + Enemy.get().getName() + "!");
        Ui.println("You lost " + damage + " health.");
        Ui.println("----------------------------------------------------");
        Ui.println("Your health: " + (health - damage));
        Ui.println("Enemy health: " + Enemy.get().getHeathStr());
        Ui.println("----------------------------------------------------");
        Ui.pause();
        Health.lose(damage);

    }

    private static int getLevel() {

        //TODO Possibly find a better way to calculate and execute this whole 'upgrade health' section later
        switch (getOutOf()) {
            case 100:
                return 0;
            case 110:
                return 1;
            case 120:
                return 2;
            case 130:
                return 3;
            case 140:
                return 4;
            case 150:
                return 5;
            case 160:
                return 6;
            case 170:
                return 7;
            case 180:
                return 8;
            case 190:
                return 9;
            case 200:
                return 10;
            default:
                Handle.error("Unable to get health level");
                return 0;
        }
    }

    public static void upgrade() {
        while (true) {

            //Make sure player didn't already upgrade fully
            if (Health.getOutOf() == 200) {
                Ui.msg("You have upgraded your health to the maximum level");
                return;
            }

            // Calculate how much to upgrade to.
            int health = getOutOf() + 10;

            //Make sure health doesn't go over 200
            if (health > 200) {
                health = 200;
            }

            Ui.cls();
            Ui.println("-----------------------------------------------------------");
            Ui.println("                           Upgrade Health                     ");
            Ui.println("You can increase your max health up to 200. ");
            Ui.println("You'll be able to upgrade 10HP at a time, and");
            Ui.println("each upgrade will cost " + UPGRADE_PRICE + " coins.");
            Ui.println();
            Ui.println("Current Health: " + getStr());
            Ui.println();
            Ui.println("1) Upgrade to " + health + " health.");
            Ui.println("2) Go back");
            Ui.println("-----------------------------------------------------------");

            if (Ui.getValidInt() == 1) {

                //Level that player is trying to upgrade to,
                //and level needed to upgrade.
                int level = getLevel() + 1;

                if ((Xp.getLevel() >= level) && (Coins.get() >= UPGRADE_PRICE)) {

                    //Make sure user doesn't already have full health
                    if (getLevel() == 10) {
                        Ui.msg("You already have max health!");
                    }

                    //Upgrade health
                    Health.set(health, health);
                    Coins.set(-UPGRADE_PRICE, true);

                    Ui.msg("You upgraded your health.");

                } else {
                /*
                 * Cannot upgrade, make sure you are at least level [level], and you have at least [coins] coins.
				 *
				 * Coins: [coins]
				 * Level: [level]
				 */
                    Ui.cls();
                    Ui.println("Cannot upgrade, make sure you are at least");
                    Ui.println("level " + level + ", and you have at least " + UPGRADE_PRICE + " coins.");
                    Ui.println();
                    Ui.println("Level: " + Xp.getLevel());
                    Ui.println("Coins: " + Coins.get());
                    Ui.pause();
                }//if
            } else {
                return;
            }
        }//While(true)
    }//upgrade
}//Health
