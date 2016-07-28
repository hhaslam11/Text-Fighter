package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Health;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

public class InstaHealth {
    private InstaHealth() {}

    private static int instaHealth;
    public static int used = 0;
    public static int price;
    public static int level;

    public static int get() {
        return instaHealth;
    }

    public static void set(int amount, boolean add) {
        if (!add) {
            instaHealth = amount;
        } else {
            instaHealth += amount;
            if (instaHealth < 0) instaHealth = 0;
        }
    }

    public static void use() {

        Ui.cls();
        if (get() <= 0) {

            Ui.println("----------------------------------------------------");
            Ui.println("You have no Insta-Health's left!");
            Ui.println("Go to the shop to buy some more.");
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else if (Health.get() == 100) {

            Ui.println("----------------------------------------------------");
            Ui.println("You already have full health!");
            Ui.println("You don't need an Insta-Health!");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getStr());
            Ui.println("Insta-Health's: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        } else {

            set(-1, true);
            Health.set(Health.getOutOf());
            used++;

            Ui.println("----------------------------------------------------");
            Ui.println("You have used an Insta-Health.");
            Ui.println("You're health has been fully restored.");
            Ui.println("----------------------------------------------------");
            Ui.println("Your health: " + Health.getStr());
            Ui.println("Insta-Health's: " + get());
            Ui.println("----------------------------------------------------");
            Ui.pause();

        }
    }
    public static void buy(){
        if(Xp.getLevel() < level){
            Ui.println("You have to be at least level " + level + " to buy this!");
            Ui.pause();
        }else if(price <= Coins.get()){
            Coins.set(-price, true);
            Stats.coinsSpentOnHealth += price;
            set(1, true);
            Ui.println("Thank you for your purchase. Come again soon! ");
            Ui.pause();
        }else{
            Ui.println("You do not have enough coins.");
            Ui.pause();
        }
    }
}
