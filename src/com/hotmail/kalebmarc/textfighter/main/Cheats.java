package com.hotmail.kalebmarc.textfighter.main;

import java.util.Scanner;

import com.hotmail.kalebmarc.textfighter.item.FirstAid;
import com.hotmail.kalebmarc.textfighter.item.InstaHealth;
import com.hotmail.kalebmarc.textfighter.item.Power;
import com.hotmail.kalebmarc.textfighter.player.Coins;
import com.hotmail.kalebmarc.textfighter.player.Health;
import com.hotmail.kalebmarc.textfighter.player.Potion;
import com.hotmail.kalebmarc.textfighter.player.Settings;
import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.player.Xp;

public class Cheats {

    //Variables
    private static Scanner cheat = new Scanner(System.in);
    private static boolean enabled = false;
    private static boolean locked = false;

    public static void cheatGateway() {

        //Makes sure cheats aren't locked
        if (locked()) {
            Ui.msg("Cheats are locked off- You cannot use cheats!");
            return;
        }

        if (!enabled()) {
            int confirm = Ui.confirmPopup("If you enable cheats, achievements and xp will be disabled. Are you sure you want to continue?", "Warning");
            if (confirm == 0) {
                Xp.setAll(0, 0, 10);
                enable();
            }
        }
        if (enabled()) Cheats.cheatSelect();
    }

    private static void cheatSelect() {
        Ui.println("*");

        switch (cheat.nextLine()) {
            case "moneylover":
                Coins.set(1000, false);
                Stats.timesCheated++;
                break;
            case "givemeitall":
                Coins.set(5000, false);
                FirstAid.set(5000, false);
                InstaHealth.set(5000, false);
                for (int i = 0; i < Weapon.getWeapons().size(); i++) {
                    Weapon.getWeapons().get(i).setAmmo(5000, false);
                }
                Power.set(5000, false);
                for (int i = 0; i < Weapon.getWeapons().size(); i++) {
                    Weapon.getWeapons().get(i).owns = true;
                }
                Stats.timesCheated++;
                for (int i = 0; i < Food.getFoods().size(); i++)
                    Food.getFoods().get(i).setQuantity(5000);
                Potion.set("Survival", 5000, false);
                Potion.set("Recovery", 5000, false);
                break;
            case "weaponstash":
                for (int i = 0; i < Weapon.arrayWeapon.size(); i++) {
                    Weapon.arrayWeapon.get(i).setAmmo(5000, false);
                }

                Power.set(5000, false);
                for (int i = 0; i < Weapon.getWeapons().size(); i++) {
                    Weapon.getWeapons().get(i).owns = true;
                }
                Stats.timesCheated++;
                break;
            case "nomorepain":
                FirstAid.set(1000, false);
                InstaHealth.set(500, false);
                Potion.set("Survival", 500, false);
                Potion.set("Recovery", 500, false);
                for (int i = 0; i < Food.getFoods().size(); i++)
                    Food.getFoods().get(i).setQuantity(100);
                Stats.timesCheated++;
                break;
            case "healme":
                Health.set(Health.getOutOf());
                Stats.timesCheated++;
                break;
            case "givemeachallenge":
                Enemy.get().setHealth(1000, 1000);
                Stats.timesCheated++;
                break;
            case "lotsofkills":
                Stats.kills = 5000;
                Stats.timesCheated++;
                break;
            case "suicide":
                Health.die();
                Stats.timesCheated++;
                break;
            case "godmode":
                Settings.toggleGodMode();
                Stats.timesCheated++;
                break;
            case "loanshark":
                Loan.setCurrentLoan(0);
                Loan.setNetDue(0);
                Stats.timesCheated++;
                break;
            case "thirstforfood":
                for (int i = 0; i < Food.getFoods().size(); i++)
                    Food.getFoods().get(i).setQuantity(10);
                Stats.timesCheated++;
                break;

        }
    }

    public static boolean enabled() {
        return enabled;
    }

    public static boolean locked() {
        return locked;
    }

    public static void enable() {
        enabled = true;
    }

    public static void lock() {
        locked = true;
    }
}