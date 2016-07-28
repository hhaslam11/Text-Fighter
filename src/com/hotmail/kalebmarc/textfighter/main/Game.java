package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.*;
import com.hotmail.kalebmarc.textfighter.player.*;

import java.util.Scanner;

import static com.hotmail.kalebmarc.textfighter.player.Health.getStr;
import static com.hotmail.kalebmarc.textfighter.player.Health.upgrade;
import static com.hotmail.kalebmarc.textfighter.player.Settings.menu;
import static com.hotmail.kalebmarc.textfighter.player.Settings.setDif;

public class Game {
	private Game() {
	}

	//Enemies
	public static Enemy darkElf;
	public static Enemy ninja;
	public static Enemy giantSpider;
	public static Enemy zombie;
	public static Enemy goblin;
	public static Enemy ghost;
	public static Enemy barbarian;
	public static Enemy giantAnt;
	public static Enemy evilUnicorn;
	public static Enemy ogre;

	//Weapons
	public static Weapon fists;
	public static Weapon baseballBat;
	public static Weapon knife;
	public static Weapon pipe;
	public static Weapon pistol;
	public static Weapon smg;
	public static Weapon shotgun;
	public static Weapon rifle;
	public static Weapon sniper;

	//Amours
	public static Armour none = new Armour("None", 0, 0, 1);//DO NOT REMOVE
	public static Armour basic = new Armour("Basic", 400, 15, 5);
	public static Armour advanced = new Armour("Advanced", 750, 30, 7);

	//Food
	//TODO when the StatusEffect system is implemented, change effect types
	public static Food apple       = new Food("Apple",         "A boring 'ol apple.",                StatusEffect.type.HEALTH, Food.type.FRUIT,      5);
	public static Food orange      = new Food("Orange",        "Sort of like an apple, but orange.", StatusEffect.type.HEALTH, Food.type.FRUIT,      5);
	public static Food dragonfruit = new Food("Dragon Fruit",  "Unfortunately, not a real dragon.",  StatusEffect.type.HEALTH, Food.type.FRUIT,      10);
	public static Food meat        = new Food("Chunk of meat", "Probably not rotten.",               StatusEffect.type.HEALTH, Food.type.MEAT_OTHER, 15);
	public static Food mushroom    = new Food("Mushroom",      "The good kind!",                     StatusEffect.type.HEALTH, Food.type.OTHER,      5);
	public static Food fish        = new Food("Fish",          "Found in rivers and lakes.",         StatusEffect.type.HEALTH, Food.type.MEAT_FISH,  15);

	private static Scanner scan = new Scanner(System.in);

	public static void start() {
		
		/*
		 * Asks if the user wants to load from the save file
		 */
		Ui.cls();
		Ui.println("____________________________________________");
		Ui.println("|                                           |");
		Ui.println("|       Do you want to load your game       |");
		Ui.println("|            from save file?                |");
		Ui.println("|                                           |");
		Ui.println("| 1) Yes                                    |");
		Ui.println("| 2) No, Start a new game                   |");
		Ui.println("|___________________________________________|");

		int choice = Ui.getValidInt();
		switch(choice){
			case 1:
				if(SaveAndLoad.load()) break;
			default:
				setDif(getDifficulty(), true, false);
				Health.set(100, 100);
				Enemy.encounterNew();
				if(choice != 1)
					User.promptNameSelection();
				break;
		}

		while (true) {

			//Runs all the tests and clears the screen
			if (Stats.kills > Stats.highScore) Stats.highScore = Stats.kills;
			Ach.check();
			SaveAndLoad.save();
			Ui.cls();

			/*
			 * MAIN GAME MENU
			 * Able to fight and go to other places from here
			 */
			Ui.println("Text-Fighter " + Version.getFull());
			Ui.println("------------------------------------------------------------------");
			//Displays only if cheats are activated
			if (Cheats.enabled()) {
				Ui.println("CHEATS ACTIVATED");
			}
			Ui.println(Settings.godModeMsg());
			//------------------
			Ui.println("--Score Info--");
			Ui.println("     Level " + Xp.getLevel() + "      " + Xp.getFull());
			Ui.println("     Kill Streak: " + Stats.kills);
			Ui.println("     Highest Kill Streak: " + Stats.highScore);
			Ui.println("--" + User.name() + "--");
			Ui.println("     Health: " + getStr());
			Ui.println("     Coins: " + Coins.get());
			Ui.println("     First-Aid kits: " + FirstAid.get());
			Ui.println("     Potions: " + (Potion.get("survival") + Potion.get("recovery")));
			Ui.println("     Equipped armour: " + Armour.getEquipped().toString());
			Ui.println("     Equipped Weapon: " + Weapon.get().getName());
			//Displays ammo only if a weapon is equipped
			Weapon.displayAmmo();
			//--------------------
			Ui.println("--Enemy Info--");
			Ui.println("     Enemy: " + Enemy.get().getName());
			Ui.println("     Enemy Health: " + Enemy.get().getHeathStr());
			Ui.println("------------------------------------------------------------------");
			Ui.println("1) Go to battle");
			Ui.println("2) Go Home");
			Ui.println("3) Go to the town");
			Ui.println("4) Use First-Aid kit");
			Ui.println("5) Use Potion");
			Ui.println("6) Eat Food");
			Ui.println("7) Use Insta-Health");
			Ui.println("8) Use POWER");
			Ui.println("9) Quit Game (Game will automatically be saved)");
			Ui.println("------------------------------------------------------------------");

			switch (Ui.getValidInt()) {
				case 1:
					int fightPath = Random.RInt(100);

					if (Weapon.get().getName().equals("Sniper")) {
						if (fightPath <= 30) Enemy.get().dealDamage();
						if (fightPath > 30) sniper.dealDam();
					} else {
						if (fightPath <= 50) Enemy.get().dealDamage();
						if (fightPath > 50) Weapon.get().dealDam();
					}
					break;
				case 2:
					home();
					break;
				case 3:
					town();
					break;
				case 4:
					FirstAid.use();
					break;
				case 5:
					Ui.cls();
					Ui.println("Which potion would you like to use?");
					Ui.println("1) Survival Potion");
					Ui.println("2) Recovery Potion");
					Ui.println("3) Back");
					switch (Ui.getValidInt()) {
						case 1:
							Potion.use("survival");
							break;
						case 2:
							Potion.use("recovery");
							break;
						case 3:
							break;
						default:
							break;
					}
					break;
				case 6:
					Food.list();
					break;
				case 7:
					InstaHealth.use();
					break;
				case 8:
					Power.use();
					break;
				case 9:
					return;
				case 0:
					Cheats.cheatGateway();
					break;
				case 99:
					Debug.menu();
				default:
					break;
			}//Switch
		}//While loop
	}//Method

