package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Food;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.main.Weapon;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Potion;

public class Chest {
    private Chest() {
    }

    public static void view() {

        Ui.cls();
        Ui.println("------------------------------");
        Ui.println("          Item Chest          ");
        Ui.println();
        Ui.println("First-Aid kits: " + FirstAid.get());
        Ui.println("Insta-Healths: " + InstaHealth.get());
        Ui.println("     Potions: ");
        Ui.println("          Survival: " + Potion.get("survival"));
        Ui.println("          Recovery: " + Potion.get("recovery"));
        Ui.println("Coins: " + Coins.get());
        Ui.println("POWERS: " + Power.get());
        for (int i = 0; i < Weapon.getWeapons().size(); i++) {
            if (Weapon.getWeapons().get(i).owns()) {
                Ui.println(Weapon.getWeapons().get(i).getName());
                if (!Weapon.getWeapons().get(i).melee)
                    Ui.println(" (Ammo: " + Weapon.getWeapons().get(i).getAmmo() + ")");
            }
        }
        for (int i = 1; i < Armour.getArmours().size(); i++) {
            if (Armour.getArmours().get(i).isOwns()) {
                Ui.println(Armour.getArmours().get(i).toString());
            }
        }
        for (int i = 0; i < Food.getFoods().size(); i++) {
            if (Food.getFoods().get(i).getQuantity() > 0)
                Ui.println(Food.getFoods().get(i).getName() + "(x" + Food.getFoods().get(i).getQuantity() + ")");
        }
        Ui.println();
        Ui.println("------------------------------");
        Ui.pause();

    }
}
