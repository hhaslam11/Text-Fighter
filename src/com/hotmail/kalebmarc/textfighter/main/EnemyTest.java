package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.player.Xp;

public class EnemyTest {
	
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

	static ArrayList<Enemy> allEnemies;

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
  
        darkElf = new Enemy("Dark Elf", 45, 10, 15, 10, 15, 15, 5, 99, true, false);
        ninja = new Enemy("Ninja", 75, 5, 15, 5, 15, 15, 1, 10, true, false);
        giantSpider = new Enemy("Giant Spider", 35, 5, 10, 5, 10, 10, 5, 99, true, false);
        zombie = new Enemy("Zombie", 20, 5, 15, 5, 15, 15, 1, 10, true, false);
        goblin = new Enemy("Goblin", 60, 10, 20, 10, 20, 20, 1, 10, true, false);
        ghost = new Enemy("Ghost", 85, 15, 25, 15, 25, 25, 1, 99, true, false);
        barbarian = new Enemy("Barbarian", 50, 5, 15, 5, 15, 15, 5, 99, true, false);
        giantAnt = new Enemy("Giant Ant", 30, 5, 10, 5, 10, 10, 1, 10, true, false);
        evilUnicorn = new Enemy("Evil Unicorn", 35, 30, 40, 5, 15, 20, 5, 99, true, false);
        ogre = new Enemy("Ogre", 90, 20, 50, 10, 30, 50, 5, 99, true, false);
        
        allEnemies = new ArrayList<>();
        
        allEnemies.add(darkElf);
        allEnemies.add(ninja);
        allEnemies.add(giantSpider);
        allEnemies.add(zombie);
        allEnemies.add(ghost);
        allEnemies.add(barbarian);
        allEnemies.add(giantAnt);
        allEnemies.add(evilUnicorn);
        allEnemies.add(ogre);
        
        Xp.setLevel(1);
        
        Weapon.BULLET_DAMAGE = 10;
        
        Weapon.BULLET_CRITICAL_MULTIPLIER = 10;
		    Weapon.BULLET_CRITICAL_CHANCE = 0.001;
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
	public void testDie() {
		// The enemies used in this test have health high enough that only a critical hit will kill them
		// Tests are formed as such to verify that critical hits affect the enemies health correctly
		
		int startHealth;
		int endHealth;
		int lost;
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("\n".getBytes()); // Initialize a stream to move past user input
        
        System.setIn(chooseIn);
		
		Enemy.encounterNew(); // Get a new enemy to fight
		
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
		
		assertTrue((lost <= Random.RInt(3, 4) * 10 * 10 && lost >= 0) || (nextEnemy != previousEnemy) || (Enemy.get().getHealth() == 20)); // Enemy should have lost a certain amount of health based on weapon, or died
		
		startHealth = Enemy.get().getHealth();

		do
		{
			Weapon.get().dealDam(); // Loop until user doesn't miss
			
			endHealth = Enemy.get().getHealth();
			
			lost = startHealth - endHealth;
			
		} while (lost == 0);
		
		String lastEnemy = Enemy.get().getName(); // Record this enemy to check for enemy death later
		
		assertTrue((lost <= Random.RInt(3, 4) * 10 * 10 && lost >= 0) || (lastEnemy != nextEnemy) || (Enemy.get().getHealth() == 20)); // Enemy should have lost a certain amount of health based on weapon, or died	
	}

	@Test
	public void testSet() {
        
        Xp.setLevel(1); // Set player level to set suitable enemies
        
        Enemy.set(1); // Set a new enemy to fight
		
		assertTrue(Enemy.get() instanceof Enemy); // Ensure that enemy was set without error
		
		assertEquals(ninja.getName(), Enemy.get().getName()); // Ensure that correct enemy was set
        
        Xp.setLevel(15); // Set player level to set suitable enemies
        
        Enemy.set(0); // Set a new enemy to fight
		
		assertTrue(Enemy.get() instanceof Enemy); // Ensure that enemy was set without error
		
		assertEquals(darkElf.getName(), Enemy.get().getName()); // Ensure that correct enemy was set
        
        Enemy getTestEnemy = new Enemy("getTestEnemy", 90, 20, 50, 10, 30, 50, 50, 100, true, false);

        Xp.setLevel(100); // Set player level to set suitable enemies
        
        Enemy.set(10); // Set a new enemy to fight
		
		assertTrue(Enemy.get() instanceof Enemy); // Ensure that enemy was set without error
		
		assertEquals(getTestEnemy.getName(), Enemy.get().getName()); // Ensure that correct enemy was set
	}

	@Test
	public void testGet() {
        
        Xp.setLevel(1); // Set player level to find suitable enemies
        
        Enemy.encounterNew(); // Encounter a new enemy to fight
		
		assertTrue(Enemy.get() instanceof Enemy); // Ensure that enemy was found without error
		
        ArrayList<Enemy> suitableEnemies = new ArrayList<Enemy>(); // Initialize a list of manually found suitable enemies
        
        suitableEnemies.add(ninja);
        suitableEnemies.add(zombie);
        suitableEnemies.add(goblin);
        suitableEnemies.add(ghost);
        suitableEnemies.add(giantAnt);
		
		assertTrue(suitableEnemies.contains(Enemy.get())); // Ensure that get returns a valid enemy that was encountered
        
        Xp.setLevel(15); // Set player level to find suitable enemies
		
        suitableEnemies = new ArrayList<Enemy>(); // Initialize a list of manually found suitable enemies
        
        suitableEnemies.add(darkElf);
        suitableEnemies.add(giantSpider);
        suitableEnemies.add(ghost);
        suitableEnemies.add(barbarian);
        suitableEnemies.add(evilUnicorn);
        suitableEnemies.add(ogre);
        
        Enemy.encounterNew(); // Encounter a new enemy to fight
		
		assertTrue(Enemy.get() instanceof Enemy); // Ensure that enemy was found without error
		
		assertTrue(suitableEnemies.contains(Enemy.get())); // Ensure that get returns a valid enemy that was encountered
		
        Enemy getTestEnemy = new Enemy("getTestEnemy", 90, 20, 50, 10, 30, 50, 50, 100, true, false);

        Xp.setLevel(100); // Set player level to find suitable enemies
        
        Enemy.encounterNew(); // Encounter a new enemy to fight
		
		assertTrue(Enemy.get() instanceof Enemy); // Ensure that enemy was found without error
		
		assertEquals(getTestEnemy.getName(), Enemy.get().getName()); // Ensure that get returns specific enemy (only valid enemy)
	}

