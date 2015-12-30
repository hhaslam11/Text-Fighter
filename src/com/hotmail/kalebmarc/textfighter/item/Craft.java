package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Action;
import com.hotmail.kalebmarc.textfighter.main.Game;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.main.Weapon;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

public class Craft {
	private Craft(){}

	public static int LEVEL = 0;

	public static void menu(){
		
		while(true){
			
			
			//Makes sure your level x, if not, exits crafting menu
			if(Xp.getLevel() < LEVEL){
				Action.cls();
				Ui.println("You need to be at least level " + LEVEL + " to craft!");
				Action.pause();
				return;
			}
			
			Action.cls();
			Ui.println("----------------------------");
			Ui.println("          CRAFTING          ");
			Ui.println();
			Ui.println("1) Shotgun ammo (1)");
			Ui.println("   - Needs 7 ammo (You have " + Weapon.getAmmo() + " ammo.)");
			Ui.println("2) Rifle with knife");
			Ui.println("   - Needs rifle and knife");
			Ui.println("3) Back");
			Ui.println("----------------------------");
			
			switch(Action.getValidInt()){
			case 1:
				craftShotgunAmmo();
				break;
			case 2:
				craftRifleWithKnife();
				break;
			case 3:
				return;
			}	
		}
	}
	private static void craftShotgunAmmo(){
		Action.cls();
		if (Weapon.getAmmo() >= 7){
			Weapon.setAmmo(-7, true);
			Weapon.setSgAmmo(1, true);
			Stats.itemsCrafted++;
			Ui.println("You've crafted 1 shotgun bullet using 7 ammo.");
			Action.pause();
		}else{
			Ui.println("You don't have enough ammo to craft this!");
			Action.pause();
		}
	}
	private static void craftRifleWithKnife(){
		Action.cls();
		if (Game.rifle.owns && Game.knife.owns && !Game.rifleWithKnife.owns){
			Game.rifle.owns = false;
			Game.knife.owns = false;
			Game.rifleWithKnife.owns = true;
			Weapon.set(Game.rifleWithKnife);
			Stats.itemsCrafted++;
			Ui.println("You've crafted a rifle with knife using a rifle and a knife.");
			Action.pause();
		}else{
			Ui.println("Cannot craft rifle with knife.");
			Action.pause();
		}
	}
}