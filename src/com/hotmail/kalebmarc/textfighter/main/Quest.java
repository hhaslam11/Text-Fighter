package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.Armour;
import com.hotmail.kalebmarc.textfighter.player.Xp;
import java.util.ArrayList;

public class Quest {
    
    //NPC that provides the quest
    private String host;
    
    //Rewards
    private int coinRewardMin;
    private int coinRewardMax;
    private int xpRewardMin;
    private int xpRewardMax;
    private int healthRewardMin;
    private int healthRewardMax;
    
    //Available Armour/Weapon reward for Quest
    private final ArrayList<Armour> rewardArmor = new ArrayList<>();
    private final ArrayList<Weapon> rewardWeapon = new ArrayList<>();
    
    //Requirements
    private int minLevelReq;
    private boolean completed;
    private boolean available;
    
    private static final ArrayList<Quest> QuestList = new ArrayList<>();

    public Quest (String host, int coinMin, int coinMax, int xpMin, int xpMax, 
                    int healthMin, int healthMax,int minLevel, boolean complete, boolean avail){
        
        this.host = host;
        this.coinRewardMin = coinMin;
        this.coinRewardMax = coinMax;
        this.xpRewardMin = xpMin;
        this.xpRewardMax = xpMax;
        this.healthRewardMin = healthMin;
        this.healthRewardMax = healthMax;
        this.minLevelReq = minLevel;
        this.completed = complete;
        this.available = avail; 
        QuestList.add(this);
    }
    public static boolean checkQuestsForNPC(String npcName){
        boolean check = false;
        int i = 0;
        do{
            if(QuestList.get(i).host.equalsIgnoreCase(npcName)){
                if(QuestList.get(i).getMinLevelReq() <= Xp.getLevel()){
                    if(QuestList.get(i).getAvailable())
                        check = !QuestList.get(i).getComplete();
                }
            }
            
            i++;
           
        }while((i < QuestList.size()) || (check));
        return check;
    }
    
    public int getMinLevelReq(){
        return minLevelReq;
    }
    
    public boolean getComplete(){
        return completed;
    }
    
    public boolean getAvailable(){
        return available;
    }
}
