package com.hotmail.kalebmarc.textfighter.main;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	}

	@Before
	public void setUp() throws Exception {
		sysInBackup = System.in; // backup System.in to restore it later
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testChoose() {
		
		ByteArrayInputStream chooseIn = new ByteArrayInputStream("3".getBytes());
        
        System.setIn(chooseIn);
        
		Weapon.choose();

        System.setIn(sysInBackup);
        
        assertEquals("Pistol", Weapon.get().getName());
	}

	@Test
	public void testGetWeapons() {
		assertEquals(Weapon.arrayWeapon, Weapon.getWeapons());
		assertEquals(Weapon.arrayWeapon.get(0), Weapon.getWeapons().get(0));
		assertEquals(Weapon.arrayWeapon.get(1), Weapon.getWeapons().get(1));
		assertEquals(Weapon.arrayWeapon.get(2), Weapon.getWeapons().get(2));
		assertEquals(Weapon.arrayWeapon.get(3), Weapon.getWeapons().get(3));
		assertEquals(Weapon.arrayWeapon.get(4), Weapon.getWeapons().get(4));
		assertEquals(Weapon.arrayWeapon.get(5), Weapon.getWeapons().get(5));
		assertEquals(Weapon.arrayWeapon.get(6), Weapon.getWeapons().get(6));
		assertEquals(Weapon.arrayWeapon.get(7), Weapon.getWeapons().get(7));
		assertEquals(Weapon.arrayWeapon.get(8), Weapon.getWeapons().get(8));
	}
}
