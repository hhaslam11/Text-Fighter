package com.hotmail.kalebmarc.textfighter.player;

import com.hotmail.kalebmarc.textfighter.main.Action;
import com.hotmail.kalebmarc.textfighter.main.*;

import javax.swing.*;
import java.util.ArrayList;

public class Ach {
	private Ach(){}

	/* Achievements
	 * 32 Total
	 *
	 * Booleans to check if the
	 * achievement has been unlocked
	 */
	public static boolean moneyMaker           = false;
	public static boolean enemySlayer          = false;
	public static boolean firstKill            = false;
	public static boolean timeForAnUpgrade     = false;
	public static boolean textFighterMaster    = false;
	public static boolean YAYPOWER             = false;
	public static boolean awwYouCareAboutMe    = false;
	public static boolean slayer               = false;
	public static boolean nobodysPerfect       = false;
	public static boolean makingMoney          = false;
	public static boolean gamblingAddiction    = false;
	public static boolean level2Fighter        = false;
	public static boolean level3Fighter        = false;
	public static boolean level4Fighter        = false;
	public static boolean level5Fighter        = false;
	public static boolean level6Fighter        = false;
	public static boolean level7Fighter		   = false;
	public static boolean level8Fighter        = false;
	public static boolean level9Fighter        = false;
	public static boolean level10Fighter       = false;
	public static boolean honestPlayer         = false;
	public static boolean learning 			   = false;

	//Variables for testing the achievements
	//Time for an upgrade
	public static boolean boughtItem           = false;
	//Aww, You Care About Me
	public static boolean viewedAbout          = false;
	//Learning
	public static boolean viewedPlayer         = false;
	public static boolean viewedHealth         = false;
	public static boolean viewedXP             = false;
	public static boolean viewedCrafting       = false;
	public static boolean viewedCheats         = false;
	public static boolean viewedAchs           = false;



    //Arrays for achievements
    private static final ArrayList<String> arrayName   = new ArrayList<>();
    public static final ArrayList<Boolean> arrayKilled = new ArrayList<>();
    private static final ArrayList<Enemy> arrayEnemy   = new ArrayList<>();

