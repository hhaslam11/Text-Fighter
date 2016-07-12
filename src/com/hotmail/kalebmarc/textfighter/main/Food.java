package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Health;

/* TODO
 * - Way to obtain
 * - Way to eat
 * - Way to see in inv
 * - Dynamic help pages
 * - Make effects actually do something
 */
public class Food {

    private String name;
    private int quantity;
    private EffectType statusEffect;
    private int effectLevel;

    public Food(String name, EffectType statusEffect, int effectLevel){
        this.name = name;
        this.statusEffect = statusEffect;
        this.effectLevel = effectLevel;
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
}