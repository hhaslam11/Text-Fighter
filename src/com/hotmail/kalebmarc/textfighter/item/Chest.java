package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Action;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.main.Weapon;
import com.hotmail.kalebmarc.textfighter.player.Coins;

public class Chest {
	private Chest(){}
	public static void view(){
		
		Action.cls();
		Ui.println("------------------------------");
		Ui.println("          Item Chest          ");
		Ui.println();
		Ui.println("First-Aid kits: " + FirstAid.get());
		Ui.println("Insta-Healths: " + InstaHealth.get());
		Ui.println("Coins: " + Coins.get());
		Ui.println("POWERS: " + Power.get());
		for(int i = 0; i < Weapon.arrayWeapon.size(); i++){
            Ui.println(Weapon.arrayWeapon.get(i).getName() + ": " + Weapon.arrayWeapon.get(i).owns());
        }
		Ui.println("Ammo: " + Weapon.getAmmo());
		Ui.println("Shotgun ammo: " + Weapon.getSgAmmo());
		Ui.println();
		Ui.println("------------------------------");
		Action.pause();
		
	}
}