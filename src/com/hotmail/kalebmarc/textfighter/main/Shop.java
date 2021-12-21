package com.hotmail.kalebmarc.textfighter.main;

import java.util.ArrayList;

import com.hotmail.kalebmarc.textfighter.item.Armour;
import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Potion;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

class Shop {
    private Shop() {
    }

    public static void menu() {
        while (true) {
            Ui.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                        Welcome to the shop!                       ");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("First-Aid kits: " + FirstAid.get());
            Ui.println("Potions: " + (Potion.get("survival") + Potion.get("recovery")));
            Ui.println();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("1) Health");
            Ui.println("2) Weapons/Ammo");
            Ui.println("3) Body Armour");
            Ui.println("4) Property");
            Ui.println("5) XP");
            Ui.println("6) Back");
            Ui.println("-------------------------------------------------------------------");
            switch (Ui.getValidInt()) {
                case 1:
                    health();
                    break;
                case 2:
                    weapons();
                    break;
                case 3:
                    armour();
                    break;
                case 4:
                    property();
                    break;
                case 5:
                    xp();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    private static void health() {

        while (true) {
            Ui.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                               Health                              ");
            Ui.println();
            NPC.welcome("Health");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("First-Aid kits: " + FirstAid.get());
            Ui.println("Potions: " + (Potion.get("survival") + Potion.get("recovery")));
            Ui.println("Insta-Healths: " + InstaHealth.get());
            Ui.println();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("1) FIRST-AID KIT");
            Ui.println("   Price - " + FirstAid.price + " coins");
            Ui.println("   Level - " + FirstAid.level);
            Ui.println();
            Ui.println("2) SURVIVAL POTION");
            Ui.println("   Price - " + Potion.spPrice + " coins");
            Ui.println("   Level - " + Potion.spLevel);
            Ui.println();
            Ui.println("3) RECOVERY POTION");
            Ui.println("   Price - " + Potion.rpPrice + " coins");
            Ui.println("   Level - " + Potion.rpLevel);
            Ui.println();
            Ui.println("4) INSTA-HEALTH");
            Ui.println("   Price - " + InstaHealth.price + " coins");
            Ui.println("   Level - " + InstaHealth.level);
            Ui.println();
            Ui.println("5) Back");
            Ui.println("-------------------------------------------------------------------");
            switch (Ui.getValidInt()) {
                case 1:
                    Ui.cls();
                    FirstAid.buy();
                    NPC.gratitude("Health", "purchase");
                    break;
                case 2:
                    Ui.cls();
                    Potion.buy("survival");
                    NPC.gratitude("Health", "purchase");
                    break;
                case 3:
                    Ui.cls();
                    Potion.buy("recovery");
                    NPC.gratitude("Health", "purchase");
                    break;
                case 4:
                    Ui.cls();
                    InstaHealth.buy();
                    NPC.gratitude("Health", "purchase");
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    private static void weapons() {
        while (true) {
            Ui.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                              Weapons                              ");
            Ui.println();
            NPC.welcome("Weapon");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("Level: " + Xp.getLevel());
            Ui.println();
            Ui.println("-------------------------------------------------------------------");
            int j = 0;
            int[] offset = new int[Weapon.getWeapons().size()];
            for (int i = 0; i < Weapon.getWeapons().size(); i++) {
                if (Weapon.getWeapons().get(i).isBuyable()) {
                    Ui.println((j + 1) + ") " + Weapon.getWeapons().get(i).getName());
                    Ui.println("   Price: " + Weapon.getWeapons().get(i).price);
                    Ui.println("   Level: " + Weapon.getWeapons().get(i).level);
                    offset[j] = i - j;
                    j++;
                    Ui.println();
                }
            }
            Ui.println((j + 1) + ") POWER");
            Ui.println("   Price: " + Power.price);
            Ui.println("   Level: " + Power.level);
            Ui.println();
            Ui.println((j + 2) + ") AMMO");
            Ui.println();
            Ui.println((j + 3) + ") Back");

            while (true) {//Make it easy to break, without going back to main store menu

                int menuItem = Ui.getValidInt();

                try { //This is probably pretty bad practice. Using exceptions as a functional part of the program.. Use variables!

                    //choices other than options in the array go here:
                    if (menuItem == (j + 1))
                        Power.buy();
                    if (menuItem == (j + 2))
                        buyAmmo();
                    if (menuItem == (j + 3) || menuItem > j)
                        return;

                    //reverts back to Weapon indexing
                    menuItem--;
                    menuItem = menuItem + offset[menuItem];

                    //Results go here:
                    Weapon.getWeapons().get(menuItem).buy();
                    return;

                } catch (Exception e) {
                    Ui.println();
                    Ui.println(menuItem + " is not an option.");
                }
            }
        }
    }

    private static void xp() {

        //Makes sure player has enough money
        boolean valid;

        while (true) {

            //Makes sure player isn't level 10 already
            if (Xp.getLevel() == 100) {
                Ui.msg("You're already level 100! You cannot buy any more xp.");
                return;
            }

            Ui.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                                 XP                                ");
            Ui.println();
            NPC.welcome("XP");
            Ui.println();
            Ui.println("Level: " + Xp.getLevel());
            Ui.println("XP: " + Xp.getFull());
            Ui.println("Coins: " + Coins.get());
            Ui.println();
            Ui.println("You can buy XP for 1 coin per XP. How much would you like to buy?");
            Ui.println("**Enter 0 to go back**");
            Ui.println("-------------------------------------------------------------------");

            int buy = Ui.getValidInt();
            valid = true;

            //Tests
            if (buy > Coins.get()) {
                //Not enough coins
                Ui.msg("You don't have enough coins to buy this much xp.");
                valid = false;
            }
            if (Xp.getLevel() == 100) {
                Ui.msg("You are already level 100; which is the maximum level.");
                valid = false;
            }
            if (buy < 0) {
                Ui.msg("You can't buy a negative amount of Xp.. Nice try though ;)");
                valid = false;
            }
            if (buy == 0) {
                return;
            }

            if (valid) {
                Ui.msg("You have bought " + buy + " xp.");

                //Results
                Xp.set(buy, true);
                Coins.set(-buy, true);
                Stats.xpBought += buy;
                NPC.gratitude("XP", "purchase");
            }

        }
    }

    private static void buyAmmo() {


        while (true) {
            Ui.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                                Ammo                               ");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("Level: " + Xp.getLevel());
            Ui.println();
            Ui.println("-------------------------------------------------------------------");
            ArrayList<Weapon> validWeapons = new ArrayList<Weapon>();
            for (int i = 0; i < Weapon.getWeapons().size(); i++) {
                if (Weapon.getWeapons().get(i).isBuyable() && !Weapon.getWeapons().get(i).melee && Weapon.getWeapons().get(i).owns()) {
                    Ui.println((validWeapons.size() + 1) + ") " + Weapon.getWeapons().get(i).getName());
                    Ui.println("   Price: " + Weapon.getWeapons().get(i).getAmmoPrice());
                    Ui.println("   Level: " + Weapon.getWeapons().get(i).level);
                    validWeapons.add(Weapon.getWeapons().get(i));
                }
            }
            Ui.println((validWeapons.size() + 1) + ") Back");

            while (true) {//Make it easy to break, without going back to main store menu

                int menuItem = Ui.getValidInt();

                try { //This is probably pretty bad practice. Using exceptions as a functional part of the program.. Use variables!
                    validWeapons.get(menuItem - 1).buyAmmo();
                    NPC.gratitude("Weapon", "purchase");
                    break;

                } catch (Exception e) {

                    if (menuItem == (validWeapons.size() + 1)) {
                        return;
                    }
                    Ui.println();
                    Ui.println(menuItem + " is not an option.");
                    Ui.pause();
                    Ui.cls();
                }
            }
        }
    }
    private static void property(){
        while (true){

            Ui.cls();
            Ui.println("________________________________________________");
            Ui.println("                    Property                    ");
            NPC.welcome("property");
            Ui.println("Level: " + Xp.getLevel());
            Ui.println("Coins: " + Coins.get());
            Ui.println("________________________________________________");

            //TODO do stuff to buy property
            Ui.pause();//temp


            return;
        }
    }
    private static void armour() {
        while (true) {
            Ui.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                            Body Armour                            ");
            Ui.println();
            NPC.welcome("Armour");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("Level: " + Xp.getLevel());
            Ui.println();
            Ui.println("-------------------------------------------------------------------");
            int j = 0;
            int[] armourShopOffset = new int[Armour.getArmours().size()];
            for (int i = 0; i < Armour.getArmours().size(); i++) {
                if (Armour.getArmours().get(i).getPrice() != 0) {
                    Ui.println((j + 1) + ") " + Armour.getArmours().get(i).getName());
                    Ui.println("   Price: " + Armour.getArmours().get(i).getPrice());
                    Ui.println("   Level: " + Armour.getArmours().get(i).getLevel());
                    armourShopOffset[j] = i - j;
                    j++;
                    Ui.println();
                }
            }
            Ui.println((j + 1) + ") Back");

            while (true) {

                int menuItem = Ui.getValidInt();

                try {

                    //choices other than options in the array go here:
                    if (menuItem == j + 1 || menuItem > j)
                        return;

                    //reverts back to armour indexing
                    menuItem--;
                    menuItem = menuItem + armourShopOffset[menuItem];

                    //Results go here:
                    Armour.getArmours().get(menuItem).buy();
                    return;

                } catch (Exception e) {
                    Ui.println();
                    Ui.println(menuItem + " is not an option.");
                }
            }
        }
    }
}