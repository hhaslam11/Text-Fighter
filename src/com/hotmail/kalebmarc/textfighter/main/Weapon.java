package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Ach;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

import javax.swing.*;
import java.util.ArrayList;

public class Weapon{

    //Constants
    private final static int AMMO_WITH_PURCHASE   = 30;
    private final static int SGAMMO_WITH_PURCHASE = 25;//TODO Remove in Alpha 4.6 (Or whenever each gun has own ammo)

    //Properties
    public static int AMMO_10_PRICE;
    public static int AMMO_50_PRICE;
    public static int AMMO_100_PRICE;
    public static int AMMO_LEVEL;
    public static int BULLET_DAMAGE;
    public int        price;
    public int        level;
    private int       damageMin;
    private int       damageMax;
    private int       ammoUsed;
    private double    chanceOfMissing;
    private String    name;
    private boolean   buyable;
    private boolean   viewedAbout;
    public boolean    melee;


    //Variables
    public static Weapon  starting;
    private static Weapon current = null;
    private static int    ammo;
    private static int    sgAmmo;
    public boolean        owns;

    //Weapon List
    public static final ArrayList<Weapon> arrayWeapon = new ArrayList<>();

    public Weapon(String name, int ammoUsed, boolean buyable, int price, int level,//For Gun
                  double chanceOfMissing, boolean firstInit, boolean changeDif){

       this.name               = name;
       this.ammoUsed           = ammoUsed;
       this.buyable            = buyable;
       this.price              = price;
       this.level              = level;
       this.chanceOfMissing    = chanceOfMissing;
       this.melee              = false;

       if(!changeDif){
           arrayWeapon.add(this);
       }

       if(firstInit){
           this.owns = false;

       }

    }
    public Weapon(String name, boolean startingWeapon, boolean buyable, int price, int level,//For Melee
                  int damageMin, int damageMax, boolean firstInit, boolean changeDif){
       this.name            = name;
       this.buyable         = buyable;
       this.price           = price;
       this.level           = level;
       this.damageMin       = damageMin;
       this.damageMax       = damageMax;
       this.melee           = true;

        if(!changeDif){
            arrayWeapon.add(this);
        }

       if(firstInit){
           if (startingWeapon){//If first init, see if player starts with this or not.
               this.owns = true;
               current = this;
               starting = this;
           }else{
               this.owns = false;
           }
       }
    }
    public static Weapon get(){
        return current;
    }
    public String getName(){
        return name;
    }
    public boolean owns(){
        return owns;
    }
    public static int getAmmo(){
        return ammo;
    }
    public static int getSgAmmo(){
        return sgAmmo;
    }
    public static int getIndex(Weapon i){
        return arrayWeapon.indexOf(i);
    }
    public static void set(Weapon x){
        current = x;
    }
    public static void set(int i){
        current = arrayWeapon.get(i);
    }
    public static void setAmmo(int amount, boolean add){
        if(add){
            ammo += amount;
        }else{
            ammo = amount;
        }
    }
    public static void setSgAmmo(int amount, boolean add){
        if(add){
            sgAmmo += amount;
        }else{
            sgAmmo = amount;
        }
    }
    public static void choose(){
        while(true) {
            Action.cls();
            Ui.println("----------------------------");
            Ui.println("Equip new weapon");
            Ui.println();
            Ui.println("Ammo: " + getAmmo());
            Ui.println("Equipped weapon: " + current.getName());
            Ui.println("----------------------------");
            for(int i = 0; i < arrayWeapon.size(); i++){
               if(!arrayWeapon.get(i).owns()){
                   Ui.println((i + 1) + ") " + arrayWeapon.get(i).getName().toUpperCase() + " IS NOT AVAILABLE");
               }else{
                   Ui.println((i + 1) + ") " + arrayWeapon.get(i).getName());
               }
            }

            //Get valid weapon index
            int choice;
            do{
                choice  = Action.getValidInt() - 1;
            }while(choice < 0 || choice > arrayWeapon.size());

            //Equip if player has the selected weapon
            if(arrayWeapon.get(choice).owns()){
                current = arrayWeapon.get(choice);
                Action.cls();
                Ui.println("You have equipped a " + arrayWeapon.get(choice).getName());
                Action.pause();
                return;
            }else{
                Action.cls();
                Ui.println("You don't have this weapon.");
                Action.pause();
            }

        }
    }
    public void dealDam(){
        int damageDealt = 0;

        if (this.melee){
			/*
			 * Melee Attack
			 */
            damageDealt = Random.RInt(this.damageMin, this.damageMax);
        }else{
			/*
			 * Gun Attack
			 */
            if(current.getName().equals("Shotgun")){
                //Use shotgun ammo if shotgun equipped
                //This will be changed in Alpha 4.6 so there's only one path
                if (getSgAmmo() >= 1){

                    for (int i = 1; i <= 7; i++){
                        if (Random.RInt(100) > this.chanceOfMissing){
                            damageDealt += 10;
                            Stats.bulletsThatHit++;
                        }
                    }
                    //Results
                    setSgAmmo(-1, true);
                    Stats.bulletsFired++;

                }else{
                    noAmmo();
                    damageDealt = 0;
                }
            }else{
                if (getAmmo() >= this.ammoUsed) {

                    for (int i = 1; i <= this.ammoUsed; i++) {
                        if (Random.RInt(100) > this.chanceOfMissing){
                            damageDealt += BULLET_DAMAGE;
                            Stats.bulletsThatHit++;
                        }
                    }
                    //Results
                    setAmmo(-ammoUsed, true);
                    Stats.bulletsFired += ammoUsed;

                }else{
                    noAmmo();
                    damageDealt = 0;
                }
            }
        }

        //Display stuff
        com.hotmail.kalebmarc.textfighter.player.Stats.totalDamageDealt += damageDealt;
        com.hotmail.kalebmarc.textfighter.player.Xp.set(damageDealt, true);
        Enemy.get().takeDamage(damageDealt);
        Action.cls();
        Ui.println("----------------------------------------------------");
        Ui.println("You have attacked a " + Enemy.get().getName() + "!");
        Ui.println("You dealt " + damageDealt + " damage with a " + this.name);
        Ui.println("----------------------------------------------------");
        Ui.println("Your health: " + com.hotmail.kalebmarc.textfighter.player.Health.getStr());
        Ui.println("Enemy health: " + Enemy.get().getHeathStr());
        Ui.println("----------------------------------------------------");

        Action.pause();
    }
    public void viewAbout(){

        final int BORDER_LENGTH = 39;

        //Start of weapon Info
        Action.cls();
        for(int i = 0; i < BORDER_LENGTH; i++) Ui.println("-");//Make line
        Ui.println();
        for(int i = 0; i < ((BORDER_LENGTH / 2) - (this.getName().length() / 2)); i++) Ui.println(" ");//Set correct spacing to get name in middle of box
        Ui.println(this.getName());
        Ui.println("Price: " + this.price + " coins");
        Ui.println("Chance of missing: " + this.chanceOfMissing + "%");
        Ui.println("Ammo Used: " + this.ammoUsed);
        Ui.println("Damage: " + this.getDamage());
        for(int i = 0; i < 39; i++) Ui.println("-");//Make line
        Action.pause();
        Action.cls();
        //End of weapon Info
        this.setViewed(true);
    }
    private String getDamage(){
        if(this.melee){
            return (this.damageMin + " - " + this.damageMax);
        }else{
            if(this.chanceOfMissing == 0){
                return String.valueOf((BULLET_DAMAGE * this.ammoUsed));
            }else{
                return ("0 - " + String.valueOf((BULLET_DAMAGE * this.ammoUsed)));
            }
        }
    }
    public boolean viewedAbout(){
        return this.viewedAbout;
    }
    public void setViewed(boolean v){
        this.viewedAbout = v;
    }
    public boolean isBuyable(){
        return this.buyable;
    }
    public void buy(){
        Action.cls();
        if(!isBuyable()){
            Ui.println("Sorry, this item is no longer in stock.");
            Action.pause();
            return;
        }
        if(this.owns()){
            Ui.println("You already own this weapon.");
            Action.pause();
            return;
        }
        if(level > Xp.getLevel()){
            Ui.println("You are not a high enough level to buy this item.");
            Action.pause();
            return;
        }
        if(price > Coins.get()){
            Ui.println("You do not have enough coins to buy this item.");
            Action.pause();
            return;
        }

        //Buy
        Ach.boughtItem = true;
        Coins.set(-price, true);
        Stats.coinsSpentOnWeapons += price;
        this.owns = true;
        current = this;
        Ui.println("You have bought a " + this.getName() + " for " + this.price + " coins.");
        Ui.println("Coins: " + Coins.get());
        Action.pause();

        //Give ammo
        if(this.name.equals("Shotgun")){
            //TODO Remove when each gun has own ammo type (Planned for alpha 4.6)
            sgAmmo += SGAMMO_WITH_PURCHASE;
        }else{
            ammo += AMMO_WITH_PURCHASE;
        }

    }
    public static void buyAmmo10(){
        /*
         * Using 3 different methods to do the same thing with slightly different values will be changed when you
         * can buy a custom amount of ammo (A4.6)
         */

        Action.cls();

        //Make sure player is a high enough level
        if(Xp.getLevel() < AMMO_LEVEL){
            Ui.println("You are not a high enough level. You need to be at least level " + AMMO_LEVEL + ".");
            Action.pause();
            return;
        }

        //Make sure player has enough coins
        if(Coins.get() < AMMO_10_PRICE){
            Ui.println("You don't have enough coins. You need " + (AMMO_10_PRICE - Coins.get()) + " more coins.");
            Action.pause();
            return;
        }

        ammo += 10;
        Coins.set(-AMMO_10_PRICE, true);
        Stats.coinsSpentOnWeapons += AMMO_10_PRICE;

        Ui.println("You have bought 10 ammo.");
        Action.pause();
    }
    public static void buyAmmo50(){
        /*
         * Using 3 different methods to do the same thing with slightly different values will be changed when you
         * can buy a custom amount of ammo (A4.6)
         */

        Action.cls();

        //Make sure player is a high enough level
        if(Xp.getLevel() < AMMO_LEVEL){
            Ui.println("You are not a high enough level. You need to be at least level " + AMMO_LEVEL + ".");
            Action.pause();
            return;
        }

        //Make sure player has enough coins
        if(Coins.get() < AMMO_50_PRICE){
            Ui.println("You don't have enough coins. You need " + (AMMO_50_PRICE - Coins.get()) + " more coins.");
            Action.pause();
            return;
        }

        ammo += 50;
        Coins.set(-AMMO_50_PRICE, true);
        Stats.coinsSpentOnWeapons += AMMO_50_PRICE;

        Ui.println("You have bought 50 ammo.");
        Action.pause();
    }
    public static void buyAmmo100(){

        /*
         * Using 3 different methods to do the same thing with slightly different values will be changed when you
         * can buy a custom amount of ammo (A4.6)
         */

        Action.cls();

        //Make sure player is a high enough level
        if(Xp.getLevel() < AMMO_LEVEL){
            Ui.println("You are not a high enough level. You need to be at least level " + AMMO_LEVEL + ".");
            Action.pause();
            return;
        }

        //Make sure player has enough coins
        if(Coins.get() < AMMO_100_PRICE){
            Ui.println("You don't have enough coins. You need " + (AMMO_100_PRICE - Coins.get()) + " more coins.");
            Action.pause();
            return;
        }

        ammo += 100;
        Coins.set(-AMMO_100_PRICE, true);
        Stats.coinsSpentOnWeapons += AMMO_100_PRICE;

        Ui.println("You have bought 100 ammo.");
        Action.pause();

    }
    public static void noAmmo(){
        Ui.popup("You've run out of ammo!", "Warning", JOptionPane.WARNING_MESSAGE);
        Weapon.current = Weapon.starting;
    }
}