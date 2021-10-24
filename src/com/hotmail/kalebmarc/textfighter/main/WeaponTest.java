<<<<<<< HEAD
package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.player.Xp;

public class WeaponTest {
	
	static InputStream sysInBackup;
	
	static Weapon fists;
	static Weapon baseballBat;
	static Weapon knife;
	static Weapon pipe;
    //Guns:
	static Weapon pistol;
	static Weapon smg;
	static Weapon shotgun;
	static Weapon rifle;
	static Weapon sniper;
	
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

        System.setIn(sysInBackup);

		fists = new Weapon("Fists", true, false, 0, 0, 5, 10, true, false);
		baseballBat = new Weapon("Baseball Bat", false, true, 120, 1, 10, 15, true, false);
		knife = new Weapon("Knife", false, true, 125, 2, 10, 20, true, false);
		pipe = new Weapon("Pipe", false, false, 0, 0, 5, 20, true, false);
	    //Guns:
		pistol = new Weapon("Pistol", 1, 18, true, 250, 1, 4, 15, 1.5, 3, 4, true, false);
		smg = new Weapon("Smg", 10, 75, true, 700, 1, 10, 75, 2.5, 4, 6, true, false);
		shotgun = new Weapon("Shotgun", 1, 12, true, 375, 2, 9, 60, 2, 5, 7, true, false);
		rifle = new Weapon("Rifle", 1, 18, true, 275, 1, 5, 10, 1.25, 6, 7, true, false);
		sniper = new Weapon("Sniper", 1, 10, true, 700, 2, 7, 0, 1, 7, 10, true, false);
		
		Weapon.arrayWeapon.get(Weapon.getIndex(baseballBat)).owns = true;
		Weapon.arrayWeapon.get(Weapon.getIndex(pistol)).owns = true;
		Weapon.arrayWeapon.get(Weapon.getIndex(pistol)).setAmmo(4, true);
		
        darkElf = new Enemy("Dark Elf", 145, 10, 15, 10, 15, 15, 5, 100, true, false);
        ninja = new Enemy("Ninja", 175, 5, 15, 5, 15, 15, 1, 10, true, false);
        giantSpider = new Enemy("Giant Spider", 135, 5, 10, 5, 10, 10, 5, 100, true, false);
        zombie = new Enemy("Zombie", 120, 5, 15, 5, 15, 15, 1, 10, true, false);
        goblin = new Enemy("Goblin", 160, 10, 20, 10, 20, 20, 1, 10, true, false);
        ghost = new Enemy("Ghost", 185, 15, 25, 15, 25, 25, 1, 100, true, false);
        barbarian = new Enemy("Barbarian", 150, 5, 15, 5, 15, 15, 5, 100, true, false);
        giantAnt = new Enemy("Giant Ant", 130, 5, 10, 5, 10, 10, 1, 10, true, false);
        evilUnicorn = new Enemy("Evil Unicorn", 135, 30, 40, 5, 15, 20, 5, 100, true, false);
        ogre = new Enemy("Ogre", 190, 20, 50, 10, 30, 50, 5, 100, true, false);
        
        Xp.setLevel(1);
        
        Weapon.BULLET_DAMAGE = 10;
        
        Weapon.BULLET_CRITICAL_MULTIPLIER = 10;
		Weapon.BULLET_CRITICAL_CHANCE = 100;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

