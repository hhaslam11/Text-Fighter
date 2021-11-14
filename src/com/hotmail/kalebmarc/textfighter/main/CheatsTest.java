package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CheatsTest {
	
	static InputStream sysInBackup;
	
	public static Food apple;
	public static Food orange;
	public static Food dragonfruit;
	public static Food meat;
	public static Food mushroom;
	public static Food fish;
	
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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Cheats.enable();
		
		sysInBackup = System.in; // backup System.in to restore it later
		
		apple = new Food("Apple", "A boring 'ol apple.", StatusEffect.type.HEALTH, Food.type.FRUIT, 5);
		orange = new Food("Orange", "Sort of like an apple, but orange.", StatusEffect.type.HEALTH, Food.type.FRUIT, 5);
		dragonfruit = new Food("Dragon Fruit", "Unfortunately, not a real dragon.", StatusEffect.type.HEALTH, Food.type.FRUIT, 10);
		meat = new Food("Chunk of meat", "Probably not rotten.", StatusEffect.type.HEALTH, Food.type.MEAT_OTHER, 15);
		mushroom = new Food("Mushroom", "The good kind!", StatusEffect.type.HEALTH, Food.type.OTHER, 5);
		fish = new Food("Fish", "Found in rivers and lakes.", StatusEffect.type.HEALTH, Food.type.MEAT_FISH, 15);

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
		
		Weapon.arrayWeapon.get(1).owns = true;
		Weapon.arrayWeapon.get(4).owns = true;
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
	public void testCheatGatewaygivemeitall() {
		
		Ui.print("Type 'givemeitall' to test");
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("givemeitall".getBytes()); // Set input stream to pick cheat automatically
        
        System.setIn(chooseIn);
	    
	    Cheats.cheatGateway();

        System.setIn(sysInBackup);
        
        // Ensure that cheat updated food counts
        assertEquals(5000, Food.arrayFood.get(0).getQuantity());
        assertEquals(5000, Food.arrayFood.get(1).getQuantity());
        assertEquals(5000, Food.arrayFood.get(2).getQuantity());
        assertEquals(5000, Food.arrayFood.get(3).getQuantity());
        assertEquals(5000, Food.arrayFood.get(4).getQuantity());
        assertEquals(5000, Food.arrayFood.get(5).getQuantity());
        
        // Ensure that cheat updated weapon counts
        assertTrue(Weapon.arrayWeapon.get(0).owns);
        assertTrue(Weapon.arrayWeapon.get(1).owns);
        assertTrue(Weapon.arrayWeapon.get(2).owns);
        assertTrue(Weapon.arrayWeapon.get(3).owns);
        assertTrue(Weapon.arrayWeapon.get(4).owns);
        assertTrue(Weapon.arrayWeapon.get(5).owns);
        assertTrue(Weapon.arrayWeapon.get(6).owns);
        assertTrue(Weapon.arrayWeapon.get(7).owns);
        assertTrue(Weapon.arrayWeapon.get(8).owns);
	}

	@Test
	public void testCheatGatewayweaponstash() {
		
		Ui.print("Type 'weaponstash' to test");
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("weaponstash".getBytes()); // Set input stream to pick cheat automatically
        
        System.setIn(chooseIn);
	    
	    Cheats.cheatGateway();

        System.setIn(sysInBackup);
        
        // Ensure that cheat updated weapon ammo counts
        assertEquals(5000, Weapon.arrayWeapon.get(4).getAmmo());
        assertEquals(5000, Weapon.arrayWeapon.get(5).getAmmo());
        assertEquals(5000, Weapon.arrayWeapon.get(6).getAmmo());
        assertEquals(5000, Weapon.arrayWeapon.get(7).getAmmo());
        assertEquals(5000, Weapon.arrayWeapon.get(8).getAmmo());
	}

	@Test
	public void testCheatGatewaythirstforfood() {
		
		Ui.print("Type 'thirstforfood' to test");
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("thirstforfood".getBytes()); // Set input stream to pick cheat automatically
        
        System.setIn(chooseIn);
	    
	    Cheats.cheatGateway();

        System.setIn(sysInBackup);
        
        // Ensure that cheat updated food counts
        assertEquals(10, Food.arrayFood.get(0).getQuantity());
        assertEquals(10, Food.arrayFood.get(1).getQuantity());
        assertEquals(10, Food.arrayFood.get(2).getQuantity());
        assertEquals(10, Food.arrayFood.get(3).getQuantity());
        assertEquals(10, Food.arrayFood.get(4).getQuantity());
        assertEquals(10, Food.arrayFood.get(5).getQuantity());
	}