	private static void town() {

		int menuChoice;

		//TOWN MENU
		while (true) {
			Ui.cls();
			Ui.println("------------------------------------------------------------------");
			Ui.println("                      WELCOME TO THE TOWN                         ");
			Ui.println("--Score Info--");
			Ui.println("     Kill Streak: " + Stats.kills);
			Ui.println("     Highest Kill Streak: " + Stats.highScore);
			Ui.println("--Player Info--");
			Ui.println("     Health: " + getStr());
			Ui.println("     Coins: " + Coins.get());
			Ui.println("     First-Aid kits: " + FirstAid.get());
                        Ui.println("     Potions: " + (Potion.get("survival") + Potion.get("recovery")));
			Ui.println("     Equipped Weapon: " + Weapon.get().getName());
			Ui.println("------------------------------------------------------------------");
			Ui.println("1) Casino");
			Ui.println("2) Home");
			Ui.println("3) Bank");
			Ui.println("4) Shop");
			Ui.println("5) Upgrade Health");
			Ui.println("6) Back");
			Ui.println("------------------------------------------------------------------");

			menuChoice = Ui.getValidInt();

			switch (menuChoice) {
				case 1:
					Casino.menu();
					break;
				case 2:
					home();
					break;
				case 3:
					Bank.menu();
					break;
				case 4:
					Shop.menu();
					break;
				case 5:
					upgrade();
					break;
				case 6:
					return;
				default:
					break;
			}//Switch
		}//While Loop
	}//Method

	private static void home() {

		int menuChoice;

		//HOME MENU
		while (true) {
			Ui.cls();
			Ui.println("------------------------------------------------------------------");
			Ui.println("                          WELCOME HOME                            ");
			Ui.println("--Score Info--");
			Ui.println("     Kill Streak: " + Stats.kills);
			Ui.println("     Highest Kill Streak: " + Stats.highScore);
			Ui.println("--Player Info--");
			Ui.println("     Health: " + getStr());
			Ui.println("     Coins: " + Coins.get());
			Ui.println("     First-Aid kits: " + FirstAid.get());
                        Ui.println("     Potions: " + (Potion.get("survival") + Potion.get("recovery")));
			Ui.println("     Equipped Weapon: " + Weapon.get().getName());
			Ui.println("------------------------------------------------------------------");
			Ui.println("1) Equip weapon");
			Ui.println("2) Equip Armour");
			Ui.println("3) View Item Chest");
			Ui.println("4) Achievements");
			Ui.println("5) Stats");
			Ui.println("6) About");
			Ui.println("7) Settings");
			Ui.println("8) Help");
			Ui.println("9) Back");
			Ui.println("------------------------------------------------------------------");

			menuChoice = Ui.getValidInt();

			switch (menuChoice) {
				case 1:
					Weapon.choose();
					break;
				case 2:
					Armour.choose();
					break;
				case 3:
					Chest.view();
					break;
				case 4:
					Ach.view();
					break;
				case 5:
					Stats.view();
					break;
				case 6:
					About.view(true);
					Ach.viewedAbout = true;
					break;
				case 7:
					menu();
					break;
				case 8:
					Help.view();
				case 9:
					return;
				default:
					break;
			}//Switch
		}//While loop
	}//Method

	private static String getDifficulty() {
		
		/*
		 * DIFFICULTY SELECTION
		 * Prompts user to get what difficulty
		 * they want to play on. Sets variables
		 * according.
		 */
		Ui.cls();
		Ui.println("_____________________________________________");
		Ui.println("|                                           |");
		Ui.println("|       What difficulty would you           |");
		Ui.println("|            like to play on?               |");
		Ui.println("|                                           |");
		Ui.println("| 1) Easy                                   |");
		Ui.println("| 2) Hard                                   |");
		Ui.println("|___________________________________________|");

		if (!scan.hasNextInt()) {
			Ui.cls();
			return "Easy";
		} else {
			int difficultyChoice = scan.nextInt();
			if (difficultyChoice == 2) {
				Ui.cls();
				return "Hard";
			} else {
				Ui.cls();
				return "Easy";
			}
		}
	}
}