	@Test
	public void testGetIndex() {
        
        Xp.setLevel(1); // Set player level to find suitable enemies
        
        Enemy.encounterNew(); // Encounter a new enemy to fight
		
        ArrayList<Integer> suitableEnemies = new ArrayList<Integer>(); // Initialize a list of manually found suitable enemy indeces
        
        suitableEnemies.add(1);
        suitableEnemies.add(3);
        suitableEnemies.add(4);
        suitableEnemies.add(5);
        suitableEnemies.add(7);
		
		assertTrue(suitableEnemies.contains(Enemy.getIndex(Enemy.get()))); // Ensure that get returns a valid enemy that was encountered
        
        Xp.setLevel(15); // Set player level to find suitable enemies
		
        suitableEnemies = new ArrayList<Integer>(); // Initialize a list of manually found suitable enemy indeces
        
        suitableEnemies.add(0);
        suitableEnemies.add(2);
        suitableEnemies.add(4);
        suitableEnemies.add(6);
        suitableEnemies.add(8);
        suitableEnemies.add(9);
        
        Enemy.encounterNew(); // Encounter a new enemy to fight
		
		assertTrue(suitableEnemies.contains(Enemy.getIndex(Enemy.get()))); // Ensure that get returns a valid enemy that was encountered
		
        Enemy getTestEnemy = new Enemy("getTestEnemy", 90, 20, 50, 10, 30, 50, 50, 100, true, false);

        Xp.setLevel(100); // Set player level to find suitable enemies
        
        Enemy.encounterNew(); // Encounter a new enemy to fight
		
		assertTrue(Enemy.get() instanceof Enemy); // Ensure that enemy was found without error
		
		assertEquals(10, Enemy.getIndex(Enemy.get())); // Ensure that get returns specific enemy (only valid enemy)
	}

	@Test
	public void testFindEnemy() {
        
        Xp.setLevel(1); // Set player level to find suitable enemies
        
        Enemy.findEnemy(); // Find a new enemy to fight
		
		assertTrue(Enemy.get() instanceof Enemy); // Ensure that enemy was found without error
		
        ArrayList<Enemy> suitableEnemies = new ArrayList<Enemy>(); // Initialize a list of manually found suitable enemies
        
        suitableEnemies.add(ninja);
        suitableEnemies.add(zombie);
        suitableEnemies.add(goblin);
        suitableEnemies.add(ghost);
        suitableEnemies.add(giantAnt);
		
		assertTrue(suitableEnemies.contains(Enemy.get())); // Ensure that valid enemy was found
        
        Xp.setLevel(15); // Set player level to find suitable enemies
		
        suitableEnemies = new ArrayList<Enemy>(); // Initialize a list of manually found suitable enemies
        
        suitableEnemies.add(darkElf);
        suitableEnemies.add(giantSpider);
        suitableEnemies.add(ghost);
        suitableEnemies.add(barbarian);
        suitableEnemies.add(evilUnicorn);
        suitableEnemies.add(ogre);
        
        Enemy.findEnemy(); // Find a new enemy to fight
		
		assertTrue(Enemy.get() instanceof Enemy); // Ensure that enemy was found without error
		
		assertTrue(suitableEnemies.contains(Enemy.get())); // Ensure that valid enemy was found
	}

	@Test
	public void testGetEnemies() {
		// Test constant enemies array access
		
		assertEquals(Enemy.arrayEnemy.size(), Enemy.getEnemies().size());
		
		assertEquals(Enemy.arrayEnemy, Enemy.getEnemies());
		
		// Check all objects are the same in each list access method
		assertEquals(Enemy.arrayEnemy.get(0), Enemy.getEnemies().get(0));
		assertEquals(Enemy.arrayEnemy.get(1), Enemy.getEnemies().get(1));
		assertEquals(Enemy.arrayEnemy.get(2), Enemy.getEnemies().get(2));
		assertEquals(Enemy.arrayEnemy.get(3), Enemy.getEnemies().get(3));
		assertEquals(Enemy.arrayEnemy.get(4), Enemy.getEnemies().get(4));
		assertEquals(Enemy.arrayEnemy.get(5), Enemy.getEnemies().get(5));
		assertEquals(Enemy.arrayEnemy.get(6), Enemy.getEnemies().get(6));
		assertEquals(Enemy.arrayEnemy.get(7), Enemy.getEnemies().get(7));
		assertEquals(Enemy.arrayEnemy.get(8), Enemy.getEnemies().get(8));
		assertEquals(Enemy.arrayEnemy.get(9), Enemy.getEnemies().get(9));
	}
}
