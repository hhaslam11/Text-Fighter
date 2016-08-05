package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.Armour;
import com.hotmail.kalebmarc.textfighter.player.Ach;

class Help {
	private Help() {
	}

	public static void view() {
		while (true) {
			Ui.cls();
			Ui.println("------------------------------------------------------------");
			Ui.println("                         HELP MENU                          ");
			Ui.println("Here you can find (almost) all the information you need to");
			Ui.println("know about Text-Fighter.");
			Ui.println("------------------------------------------------------------");
			Ui.println("1) Enemy");
			Ui.println("2) Armour");
			Ui.println("3) Weapon");
			Ui.println("4) Health");
			Ui.println("5) Food");
			Ui.println("6) XP");
			Ui.println("7) Cheats");
			Ui.println("8) Achievements");
			Ui.println("9) Back");
			Ui.println("------------------------------------------------------------");
			switch (Ui.getValidInt()) {
				case 1:
					info_enemy();
					break;
				case 2:
					info_armour();
					break;
				case 3:
					info_weapons();
					break;
				case 4:
					info_health();
					break;
				case 5:
					info_food();
					break;
				case 6:
					info_xp();
					break;
				case 7:
					info_cheats();
					break;
				case 8:
					info_achs();
					break;
				case 9:
					return;
			}
		}
	}

	private static void info_enemy() {
		while (true) {
			Ui.cls();
			Ui.println("------------------------------------------------------------");
			Ui.println("                         ENEMY INFO                         ");
			Ui.println("Which enemy would you like to know about?");
			Ui.println();
			for (int i = 0; i < Enemy.arrayEnemy.size(); i++) {
				Ui.println((i + 1) + ") " + Enemy.arrayEnemy.get(i).getName());
            }
            Ui.println((Enemy.arrayEnemy.size() + 1) + ") Back");
			Ui.println("------------------------------------------------------------");

            int menuItem = Ui.getValidInt();

			try {
				Enemy.arrayEnemy.get(menuItem - 1).viewAbout();
			} catch (Exception e) {
				if (menuItem == (Enemy.arrayEnemy.size() + 1)) return;
				Ui.println(menuItem + " is not an option.");
                Ui.pause();
            }
		}
	}

	private static void info_armour() {
		//Start of armour info
		while (true) {
			Ui.cls();
			Ui.println("--------------------------------------------------");
			Ui.println("                    ARMOUR INFO                   ");
			Ui.println("Which armour type would you like to know about?");
			Ui.println();
			for (int i = 0; i < Armour.getArmours().size(); i++) {
				Ui.println((i + 1) + ") " + Armour.getArmours().get(i).getName());
			}
			Ui.println((Armour.getArmours().size() + 1) + ") Back");
			Ui.println("--------------------------------------------------");

			int menuItem = Ui.getValidInt();

			try {
				Armour.getArmours().get(menuItem - 1).viewAbout();
			} catch (Exception e) {
				if (menuItem == (Armour.getArmours().size() + 1)) return;
				Ui.println(menuItem + " is not an option.");
				Ui.pause();
			}
		}
		//End of armour info
	}

	private static void info_weapons() {
		while (true) {
			Ui.cls();
            Ui.println("------------------------------------------------------------");
            Ui.println("                         WEAPON INFO                        ");
            Ui.println("Which weapon would you like to know about?");
            Ui.println();
			for (int i = 0; i < Weapon.arrayWeapon.size(); i++) {
				Ui.println((i + 1) + ") " + Weapon.arrayWeapon.get(i).getName());
            }
            Ui.println((Weapon.arrayWeapon.size() + 1) + ") Back");
            Ui.println("------------------------------------------------------------");

            int menuItem = Ui.getValidInt();

			try {
				Weapon.arrayWeapon.get(menuItem - 1).viewAbout();
			} catch (Exception e) {
				if (menuItem == (Weapon.arrayWeapon.size() + 1)) return;
				Ui.println(menuItem + " is not an option.");
                Ui.pause();
            }
        }
    }

	private static void info_health() {
		Ui.cls();
		Ui.println("------------------------------------------------------------");
		Ui.println("                        HEALTH INFO                         ");
		Ui.println("You will start off with 100 health, and you can upgrade your");
		Ui.println("health up to 200. Each upgrade will cost 100 coins on easy, ");
		Ui.println("and 150 coins on hard; and it will upgrade your health by 10.");
		Ui.println("You will be able to upgrade once per level.");
		//TODO Add more health info
		Ui.println("------------------------------------------------------------");
		Ui.pause();
		Ach.viewedHealth = true;
	}

	private static void info_food() {
		while (true) {
			Ui.cls();
			Ui.println("------------------------------------------------------------");
			Ui.println("                          FOOD INFO                         ");
			Ui.println("Which food would you like to know about?");
			Ui.println();
			for (int i = 0; i < Food.arrayFood.size(); i++) {
				Ui.println((i + 1) + ") " + Food.arrayFood.get(i).getName());
			}
			Ui.println((Food.arrayFood.size() + 1) + ") Back");
			Ui.println("------------------------------------------------------------");

			int menuItem = Ui.getValidInt();

			try {
				Food.arrayFood.get(menuItem - 1).viewAbout();
			} catch (Exception e) {
				if (menuItem == (Food.arrayFood.size() + 1)) return;
				Ui.println(menuItem + " is not an option.");
				Ui.pause();
			}
		}
	}