	public static void setUpEnemyAch(String name, Enemy type){

        arrayName.add(name);
        arrayKilled.add(false);
        arrayEnemy.add(type);

    }
	public static void view(){

		//Displays which achievements the user has gotten
		Action.cls();

		boolean ach[] = new boolean[22];
		String strAch[] = new String[22];
		ach[0] = moneyMaker;
		strAch[0] = "Money Maker";

		ach[1] = enemySlayer;
		strAch[1] = "Enemy Slayer";

		ach[2] = firstKill;
		strAch[2] = "First Kill";

		ach[3] = timeForAnUpgrade;
		strAch[3] = "Time For An Upgrade";

		ach[4] = textFighterMaster;
		strAch[4] = "Text-Fighter Master";

		ach[5] = YAYPOWER;
		strAch[5] = "YAY POWER!";

		ach[6] = awwYouCareAboutMe;
		strAch[6] = "Aww, You Care About Me :')";

		ach[7] = slayer;
		strAch[7] = "Slayer";

		ach[8] = nobodysPerfect;
		strAch[8] = "Nobodys Perfect";

		ach[9] = makingMoney;
		strAch[9] = "Making Money";

		ach[10] = gamblingAddiction;
		strAch[10] = "Gambling Addiction";

		ach[11] = level2Fighter;
		strAch[11] = "Level 2 Fighter!";

		ach[12] = level3Fighter;
		strAch[12] = "Level 3 Fighter!";

		ach[13] = level4Fighter;
		strAch[13] = "Level 4 Fighter!";

		ach[14] = level5Fighter;
		strAch[14] = "Level 5 Fighter!";

		ach[15] = level6Fighter;
		strAch[15] = "Level 6 Fighter!";

		ach[16] = level7Fighter;
		strAch[16] = "Level 7 Fighter!";

		ach[17] = level8Fighter;
		strAch[17] = "Level 8 Fighter!";

		ach[18] = level9Fighter;
		strAch[18] = "Level 9 Fighter!";

		ach[19] = level10Fighter;
		strAch[19] = "Level 10 Fighter!";

		ach[20] = honestPlayer;
		strAch[20] = "Honest Player";

		ach[21] = learning;
		strAch[21] = "Learning";

		Ui.println("---------------------------------------");
		Ui.println("Achievements");
		Ui.println();
		Ui.println("Unlocked Achievements:");
		Ui.println();
		for (int i = 0; i < ach.length; i++){
			if (ach[i]){
				Ui.println(strAch[i]);
			}
		}
        //Enemy
        for (int i = 0; i < arrayEnemy.size(); i++){
            if (arrayKilled.get(i)){
                Ui.println("Goodbye, " + arrayEnemy.get(i).getName() + "!");
            }
        }
		Ui.println();
		Ui.println("Locked Achievements:");
		Ui.println();
		for (int i = 0; i < ach.length; i++){
			if (!ach[i]){
				Ui.println(strAch[i]);
			}
		}
        //Enemy
        for (int i = 0; i < arrayEnemy.size(); i++){
            if (!arrayKilled.get(i)){
                Ui.println("Goodbye, " + arrayEnemy.get(i).getName() + "!");
            }
        }
		Ui.println();
		Ui.println("---------------------------------------");

		Action.pause();
	}
	public static void check(){

		//Tests achievements if not already unlocked

		if (!Cheats.enabled()){
			if (!moneyMaker)         checkMoneyMaker();
			if (!enemySlayer)        checkEnemySlayer();
			if (!firstKill)          checkFirstKill();
			if (!timeForAnUpgrade)   checkTimeForAnUpgrade();
			if (!textFighterMaster)  checkTextFighterMaster();
			if (!YAYPOWER)           checkYAYPOWER();
			if (!awwYouCareAboutMe)  checkAwwYouCareAboutMe();
			if (!slayer)             checkSlayer();
			if (!nobodysPerfect)     checkNobodysPerfect();
			if (!makingMoney)        checkMakingMoney();
			if (!gamblingAddiction)  checkGamblingAddiction();
			if (!level2Fighter)      checkLevel2Fighter();
			if (!level3Fighter)      checkLevel3Fighter();
			if (!level4Fighter)      checkLevel4Fighter();
			if (!level5Fighter)      checkLevel5Fighter();
			if (!level6Fighter)      checkLevel6Fighter();
			if (!level7Fighter)      checkLevel7Fighter();
			if (!level8Fighter)      checkLevel8Fighter();
			if (!level9Fighter)      checkLevel9Fighter();
			if (!level10Fighter)     checkLevel10Fighter();
			if (!honestPlayer)       checkHonestPlayer();
			if (!learning)           checkLearning();
            //Enemy achs get checked from textfighter.Enemy class
		}
	}
    public static void getEnemyAch(Enemy x){
        get("Goodbye, " + x.getName() + "!");
        arrayKilled.set(arrayEnemy.indexOf(x), true);
	}
	private static void get(String ach){
		//Displays that you've gotten an achievement
		Ui.popup("You've got an achievement! \n\n" + ach, "Achievement", JOptionPane.INFORMATION_MESSAGE);
		Xp.set(100, true);
	}
	private static void checkMoneyMaker(){
		if (Coins.get() >= 1500){
			moneyMaker = true;
			get("Money Maker");
		}
	}
	private static void checkEnemySlayer(){
		if (Stats.totalKills >= 100){
			enemySlayer = true;
			get("Enemy Slayer");
		}
	}
	private static void checkFirstKill(){
		if (Stats.totalKills >= 1){
			firstKill = true;
			get("First Kill");
		}
	}
	private static void checkTimeForAnUpgrade(){
		if (boughtItem){
			timeForAnUpgrade = true;
			get("Time for an Upgrade");
		}
	}
	private static void checkTextFighterMaster(){
		if (
				moneyMaker &&
                enemySlayer &&
				firstKill &&
				timeForAnUpgrade &&
				YAYPOWER &&
				awwYouCareAboutMe &&
				slayer &&
				nobodysPerfect &&
				makingMoney &&
				gamblingAddiction &&
				level2Fighter &&
				level3Fighter &&
				level4Fighter &&
				level5Fighter &&
				level6Fighter &&
				level7Fighter &&
				level8Fighter &&
				level9Fighter &&
				level10Fighter &&
				honestPlayer &&
				learning
				){

			//Check Enemy Achs
            int temp = 0;
            for(int i = 0; i <= arrayEnemy.size(); i++){
                if (arrayKilled.get(i)){
                    temp++;
                }
            }
            if(temp < arrayEnemy.size()) {
                textFighterMaster = true;
                get("Text-Fighter Master\n Congratulations, you have gotten every achievement in Text Fighter! You've been awarded 2500 coins.");
                Coins.set(2500, true);
            }
		}
	}
	private static void checkYAYPOWER(){
		if (com.hotmail.kalebmarc.textfighter.item.Power.used >= 5){
			YAYPOWER = true;
			get("YAY, POWER!!");
		}
	}
	private static void checkAwwYouCareAboutMe(){
		if (viewedAbout){
			awwYouCareAboutMe = true;
			get("Aww, You Care About Me");
		}
	}
	private static void checkSlayer(){
		if(Stats.totalDamageDealt >= 1000){
			slayer = true;
			get("Slayer");
		}
	}
	private static void checkNobodysPerfect(){
		if(Health.timesDied > 0){
			nobodysPerfect = true;
			get("Nobodys Perfect");
		}
	}
	private static void checkMakingMoney(){
		if (Casino.totalCoinsWon >= 1000){
			makingMoney = true;
			get("Making Money");
		}
	}
	private static void checkGamblingAddiction(){
		if (Casino.gamesPlayed >= 75){
			gamblingAddiction = true;
			get("Gambling Addiction");
		}
	}
	private static void checkLevel2Fighter(){
		if (Xp.getLevel() == 2){
			level2Fighter = true;
			get("Level 2 Fighter!");
		}
	}
	private static void checkLevel3Fighter(){
		if (Xp.getLevel() == 3){
			level3Fighter = true;
			get("Level 3 Fighter!");
		}
	}
	private static void checkLevel4Fighter(){
		if (Xp.getLevel() == 4){
			level4Fighter = true;
			get("Level 4 Fighter!");
		}
	}
	private static void checkLevel5Fighter(){
		if (Xp.getLevel() == 5){
			level5Fighter = true;
			get("Level 5 Fighter!");
		}
	}
	private static void checkLevel6Fighter(){
		if (Xp.getLevel() == 6){
			level6Fighter = true;
			get("Level 6 Fighter!");
		}
	}
	private static void checkLevel7Fighter(){
		if (Xp.getLevel() == 7){
			level7Fighter = true;
			get("Level 7 Fighter!");
		}
	}
	private static void checkLevel8Fighter(){
		if (Xp.getLevel() == 8){
			level8Fighter = true;
			get("Level 8 Fighter!");
		}
	}
	private static void checkLevel9Fighter(){
		if (Xp.getLevel() == 9){
			level9Fighter = true;
			get("Level 9 Fighter!");
		}
	}
	private static void checkLevel10Fighter(){
		if (Xp.getLevel() == 10){
			level10Fighter = true;
			get("Level 10 Fighter!");
		}
	}
	private static void checkHonestPlayer(){
		if (Cheats.locked()){
			honestPlayer = true;
			get("Honest Player");
		}
	}
	private static void checkLearning(){

        for (int i = 0; i < Weapon.arrayWeapon.size(); i++) {
            if (!Weapon.arrayWeapon.get(i).viewedAbout()) return;
        }

        for (int i = 0; i < Enemy.arrayEnemy.size(); i++) {
            if (!Enemy.arrayEnemy.get(i).viewedAbout()) return;
        }

        if(!viewedPlayer)   return;
        if(!viewedXP)       return;
        if(!viewedCrafting) return;
        if(!viewedCheats)   return;
        if(!viewedAchs)     return;
        if(!viewedHealth)   return;

		learning = true;
		get("Learning");
	}
}