package com.hotmail.kalebmarc.textfighter.player;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class PotionTest {
	
	static InputStream sysInBackup;
	
	static ByteArrayInputStream in;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        sysInBackup = System.in; // backup System.in to restore it later
        in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
        System.setIn(sysInBackup);
	}

	@Before
	public void setUp() throws Exception {
        in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);
	}

	@After
	public void tearDown() throws Exception {
        System.setIn(sysInBackup);
	}

	@Test
	public void testGet() {
		
		assertEquals(Potion.get("survival"), 0); // Starting with no potions
		
		assertEquals(Potion.get("recovery"), 0); // Starting with no potions
		
		Potion.set("survival", 5, false); // Set player's survival potion count to 5
		
		Potion.set("recovery", 5, false); // Set player's recovery potion count to 5
		
		assertEquals(Potion.get("survival"), 5); // Check survival potion total
		
		assertEquals(Potion.get("recovery"), 5); // Check recovery potion total
		
		// Test that using a potion depletes the total
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		assertEquals(Potion.get("survival"), 2); // Check survival potion total after using some potions
		
		assertEquals(Potion.get("recovery"), 3); // Check recovery potion total after using some potions
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		assertEquals(Potion.get("survival"), 0); // Check survival potion total
		
		assertEquals(Potion.get("recovery"), 0); // Check recovery potion total
		
		// Attempt to use nonexistant potions
		Potion.use("survival");
		
		Potion.use("recovery");
		
		assertEquals(Potion.get("survival"), 0); // Check survival potion total after using all potions
		
		assertEquals(Potion.get("recovery"), 0); // Check recovery potion total after using all potions
	}

	@Test
	public void testSet() {
		
		Potion.set("survival", 0, false); // Starting with no potions
		
		Potion.set("recovery", 0, false); // Starting with no potions
		
		assertEquals(Potion.get("survival"), 0); // Check survival potion total
		
		assertEquals(Potion.get("recovery"), 0); // Check recovery potion total
		
		Potion.set("survival", 5, false); // Set player's survival potion count to 5
		
		Potion.set("recovery", 5, false); // Set player's recovery potion count to 5
		
		assertEquals(Potion.get("survival"), 5); // Check survival potion total
		
		assertEquals(Potion.get("recovery"), 5); // Check recovery potion total

		// Test that using a potion depletes the total
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		Potion.set("survival", 5, false); // Set player's survival potion count to 5
		
		Potion.set("recovery", 5, false); // Set player's recovery potion count to 5
		
		assertEquals(Potion.get("survival"), 5); // Check survival potion total
		
		assertEquals(Potion.get("recovery"), 5); // Check recovery potion total
		
		// Deplete potions again
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		assertEquals(Potion.get("survival"), 2); // Check survival potion total
		
		assertEquals(Potion.get("recovery"), 3); // Check recovery potion total
		
		Potion.set("survival", 5, true); // Set player's survival potion count to 5 more
		
		Potion.set("recovery", 5, true); // Set player's recovery potion count to 5 more
		
		assertEquals(Potion.get("survival"), 7); // Check survival potion total
		
		assertEquals(Potion.get("recovery"), 8); // Check recovery potion total
	}

	@Test
	public void testUse() {
		
		Potion.set("survival", 0, false); // Starting with no potions
		
		Potion.set("recovery", 0, false); // Starting with no potions
		
		Potion.set("survival", 5, false); // Set player's survival potion count to 5
		
		Potion.set("recovery", 5, false); // Set player's recovery potion count to 5
		
		// Test that using a potion depletes the total
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");

		assertEquals(Potion.get("survival"), 2); // Check survival potion total
		
		assertEquals(Potion.get("recovery"), 3); // Check recovery potion total
		
		// Deplete potions again
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		Potion.use("recovery");

		assertEquals(Potion.get("survival"), 0); // Check survival potion total
		
		assertEquals(Potion.get("recovery"), 0); // Check recovery potion total
		
		// Attempt to use nonexistant potions
		Potion.use("survival");
		
		Potion.use("recovery");

		assertEquals(Potion.get("survival"), 0); // Check survival potion total after using all potions
		
		assertEquals(Potion.get("recovery"), 0); // Check recovery potion total after using all potions
	}

	@Test
	public void testUsed() {
		
		Potion.set("survival", 0, false); // Starting with no potions
		
		Potion.set("recovery", 0, false); // Starting with no potions
		
		Potion.set("survival", 5, false); // Set player's survival potion count to 5
		
		Potion.set("recovery", 5, false); // Set player's recovery potion count to 5

		assertEquals(16, Potion.spUsed); // Check total survival potions that have been used throughout the tests
		
		assertEquals(14, Potion.rpUsed); // Check total recovery potions that have been used throughout the tests

		// Test that using a potion increments the total used
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");

		assertEquals(19, Potion.spUsed); // Check total survival potions that have been used
		
		assertEquals(16, Potion.rpUsed); // Check total recovery potions that have been used
		
		// Deplete potions again
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		Potion.use("recovery");

		assertEquals(21, Potion.spUsed); // Check total survival potions that have been used
		
		assertEquals(19, Potion.rpUsed); // Check total recovery potions that have been used

		// Attempt to use nonexistant potions
		Potion.use("survival");
		
		Potion.use("recovery");

		assertEquals(21, Potion.spUsed); // Check total survival potions that have been used after using all potions
		
		assertEquals(19, Potion.rpUsed); // Check total recovery potions that have been used after using all potions
	}

	@Ignore
	@Test
	public void testUsedAlone() {
		
		Potion.set("survival", 0, false); // Starting with no potions
		
		Potion.set("recovery", 0, false); // Starting with no potions
		
		Potion.set("survival", 5, false); // Set player's survival potion count to 5
		
		Potion.set("recovery", 5, false); // Set player's recovery potion count to 5
		
		Potion.spUsed = 0; // Reset survival potion usage count
		
		Potion.rpUsed = 0; // Reset recovery potion usage count

		assertEquals(0, Potion.spUsed); // Check total survival potions that have been used in this test
		
		assertEquals(0, Potion.rpUsed); // Check total recovery potions that have been used in this test

		// Test that using a potion increments the total used
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");

		assertEquals(3, Potion.spUsed); // Check total survival potions that have been used
		
		assertEquals(2, Potion.rpUsed); // Check total recovery potions that have been used
		
		// Deplete potions again
		Potion.use("survival");
		
		Potion.use("survival");
		
		Potion.use("recovery");
		
		Potion.use("recovery");
		
		Potion.use("recovery");

		assertEquals(5, Potion.spUsed); // Check total survival potions that have been used
		
		assertEquals(5, Potion.rpUsed); // Check total recovery potions that have been used

		// Attempt to use nonexistant potions
		Potion.use("survival");
		
		Potion.use("recovery");

		assertEquals(5, Potion.spUsed); // Check total survival potions that have been used after using all potions
		
		assertEquals(5, Potion.rpUsed); // Check total recovery potions that have been used after using all potions
	}
}
