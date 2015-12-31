package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.*;
import com.hotmail.kalebmarc.textfighter.player.*;

import java.util.Scanner;

import static com.hotmail.kalebmarc.textfighter.player.Health.getStr;
import static com.hotmail.kalebmarc.textfighter.player.Health.upgrade;
import static com.hotmail.kalebmarc.textfighter.player.Settings.menu;
import static com.hotmail.kalebmarc.textfighter.player.Settings.setDif;

public class Game {
	private Game(){}

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
    public static Weapon nothing;
    public static Weapon baseballBat;
    public static Weapon knife;//Do not remove
    public static Weapon pipe;
    public static Weapon pistol;
    public static Weapon smg;
    public static Weapon shotgun;
    public static Weapon rifle;//Do not remove
    public static Weapon rifleWithKnife;//Do not remove
    public static Weapon sniper;

    private static Scanner scan = new Scanner(System.in);

	public static void start(){
		
		/*
		 * Asks if the user wants to load from the save file
		 */
		Action.cls();
		Ui.println("____________________________________________");
		Ui.println("|                                           |");
		Ui.println("|       Do you want to load your game       |");
		Ui.println("|            from save file?                |");
		Ui.println("|                                           |");
		Ui.println("| 1) Yes                                    |");
		Ui.println("| 2) No, Start a new game                   |");
		Ui.println("|___________________________________________|");
		
		switch(Action.getValidInt()){
		case 1:
			if(SaveAndLoad.load()) break;
		default:
			setDif(getDifficulty(), true, false);
			Health.set(100, 100);
			Enemy.encounterNew();
			break;
		}

		while (true){
			
			//Runs all the tests and clears the screen
			if(Stats.kills > Stats.highScore) Stats.highScore = Stats.kills;
			Ach.check();
			Action.cls();
			
			/*
			 * MAIN GAME MENU
			 * Able to fight and go to other places from here
			 */ 
			Ui.println("Text-Fighter " + Version.getFull());
			Ui.println("------------------------------------------------------------------");
			//Displays only if cheats are activated
			if(Cheats.enabled()){
				Ui.println("CHEATS ACTIVATED");
			}
			Ui.println(Settings.godModeMsg());
			//------------------
			Ui.println("--Score Info--");
			Ui.println("     Level " + Xp.getLevel() + "      " + Xp.getFull());
			Ui.println("     Kill Streak: " + Stats.kills);
			Ui.println("     Highest Kill Streak: " + Stats.highScore);
			Ui.println("--Player Info--");
			Ui.println("     Health: " + getStr());
			Ui.println("     Coins: " + Coins.get());
			Ui.println("     First-Aid kits: " + FirstAid.get());
			Ui.println("     Equipped Weapon: " + Weapon.get().getName());
			//Displays ammo only if a weapon is equipped
			Action.displayAmmo();
			//--------------------
			Ui.println("--Enemy Info--");
			Ui.println("     Enemy: " + Enemy.get().getName());
			Ui.println("     Enemy Health: " + Enemy.get().getHeathStr());
			Ui.println("------------------------------------------------------------------");
			Ui.println("1) Go to battle");
			Ui.println("2) Go Home");
			Ui.println("3) Go to the town");
			Ui.println("4) Use First-Aid kit");
			Ui.println("5) Use Insta-Health");
			Ui.println("6) Use POWER");
			Ui.println("7) Quit Game (Game will automatically be saved)");
			Ui.println("------------------------------------------------------------------");

			switch(Action.getValidInt()){
			    case 1:
                    int fightPath = Random.RInt(100);

                    if (Weapon.get().getName().equals("Sniper")){
                        if (fightPath <= 30) Enemy.get().dealDamage();
                        if (fightPath > 30)  sniper.dealDam();
                    }else{
                        if (fightPath <= 50) Enemy.get().dealDamage();
                        if (fightPath >50) Weapon.get().dealDam();
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
    				InstaHealth.use();
    				break;
    			case 6:
    				Power.use();
	    			break;
    			case 7:
    				return;
    			case 1337:
    				Cheats.cheatGateway();
    				break;
                case 99:
                    Debug.menu();
			default:
				break;
			}//Switch
		}//While loop
	}//Method
	private static void town(){
		
		int menuChoice;
		
		//TOWN MENU
		while (true){
			Action.cls();
			Ui.println("------------------------------------------------------------------");
			Ui.println("                      WELCOME TO THE TOWN                         ");
			Ui.println("--Score Info--");
			Ui.println("     Kill Streak: " + Stats.kills);
			Ui.println("     Highest Kill Streak: " + Stats.highScore);
			Ui.println("--Player Info--");
			Ui.println("     Health: " + getStr());
			Ui.println("     Coins: " + Coins.get());
			Ui.println("     First-Aid kits: " + FirstAid.get());
			Ui.println("     Equipped Weapon: " + Weapon.get().getName());
			Ui.println("------------------------------------------------------------------");
			Ui.println("1) Casino");
			Ui.println("2) Home");
			Ui.println("3) Bank");
			Ui.println("4) Shop");
			Ui.println("5) Upgrade Health");
			Ui.println("6) Back");
			Ui.println("------------------------------------------------------------------");
			
			menuChoice = Action.getValidInt();
			
			switch(menuChoice){
			case 1:
				Casino.menu();
				break;
			case 2:
				home();
				break;
			case 3:
                Coins.bank();
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

	private static void home(){
		
		int menuChoice;
		
		//HOME MENU
		while (true){
			Action.cls();
			Ui.println("------------------------------------------------------------------");
			Ui.println("                          WELCOME HOME                            ");
			Ui.println("--Score Info--");
			Ui.println("     Kill Streak: " + Stats.kills);
			Ui.println("     Highest Kill Streak: " + Stats.highScore);
			Ui.println("--Player Info--");
			Ui.println("     Health: " + getStr());
			Ui.println("     Coins: " + Coins.get());
			Ui.println("     First-Aid kits: " + FirstAid.get());
			Ui.println("     Equipped Weapon: " + Weapon.get().getName());
			Ui.println("------------------------------------------------------------------");
			Ui.println("1) Equip weapon");
			Ui.println("2) View Item Chest");
			Ui.println("3) Achievements");
			Ui.println("4) Stats");
			Ui.println("5) About");
			Ui.println("6) Settings");
			Ui.println("7) Help");
			Ui.println("8) Back");
			Ui.println("------------------------------------------------------------------");
			
			menuChoice = Action.getValidInt();

			switch(menuChoice){
			case 1:
				Weapon.choose();
				break;
			case 2:
				Chest.view();
				break;
			case 3:
				Ach.view();
				break;
			case 4:
				Stats.view();
				break;
			case 5:
				About.view(true);
				Ach.viewedAbout = true;
				break;
			case 6:
				menu();
				break;
			case 7:
				Help.view();
			case 8:
				return;
			default:
				break;
			}//Switch
		}//While loop
	}//Method
	private static String getDifficulty(){
		
		/*
		 * DIFFICULTY SELECTION
		 * Prompts user to get what difficulty
		 * they want to play on. Sets variables
		 * according.
		 */
		Action.  cls();
		Ui.println("_____________________________________________");
		Ui.println("|                                           |");
		Ui.println("|       What difficulty would you           |");
		Ui.println("|            like to play on?               |");
		Ui.println("|                                           |");
		Ui.println("| 1) Easy                                   |");
		Ui.println("| 2) Hard                                   |");
		Ui.println("|___________________________________________|");

		if (!scan.hasNextInt()){
			Action.cls();
			return "Easy";
		}else{
			int difficultyChoice = scan.nextInt();
			if (difficultyChoice == 2){
				Action.cls();
				return "Hard";
			} else {
				Action.cls();
				return "Easy";
			}
		}
	}
}//Class