	private static void info_xp() {
		Ui.cls();
		Ui.println("------------------------------------------------------------");
		Ui.println("                              XP                            ");
		Ui.println("Getting XP levels you up, which unlocks more items to buy.  ");
		Ui.println("You start on level one, and you can get up to level 100.    ");
		Ui.println("You need more and more XP for each level. You start needing ");
		Ui.println("only 500 XP to reach level two, then each level you need 500");
		Ui.println("more. So you need 1000 for level 3, 1500 for level 4, etc.  ");
		Ui.println("Each time you level up, your XP gets reset back to 0. You   ");
		Ui.println("get an achievement for each level you reach up to level 10. ");
		Ui.println("You will also receive 100 coins (or 250 coins when you get  ");
		Ui.println("to level 10) Although you can get up to level 100, once you ");
		Ui.println("get to level 10, there's nothing else to unlock.");
		Ui.println();
		Ui.println("How to get XP..");
		Ui.println("There's a few different ways that you can get XP. The main   ");
		Ui.println("way you get XP is by fighting enemies. For every point of   ");
		Ui.println("damage you deal to an enemy, you get 1 XP. Another way is by");
		Ui.println("buying it. You can buy 1 XP for 1 coin. (You can buy as much");
		Ui.println("as you like/as much as you can afford). You will also get   ");
		Ui.println("100 XP for each achievement you unlock. Using a POWER will  ");
		Ui.println("give you 20 XP");
		Ui.println("------------------------------------------------------------");
		Ui.pause();
		Ach.viewedXP = true;
	}

	private static void info_cheats() {
		Ui.cls();
		Ui.println("------------------------------------------------------------------------");
		Ui.println("                            CHEATS                          ");
		Ui.println("To use a cheat code, make sure to be in the main game menu, ");
		Ui.println("then enter '0'. A star (*) should appear to indicate that   ");
		Ui.println("you can type in a cheat code.                               ");
		Ui.println("WARNING: Using cheats will disable all achievements and the ");
		Ui.println("XP system.                                                  ");
		Ui.println("*Tip: You can lock cheats off in the settings menu to       ");
		Ui.println("      prevent the use of cheats                             ");
		Ui.println();
		Ui.println("List of cheat codes:");
		Ui.println("   Code             | Description");
		Ui.println("                    |            ");
		Ui.println("   moneylover       | Gives you 1000 coins");
		Ui.println("   givemeitall      | Gives you 5000 of every item + all weapons");
		Ui.println("   weaponstash      | Gives you every weapon, and 5000 ammo");
		Ui.println("   nomorepain       | Gives you 1000 First-Aid kits and 500 Insta-Healths");
		Ui.println("   healme           | Sets your health to 100");
		Ui.println("   givemeachallenge | Gives enemy 1000 health");
		Ui.println("   lotsofkills      | Sets kill-streak to 5000");
		Ui.println("   suicide          | Kills you");
		Ui.println("   godmode          | Never dies");
		Ui.println("   loanshark        | Removes current loan");
		Ui.println("------------------------------------------------------------------------");
		Ui.pause();
		Ach.viewedCheats = true;
	}

	private static void info_achs() {
		Ui.cls();
		Ui.println("-------------------------------------------------------------------------");
		Ui.println("                         ACHIEVEMENTS                       ");
		Ui.println("You are rewarded 100 xp for each achievement you get. ");
		Ui.println("If you get all achievements, you will be rewarded with 2500 ");
		Ui.println("coins.");
		Ui.println("");
		Ui.println("List of achievements: ");
		Ui.println("   Achievement            | Description");
		Ui.println("                          | ");
		Ui.println("   Money Maker            | Get 1500 coins");
		Ui.println("   Enemy Slayer           | Kill a total of 100 enemies");
		Ui.println("   First Kill             | Kill one enemy");
		Ui.println("   Time For An Upgrade    | Buy any weapon from the shop");
		for (int i = 0; i < Enemy.arrayEnemy.size(); i++) {
			Ui.print("   Goodbye, " + Enemy.arrayEnemy.get(i).getName());
            for (int x = 0; x < (14 - Enemy.arrayEnemy.get(i).getName().length()); x++) Ui.print(" ");
            Ui.println("| Kill a " + Enemy.arrayEnemy.get(i).getName());

        }
		Ui.println("   Text-Fighter Master    | Get all other achievements");
		Ui.println("   Yay, POWER!            | Use 5 POWERS");
		Ui.println("   Slayer                 | Deal a total of 1000 damage");
		Ui.println("   Nobody's Perfect       | Die");
		Ui.println("   Making Money           | Win 1000 coins altogether in the Casino");
		Ui.println("   Gambling Addiction     | Complete 75 rounds in the Casino");
		Ui.println("   Level 2 Fighter        | Reach level 2");
		Ui.println("   Level 3 Fighter        | Reach level 3");
		Ui.println("   Level 4 Fighter        | Reach level 4");
		Ui.println("   Level 5 Fighter        | Reach level 5");
		Ui.println("   Level 6 Fighter        | Reach level 6");
		Ui.println("   Level 7 Fighter        | Reach level 7");
		Ui.println("   Level 8 Fighter        | Reach level 8");
		Ui.println("   Level 9 Fighter        | Reach level 9");
		Ui.println("   Level 10 Fighter       | Reach level 10");
		Ui.println("   Honest Player          | Lock cheats off");
		Ui.println("   Learning               | Look at every single help page in one session");
		Ui.println("-------------------------------------------------------------------------");
		Ui.pause();
		Ach.viewedAchs = true;
	}
}