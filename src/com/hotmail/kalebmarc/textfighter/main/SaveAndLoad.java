package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.item.Armour;
import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.player.*;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

class SaveAndLoad {

	private static PrintStream output;
    private static String path = SaveAndLoad.class.getProtectionDomain().getCodeSource().getLocation().getPath() + ".TFsave";

	public static boolean load(){

        User.promptNameSelection();
        path = path.replace(".jar", "_" + User.name());
        path = path.replaceAll("%20", " ");
        Scanner input;
		try {
			input = new Scanner(new File(path));
		} catch (Exception e) {
			Action.cls();
			Ui.println("------------------------------");
			Ui.println("Cannot find save file.  ");
			Ui.println("Starting a new game...  ");
			Ui.println("------------------------------");
			Action.pause();
			return false;
		}

		try{
			if(!input.nextLine().equals(Version.getFull())){
				Action.cls();
				Ui.println("------------------------------------");
				Ui.println("WARNING- This save file is from");
				Ui.println("a different version of TextFighter,");
				Ui.println("and will probably crash the game");
				Ui.println("if you try and load it. Do you");
				Ui.println("want to continue anyways?");
				Ui.println("------------------------------------");
				Ui.println("1) No, start a new game");
				Ui.println("2) Yes, attempt to load");
				switch(Action.getValidInt()){
				case 1:
					return false;
				case 2:
					break;
				default:
					return false;
				}
			}

            Health.set(Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine()));
			FirstAid.set(Integer.parseInt(input.nextLine()), false);
			FirstAid.used = Integer.parseInt(input.nextLine());
			InstaHealth.set(Integer.parseInt(input.nextLine()), false);
			InstaHealth.used = Integer.parseInt(input.nextLine());
			Health.timesDied = Integer.parseInt(input.nextLine());

			//Coins
			Coins.set(Integer.parseInt(input.nextLine()), false);
			Bank.set(Integer.parseInt(input.nextLine()), false);
			Casino.totalCoinsWon = Integer.parseInt(input.nextLine());
			Casino.gamesPlayed = Integer.parseInt(input.nextLine());
            Ach.boughtItem = Boolean.parseBoolean(input.nextLine());
            Stats.totalCoinsSpent = Integer.parseInt(input.nextLine());
            Stats.coinsSpentOnBankInterest = Integer.parseInt(input.nextLine());
            Stats.coinsSpentOnWeapons = Integer.parseInt(input.nextLine());
            Stats.coinsSpentOnHealth = Integer.parseInt(input.nextLine());
            Stats.xpBought = Integer.parseInt(input.nextLine());

			//Xp
            Xp.setLevel(Integer.parseInt(input.nextLine()));
            Xp.setOutOf(Integer.parseInt(input.nextLine()));
			Xp.set(Integer.parseInt(input.nextLine()), false);
			Xp.total = Integer.parseInt(input.nextLine());

            //Settings
            Settings.setDif(input.nextLine(), false, false);
            if(Boolean.parseBoolean(input.nextLine())) Cheats.enable();
            if(Boolean.parseBoolean(input.nextLine())) Cheats.lock();
            Settings.difLocked = Boolean.parseBoolean(input.nextLine());
            Ui.guiEnabled = Boolean.parseBoolean(input.nextLine());

			//Combat
			Stats.kills = Integer.parseInt(input.nextLine());
			Stats.highScore = Integer.parseInt(input.nextLine());
			Stats.totalKills = Integer.parseInt(input.nextLine());
			Weapon.set(Integer.parseInt(input.nextLine()));
			for(int i = 0; i < Weapon.arrayWeapon.size(); i++){
				Weapon.arrayWeapon.get(i).owns = Boolean.parseBoolean(input.nextLine());
			}
            for(int i = 0; i < Weapon.arrayWeapon.size(); i++){
                Weapon.arrayWeapon.get(i).setAmmo(Integer.parseInt(input.nextLine()), false);
            }
			Power.set(Integer.parseInt(input.nextLine()), false);
			Power.used = Integer.parseInt(input.nextLine());
			Stats.totalDamageDealt = Integer.parseInt(input.nextLine());
            Stats.bulletsFired = Integer.parseInt(input.nextLine());
            Stats.bulletsThatHit = Integer.parseInt(input.nextLine());
            for(int i = 0; i < Armour.getArmours().size(); i++){
                Armour.getArmours().get(i).setOwns(Boolean.parseBoolean(input.nextLine()));
            }
            Armour.set(Integer.parseInt(input.nextLine()));

            //Enemy
            Enemy.set(Integer.parseInt(input.nextLine()));
            Enemy.get().setHealth(Integer.parseInt(input.nextLine()), Enemy.get().getHealthMax());

			//Achs
            Ach.moneyMaker         = Boolean.parseBoolean(input.nextLine());
            Ach.enemySlayer        = Boolean.parseBoolean(input.nextLine());
            Ach.firstKill          = Boolean.parseBoolean(input.nextLine());
            Ach.timeForAnUpgrade   = Boolean.parseBoolean(input.nextLine());
            for(int i = 0; i < Enemy.arrayEnemy.size(); i++){
                 Ach.arrayKilled.set(i, Boolean.parseBoolean(input.nextLine()));
            }
            Ach.textFighterMaster  = Boolean.parseBoolean(input.nextLine());
            Ach.YAYPOWER           = Boolean.parseBoolean(input.nextLine());
            Ach.awwYouCareAboutMe  = Boolean.parseBoolean(input.nextLine());
            Ach.slayer             = Boolean.parseBoolean(input.nextLine());
            Ach.nobodysPerfect     = Boolean.parseBoolean(input.nextLine());
            Ach.makingMoney        = Boolean.parseBoolean(input.nextLine());
            Ach.gamblingAddiction  = Boolean.parseBoolean(input.nextLine());
            Ach.level2Fighter      = Boolean.parseBoolean(input.nextLine());
            Ach.level3Fighter      = Boolean.parseBoolean(input.nextLine());
            Ach.level4Fighter      = Boolean.parseBoolean(input.nextLine());
            Ach.level5Fighter      = Boolean.parseBoolean(input.nextLine());
            Ach.level6Fighter      = Boolean.parseBoolean(input.nextLine());
            Ach.level7Fighter      = Boolean.parseBoolean(input.nextLine());
            Ach.level8Fighter      = Boolean.parseBoolean(input.nextLine());
            Ach.level9Fighter      = Boolean.parseBoolean(input.nextLine());
            Ach.level10Fighter     = Boolean.parseBoolean(input.nextLine());
            Ach.honestPlayer       = Boolean.parseBoolean(input.nextLine());
            Ach.learning           = Boolean.parseBoolean(input.nextLine());

			//Other Stuff
            About.setViewed(Boolean.parseBoolean(input.nextLine()));
            Stats.timesCheated = Integer.parseInt(input.nextLine());
            Stats.timesQuit = Integer.parseInt(input.nextLine());
            Stats.itemsCrafted = Integer.parseInt(input.nextLine());
            Stats.diceGamesPlayed = Integer.parseInt(input.nextLine());
            Stats.slotGamesPlayed = Integer.parseInt(input.nextLine());


		}catch(Exception e){
			Handle.error("Error Code - 009\n\n" + e.toString());
            System.exit(1);
		}

