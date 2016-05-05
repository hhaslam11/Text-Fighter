package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.player.*;

import java.util.Scanner;

public class Cheats {

    //Variables
	private static Scanner cheat = new Scanner(System.in);
	private static boolean enabled = false;
	private static boolean locked = false;

	public static void cheatGateway(){

		//Makes sure cheats aren't locked
		if(locked()){
			Action.cls();
			Ui.println("Cheats are locked off- You cannot use cheats!");
			Action.pause();
			return;
		}
		
		if (!enabled()){
			int confirm = Ui.confirmPopup("If you enable cheats, achievements and xp will be disabled. Are you sure you want to continue?", "Warning");
			if (confirm == 0){
				Xp.setAll(0, 0, 10);
				enable();
			}
		}
		if (enabled()) Cheats.cheatSelect();
	}
	private static void cheatSelect(){
		Ui.println("*");

        switch (cheat.nextLine()){
		case "moneylover":
			Coins.set(1000, false);
            Stats.timesCheated++;
			break;
		case "givemeitall":
			Coins.set(5000, false);
			FirstAid.set(5000, false);
			InstaHealth.set(5000, false);
			for(int i = 0; i <= Weapon.arrayWeapon.size(); i++){
				Weapon.arrayWeapon.get(i).setAmmo(5000, false);
			}
			Power.set(5000, false);
			for(int i = 0; i < Weapon.arrayWeapon.size(); i++){
                Weapon.arrayWeapon.get(i).owns = true;
            }
            Stats.timesCheated++;
			break;
		case "weaponstash":
			for(int i = 0; i <= Weapon.arrayWeapon.size(); i++){
				Weapon.get().setAmmo(5000, false);
			}

            Power.set(5000, false);
            for(int i = 0; i <= Weapon.arrayWeapon.size(); i++){
                Weapon.arrayWeapon.get(i).owns = true;
            }
            Stats.timesCheated++;
			break;
		case "nomorepain":
			FirstAid.set(1000, false);
			InstaHealth.set(500, false);
            Stats.timesCheated++;
			break;
		case "healme":
			Health.set(Health.getOutOf());
            Stats.timesCheated++;
			break;
		case "givemeachallange":
			Enemy.get().setHealth(1000, 1000);
            Stats.timesCheated++;
			break;
		case "lotsofkills":
			Stats.kills = 5000;
            Stats.timesCheated++;
			break;
		case "suicide":
			Health.set(0);
            Stats.timesCheated++;
			break;
		case "godmode":
			Settings.toggleGodMode();
            Stats.timesCheated++;
			break;
		case "loanshark":
			Loan.setCurrentLoan(0);
            Loan.setNetDue(0);
			break;
		}
	}
    public static boolean enabled(){
        return enabled;
    }
    public static boolean locked(){
        return locked;
    }
    public static void enable(){
        enabled = true;
    }
    public static void lock(){
        locked = true;
    }
}