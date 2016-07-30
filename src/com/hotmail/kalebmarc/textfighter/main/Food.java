package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Health;

import java.util.ArrayList;

public class Food {

    private String name;
    private String desc;
    private int quantity = 3;
    private StatusEffect.type statusEffect;
    private int effectLevel;
    private type foodType;

    //for ach
    private boolean viewedAbout;

    //Weapon List
    public static final ArrayList<Food> arrayFood = new ArrayList<>();

    public Food(String name, String desc, StatusEffect.type statusEffect, type foodType, int effectLevel){
        this.name = name;
        this.desc = desc;
        this.statusEffect = statusEffect;
        this.foodType = foodType;
        this.effectLevel = effectLevel;
        arrayFood.add(this);
    }
    public String getName(){
        return this.name;
    }
    public int getEffectLevel(){
        return effectLevel;
    }
    public StatusEffect.type getStatusEffect(){
        return statusEffect;
    }
    public int getQuantity(){
        return quantity;
    }
    public void eat(){
        Ui.cls();


        if(Health.get() == Health.getOutOf()){

        }

        Ui.println("You have ate a " + getName());
        Ui.println("You've gained " + effectLevel + " " + statusEffect.toString() + " points.");
        this.quantity--;
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
        Ui.println("Category: " + this.foodType.toString());
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
    public static void list(){

        while(true) {
            Ui.cls();
            int j = 0;
            int[] offset = new int[arrayFood.size()];
            for(int i = 0; i < arrayFood.size(); i++){
                if(arrayFood.get(i).quantity > 0){
                    Ui.println((j + 1) + ") " + arrayFood.get(i).getName() + "(" + arrayFood.get(i).quantity + ")");
                    offset[j] = i - j;
                    j++;
                }
            }
            Ui.println((j + 1) + ") Back");

            //Get valid food index
            int choice = 0;
            do{
                choice  = Ui.getValidInt() - 1 + offset[choice];
            }while(choice < 0 || choice > arrayFood.size());

            //Eat if player has the selected food
            if(choice >= arrayFood.size())//Does this even do anything?? Do while loop should prevent this.
                return;

            //TODO once more status effects are implimented, use a switch here if appropiate.
            if(arrayFood.get(choice).getStatusEffect() == StatusEffect.type.HEALTH && Health.get() == Health.getOutOf()){
                Ui.cls();
                Ui.println("Your health is already full. No need to eat this!");
                Ui.pause();
                return;
            }

            if(arrayFood.get(choice).quantity > 0){
                arrayFood.get(choice).eat();
                return;
            }else{
                Ui.cls();
                Ui.println("You don't have this food.");
                Ui.pause();
            }

        }
        
    }
    public static enum type{
        MEAT_FISH,
        MEAT_OTHER,
        FRUIT,
        OTHER;

        @Override
        public String toString() {
            String effectString = super.toString();
            effectString = effectString.replace("_", " ");
            effectString = effectString.replace("MEAT", "");
            effectString = effectString.trim();
            return effectString.substring(0, 1) + effectString.substring(1).toLowerCase();
        }
    }
}

