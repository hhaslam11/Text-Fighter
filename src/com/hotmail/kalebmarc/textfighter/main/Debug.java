package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Settings;
import com.hotmail.kalebmarc.textfighter.player.Xp;

class Debug {

    private static boolean enabled = false;
    Debug(){}

    public static void enable(){
        Ui.println("Enabling debug menu..");
        enabled = true;
    }
    public static boolean enabled(){
        return enabled;
    }
    public static void menu(){

        //Validate
        if(!enabled()){
            return;
        }

        while(true){
            Action.cls();
            Ui.println("==================");
            Ui.println("=== DEBUG MENU ===");
            Ui.println();
            Ui.println("1) Coins");
            Ui.println("2) Xp");
            Ui.println("3) Weapon");
            Ui.println("4) First-Aid");
            Ui.println("5) Insta-health");
            Ui.println("6) Encounter new");
            Ui.println("7) God Mode");
            Ui.println("8)");
            Ui.println("9) Go back");
            switch(Action.getValidInt()){
                case 1:
                    Action.cls();
                    Ui.println("How much?");
                    Coins.set(Action.getValidInt(), false);
                    break;
                case 2:
                    Action.cls();
                    Ui.println("How much?");
                    Xp.set(Action.getValidInt(), false);
                    break;
                case 3:
                    for(int i = 0; i < Weapon.arrayWeapon.size(); i++){
                        Weapon.arrayWeapon.get(i).owns = true;
                    }
                    Power.set(100, true);
                    Weapon.setAmmo(10000, false);
                    Weapon.setSgAmmo(10000, false);
                    Ui.println("You now have all weapons");
                    Action.pause();
                    break;
                case 4:
                    Action.cls();
                    Ui.println("How much?");
                    FirstAid.set(Action.getValidInt(), false);
                    break;
                case 5:
                    Action.cls();
                    Ui.println("How much?");
                    InstaHealth.set(Action.getValidInt(), false);
                    break;
                case 6:
                    Enemy.encounterNew();
                    break;
                case 7:
                    Settings.toggleGodMode();
                    break;
                case 8:
                    break;
                case 9:
                    return;
            }
        }
    }
}
