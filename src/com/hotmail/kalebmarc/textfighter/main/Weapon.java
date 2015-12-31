package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Ach;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

import javax.swing.*;
import java.util.ArrayList;

public class Weapon{

    //Properties
    public static int BULLET_DAMAGE;
    public int        price;
    public int        level;
    private int       damageMin;
    private int       damageMax;
    private double    chanceOfMissing;
    private String    name;
    private boolean   buyable;
    private boolean   viewedAbout;
    public boolean    melee;

    //Variables
    public static Weapon  starting;
    private static Weapon current = null;
    public boolean        owns;

    //Ammo
    private int ammo;
    private int ammoUsed;
    private int ammoPrice;//Per 1
    private int ammoIncludedWithPurchase;

    //Weapon List
    public static final ArrayList<Weapon> arrayWeapon = new ArrayList<>();

    public Weapon(String name, int ammoUsed, int ammoIncludedWithPurchase, boolean buyable, int price, //For guns
                  int ammoPrice, int level, double chanceOfMissing, boolean firstInit, boolean changeDif){

        this.name                     = name;
        this.ammoUsed                 = ammoUsed;
        this.ammoIncludedWithPurchase = ammoIncludedWithPurchase;
        this.buyable                  = buyable;
        this.price                    = price;
        this.ammoPrice                = ammoPrice;
        this.level                    = level;
        this.chanceOfMissing          = chanceOfMissing;
        this.melee                    = false;

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
    static int getIndex(Weapon i){
        return arrayWeapon.indexOf(i);
    }
    public static void set(Weapon x){
        current = x;
    }
    public static void set(int i){
        current = arrayWeapon.get(i);
    }
    public void setAmmo(int amount, boolean add){
        if(this.melee) return;
        if(add){
            this.ammo += amount;
        }else{
            this.ammo = amount;
        }
    }
    public int getAmmo(){
        return this.ammo;
    }
    public static void choose(){
        while(true) {
            Action.cls();
            Ui.println("----------------------------");
            Ui.println("Equip new weapon");
            Ui.println();
            Ui.println("Ammo: " + current.getAmmo());
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

            if (getAmmo() >= this.ammoUsed) {

                for (int i = 1; i <= this.ammoUsed; i++) {
                    if (Random.RInt(100) > this.chanceOfMissing) {
                        damageDealt += BULLET_DAMAGE;
                        Stats.bulletsThatHit++;
                    }

                    //Results
                    setAmmo(-ammoUsed, true);
                    Stats.bulletsFired += ammoUsed;
                }

            } else {
                    noAmmo();
                    damageDealt = 0;
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
        ammo += this.ammoIncludedWithPurchase;

    }
    public void buyAmmo(){

        Action.cls();

        //Make sure player is a high enough level
        if(Xp.getLevel() < this.level){
            Ui.println("You are not a high enough level. You need to be at least level " + this.level + ".");
            Action.pause();
            return;
        }

        //Get amount of ammo user wants
        Ui.println("How much ammo would you like to buy?");
        Ui.println("1 ammo cost " + this.ammoPrice + " coins.");
        Ui.println("You have " + Coins.get() + " coins.");
        int ammoToBuy = Action.getValidInt();
        int cost = ammoToBuy * ammoPrice;

        //Make sure player has enough coins
        if(Coins.get() < (cost)){
            Ui.println("You don't have enough coins. You need " + (cost - Coins.get()) + " more coins.");
            Action.pause();
            return;
        }

        this.ammo += ammoToBuy;
        Coins.set(-cost, true);
        Stats.coinsSpentOnWeapons += cost;

        Ui.println("You have bought " + ammoToBuy + " ammo.");
        Action.pause();
    }
    private static void noAmmo(){
        Ui.popup("You've run out of ammo!", "Warning", JOptionPane.WARNING_MESSAGE);
        Weapon.current = Weapon.starting;
    }
    public int getAmmoPrice(){
        return this.ammoPrice;
    }
}