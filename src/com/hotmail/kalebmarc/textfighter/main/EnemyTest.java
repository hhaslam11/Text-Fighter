package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hotmail.kalebmarc.textfighter.player.Xp;

public class EnemyTest {
	
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
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
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
