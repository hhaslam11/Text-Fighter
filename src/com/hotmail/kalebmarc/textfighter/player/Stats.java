package com.hotmail.kalebmarc.textfighter.player;

import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.main.*;

public class Stats {
	private Stats(){}

    //Battle Stats
    public  static int highScore;
    public  static int kills;
    public  static int totalDamageDealt;
    public  static int totalKills;
    public  static int bulletsFired;
    public  static int bulletsThatHit;
    private static String killDeathRatio;

	//Coins
    public static int totalCoinsSpent;
    public static int coinsSpentOnWeapons;
    public static int coinsSpentOnHealth;
    public static int coinsSpentOnBankInterest;
    public static int xpBought;

    //Other
    public static int timesCheated;
    public static int timesQuit;
    public static int itemsCrafted;
    public static int diceGamesPlayed;
    public static int slotGamesPlayed;

	public static void view(){

        updateKillDeathRatio();

		Action.cls();
		Ui.println("-------------------------------------------------");
		Ui.println("                   PLAYER STATS                  ");
		Ui.println();
		Ui.println("Battle stats:");
		Ui.println("   High Score - " + highScore);
		Ui.println("   Current Kill Streak - " + kills);
		Ui.println("   Total POWER's Used - " + Power.used);
		Ui.println("   Current Weapon - " + Weapon.get().getName());
		Ui.println("   Current Enemy - " + com.hotmail.kalebmarc.textfighter.main.Enemy.get().getName());
		Ui.println("   Total Damage Dealt - " + totalDamageDealt);
		Ui.println("   Total Kills - " + totalKills);
        Ui.println("   Bullets Fired - " + bulletsFired);
        Ui.println("   Bullets that hit - " + bulletsThatHit);
        Ui.println("   K:D - " + killDeathRatio);
		Ui.println();
		Ui.println("Coins:");
		Ui.println("   Coins - " + Coins.get());
		Ui.println("   Coins in bank - " + Coins.getBank());
		Ui.println("   Total Coins Won in Casino - " + Casino.totalCoinsWon);
		Ui.println("   Total Games Played in Casino - " + Casino.gamesPlayed);
        Ui.println("   Total coins spent - " + totalCoinsSpent);
        Ui.println("   Coins spent on bank interest - " + coinsSpentOnBankInterest);
        Ui.println("   Coins spent on weapons - " + coinsSpentOnWeapons);
        Ui.println("   Coins spent on health - " + coinsSpentOnBankInterest);
        Ui.println("   XP bought - " + xpBought);
		Ui.println();
		Ui.println("Health:");
		Ui.println("   Health - " + Health.getStr());
        Ui.println("   Insta-Healths used - " + InstaHealth.used);
        Ui.println("   First-Aid kits used - " + FirstAid.used);
		Ui.println("   Times Died - " + Health.timesDied);
		Ui.println();
		Ui.println("Other: ");
		Ui.println("   Cheats Enabled? - " + Cheats.enabled());
		Ui.println("   Level - " + Xp.getLevel());
		Ui.println("   Xp - " + Xp.getFull());
		Ui.println("   Total Xp gained - " + Xp.total);
		Ui.println("   Times cheated - " + timesCheated);
		Ui.println("   Times quit - " + timesQuit);
		Ui.println("   Items Crafted - " + itemsCrafted);
		Ui.println("   Dice Games Played - " + diceGamesPlayed);
		Ui.println("   Slot Games Played - " + slotGamesPlayed);
		Ui.println();
		Ui.println("-------------------------------------------------");
		Action.pause();
	}
    private static void updateKillDeathRatio(){
        killDeathRatio = totalKills + ":" + Health.timesDied;
    }
}
