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
        darkElf = new Enemy("Dark Elf", 45, 10, 15, 10, 15, 15, 5, 100, true, false);
        ninja = new Enemy("Ninja", 75, 5, 15, 5, 15, 15, 1, 10, true, false);
        giantSpider = new Enemy("Giant Spider", 35, 5, 10, 5, 10, 10, 5, 100, true, false);
        zombie = new Enemy("Zombie", 20, 5, 15, 5, 15, 15, 1, 10, true, false);
        goblin = new Enemy("Goblin", 60, 10, 20, 10, 20, 20, 1, 10, true, false);
        ghost = new Enemy("Ghost", 85, 15, 25, 15, 25, 25, 1, 100, true, false);
        barbarian = new Enemy("Barbarian", 50, 5, 15, 5, 15, 15, 5, 100, true, false);
        giantAnt = new Enemy("Giant Ant", 30, 5, 10, 5, 10, 10, 1, 10, true, false);
        evilUnicorn = new Enemy("Evil Unicorn", 35, 30, 40, 5, 15, 20, 5, 100, true, false);
        ogre = new Enemy("Ogre", 90, 20, 50, 10, 30, 50, 5, 100, true, false);
        
        allEnemies = new ArrayList<>();
        
        allEnemies.add(darkElf);
        allEnemies.add(ninja);
        allEnemies.add(giantSpider);
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
	public void testGet() {
        
        Xp.setLevel(1);
        
        Enemy.encounterNew();
		
		assertTrue(Enemy.get() instanceof Enemy);
		
        ArrayList<Enemy> suitableEnemies = new ArrayList<Enemy>();
        
        suitableEnemies.add(ninja);
        suitableEnemies.add(zombie);
        suitableEnemies.add(goblin);
        suitableEnemies.add(ghost);
        suitableEnemies.add(giantAnt);
		
		assertTrue(suitableEnemies.contains(Enemy.get()));
        
        Xp.setLevel(15);
		
        suitableEnemies = new ArrayList<Enemy>();
        
        suitableEnemies.add(darkElf);
        suitableEnemies.add(giantSpider);
        suitableEnemies.add(ghost);
        suitableEnemies.add(barbarian);
        suitableEnemies.add(evilUnicorn);
        suitableEnemies.add(ogre);
        
        Enemy.encounterNew();
		
		assertTrue(Enemy.get() instanceof Enemy);
		
		assertTrue(suitableEnemies.contains(Enemy.get()));
	}

	@Test
	public void testFindEnemy() {
        
        Xp.setLevel(1);
        
        Enemy.findEnemy();
		
		assertTrue(Enemy.get() instanceof Enemy);
		
        ArrayList<Enemy> suitableEnemies = new ArrayList<Enemy>();
        
        suitableEnemies.add(ninja);
        suitableEnemies.add(zombie);
        suitableEnemies.add(goblin);
        suitableEnemies.add(ghost);
        suitableEnemies.add(giantAnt);
		
		assertTrue(suitableEnemies.contains(Enemy.get()));
        
        Xp.setLevel(15);
		
        suitableEnemies = new ArrayList<Enemy>();
        
        suitableEnemies.add(darkElf);
        suitableEnemies.add(giantSpider);
        suitableEnemies.add(ghost);
        suitableEnemies.add(barbarian);
        suitableEnemies.add(evilUnicorn);
        suitableEnemies.add(ogre);
        
        Enemy.findEnemy();
		
		assertTrue(Enemy.get() instanceof Enemy);
		
		assertTrue(suitableEnemies.contains(Enemy.get()));
	}

	@Test
	public void testGetEnemies() {
		assertEquals(Enemy.arrayEnemy, Enemy.getEnemies());
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
