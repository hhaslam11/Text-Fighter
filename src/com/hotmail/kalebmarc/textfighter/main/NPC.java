package com.hotmail.kalebmarc.textfighter.main;

//import Quest;

public class NPC {
    
    private static String name;
    private static String shop;

    private static final String NAME_HEALTH = "Corinna";
    private static final String NAME_WEAPON = "Niel";
    private static final String NAME_XP     = "Halette";
    private static final String NAME_ARMOUR = "Leon";


    public NPC(){}
    
    public static String getName(String type){
        switch(type.toLowerCase()){
            case "health":
                name = "Corinna";
                break;
            case "weapon":
                name = "Niel";
                break;
            case "xp":
                name = "Halette";
                break;
            case "armour":
                name = "Leon";
                break;
            default:
                name = "This shop does not exist.";
                break;
        }
        return name;
    }
    
    public static String getShop(String npc){
        switch(npc.toLowerCase()){
            case "corinna":
                shop = "Health";
                break;
            case "niel":
                shop = "Weapon";
                break;
            case "halette":
                shop = "XP";
                break;
            case "leon":
                shop = "Armour";
                break;
            default:
                shop = "This NPC does not exist.";
        }
        return shop;
    }
    
    public static void setName(String npc){
        name = npc;
    }
    
    public static void setShop(String type){
        shop = type;
    }
    
    public static void welcome(String type){
        Ui.println(getName(type) + ": \n\tWelcome to the " + type + " shop.");
        Ui.println("\tHow can I help you today?");
    }
    
    public static void gratitude(String shop, String type){
        if(type.toLowerCase().equals("purchase")){
            Ui.println(getName(shop) + ": \nThank you for your purchase.");
        }
        
    }
    
    public boolean hasQuests(){
        return Quest.checkQuestsForNPC(name);
    }

}
