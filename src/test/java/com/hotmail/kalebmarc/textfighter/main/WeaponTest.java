package com.hotmail.kalebmarc.textfighter.main;

import com.hotmail.kalebmarc.textfighter.player.Stats;
import com.hotmail.kalebmarc.textfighter.main.Enemy;

import com.hotmail.kalebmarc.textfighter.player.Xp;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {
    Weapon rifle;
    Weapon pistol;
    Enemy enemy;

    @Before
    public void setUp() throws Exception {
        rifle = new Weapon("Rifle", 1, 18, true, 275, 1, 5, 0, true, true , 1);
        rifle.setAmmo(10,true);
        pistol = new Weapon("Pistol", 1, 18, true, 250, 1, 4, 0, true, true);
        pistol.setAmmo(10,true);
        enemy = new Enemy("Dark Elf", 45, 10, 15, 10, 15, 15, true, false);
        Enemy.encounterNew();
        Weapon.BULLET_DAMAGE = 10;

    }

    @Test
    public void dealDam() {
        /*
        * Make sure to click ok pop ups
        * */
        // Non critical
        int enemyStartHealth = enemy.getHealth();
        assertEquals(enemy.getHealth(), 45);
        // Make sure there is 0 chance of critical damage
        pistol.setCriticalChance(0);
        pistol.dealDam();
        assertNotEquals(enemyStartHealth, enemy.getHealth());
        assertEquals(enemyStartHealth - Weapon.BULLET_DAMAGE , enemy.getHealth());
        int enemyAfterHealth = enemy.getHealth();
        // Reset pistol's criticalChance back to default
        pistol.setCriticalChance(.01);

        // Critical
        rifle.dealDam();
        assertNotEquals(enemyAfterHealth, enemy.getHealth());
        // Enemy died and gets respawned immediately. Health should be 45 or whatever test enemy health set to.
        assertEquals(enemyStartHealth , enemy.getHealth());
    }

    @Test
    public void setCriticalChance() {
        // Check the Rifle critical chance is set to 1
        assertTrue(rifle.getCriticalChance() == 1);
        rifle.setCriticalChance(-200);
        assertTrue(rifle.getCriticalChance() == .01);
        rifle.setCriticalChance(1);
        assertTrue(rifle.getCriticalChance() == 1);

        // Check Pistol set to default .01
        assertTrue(pistol.getCriticalChance() == .01);
        pistol.setCriticalChance(0);
        assertTrue(pistol.getCriticalChance() == 0);
        pistol.setCriticalChance(.01);
        assertTrue(pistol.getCriticalChance() == .01);
    }

    @Test
    public void getCriticalChance() {
        Weapon rifle2 = new Weapon("Rifle", 1, 18, true, 275, 1, 5, 10, true, true , .06);
        assertTrue(rifle2.getCriticalChance() == .06);

        // Check the Rifle critical chance is set to 1
        assertTrue(rifle.getCriticalChance() == 1);

        // Check Pistol set to default .01
        assertTrue(pistol.getCriticalChance() == .01);
    }

    @Test
    public void displayDamageDealt() {
        int nDealt = Stats.totalDamageDealt;
        int xp = Xp.getBattleXp();

        assertEquals(nDealt,Stats.totalDamageDealt);
        assertEquals(xp, Xp.getBattleXp());

        pistol.dealDam();

        assertNotEquals(nDealt,Stats.totalDamageDealt);
        assertNotEquals(xp, Xp.getBattleXp());

        // Set to current values
        nDealt = Stats.totalDamageDealt;
        xp = Xp.getBattleXp();

        // Sets pistols ammo to 0 so cant do damage
        pistol.setAmmo(-pistol.getAmmo(), true);
        assertEquals(nDealt,Stats.totalDamageDealt);
        assertEquals(xp, Xp.getBattleXp());

    }

    @Test
    public void didCriticalHit() {
        assertEquals(rifle.didCriticalHit(), true);
        rifle.setCriticalChance(0);
        assertFalse(rifle.didCriticalHit());
        rifle.setCriticalChance(1);
        assertTrue(rifle.didCriticalHit());

    }
}