		//input.close();
		return true;
	}
	public static void save(){

        path = path.replace(".jar", User.name());
        path = path.replaceAll("%20", " ");

		try {
			output = new PrintStream(path);
		} catch (Exception e) {
			Handle.error("Error Code - 008");
		}

        //Version
		output.println(Version.getFull());

        //Player Health
		output.println(Health.get());
		output.println(Health.getOutOf());
        output.println(FirstAid.get());
        output.println(FirstAid.used);
        output.println(InstaHealth.get());
        output.println(InstaHealth.used);
        output.println(Health.timesDied);

        //Coins
        output.println(Coins.get());
        output.println(Bank.get());
        output.println(Casino.totalCoinsWon);
        output.println(Casino.gamesPlayed);
        output.println(Ach.boughtItem);
        output.println(Stats.totalCoinsSpent);
        output.println(Stats.coinsSpentOnBankInterest);
        output.println(Stats.coinsSpentOnWeapons);
        output.println(Stats.coinsSpentOnHealth);
        output.println(Stats.xpBought);

        //Xp
        output.println(Xp.getLevel());
        output.println(Xp.getOutOf());
        output.println(Xp.get());
        output.println(Xp.total);

        //Settings
        output.println(Settings.getDif());
        output.println(Cheats.enabled());
        output.println(Cheats.locked());
        output.println(Settings.difLocked);
        output.println(Ui.guiEnabled);

        //Combat
        output.println(Stats.kills);
        output.println(Stats.highScore);
        output.println(Stats.totalKills);
        output.println(Weapon.getIndex(Weapon.get()));
        for(int i = 0; i < Weapon.arrayWeapon.size(); i++){
            //Weapons owned
            output.println(Weapon.arrayWeapon.get(i).owns());
        }
        for(int i = 0; i < Weapon.arrayWeapon.size(); i++){
            output.println(Weapon.arrayWeapon.get(i).getAmmo());
        }
        output.println(Power.get());
        output.println(Power.used);
        output.println(Stats.totalDamageDealt);
        output.println(Stats.bulletsFired);
        output.println(Stats.bulletsThatHit);
        for(int i = 0; i < Armour.getArmours().size(); i++){
            output.println(Armour.getArmours().get(i).isOwns());
        }
        output.println(Armour.get());

        //Enemy
        output.println(Enemy.getIndex(Enemy.get()));
        output.println(Enemy.get().getHealth());

        //Achs
        output.println(Ach.moneyMaker);
        output.println(Ach.enemySlayer);
        output.println(Ach.firstKill);
        output.println(Ach.timeForAnUpgrade);
        for(int i = 0; i < Enemy.arrayEnemy.size(); i++){
            output.println(Ach.arrayKilled.get(i));
        }
        output.println(Ach.textFighterMaster);
        output.println(Ach.YAYPOWER);
        output.println(Ach.awwYouCareAboutMe);
        output.println(Ach.slayer);
        output.println(Ach.nobodysPerfect);
        output.println(Ach.makingMoney);
        output.println(Ach.gamblingAddiction);
        output.println(Ach.level2Fighter);
        output.println(Ach.level3Fighter);
        output.println(Ach.level4Fighter);
        output.println(Ach.level5Fighter);
        output.println(Ach.level6Fighter);
        output.println(Ach.level7Fighter);
        output.println(Ach.level8Fighter);
        output.println(Ach.level9Fighter);
        output.println(Ach.level10Fighter);
        output.println(Ach.honestPlayer);
        output.println(Ach.learning);

        //Other random stuff
        output.println(About.viewed());
        output.println(Stats.timesCheated);
        output.println(++Stats.timesQuit);
        output.println(Stats.itemsCrafted);
        output.println(Stats.diceGamesPlayed);
        output.println(Stats.slotGamesPlayed);

		//output.close();
	}
}