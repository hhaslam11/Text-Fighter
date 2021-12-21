package com.hotmail.kalebmarc.textfighter.player;

import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.main.Bank;
import com.hotmail.kalebmarc.textfighter.main.Casino;
import com.hotmail.kalebmarc.textfighter.main.Cheats;
import com.hotmail.kalebmarc.textfighter.main.Food;
import com.hotmail.kalebmarc.textfighter.main.Ui;
import com.hotmail.kalebmarc.textfighter.main.Weapon;

public class Stats {
    //Battle Stats
    public static int highScore;
    public static int kills;
    public static int totalDamageDealt;
    public static int totalKills;
    public static int bulletsFired;
    public static int bulletsThatHit;
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
    public static int lotteryTicketsBought;
    public static int lotteryWon;
    public static int blackjackGamesPlayed;
    private static String killDeathRatio;

    private Stats() {
    }

    public static void view() {

        updateKillDeathRatio();

        Ui.cls();
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
        Ui.println("   Coins in bank - " + Bank.get());
        Ui.println("   Total Coins Won in Casino - " + Casino.totalCoinsWon);
        Ui.println("   Total Games Played in Casino - " + Casino.gamesPlayed);
        Ui.println("   Total coins spent - " + totalCoinsSpent);
        Ui.println("   Coins spent on bank interest - " + coinsSpentOnBankInterest);
        Ui.println("   Coins spent on weapons - " + coinsSpentOnWeapons);
        Ui.println("   Coins spent on health - " + coinsSpentOnHealth);
        Ui.println("   XP bought - " + xpBought);
        Ui.println();
        Ui.println("Health:");
        Ui.println("   Health - " + Health.getStr());
        Ui.println("   Insta-Healths used - " + InstaHealth.used);
        Ui.println("   First-Aid kits used - " + FirstAid.used);
        Ui.println("   Survival potions used - " + (Potion.spUsed));
        Ui.println("   Recovery potions used - " + (Potion.rpUsed));
        Ui.println("   Total potions used - " + (Potion.spUsed + Potion.rpUsed));
        Ui.println("   Times Died - " + Health.timesDied);
        Ui.println("   Food items eaten - " + Food.totalEaten);
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
        Ui.println("   Blackjack Games Played - " + blackjackGamesPlayed);
        Ui.println("   Lottery Tickets Bought - " + lotteryTicketsBought);
        Ui.println("   Lotteries Won - " + lotteryWon);
        Ui.println();
        Ui.println("-------------------------------------------------");
        Ui.pause();
    }

    private static void updateKillDeathRatio() {
        int i, gcm = 1, first = totalKills, second = Health.timesDied;

        i = (first >= second) ? first : second;

        while (i != 0) {
            if (first % i == 0 && second % i == 0) {
                gcm = i;
                break;
            }
            i--;
        }

        killDeathRatio = first / gcm + ":" + second / gcm;
    }
}
