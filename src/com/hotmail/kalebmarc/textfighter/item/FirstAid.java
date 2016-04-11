package com.hotmail.kalebmarc.textfighter.item;

import com.hotmail.kalebmarc.textfighter.main.Action;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Health;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

public class FirstAid {
	private FirstAid(){}
	
	private static int firstAid;
	public static int used = 0;
        public static int price;
        public static int level;

	public static int get(){
		return firstAid;
	}
	public static void set(int amount, boolean add){
		if(!add){
			firstAid = amount;
		}else{
			firstAid += amount;
			if (firstAid < 0) firstAid = 0;
		}
	}
	public static void use(){
		
		Action.cls();
		
		if(get() <= 0){
			
			Ui.println("----------------------------------------------------");
			Ui.println("You have no First-Aid kits left!");
			Ui.println("Go to the shop to buy some more.");
			Ui.println("----------------------------------------------------");
			Action.pause();
			
		}else if(Health.get() == 100){
						
			Ui.println("----------------------------------------------------");
			Ui.println("You already have full health!");
			Ui.println("You don't need a First-Aid kit!");
			Ui.println("----------------------------------------------------");
			Ui.println("Your health: " + Health.getStr());
			Ui.println("First-Aid kits: " + get());
			Ui.println("----------------------------------------------------");
			Action.pause();
			
		}else{
			
			set(-1, true);
			Health.gain(20);
			used++;

			Ui.println("----------------------------------------------------");
			Ui.println("You have used a First-Aid kit.");
			Ui.println("You've gained 20 health.");
			Ui.println("----------------------------------------------------");
			Ui.println("Your health: " + Health.getStr());
			Ui.println("First-Aid kits: " + get());
			Ui.println("----------------------------------------------------");
			Action.pause();
			
		}
		
	}
	public static void buy(){
        if(Xp.getLevel() < level){
			Ui.println("You have to be at least level " + level + " to buy this!");
			Action.pause();
		}else if(price <= Coins.get()){
			Coins.set(-price, true);
			Stats.coinsSpentOnHealth += price;
			set(1, true);
			Ui.println("Thank you for your purchase. Come again soon! ");
			Action.pause();
		}else{
			Ui.println("You do not have enough coins.");
			Action.pause();
		}
    }
}