        System.setIn(sysInBackup);
	}

	@Before
	public void setUp() throws Exception {

        System.setIn(sysInBackup);
	}

	@After
	public void tearDown() throws Exception {

        System.setIn(sysInBackup);
	}

	@Test
	public void testDealDam() {
		
		Weapon.set(0);
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("\n".getBytes()); // Initialize a stream to move past user input
        
        System.setIn(chooseIn);
		
		Enemy.encounterNew();
		
		String previousEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		int startHealth = Enemy.get().getHealth();
		
		Weapon.get().dealDam();
		
		int endHealth = Enemy.get().getHealth();
		
		int lost = startHealth - endHealth;
		
		assertTrue(lost <= 10 && lost >= 5);
		
		startHealth = Enemy.get().getHealth();
		
		Weapon.set(4);
		
		Weapon.get().dealDam();
		
		endHealth = Enemy.get().getHealth();
		
		lost = startHealth - endHealth;
		
		String nextEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		assertTrue((lost <= Random.RInt(3, 4) * 10 * 10 && lost >= 0) || (nextEnemy != previousEnemy)); // Enemy should have lost a certain amount of health based on weapon, or died
		
		startHealth = Enemy.get().getHealth();
		
		Weapon.get().dealDam();
		
		endHealth = Enemy.get().getHealth();
		
		lost = startHealth - endHealth;
		
		String lastEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		assertTrue((lost <= Random.RInt(3, 4) * 10 * 10 && lost >= 0) || (lastEnemy != nextEnemy)); // Enemy should have lost a certain amount of health based on weapon, or died
	}

	@Test
	public void testGeneralBulletCriticalHit() {
		
		Weapon.BULLET_CRITICAL_MULTIPLIER = 10;
		Weapon.BULLET_CRITICAL_CHANCE = 100; // Set critical chance to 100 to force critical hits to test
		
		int startHealth;
		int endHealth;
		int lost;
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("\n".getBytes()); // Initialize a stream to move past user input
        
        System.setIn(chooseIn);
		
		Enemy.encounterNew();
		
		String previousEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		startHealth = Enemy.get().getHealth();
		
		Weapon.set(4);
		
		do
		{
			Weapon.get().dealDam(); // Loop until user doesn't miss
			
			endHealth = Enemy.get().getHealth();
			
			lost = startHealth - endHealth;
			
		} while (lost == 0);
		
		String nextEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		assertTrue((lost <= Random.RInt(3, 4) * 10 * 10 && lost >= 100) || (nextEnemy != previousEnemy) || (Enemy.get().getHealth() == 20)); // Enemy should have lost a certain amount of health based on bullet damage, or died
		
		startHealth = Enemy.get().getHealth();

		do
		{
			Weapon.get().dealDam(); // Loop until user doesn't miss
			
			endHealth = Enemy.get().getHealth();
			
			lost = startHealth - endHealth;
			
		} while (lost == 0);
		
		String lastEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		assertTrue((lost <= Random.RInt(3, 4) * 10 * 10 && lost >= 100) || (lastEnemy != nextEnemy) || (Enemy.get().getHealth() == 20)); // Enemy should have lost a certain amount of health based on bullet damage, or died
	}
}
=======
package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.player.Xp;

public class WeaponTest {
	
	static InputStream sysInBackup;
	
	static Weapon fists;
	static Weapon baseballBat;
	static Weapon knife;
	static Weapon pipe;
    //Guns:
	static Weapon pistol;
	static Weapon smg;
	static Weapon shotgun;
	static Weapon rifle;
	static Weapon sniper;
	
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

        System.setIn(sysInBackup);

		fists = new Weapon("Fists", true, false, 0, 0, 5, 10, true, false);
		baseballBat = new Weapon("Baseball Bat", false, true, 120, 1, 10, 15, true, false);
		knife = new Weapon("Knife", false, true, 125, 2, 10, 20, true, false);
		pipe = new Weapon("Pipe", false, false, 0, 0, 5, 20, true, false);
	    //Guns:
		pistol = new Weapon("Pistol", 1, 18, true, 250, 1, 4, 15, 1.5, 3, 4, true, false);
		smg = new Weapon("Smg", 10, 75, true, 700, 1, 10, 75, 2.5, 4, 6, true, false);
		shotgun = new Weapon("Shotgun", 1, 12, true, 375, 2, 9, 60, 2, 5, 7, true, false);
		rifle = new Weapon("Rifle", 1, 18, true, 275, 1, 5, 10, 1.25, 6, 7, true, false);
		sniper = new Weapon("Sniper", 1, 10, true, 700, 2, 7, 0, 1, 7, 10, true, false);
		
		Weapon.arrayWeapon.get(Weapon.getIndex(baseballBat)).owns = true;
		Weapon.arrayWeapon.get(Weapon.getIndex(pistol)).owns = true;
		Weapon.arrayWeapon.get(Weapon.getIndex(pistol)).setAmmo(4, true);
		
