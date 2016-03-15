package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.Armour;
import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

class Shop{
    private Shop(){}

    public static void menu() {
        while (true) {
            Action.cls();
			Ui.println("-------------------------------------------------------------------");
			Ui.println("                        Welcome to the shop!                       ");
			Ui.println();
			Ui.println("Coins: " + Coins.get());
			Ui.println("First-Aid kits: " + FirstAid.get());
			Ui.println();
			Ui.println("-------------------------------------------------------------------");
			Ui.println("1) Health");
			Ui.println("2) Weapons/Ammo");
            Ui.println("3) Body Armour");
			Ui.println("4) XP");
			Ui.println("5) Back");
			Ui.println("-------------------------------------------------------------------");
			switch(Action.getValidInt()){
			    case 1:
				    health();
				    break;
			    case 2:
    				weapons();
	    			break;
                case 3:
                    armour();
                    break;
		    	case 4:
			    	xp();
				    break;
			    case 5:
				    return;
			    default:
				    break;
			}
        }
    }
    private static void health(){

        while(true){
            Action.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                               Health                              ");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("First-Aid kits: " + FirstAid.get());
            Ui.println("Insta-Healths: " + InstaHealth.get());
            Ui.println();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("1) FIRST-AID KIT");
            Ui.println("   Price - " + FirstAid.price + " coins");
            Ui.println("   Level - " + FirstAid.level);
            Ui.println();
            Ui.println("2) INSTA-HEALTH");
            Ui.println("   Price - " + InstaHealth.price + " coins");
            Ui.println("   Level - " + InstaHealth.level);
            Ui.println();
            Ui.println("3) Back");
            Ui.println("-------------------------------------------------------------------");
            switch(Action.getValidInt()){
                case 1:
                    FirstAid.buy();
                    break;
                case 2:
                    InstaHealth.buy();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }
    }
    private static void weapons(){
        while(true) {
            Action.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                              Weapons                              ");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("Level: " + Xp.getLevel());
            Ui.println();
            Ui.println("-------------------------------------------------------------------"); 
            int j = 0;
            for(int i = 0; i < Weapon.arrayWeapon.size(); i++){
                if(Weapon.arrayWeapon.get(i).isBuyable()){
                    Ui.println((j + 1) + ") " + Weapon.arrayWeapon.get(i).getName());
                    Ui.println("   Price: " + Weapon.arrayWeapon.get(i).price);
                    Ui.println("   Level: " + Weapon.arrayWeapon.get(i).level);
                    j++;
                    Ui.println();
                }
            }
            Ui.println((Weapon.arrayWeapon.size() + 1) + ") POWER");
            Ui.println("   Price: " + Power.price);
            Ui.println("   Level: " + Power.level);
            Ui.println();
            Ui.println((Weapon.arrayWeapon.size() + 2) + ") AMMO");
            Ui.println();
            Ui.println((Weapon.arrayWeapon.size() + 3) + ") Back");


            while(true) {//Make it easy to break, without going back to main store menu

                int menuItem = Action.getValidInt();

                try { //This is probably pretty bad practice. Using exceptions as a functional part of the program.. Use variables!

                    Weapon.arrayWeapon.get(menuItem - 1).buy();
                    break;

                } catch (Exception e) {

                    if (menuItem == (Weapon.arrayWeapon.size() + 1)) {
                        Power.buy();
                        break;
                    }
                    if (menuItem == (Weapon.arrayWeapon.size() + 2)) {
                        buyAmmo();
                        break;
                    }
                    if (menuItem == (Weapon.arrayWeapon.size() + 3)) {
                        return;
                    }
                    Ui.println();
                    //if (menuItem == (Weapon.arrayWeapon.size() + 2)) return; TODO I don't remember why this line was here. Doesn't seem like it would do anything?
                    Ui.println(menuItem + " is not an option.");
                }
            }
        }
    }
    private static void xp(){

		//Makes sure player has enough money
		boolean valid;

		while(true){

            //Makes sure player isn't level 10 already
            if(Xp.getLevel() == 100){
                Action.cls();
                Ui.println("You're already level 100! You cannot buy any more xp.");
                Action.pause();
                return;
            }

            Action.cls();
			Ui.println("-------------------------------------------------------------------");
			Ui.println("                                 XP                                ");
			Ui.println();
			Ui.println("Level: " + Xp.getLevel());
			Ui.println("XP: " + Xp.getFull());
			Ui.println("Coins: " + Coins.get());
			Ui.println();
			Ui.println("You can buy XP for 1 coin per XP. How much would you like to buy?");
			Ui.println("**Enter 0 to go back**");
			Ui.println("-------------------------------------------------------------------");

			int buy = Action.getValidInt();
			valid = true;

			//Tests
			if (buy > Coins.get()){
				//Not enough coins
				Action.cls();
				Ui.println("You don't have enough coins to buy this much xp.");
				valid = false;
				Action.pause();
			}
            if (Xp.getLevel() == 100){
                Action.cls();
                Ui.println("You are already level 100; which is the maximum level.");
                valid = false;
                Action.pause();
            }
			if (buy < 0){
				Action.cls();
				Ui.println("You can't buy a negative amount of Xp.. Nice try though ;)");
				valid = false;
				Action.pause();
			}
			if (buy == 0){
				return;
			}

			if (valid){
				Action.cls();
				Ui.println("You have bought " + buy + " xp.");
				Action.pause();

				//Results
				Xp.set(buy, true);
				Coins.set(-buy, true);
                Stats.xpBought += buy;
            }

		}
	}
    private static void buyAmmo(){


        while(true) {
            Action.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                                Ammo                               ");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("Level: " + Xp.getLevel());
            Ui.println();
            Ui.println("-------------------------------------------------------------------");
            for(int i = 0; i < Weapon.arrayWeapon.size(); i++){
                if(Weapon.arrayWeapon.get(i).melee){
                    Ui.println((i + 1) + ") [NOT AVAILABLE FOR PURCHASE]");//TODO Make it so it just skips (A4.9)
                }else{
                    Ui.println((i + 1) + ") " + Weapon.arrayWeapon.get(i).getName());
                    Ui.println("   Price: " + Weapon.arrayWeapon.get(i).getAmmoPrice());
                    Ui.println("   Level: " + Weapon.arrayWeapon.get(i).level);
                }
                Ui.println();
            }
            Ui.println((Weapon.arrayWeapon.size() + 1) + ") Back");

            while(true) {//Make it easy to break, without going back to main store menu

                int menuItem = Action.getValidInt();

                try { //This is probably pretty bad practice. Using exceptions as a functional part of the program.. Use variables!
                    Weapon.arrayWeapon.get(menuItem - 1).buyAmmo();
                    break;
                } catch (Exception e) {

                    if (menuItem == (Weapon.arrayWeapon.size() + 1)) {
                        return;
                    }
                    Ui.println();
                    Ui.println(menuItem + " is not an option.");
                    Action.pause();
                    Action.cls();
                }
            }
        }
    }
    private static void armour(){
        while(true) {
            Action.cls();
            Ui.println("-------------------------------------------------------------------");
            Ui.println("                            Body Armour                            ");
            Ui.println();
            Ui.println("Coins: " + Coins.get());
            Ui.println("Level: " + Xp.getLevel());
            Ui.println();
            Ui.println("-------------------------------------------------------------------");
            for(int i = 1; i < Armour.getArmours().size(); i++){
                if(Armour.getArmours().get(i).getPrice() == 0){
                    Ui.println((i) + ") [NOT AVAILABLE FOR PURCHASE]");//TODO Make it so it just skips (A4.9)
                }else{
                    Ui.println((i) + ") " + Armour.getArmours().get(i).getName());
                    Ui.println("   Price: " + Armour.getArmours().get(i).getPrice());
                    Ui.println("   Level: " + Armour.getArmours().get(i).getLevel());
                }
                Ui.println();
            }
            Ui.println((Armour.getArmours().size()) + ") Back");

            while(true) {//Make it easy to break, without going back to main store menu

                int menuItem = Action.getValidInt();

                try { //This is probably pretty bad practice. Using exceptions as a functional part of the program.. Use variables!

                    Armour.getArmours().get(menuItem).buy();
                    break;

                } catch (Exception e) {
                    if (menuItem == (Armour.getArmours().size())) {
                        return;
                    }
                    Ui.println();
                    Ui.println(menuItem + " is not an option.");
                }
            }
        }
    }
}