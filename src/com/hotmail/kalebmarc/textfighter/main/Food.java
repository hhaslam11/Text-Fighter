package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Health;

import java.util.ArrayList;

/* TODO
 * - Way to obtain
 * - Way to eat
 * - Way to see in inv
 */
public class Food {

    private String name;
    private String desc;
    private int quantity;
    private EffectType statusEffect;
    private int effectLevel;

    //for ach
    private boolean viewedAbout;

    //Weapon List
    public static final ArrayList<Food> arrayFood = new ArrayList<>();

    public Food(String name, String desc, EffectType statusEffect, int effectLevel){
        this.name = name;
        this.desc = desc;
        this.statusEffect = statusEffect;
        this.effectLevel = effectLevel;
        arrayFood.add(this);
    }
    public String getName(){
        return this.name;
    }
    public int getEffectLevel(){
        return effectLevel;
    }
    public EffectType getStatusEffect(){
        return statusEffect;
    }
    public int getQuantity(){
        return quantity;
    }
    public void eat(){
        Ui.cls();
        Ui.println("You have ate a " + getName());
        Ui.println("You've gained " + effectLevel + " " + statusEffect.toString() + "points.");
        Ui.pause();

        switch(this.statusEffect){
            case HEALTH:
                Health.gain(this.effectLevel);
                break;
            case STRENGTH:
                break;
            case STANIMA:
                break;
            case ACCURACY:
                break;
            case LUCK:
                break;
        }

    }
    public void viewAbout(){

        final int BORDER_LENGTH = 39;

        //End of food Info
        Ui.cls();
        for(int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//draw line
        Ui.println();
        for(int i = 0; i < ((BORDER_LENGTH / 2) - (this.getName().length() / 2)); i++) Ui.print(" ");//Set correct spacing to get name in middle of box
        Ui.println(this.getName());
        Ui.println(this.desc);
        Ui.println("Status effect type: " + this.statusEffect.toString());
        Ui.println("Status effect level: " + this.getEffectLevel());
        for(int i = 0; i < BORDER_LENGTH; i++) Ui.print("-");//draw line
        Ui.pause();
        Ui.cls();
        //End of food info
        this.setViewed(true);
    }
    public boolean viewedAbout(){
        return this.viewedAbout;
    }
    public void setViewed(boolean v){
        this.viewedAbout = v;
    }
}