        darkElf = new Enemy("Dark Elf", 145, 10, 15, 10, 15, 15, 5, 100, true, false);
        ninja = new Enemy("Ninja", 175, 5, 15, 5, 15, 15, 1, 10, true, false);
        giantSpider = new Enemy("Giant Spider", 135, 5, 10, 5, 10, 10, 5, 100, true, false);
        zombie = new Enemy("Zombie", 120, 5, 15, 5, 15, 15, 1, 10, true, false);
        goblin = new Enemy("Goblin", 160, 10, 20, 10, 20, 20, 1, 10, true, false);
        ghost = new Enemy("Ghost", 185, 15, 25, 15, 25, 25, 1, 100, true, false);
        barbarian = new Enemy("Barbarian", 150, 5, 15, 5, 15, 15, 5, 100, true, false);
        giantAnt = new Enemy("Giant Ant", 130, 5, 10, 5, 10, 10, 1, 10, true, false);
        evilUnicorn = new Enemy("Evil Unicorn", 135, 30, 40, 5, 15, 20, 5, 100, true, false);
        ogre = new Enemy("Ogre", 190, 20, 50, 10, 30, 50, 5, 100, true, false);
        
        Xp.setLevel(1);
        
        Weapon.BULLET_DAMAGE = 10;
        
        Weapon.BULLET_CRITICAL_MULTIPLIER = 10;
		Weapon.BULLET_CRITICAL_CHANCE = 100;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

        System.setIn(sysInBackup);
	}

	@Before
	public void setUp() throws Exception {

        System.setIn(sysInBackup);
	}

	@After
	public void tearDown() throws Exception {

        System.setIn(sysInBackup);
	}

	@Test
	public void testDealDam() {
		
		Weapon.set(0);
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("\n".getBytes()); // Initialize a stream to move past user input
        
        System.setIn(chooseIn);
		
		Enemy.encounterNew();
		
		String previousEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		int startHealth = Enemy.get().getHealth();
		
		Weapon.get().dealDam();
		
		int endHealth = Enemy.get().getHealth();
		
		int lost = startHealth - endHealth;
		
		assertTrue(lost <= 10 && lost >= 5);
		
		startHealth = Enemy.get().getHealth();
		
		Weapon.set(4);
		
		Weapon.get().dealDam();
		
		endHealth = Enemy.get().getHealth();
		
		lost = startHealth - endHealth;
		
		String nextEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		assertTrue((lost <= Random.RInt(3, 4) * 10 * 10 && lost >= 0) || (nextEnemy != previousEnemy)); // Enemy should have lost a certain amount of health based on weapon, or died
		
		startHealth = Enemy.get().getHealth();
		
		Weapon.get().dealDam();
		
		endHealth = Enemy.get().getHealth();
		
		lost = startHealth - endHealth;
		
		String lastEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		assertTrue((lost <= Random.RInt(3, 4) * 10 * 10 && lost >= 0) || (lastEnemy != nextEnemy)); // Enemy should have lost a certain amount of health based on weapon, or died
	}

	@Test
	public void testGeneralBulletCriticalHit() {
		
		Weapon.BULLET_CRITICAL_MULTIPLIER = 10;
		Weapon.BULLET_CRITICAL_CHANCE = 100; // Set critical chance to 100 to force critical hits to test
		
		int startHealth;
		int endHealth;
		int lost;
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("\n".getBytes()); // Initialize a stream to move past user input
        
        System.setIn(chooseIn);
		
		Enemy.encounterNew();
		
		String previousEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		startHealth = Enemy.get().getHealth();
		
		Weapon.set(4);
		
		do
		{
			Weapon.get().dealDam(); // Loop until user doesn't miss
			
			endHealth = Enemy.get().getHealth();
			
			lost = startHealth - endHealth;
			
		} while (lost == 0);
		
		String nextEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		assertTrue((lost <= Random.RInt(3, 4) * 10 * 10 && lost >= 100) || (nextEnemy != previousEnemy) || (Enemy.get().getHealth() == 20)); // Enemy should have lost a certain amount of health based on bullet damage, or died
		
		startHealth = Enemy.get().getHealth();

		do
		{
			Weapon.get().dealDam(); // Loop until user doesn't miss
			
			endHealth = Enemy.get().getHealth();
			
			lost = startHealth - endHealth;
			
		} while (lost == 0);
		
		String lastEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		assertTrue((lost <= Random.RInt(3, 4) * 10 * 10 && lost >= 100) || (lastEnemy != nextEnemy) || (Enemy.get().getHealth() == 20)); // Enemy should have lost a certain amount of health based on bullet damage, or died
	}
}
>>>>>>> eb762b36c0b66aafe4b627b4e701e492ef8a431e
