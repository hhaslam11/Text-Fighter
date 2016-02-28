package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Action;
import com.hotmail.kalebmarc.textfighter.main.Handle;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Xp;

import java.util.ArrayList;

public class Armour {

    private String  name;
    private int     price;
    private int     damResist;//x%
    private int     level;
    private boolean owns;
    private boolean equipped;
    private boolean viewed;
    private static  ArrayList<Armour> armours = new ArrayList<>(3);

    public Armour(String name, int price, int damResist, int level){
        this.name      = name;
        this.price     = price;
        this.damResist = damResist;
        this.level     = level;
        armours.add(this);
    }
    public void setName(String name){
        if(name.equals("")) return;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    public void setDamResist(int damResist){
        this.damResist = damResist;
    }
    public int getDamResist(){
        return this.damResist;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return this.level;
    }
    public void setOwns(boolean owns) {
        this.owns = owns;
    }
    public boolean isOwns(){
        return this.owns;
    }
    public boolean isEquipped(){
        return this.equipped;
    }
    public void equip(){
        if(!(this.owns)){
            Action.cls();
            Ui.println("You do not own this.");
            Action.pause();
            return;
        }

        this.equipped = true;//To make sure something is already equipped
        getEquipped().unequip();
        this.equipped = true;
        Action.cls();
        Ui.println("You have equipped " + this.toString());
        Action.pause();
    }
    public void equipSilent(){
        if(!(this.owns)){
            return;
        }
        this.equipped = true;//To make sure something is already equipped
        getEquipped().unequip();
        this.equipped = true;
    }
    public void unequip(){
        this.equipped = false;
    }
    public static Armour getEquipped(){
        for(Armour i : armours){
            if(i.isEquipped()) return i;
        }
        Handle.error("Error - No armour equipped");
        return null;
    }
    public static ArrayList<Armour> getArmours(){
        return armours;
    }
    public String toString(){
        if(this.getName().equals("None")) return "No armour";
        return this.getName() + " armour";
    }
    public boolean buy(){
        if(Xp.getLevel() < this.getLevel()){
            Ui.println("You have to be at least level " + this.getLevel() + " to buy this!");
            Action.pause();
            return false;
        }else if (this.isOwns()) {
            Ui.println("You already own this.");
            Action.pause();
            return false;
        }else if(this.getPrice() <= Coins.get()){
            Coins.set(-this.price, true);
            setOwns(true);
            equip();
            Ui.println("Thank you for your purchase. Come again soon! ");
            Action.pause();
            return true;
        }else{
            Ui.println("You do not have enough coins.");
            Action.pause();
            return false;
        }
    }
    public static int get(){
        return armours.indexOf(getEquipped());
    }
    public static void set(int i){
        armours.get(i).equipped = true;
    }
    public void viewAbout(){

        final int BORDER_LENGTH = 39;

        //Start of armour Info
        Action.cls();
        for(int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//Make line
        Ui.println();
        for(int i = 0; i < ((BORDER_LENGTH / 2) - (this.getName().length() / 2)); i++) Ui.print(" ");//Set correct spacing to get name in middle of box
        Ui.println(this.toString());
        Ui.println("Price: " + this.price + " coins");
        Ui.println("Damage Resistance(%): " + this.damResist + "%");
        Ui.println("Level needed: " + this.level);
        for(int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//Make line
        Action.pause();
        Action.cls();
        //End of armour Info
        this.setViewed(true);
    }
    public void setViewed(boolean viewed){
        this.viewed = viewed;
    }
    public boolean getViewed(){
        return this.viewed;
    }
    public static void choose(){
        while(true) {
            Action.cls();
            Ui.println("----------------------------");
            Ui.println("Equip new armour");
            Ui.println();
            Ui.println("Equipped: " + getEquipped().toString());
            Ui.println("----------------------------");
            for(int i = 0; i < getArmours().size(); i++){
                if(!getArmours().get(i).isOwns()){
                    Ui.println((i + 1) + ") " + getArmours().get(i).getName().toUpperCase() + " IS NOT AVAILABLE");
                }else{
                    Ui.println((i + 1) + ") " + getArmours().get(i).getName());
                }
            }

            //Get valid weapon index
            int choice;
            do{
                choice  = Action.getValidInt() - 1;
            }while(choice < 0 || choice > getArmours().size());

            //Equip if player has the selected weapon
            if(getArmours().get(choice).isOwns()){
                getArmours().get(choice).equip();
                return;
            }else{
                Action.cls();
                Ui.println("You don't have this armour.");
                Action.pause();
            }
        }
    }
}
